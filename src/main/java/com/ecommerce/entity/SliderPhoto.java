package com.ecommerce.entity;

import com.ecommerce.dto.SliderPhotoDto;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "sliderphotos")
@Data
public class SliderPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming 'id' is an auto-increment field
    private Long id;

    @Column(name = "ftext")
    private String ftext;

    @Column(name = "srno")
    private Integer srno;

    @Column(name = "photo")
    private String photo;

    // Getters and Setters (omitted for brevity)

    // Method to convert entity to DTO
    public SliderPhotoDto toDto() {
        SliderPhotoDto dto = new SliderPhotoDto();
        dto.setId(id);
        dto.setFtext(ftext);
        dto.setSrno(srno);
        dto.setPhoto(photo);
        return dto;
    }
}
