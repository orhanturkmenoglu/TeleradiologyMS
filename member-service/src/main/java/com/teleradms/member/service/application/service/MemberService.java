package com.teleradms.member.service.application.service;

import com.teleradms.common.lib.audit.AuditEvent;
import com.teleradms.common.lib.dto.NotificationEventDTO;
import com.teleradms.common.lib.exception.AlreadyExistsException;
import com.teleradms.common.lib.exception.NotFoundException;
import com.teleradms.member.service.application.dto.request.CreateMemberRequestDTO;
import com.teleradms.member.service.application.dto.request.UpdateMemberRequestDTO;
import com.teleradms.member.service.application.dto.response.MemberResponseDTO;
import com.teleradms.member.service.application.mapper.MemberMapper;
import com.teleradms.member.service.application.port.input.MemberUseCase;
import com.teleradms.member.service.application.port.output.MemberRepositoryPort;
import com.teleradms.member.service.domain.entities.Member;
import com.teleradms.member.service.infrastructure.kafka.KafkaProducer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCase {

    private final MemberRepositoryPort memberRepositoryPort;
    private final KafkaProducer kafkaProducer;
    private final MessageSource messageSource;

    @Transactional
    @Override
    public MemberResponseDTO createMember(CreateMemberRequestDTO createMemberRequestDTO) {
        Member member = MemberMapper.toDomain(createMemberRequestDTO);

        existsByPhone(createMemberRequestDTO.getPhone());

        Member savedMember = memberRepositoryPort.save(member);

        Map<String, Object> requestData = Map.of(
                "phone", createMemberRequestDTO.getPhone(),
                "name", createMemberRequestDTO.getFirstName()
        );

        // Audit log için responseData (örneğin oluşturulan member id)
        Map<String, Object> responseData = Map.of(
                "memberId", savedMember.getId()
        );

        try {
            kafkaProducer.sendAuditLog(
                    AuditEvent.builder()
                            .serviceName("member-service")
                            .action("CREATE_MEMBER")
                            .userId(savedMember.getId().toString())   // userId olarak member id kullanıyoruz
                            .ipAddress("127.0.0.1")                    // IP adresi elde ediliyorsa set et, burada örnek localhost
                            .requestData(requestData)
                            .responseData(responseData)
                            .description("Yeni üye oluşturuldu: " + savedMember.getFirstName())
                            .build());



            kafkaProducer.sendNotification(
                    NotificationEventDTO.builder()
                            .to("orhantrkm749@gmail.com")
                            .subject("Member Service Üye kayıt ")
                            .message("Yeni üye oluşturuldu: " + savedMember.getFirstName())
                            .build()
            );


        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return MemberMapper.toResponse(savedMember);
    }

    @Cacheable(value = "member", key = "#memberId")
    @Override
    public MemberResponseDTO getMemberById(UUID memberId) {
        Member member = memberRepositoryPort.
                findById(memberId).orElseThrow(() -> new NotFoundException(messageSource.getMessage("MEMBER_ERR_NOT_FOUND", new Object[]{memberId}, LocaleContextHolder.getLocale())));

        return MemberMapper.toResponse(member);
    }

    @Cacheable(value = "members")
    @Override
    public List<MemberResponseDTO> getAllMembers() {
        List<Member> members = memberRepositoryPort.findAll();
        return members.stream().map(MemberMapper::toResponse).toList();
    }

    @CacheEvict(value = "member", key = "#memberId")
    @Override
    public MemberResponseDTO updateMember(UUID memberId, UpdateMemberRequestDTO updateMemberRequestDTO) {
        Member member = memberRepositoryPort.
                findById(memberId).orElseThrow(() -> new NotFoundException(messageSource.getMessage("MEMBER_ERR_NOT_FOUND", new Object[]{memberId}, LocaleContextHolder.getLocale())));

        Member updatedMember = MemberMapper.updateDomain(member, updateMemberRequestDTO);
        Member savedMember = memberRepositoryPort.save(updatedMember);

        return MemberMapper.toResponse(savedMember);
    }

    @Override
    public boolean existsByPhone(String phoneNumber) {
        boolean isPhoneRegistered = memberRepositoryPort.existsByPhone(phoneNumber);
        if (isPhoneRegistered) {
            throw new AlreadyExistsException("Phone number already registered: " + phoneNumber);
        }
        return false;
    }

    @CacheEvict(value = {"member", "members"}, key = "#memberId", allEntries = true)
    @Override
    public void deleteMember(UUID memberId) {
        Member member = memberRepositoryPort.findById(memberId)
                .orElseThrow(() -> new NotFoundException(messageSource.getMessage("MEMBER_ERR_NOT_FOUND", new Object[]{memberId}, LocaleContextHolder.getLocale())));

        memberRepositoryPort.deleteById(member.getId());
    }
}
