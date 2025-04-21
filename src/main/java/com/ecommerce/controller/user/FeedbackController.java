package com.ecommerce.controller.user;

import com.ecommerce.dto.FeedbackDto;
import com.ecommerce.service.user.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Get all Feedback records
    @GetMapping
    public List<FeedbackDto> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    // Get Feedback by ID
    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDto> getFeedbackById(@PathVariable Long id) {
        FeedbackDto feedbackDto = feedbackService.getFeedbackById(id);
        if (feedbackDto != null) {
            return ResponseEntity.ok(feedbackDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new Feedback record
    @PostMapping
    public ResponseEntity<FeedbackDto> createFeedback(@RequestBody FeedbackDto feedbackDto) {
        FeedbackDto createdFeedback = feedbackService.createFeedback(feedbackDto);
        return ResponseEntity.ok(createdFeedback);
    }

    // Update an existing Feedback record
    @PutMapping("/{id}")
    public ResponseEntity<FeedbackDto> updateFeedback(@PathVariable Long id, @RequestBody FeedbackDto updatedFeedbackDto) {
        try {
            FeedbackDto updatedFeedback = feedbackService.updateFeedback(id, updatedFeedbackDto);
            return ResponseEntity.ok(updatedFeedback);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Feedback by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}
