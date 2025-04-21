package com.ecommerce.service.admin;
import com.ecommerce.dto.PanipattiDto;

import java.util.List;
import java.util.Optional;

public interface AdminPanipattiService {
    List<PanipattiDto> getAllPanipatti();
    Optional<PanipattiDto> getPanipattiById(Long id);
    PanipattiDto savePanipatti(PanipattiDto panipattiDto);
    PanipattiDto updatePanipatti(Long id, PanipattiDto updatedPanipattiDto);
    void deletePanipatti(Long id);
}