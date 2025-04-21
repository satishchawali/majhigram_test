package com.ecommerce.entity;

import com.ecommerce.dto.FeedbackDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "feedback")
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String feedback;
    private Boolean approveone;
    private Boolean adminapprove;
    private Long userid;

    @Column(name = "time")
    private String time;

    // Method to convert Feedback to FeedbackDto
    public FeedbackDto getFeedbackDto() {
        FeedbackDto feedbackDto = new FeedbackDto();
        feedbackDto.setId(id);
        feedbackDto.setFeedback(feedback);
        feedbackDto.setApproveone(approveone);
        feedbackDto.setAdminapprove(adminapprove);
        feedbackDto.setUserid(userid);
        feedbackDto.setTime(time);
        return feedbackDto;
    }
}
