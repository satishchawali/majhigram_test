package com.ecommerce.service.user;

import com.ecommerce.dto.SliderPhotoDto;

import java.util.List;
import java.util.Optional;

public interface SliderPhotoService {
    List<SliderPhotoDto> getAllSliderPhotos();
    Optional<SliderPhotoDto> getSliderPhotoById(Long id);
    SliderPhotoDto saveSliderPhoto(SliderPhotoDto sliderPhotoDto);
    SliderPhotoDto updateSliderPhoto(Long id, SliderPhotoDto updatedSliderPhotoDto);
    void deleteSliderPhoto(Long id);
}