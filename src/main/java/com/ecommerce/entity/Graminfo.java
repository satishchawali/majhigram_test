package com.ecommerce.entity;

import com.ecommerce.dto.GraminfoDto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "graminfo")
@Data
public class Graminfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gpname")
    private String gpname;

    @Column(name = "district")
    private String district;

    @Column(name = "taluka")
    private String taluka;

    @Column(name = "sarpanch")
    private String sarpanch;

    @Column(name = "sarpanchgender")
    private String sarpanchgender;

    @Column(name = "userid")
    private String userid;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    // Method to convert Graminfo to GraminfoDto
    public GraminfoDto toDto() {
        GraminfoDto dto = new GraminfoDto();
        dto.setId(id);
        dto.setGpname(gpname);
        dto.setDistrict(district);
        dto.setTaluka(taluka);
        dto.setSarpanch(sarpanch);
        dto.setSarpanchgender(sarpanchgender);
        dto.setUserid(userid);
        dto.setCreated(created);
        dto.setModified(modified);
        return dto;
    }
}
