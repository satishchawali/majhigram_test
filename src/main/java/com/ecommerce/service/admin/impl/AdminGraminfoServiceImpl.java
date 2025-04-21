package com.ecommerce.service.admin.impl;

import com.ecommerce.dto.GraminfoDto;
import com.ecommerce.entity.Graminfo;
import com.ecommerce.repo.GraminfoRepository;
import com.ecommerce.service.admin.AdminGraminfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminGraminfoServiceImpl implements AdminGraminfoService {

    @Autowired
    private GraminfoRepository graminfoRepository;

    @Override
    public List<GraminfoDto> getAllGraminfo() {
        return graminfoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GraminfoDto> getGraminfoById(Long id) {
        return graminfoRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public GraminfoDto saveGraminfo(GraminfoDto graminfoDto) {
        Graminfo graminfo = convertToEntity(graminfoDto);
        Graminfo savedGraminfo = graminfoRepository.save(graminfo);
        return convertToDto(savedGraminfo);
    }

    @Override
    public GraminfoDto updateGraminfo(Long id, GraminfoDto updatedGraminfoDto) {
        return graminfoRepository.findById(id).map(existingGraminfo -> {
            existingGraminfo.setGpname(updatedGraminfoDto.getGpname());
            existingGraminfo.setDistrict(updatedGraminfoDto.getDistrict());
            existingGraminfo.setTaluka(updatedGraminfoDto.getTaluka());
            existingGraminfo.setSarpanch(updatedGraminfoDto.getSarpanch());
            existingGraminfo.setSarpanchgender(updatedGraminfoDto.getSarpanchgender());
            existingGraminfo.setUserid(updatedGraminfoDto.getUserid());
            existingGraminfo.setCreated(updatedGraminfoDto.getCreated());
            existingGraminfo.setModified(updatedGraminfoDto.getModified());
            return convertToDto(graminfoRepository.save(existingGraminfo));
        }).orElseThrow(() -> new RuntimeException("Graminfo not found with id " + id));
    }

    @Override
    public void deleteGraminfo(Long id) {
        graminfoRepository.deleteById(id);
    }

    private GraminfoDto convertToDto(Graminfo graminfo) {
        if (graminfo == null) {
            return null;
        }
        return new GraminfoDto(
                graminfo.getId(),
                graminfo.getGpname(),
                graminfo.getDistrict(),
                graminfo.getTaluka(),
                graminfo.getSarpanch(),
                graminfo.getSarpanchgender(),
                graminfo.getUserid(),
                graminfo.getCreated(),
                graminfo.getModified()
        );
    }

    private Graminfo convertToEntity(GraminfoDto dto) {
        Graminfo graminfo = new Graminfo();
        graminfo.setId(dto.getId());
        graminfo.setGpname(dto.getGpname());
        graminfo.setDistrict(dto.getDistrict());
        graminfo.setTaluka(dto.getTaluka());
        graminfo.setSarpanch(dto.getSarpanch());
        graminfo.setSarpanchgender(dto.getSarpanchgender());
        graminfo.setUserid(dto.getUserid());
        graminfo.setCreated(dto.getCreated());
        graminfo.setModified(dto.getModified());
        return graminfo;
    }
}
