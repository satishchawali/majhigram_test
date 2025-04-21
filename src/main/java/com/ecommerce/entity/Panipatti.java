package com.ecommerce.entity;

import com.ecommerce.dto.PanipattiDto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "panipatti")
@Data
public class Panipatti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gpid")
    private String gpid;

    @Column(name = "userid")
    private String userId;

    private String khatedar;
    private Integer billcount;
    private String taxname;
    private String old;
    private String current;

    private LocalDateTime created;
    private LocalDateTime modified;

    // Getters and Setters (omitted for brevity)

    // Method to convert Entity to DTO
    public PanipattiDto toDto() {
        PanipattiDto dto = new PanipattiDto();
        dto.setId(id);
        dto.setGpid(gpid);
        dto.setUserId(userId);
        dto.setKhatedar(khatedar);
        dto.setBillcount(billcount);
        dto.setTaxname(taxname);
        dto.setOld(old);
        dto.setCurrent(current);
        dto.setCreated(created);
        dto.setModified(modified);
        return dto;
    }
}
