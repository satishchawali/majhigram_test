package com.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private Long id;
    private String post;
    private LocalDateTime datetime;
    private Long userId;
    private String tag;
}
