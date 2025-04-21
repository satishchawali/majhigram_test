package com.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SliderPhotoDto {

    private Long id;
    private String ftext;
    private Integer srno;
    private String photo;
}
