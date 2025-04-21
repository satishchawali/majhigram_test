package com.ecommerce.service.admin.impl;

import com.ecommerce.dto.FeedbackDto;
import com.ecommerce.entity.Feedback;
import com.ecommerce.repo.FeedbackRepository;
import com.ecommerce.service.admin.AdminFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminFeedbackServiceImpl implements AdminFeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public List<FeedbackDto> getAllFeedbacks() {
        return feedbackRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackDto getFeedbackById(Long id) {
        return feedbackRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public FeedbackDto createFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = convertToEntity(feedbackDto);
        return convertToDTO(feedbackRepository.save(feedback));
    }

    @Override
    public FeedbackDto updateFeedback(Long id, FeedbackDto updatedFeedbackDto) {
        return feedbackRepository.findById(id).map(existingFeedback -> {
            existingFeedback.setFeedback(updatedFeedbackDto.getFeedback());
            existingFeedback.setApproveone(updatedFeedbackDto.getApproveone());
            existingFeedback.setAdminapprove(updatedFeedbackDto.getAdminapprove());
            existingFeedback.setUserid(updatedFeedbackDto.getUserid());
            existingFeedback.setTime(updatedFeedbackDto.getTime());
            return convertToDTO(feedbackRepository.save(existingFeedback));
        }).orElseThrow(() -> new RuntimeException("Feedback not found with id " + id));
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    // Helper methods for DTO conversion
    private FeedbackDto convertToDTO(Feedback feedback) {
        FeedbackDto dto = new FeedbackDto();
        dto.setId(feedback.getId());
        dto.setFeedback(feedback.getFeedback());
        dto.setApproveone(feedback.getApproveone());
        dto.setAdminapprove(feedback.getAdminapprove());
        dto.setUserid(feedback.getUserid());
        dto.setTime(feedback.getTime());
        return dto;
    }

    private Feedback convertToEntity(FeedbackDto dto) {
        Feedback feedback = new Feedback();
        feedback.setId(dto.getId());
        feedback.setFeedback(dto.getFeedback());
        feedback.setApproveone(dto.getApproveone());
        feedback.setAdminapprove(dto.getAdminapprove());
        feedback.setUserid(dto.getUserid());
        feedback.setTime(dto.getTime());
        return feedback;
    }
}
