package com.ecommerce.controller.admin;

import com.ecommerce.dto.MeetingplaceDto;
import com.ecommerce.service.admin.AdminMeetingplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/meetingplaces")
public class AdminMeetingplaceController {

    @Autowired
    private AdminMeetingplaceService adminMeetingplaceService;

    // Get all meeting places
    @GetMapping
    public List<MeetingplaceDto> getAllMeetingplaces() {
        return adminMeetingplaceService.getAllMeetingplaces();
    }

    // Get a meeting place by ID
    @GetMapping("/{id}")
    public ResponseEntity<MeetingplaceDto> getMeetingplaceById(@PathVariable Long id) {
        return adminMeetingplaceService.getMeetingplaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new meeting place
    @PostMapping
    public ResponseEntity<MeetingplaceDto> createMeetingplace(@RequestBody MeetingplaceDto meetingplaceDTO) {
        MeetingplaceDto createdMeetingplace = adminMeetingplaceService.saveMeetingplace(meetingplaceDTO);
        return ResponseEntity.ok(createdMeetingplace);
    }

    // Update an existing meeting place
    @PutMapping("/{id}")
    public ResponseEntity<MeetingplaceDto> updateMeetingplace(@PathVariable Long id, @RequestBody MeetingplaceDto meetingplaceDTO) {
        try {
            MeetingplaceDto updatedMeetingplace = adminMeetingplaceService.updateMeetingplace(id, meetingplaceDTO);
            return ResponseEntity.ok(updatedMeetingplace);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a meeting place by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeetingplace(@PathVariable Long id) {
        try {
            adminMeetingplaceService.deleteMeetingplace(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
