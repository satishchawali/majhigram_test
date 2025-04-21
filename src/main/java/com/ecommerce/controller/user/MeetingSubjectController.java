package com.ecommerce.controller.user;

import com.ecommerce.dto.MeetingSubjectDto;
import com.ecommerce.service.user.MeetingSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/meetingsubjects")
public class MeetingSubjectController {

    @Autowired
    private MeetingSubjectService meetingSubjectService;

    // Get all meeting subjects
    @GetMapping
    public List<MeetingSubjectDto> getAllMeetingSubjects() {
        return meetingSubjectService.getAllMeetingSubjects();
    }

    // Get a meeting subject by ID
    @GetMapping("/{id}")
    public ResponseEntity<MeetingSubjectDto> getMeetingSubjectById(@PathVariable Long id) {
        return meetingSubjectService.getMeetingSubjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new meeting subject
    @PostMapping
    public ResponseEntity<MeetingSubjectDto> createMeetingSubject(@RequestBody MeetingSubjectDto meetingSubjectDto) {
        MeetingSubjectDto createdMeetingSubject = meetingSubjectService.saveMeetingSubject(meetingSubjectDto);
        return ResponseEntity.ok(createdMeetingSubject);
    }

    // Update an existing meeting subject
    @PutMapping("/{id}")
    public ResponseEntity<MeetingSubjectDto> updateMeetingSubject(@PathVariable Long id, @RequestBody MeetingSubjectDto meetingSubjectDto) {
        try {
            MeetingSubjectDto updatedMeetingSubject = meetingSubjectService.updateMeetingSubject(id, meetingSubjectDto);
            return ResponseEntity.ok(updatedMeetingSubject);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a meeting subject by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeetingSubject(@PathVariable Long id) {
        try {
            meetingSubjectService.deleteMeetingSubject(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
