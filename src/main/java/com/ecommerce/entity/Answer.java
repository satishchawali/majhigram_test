package com.ecommerce.entity;

import com.ecommerce.dto.AnswerDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "answer")
@Data
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String post;
    private Long userid;
    private Long qid;

    @Column(name = "datetime", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime datetime;

    // Method to convert Answer to AnswerDto
    public AnswerDto getAnswerDto() {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setId(id);
        answerDto.setPost(post);
        answerDto.setUserid(userid);
        answerDto.setDatetime(datetime);
        answerDto.setQid(qid);
        return answerDto;
    }
}
