package com.ecommerce.entity;

import com.ecommerce.dto.MeetingplaceDto;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "meetingplaces")
@Data
public class Meetingplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "userid")
    private String userId;

    // Method to convert Entity to DTO
    public MeetingplaceDto toDto() {
        MeetingplaceDto dto = new MeetingplaceDto();
        dto.setId(id);
        dto.setName(name);
        dto.setUserId(userId);
        return dto;
    }
}
