package com.ecommerce.controller.admin;

import com.ecommerce.dto.FeedbackDto;
import com.ecommerce.service.admin.AdminFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/feedbacks")
public class AdminFeedbackController {

    @Autowired
    private AdminFeedbackService adminFeedbackService;

    // Get all Feedback records
    @GetMapping
    public List<FeedbackDto> getAllFeedbacks() {
        return adminFeedbackService.getAllFeedbacks();
    }

    // Get Feedback by ID
    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDto> getFeedbackById(@PathVariable Long id) {
        FeedbackDto feedbackDto = adminFeedbackService.getFeedbackById(id);
        if (feedbackDto != null) {
            return ResponseEntity.ok(feedbackDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new Feedback record
    @PostMapping
    public ResponseEntity<FeedbackDto> createFeedback(@RequestBody FeedbackDto feedbackDto) {
        FeedbackDto createdFeedback = adminFeedbackService.createFeedback(feedbackDto);
        return ResponseEntity.ok(createdFeedback);
    }

    // Update an existing Feedback record
    @PutMapping("/{id}")
    public ResponseEntity<FeedbackDto> updateFeedback(@PathVariable Long id, @RequestBody FeedbackDto updatedFeedbackDto) {
        try {
            FeedbackDto updatedFeedback = adminFeedbackService.updateFeedback(id, updatedFeedbackDto);
            return ResponseEntity.ok(updatedFeedback);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Feedback by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        adminFeedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}
