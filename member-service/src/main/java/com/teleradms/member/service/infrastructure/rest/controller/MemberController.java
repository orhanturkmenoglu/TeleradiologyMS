package com.teleradms.member.service.infrastructure.rest.controller;

import com.teleradms.member.service.application.dto.request.CreateMemberRequestDTO;
import com.teleradms.member.service.application.dto.request.UpdateMemberRequestDTO;
import com.teleradms.member.service.application.dto.response.MemberResponseDTO;
import com.teleradms.member.service.application.port.input.MemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberUseCase memberUseCase;

    @PostMapping
    public ResponseEntity<MemberResponseDTO> create(@RequestBody CreateMemberRequestDTO dto) {
        MemberResponseDTO member = memberUseCase.createMember(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> getById(@PathVariable UUID id) {
        MemberResponseDTO member = memberUseCase.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDTO>> getAll() {
        return ResponseEntity.ok(memberUseCase.getAllMembers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> update(@PathVariable UUID id, @RequestBody UpdateMemberRequestDTO dto) {
        return ResponseEntity.ok(memberUseCase.updateMember(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        memberUseCase.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
