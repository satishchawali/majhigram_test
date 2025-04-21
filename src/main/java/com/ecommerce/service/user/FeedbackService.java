package com.ecommerce.service.user;

import com.ecommerce.dto.FeedbackDto;

import java.util.List;

public interface FeedbackService {
    List<FeedbackDto> getAllFeedbacks();
    FeedbackDto getFeedbackById(Long id);
    FeedbackDto createFeedback(FeedbackDto feedbackDto);
    FeedbackDto updateFeedback(Long id, FeedbackDto updatedFeedbackDto);
    void deleteFeedback(Long id);
}
