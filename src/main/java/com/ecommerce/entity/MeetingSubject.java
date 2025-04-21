package com.ecommerce.entity;

import com.ecommerce.dto.MeetingSubjectDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "meetingsubjects")
@Data
public class MeetingSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "userid")
    private Long userId;

    // Method to convert Entity to DTO
    public MeetingSubjectDto toDto() {
        MeetingSubjectDto dto = new MeetingSubjectDto();
        dto.setId(id);
        dto.setName(name);
        dto.setUserId(userId);
        return dto;
    }
}
