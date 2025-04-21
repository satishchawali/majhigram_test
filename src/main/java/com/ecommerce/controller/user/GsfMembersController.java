package com.ecommerce.controller.user;

import com.ecommerce.dto.GsfMembersDto;
import com.ecommerce.service.user.GsfMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/gsfmembers")
public class GsfMembersController {

    @Autowired
    private GsfMembersService gsfMembersService;

    // Get all members
    @GetMapping
    public List<GsfMembersDto> getAllMembers() {
        return gsfMembersService.getAllMembers();
    }

    // Get member by ID
    @GetMapping("/{id}")
    public ResponseEntity<GsfMembersDto> getMemberById(@PathVariable Long id) {
        Optional<GsfMembersDto> member = gsfMembersService.getMemberById(id);
        return member.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Save new member
    @PostMapping
    public ResponseEntity<GsfMembersDto> saveMember(@RequestBody GsfMembersDto memberDto) {
        GsfMembersDto savedMember = gsfMembersService.saveMember(memberDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }

    // Update member by ID
    @PutMapping("/{id}")
    public ResponseEntity<GsfMembersDto> updateMember(@PathVariable Long id, @RequestBody GsfMembersDto updatedMemberDto) {
        try {
            GsfMembersDto updatedMember = gsfMembersService.updateMember(id, updatedMemberDto);
            return ResponseEntity.ok(updatedMember);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete member by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        try {
            gsfMembersService.deleteMember(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
