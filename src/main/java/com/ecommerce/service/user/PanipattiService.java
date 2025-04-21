package com.ecommerce.service.user;
import com.ecommerce.dto.PanipattiDto;

import java.util.List;
import java.util.Optional;

public interface PanipattiService {
    List<PanipattiDto> getAllPanipatti();
    Optional<PanipattiDto> getPanipattiById(Long id);
    PanipattiDto savePanipatti(PanipattiDto panipattiDto);
    PanipattiDto updatePanipatti(Long id, PanipattiDto updatedPanipattiDto);
    void deletePanipatti(Long id);
}