package com.teleradms.member.service.infrastructure.rest.controller;

import com.teleradms.member.service.application.dto.request.CreateMemberRequestDTO;
import com.teleradms.member.service.application.dto.request.UpdateMemberRequestDTO;
import com.teleradms.member.service.application.dto.response.MemberResponseDTO;
import com.teleradms.member.service.application.port.input.MemberUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

    @Operation(summary = "Create a new member")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Member created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")}
    )
    @PostMapping
    public ResponseEntity<MemberResponseDTO> create(@Valid @RequestBody CreateMemberRequestDTO dto) {
        MemberResponseDTO member = memberUseCase.createMember(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    @Operation(summary = "Get a member by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Member found"),
            @ApiResponse(responseCode = "404", description = "Member not found")}
    )
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> getById(@PathVariable UUID id) {
        MemberResponseDTO member = memberUseCase.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    @Operation(summary = "Get all members")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Members found")}
    )
    @GetMapping
    public ResponseEntity<List<MemberResponseDTO>> getAll() {
        return ResponseEntity.ok(memberUseCase.getAllMembers());
    }

    @Operation(summary = "Update a member")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Member updated"),
            @ApiResponse(responseCode = "404", description = "Member not found")}
    )
    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> update(@PathVariable UUID id,
                                                    @Valid @RequestBody UpdateMemberRequestDTO dto) {
        return ResponseEntity.ok(memberUseCase.updateMember(id, dto));
    }

    @Operation(summary = "Delete a member")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Member deleted"),
            @ApiResponse(responseCode = "404", description = "Member not found")}
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        memberUseCase.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
