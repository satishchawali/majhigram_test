package com.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanipattiDto {

    private Long id;
    private String gpid;
    private String userId;
    private String khatedar;
    private Integer billcount;
    private String taxname;
    private String old;
    private String current;
    private LocalDateTime created;
    private LocalDateTime modified;

}
