package com.ecommerce.service.user;

import com.ecommerce.dto.GraminfoDto;

import java.util.List;
import java.util.Optional;

public interface GraminfoService {
    List<GraminfoDto> getAllGraminfo();
    Optional<GraminfoDto> getGraminfoById(Long id);
    GraminfoDto saveGraminfo(GraminfoDto graminfoDto);
    GraminfoDto updateGraminfo(Long id, GraminfoDto updatedGraminfoDto);
    void deleteGraminfo(Long id);
}