package com.ecommerce.controller.admin;

import com.ecommerce.dto.MeetingSubjectDto;
import com.ecommerce.service.admin.AdminMeetingSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/meetingsubjects")
public class AdminMeetingSubjectController {

    @Autowired
    private AdminMeetingSubjectService adminMeetingSubjectService;

    // Get all meeting subjects
    @GetMapping
    public List<MeetingSubjectDto> getAllMeetingSubjects() {
        return adminMeetingSubjectService.getAllMeetingSubjects();
    }

    // Get a meeting subject by ID
    @GetMapping("/{id}")
    public ResponseEntity<MeetingSubjectDto> getMeetingSubjectById(@PathVariable Long id) {
        return adminMeetingSubjectService.getMeetingSubjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new meeting subject
    @PostMapping
    public ResponseEntity<MeetingSubjectDto> createMeetingSubject(@RequestBody MeetingSubjectDto meetingSubjectDto) {
        MeetingSubjectDto createdMeetingSubject = adminMeetingSubjectService.saveMeetingSubject(meetingSubjectDto);
        return ResponseEntity.ok(createdMeetingSubject);
    }

    // Update an existing meeting subject
    @PutMapping("/{id}")
    public ResponseEntity<MeetingSubjectDto> updateMeetingSubject(@PathVariable Long id, @RequestBody MeetingSubjectDto meetingSubjectDto) {
        try {
            MeetingSubjectDto updatedMeetingSubject = adminMeetingSubjectService.updateMeetingSubject(id, meetingSubjectDto);
            return ResponseEntity.ok(updatedMeetingSubject);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a meeting subject by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeetingSubject(@PathVariable Long id) {
        try {
            adminMeetingSubjectService.deleteMeetingSubject(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
