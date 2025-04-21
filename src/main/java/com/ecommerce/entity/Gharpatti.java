package com.ecommerce.entity;

import com.ecommerce.dto.GharpattiDto;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "gharpatti")
@Data
public class Gharpatti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gpid")
    private String gpid;

    @Column(name = "userid")
    private String userid;

    @Column(name = "khatedar")
    private String khatedar;

    @Column(name = "billcount")
    private Integer billcount;

    @Column(name = "taxname")
    private String taxname;

    @Column(name = "old")
    private Double old;

    @Column(name = "current")
    private Double current;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    // Method to convert Gharpatti to GharpattiDto
    public GharpattiDto getGharpattiDto() {
        GharpattiDto dto = new GharpattiDto();
        dto.setId(id);
        dto.setGpid(gpid);
        dto.setUserid(userid);
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
