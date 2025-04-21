package com.ecommerce.service.admin;

import com.ecommerce.dto.EcoYearDto;

import java.util.List;

public interface AdminEcoYearService {
    List<EcoYearDto> getAllEcoyears();
    EcoYearDto getEcoyearById(Long id);
    EcoYearDto saveEcoyear(EcoYearDto ecoYearDto);
    EcoYearDto updateEcoyear(Long id, EcoYearDto updatedEcoYearDto);
    void deleteEcoyear(Long id);
}
