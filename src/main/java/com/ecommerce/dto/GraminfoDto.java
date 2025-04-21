package com.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraminfoDto {

    private Long id;
    private String gpname;
    private String district;
    private String taluka;
    private String sarpanch;
    private String sarpanchgender;
    private String userid;
    private LocalDateTime created;
    private LocalDateTime modified;
}
