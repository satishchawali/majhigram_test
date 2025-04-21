package com.ecommerce.service.user.impl;

import com.ecommerce.dto.GharpattiDto;
import com.ecommerce.entity.Gharpatti;
import com.ecommerce.repo.GharpattiRepository;
import com.ecommerce.service.user.GharpattiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GharpattiServiceImpl implements GharpattiService {

    @Autowired
    private GharpattiRepository gharpattiRepository;

    @Override
    public List<GharpattiDto> getAllGharpatti() {
        return gharpattiRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GharpattiDto> getGharpattiById(Long id) {
        return gharpattiRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public GharpattiDto saveGharpatti(GharpattiDto gharpattiDto) {
        Gharpatti gharpatti = convertToEntity(gharpattiDto);
        Gharpatti savedGharpatti = gharpattiRepository.save(gharpatti);
        return convertToDto(savedGharpatti);
    }

    @Override
    public GharpattiDto updateGharpatti(Long id, GharpattiDto updatedGharpattiDto) {
        return gharpattiRepository.findById(id).map(existingGharpatti -> {
            existingGharpatti.setGpid(updatedGharpattiDto.getGpid());
            existingGharpatti.setUserid(updatedGharpattiDto.getUserid());
            existingGharpatti.setKhatedar(updatedGharpattiDto.getKhatedar());
            existingGharpatti.setBillcount(updatedGharpattiDto.getBillcount());
            existingGharpatti.setTaxname(updatedGharpattiDto.getTaxname());
            existingGharpatti.setOld(updatedGharpattiDto.getOld());
            existingGharpatti.setCurrent(updatedGharpattiDto.getCurrent());
            existingGharpatti.setCreated(updatedGharpattiDto.getCreated());
            existingGharpatti.setModified(updatedGharpattiDto.getModified());
            return convertToDto(gharpattiRepository.save(existingGharpatti));
        }).orElseThrow(() -> new RuntimeException("Gharpatti not found with id " + id));
    }

    @Override
    public void deleteGharpatti(Long id) {
        gharpattiRepository.deleteById(id);
    }

    private GharpattiDto convertToDto(Gharpatti gharpatti) {
        if (gharpatti == null) {
            return null;
        }
        return new GharpattiDto(
                gharpatti.getId(),
                gharpatti.getGpid(),
                gharpatti.getUserid(),
                gharpatti.getKhatedar(),
                gharpatti.getBillcount(),
                gharpatti.getTaxname(),
                gharpatti.getOld(),
                gharpatti.getCurrent(),
                gharpatti.getCreated(),
                gharpatti.getModified()
        );
    }

    private Gharpatti convertToEntity(GharpattiDto dto) {
        Gharpatti gharpatti = new Gharpatti();
        gharpatti.setId(dto.getId());
        gharpatti.setGpid(dto.getGpid());
        gharpatti.setUserid(dto.getUserid());
        gharpatti.setKhatedar(dto.getKhatedar());
        gharpatti.setBillcount(dto.getBillcount());
        gharpatti.setTaxname(dto.getTaxname());
        gharpatti.setOld(dto.getOld());
        gharpatti.setCurrent(dto.getCurrent());
        gharpatti.setCreated(dto.getCreated());
        gharpatti.setModified(dto.getModified());
        return gharpatti;
    }
}