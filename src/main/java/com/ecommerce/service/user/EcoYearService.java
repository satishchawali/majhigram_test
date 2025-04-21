package com.ecommerce.service.user;

import com.ecommerce.dto.EcoYearDto;

import java.util.List;

public interface EcoYearService {
    List<EcoYearDto> getAllEcoyears();
    EcoYearDto getEcoyearById(Long id);
    EcoYearDto saveEcoyear(EcoYearDto ecoYearDto);
    EcoYearDto updateEcoyear(Long id, EcoYearDto updatedEcoYearDto);
    void deleteEcoyear(Long id);
}
