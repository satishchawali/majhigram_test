package com.ecommerce.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AnswerDto {
    private Long id;
    private String post;
    private Long userid;
    private LocalDateTime datetime;
    private Long qid;
}
