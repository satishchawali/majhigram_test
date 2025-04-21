package com.ecommerce.service.user;

import com.ecommerce.dto.GharpattiDto;

import java.util.List;
import java.util.Optional;

public interface GharpattiService {
    List<GharpattiDto> getAllGharpatti();
    Optional<GharpattiDto> getGharpattiById(Long id);
    GharpattiDto saveGharpatti(GharpattiDto gharpattiDto);
    GharpattiDto updateGharpatti(Long id, GharpattiDto updatedGharpattiDto);
    void deleteGharpatti(Long id);
}