package com.ecommerce.entity;

import com.ecommerce.dto.GsfMembersDto;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "gsfmembers")
@Data
public class GsfMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "designation")
    private String designation;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "plan")
    private String plan;

    @Column(name = "dob")
    private LocalDateTime dob;

    @Column(name = "sdate")
    private LocalDateTime sdate;

    @Column(name = "password")
    private String password;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modify")
    private LocalDateTime modify;

    @Column(name = "photo")
    private String photo;

    @Column(name = "status")
    private String status;

    @Column(name = "otp")
    private String otp;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "renewplan")
    private String renewplan;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "history")
    private String history;

    @Column(name = "district")
    private String district;

    @Column(name = "taluka")
    private String taluka;

    @Column(name = "gstin")
    private String gstin;

    @Column(name = "isStateBody")
    private Boolean isStateBody;

    @Column(name = "showNumber")
    private String showNumber;

    // Method to convert Entity to DTO
    public GsfMembersDto toDto() {
        GsfMembersDto dto = new GsfMembersDto();
        dto.setId(id);
        dto.setFullname(fullname);
        dto.setDesignation(designation);
        dto.setEmail(email);
        dto.setMobile(mobile);
        dto.setPlan(plan);
        dto.setDob(dob);
        dto.setSdate(sdate);
        dto.setCreated(created);
        dto.setModify(modify);
        dto.setPhoto(photo);
        dto.setStatus(status);
        dto.setRemarks(remarks);
        dto.setRenewplan(renewplan);
        dto.setBillingAddress(billingAddress);
        dto.setHistory(history);
        dto.setDistrict(district);
        dto.setTaluka(taluka);
        dto.setGstin(gstin);
        dto.setIsStateBody(isStateBody);
        dto.setShowNumber(showNumber);
        return dto;
    }
}
