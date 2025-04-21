package com.ecommerce.service.user.impl;

import com.ecommerce.dto.SliderPhotoDto;
import com.ecommerce.entity.SliderPhoto;
import com.ecommerce.repo.SliderPhotoRepository;
import com.ecommerce.service.user.SliderPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SliderPhotoServiceImpl implements SliderPhotoService {

    @Autowired
    private SliderPhotoRepository sliderPhotoRepository;

    @Override
    public List<SliderPhotoDto> getAllSliderPhotos() {
        return sliderPhotoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SliderPhotoDto> getSliderPhotoById(Long id) {
        return sliderPhotoRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public SliderPhotoDto saveSliderPhoto(SliderPhotoDto sliderPhotoDto) {
        SliderPhoto sliderPhoto = convertToEntity(sliderPhotoDto);
        SliderPhoto savedSliderPhoto = sliderPhotoRepository.save(sliderPhoto);
        return convertToDto(savedSliderPhoto);
    }

    @Override
    public SliderPhotoDto updateSliderPhoto(Long id, SliderPhotoDto updatedSliderPhotoDto) {
        return sliderPhotoRepository.findById(id).map(existingSliderPhoto -> {
            existingSliderPhoto.setFtext(updatedSliderPhotoDto.getFtext());
            existingSliderPhoto.setSrno(updatedSliderPhotoDto.getSrno());
            existingSliderPhoto.setPhoto(updatedSliderPhotoDto.getPhoto());
            SliderPhoto updatedSliderPhoto = sliderPhotoRepository.save(existingSliderPhoto);
            return convertToDto(updatedSliderPhoto);
        }).orElseThrow(() -> new RuntimeException("SliderPhoto not found with id " + id));
    }

    @Override
    public void deleteSliderPhoto(Long id) {
        sliderPhotoRepository.deleteById(id);
    }

    private SliderPhotoDto convertToDto(SliderPhoto sliderPhoto) {
        return new SliderPhotoDto(
                sliderPhoto.getId(),
                sliderPhoto.getFtext(),
                sliderPhoto.getSrno(),
                sliderPhoto.getPhoto()
        );
    }

    private SliderPhoto convertToEntity(SliderPhotoDto sliderPhotoDto) {
        SliderPhoto sliderPhoto = new SliderPhoto();
        sliderPhoto.setId(sliderPhotoDto.getId());
        sliderPhoto.setFtext(sliderPhotoDto.getFtext());
        sliderPhoto.setSrno(sliderPhotoDto.getSrno());
        sliderPhoto.setPhoto(sliderPhotoDto.getPhoto());
        return sliderPhoto;
    }
}