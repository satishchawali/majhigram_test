package com.ecommerce.controller.user;

import com.ecommerce.dto.MeetingplaceDto;
import com.ecommerce.service.user.MeetingplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/meetingplaces")
public class MeetingplaceController {

    @Autowired
    private MeetingplaceService meetingplaceService;

    // Get all meeting places
    @GetMapping
    public List<MeetingplaceDto> getAllMeetingplaces() {
        return meetingplaceService.getAllMeetingplaces();
    }

    // Get a meeting place by ID
    @GetMapping("/{id}")
    public ResponseEntity<MeetingplaceDto> getMeetingplaceById(@PathVariable Long id) {
        return meetingplaceService.getMeetingplaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new meeting place
    @PostMapping
    public ResponseEntity<MeetingplaceDto> createMeetingplace(@RequestBody MeetingplaceDto meetingplaceDTO) {
        MeetingplaceDto createdMeetingplace = meetingplaceService.saveMeetingplace(meetingplaceDTO);
        return ResponseEntity.ok(createdMeetingplace);
    }

    // Update an existing meeting place
    @PutMapping("/{id}")
    public ResponseEntity<MeetingplaceDto> updateMeetingplace(@PathVariable Long id, @RequestBody MeetingplaceDto meetingplaceDTO) {
        try {
            MeetingplaceDto updatedMeetingplace = meetingplaceService.updateMeetingplace(id, meetingplaceDTO);
            return ResponseEntity.ok(updatedMeetingplace);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a meeting place by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeetingplace(@PathVariable Long id) {
        try {
            meetingplaceService.deleteMeetingplace(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
