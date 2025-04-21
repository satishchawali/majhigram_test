package com.ecommerce.entity;

import com.ecommerce.dto.QuestionDto;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "question")
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String post;
    private LocalDateTime datetime;

    @Column(name = "userid")
    private Long userId;

    private String tag;

    // Getters and Setters (omitted for brevity)

    // Method to convert Entity to DTO
    public QuestionDto toDto() {
        QuestionDto dto = new QuestionDto();
        dto.setId(id);
        dto.setPost(post);
        dto.setDatetime(datetime);
        dto.setUserId(userId);
        dto.setTag(tag);
        return dto;
    }
}
