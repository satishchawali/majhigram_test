package com.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GharpattiDto {

    private Long id;
    private String gpid;
    private String userid;
    private String khatedar;
    private Integer billcount;
    private String taxname;
    private Double old;
    private Double current;
    private LocalDateTime created;
    private LocalDateTime modified;
}
