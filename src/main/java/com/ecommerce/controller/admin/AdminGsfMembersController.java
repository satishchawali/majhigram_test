package com.ecommerce.controller.admin;

import com.ecommerce.dto.GsfMembersDto;
import com.ecommerce.service.admin.AdminGsfMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/gsfmembers")
public class AdminGsfMembersController {

    @Autowired
    private AdminGsfMembersService adminGsfMembersService;

    // Get all members
    @GetMapping
    public ResponseEntity<List<GsfMembersDto>> getAllMembers() {
        List<GsfMembersDto> members = adminGsfMembersService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    // Get member by ID
    @GetMapping("/{id}")
    public ResponseEntity<GsfMembersDto> getMemberById(@PathVariable Long id) {
        return adminGsfMembersService.getMemberById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Save a new member
    @PostMapping
    public ResponseEntity<GsfMembersDto> saveMember(@RequestBody GsfMembersDto memberDto) {
        GsfMembersDto savedMember = adminGsfMembersService.saveMember(memberDto);
        return ResponseEntity.ok(savedMember);
    }

    // Update an existing member
    @PutMapping("/{id}")
    public ResponseEntity<GsfMembersDto> updateMember(
            @PathVariable Long id, 
            @RequestBody GsfMembersDto updatedMemberDto
    ) {
        try {
            GsfMembersDto updatedMember = adminGsfMembersService.updateMember(id, updatedMemberDto);
            return ResponseEntity.ok(updatedMember);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a member
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        adminGsfMembersService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
