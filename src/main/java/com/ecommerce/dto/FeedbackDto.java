package com.ecommerce.dto;

import lombok.Data;
@Data
public class FeedbackDto {
    private Long id;
    private String feedback;
    private Boolean approveone;
    private Boolean adminapprove;
    private Long userid;
    private String time;

}
