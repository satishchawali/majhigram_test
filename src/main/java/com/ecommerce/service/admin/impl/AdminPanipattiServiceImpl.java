package com.ecommerce.service.admin.impl;

import com.ecommerce.dto.PanipattiDto;
import com.ecommerce.entity.Panipatti;
import com.ecommerce.repo.PanipattiRepository;
import com.ecommerce.service.admin.AdminPanipattiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminPanipattiServiceImpl implements AdminPanipattiService {

    @Autowired
    private PanipattiRepository panipattiRepository;

    @Override
    public List<PanipattiDto> getAllPanipatti() {
        return panipattiRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PanipattiDto> getPanipattiById(Long id) {
        return panipattiRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public PanipattiDto savePanipatti(PanipattiDto panipattiDto) {
        Panipatti panipatti = convertToEntity(panipattiDto);
        Panipatti savedPanipatti = panipattiRepository.save(panipatti);
        return convertToDto(savedPanipatti);
    }

    @Override
    public PanipattiDto updatePanipatti(Long id, PanipattiDto updatedPanipattiDto) {
        return panipattiRepository.findById(id).map(existingRecord -> {
            existingRecord.setGpid(updatedPanipattiDto.getGpid());
            existingRecord.setUserId(updatedPanipattiDto.getUserId());
            existingRecord.setKhatedar(updatedPanipattiDto.getKhatedar());
            existingRecord.setBillcount(updatedPanipattiDto.getBillcount());
            existingRecord.setTaxname(updatedPanipattiDto.getTaxname());
            existingRecord.setOld(updatedPanipattiDto.getOld());
            existingRecord.setCurrent(updatedPanipattiDto.getCurrent());
            existingRecord.setCreated(updatedPanipattiDto.getCreated());
            existingRecord.setModified(updatedPanipattiDto.getModified());
            Panipatti updatedPanipatti = panipattiRepository.save(existingRecord);
            return convertToDto(updatedPanipatti);
        }).orElseThrow(() -> new RuntimeException("Panipatti record not found with id " + id));
    }

    @Override
    public void deletePanipatti(Long id) {
        panipattiRepository.deleteById(id);
    }

    private PanipattiDto convertToDto(Panipatti panipatti) {
        return new PanipattiDto(
                panipatti.getId(),
                panipatti.getGpid(),
                panipatti.getUserId(),
                panipatti.getKhatedar(),
                panipatti.getBillcount(),
                panipatti.getTaxname(),
                panipatti.getOld(),
                panipatti.getCurrent(),
                panipatti.getCreated(),
                panipatti.getModified()
        );
    }

    private Panipatti convertToEntity(PanipattiDto panipattiDto) {
        Panipatti panipatti = new Panipatti();
        panipatti.setId(panipattiDto.getId());
        panipatti.setGpid(panipattiDto.getGpid());
        panipatti.setUserId(panipattiDto.getUserId());
        panipatti.setKhatedar(panipattiDto.getKhatedar());
        panipatti.setBillcount(panipattiDto.getBillcount());
        panipatti.setTaxname(panipattiDto.getTaxname());
        panipatti.setOld(panipattiDto.getOld());
        panipatti.setCurrent(panipattiDto.getCurrent());
        panipatti.setCreated(panipattiDto.getCreated());
        panipatti.setModified(panipattiDto.getModified());
        return panipatti;
    }
}
