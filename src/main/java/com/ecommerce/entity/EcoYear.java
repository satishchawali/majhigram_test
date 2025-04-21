package com.ecommerce.entity;

import com.ecommerce.dto.EcoYearDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ecoyear")
@Data
public class EcoYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String year;
    private Long userid;

    // Method to convert EcoYear to EcoYearDto
    public EcoYearDto getEcoYearDto() {
        EcoYearDto ecoYearDto = new EcoYearDto();
        ecoYearDto.setId(id);
        ecoYearDto.setYear(year);
        ecoYearDto.setUserid(userid);
        return ecoYearDto;
    }
}
