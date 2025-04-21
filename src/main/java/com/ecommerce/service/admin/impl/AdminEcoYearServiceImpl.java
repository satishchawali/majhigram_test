package com.ecommerce.service.admin.impl;

import com.ecommerce.dto.EcoYearDto;
import com.ecommerce.entity.EcoYear;
import com.ecommerce.repo.EcoYearRepository;
import com.ecommerce.service.admin.AdminEcoYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminEcoYearServiceImpl implements AdminEcoYearService {

    @Autowired
    private EcoYearRepository ecoYearRepository;

    @Override
    public List<EcoYearDto> getAllEcoyears() {
        return ecoYearRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EcoYearDto getEcoyearById(Long id) {
        return ecoYearRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public EcoYearDto saveEcoyear(EcoYearDto ecoYearDto) {
        EcoYear ecoYear = convertToEntity(ecoYearDto);
        return convertToDTO(ecoYearRepository.save(ecoYear));
    }

    @Override
    public EcoYearDto updateEcoyear(Long id, EcoYearDto updatedEcoYearDto) {
        return ecoYearRepository.findById(id).map(existing -> {
            existing.setYear(updatedEcoYearDto.getYear());
            existing.setUserid(updatedEcoYearDto.getUserid());
            return convertToDTO(ecoYearRepository.save(existing));
        }).orElseThrow(() -> new RuntimeException("EcoYear not found with id " + id));
    }

    @Override
    public void deleteEcoyear(Long id) {
        ecoYearRepository.deleteById(id);
    }

    // Helper methods for DTO conversion
    private EcoYearDto convertToDTO(EcoYear ecoYear) {
        EcoYearDto dto = new EcoYearDto();
        dto.setId(ecoYear.getId());
        dto.setYear(ecoYear.getYear());
        dto.setUserid(ecoYear.getUserid());
        return dto;
    }

    private EcoYear convertToEntity(EcoYearDto dto) {
        EcoYear ecoYear = new EcoYear();
        ecoYear.setId(dto.getId());
        ecoYear.setYear(dto.getYear());
        ecoYear.setUserid(dto.getUserid());
        return ecoYear;
    }
}
