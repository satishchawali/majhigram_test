package com.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GsfMembersDto {

    private Long id;
    private String fullname;
    private String designation;
    private String email;
    private String mobile;
    private String plan;
    private LocalDateTime dob;
    private LocalDateTime sdate;
    private String photo;
    private String status;
    private String remarks;
    private LocalDateTime created;
    private LocalDateTime modify;
    private String history;
    private String renewplan;
    private String billingAddress;
    private String district;
    private String taluka;
    private String gstin;
    private Boolean isStateBody;
    private String showNumber;

}
