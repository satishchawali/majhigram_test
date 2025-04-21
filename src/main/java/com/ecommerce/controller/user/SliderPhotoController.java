package com.ecommerce.controller.user;

import com.ecommerce.dto.SliderPhotoDto;
import com.ecommerce.service.user.SliderPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/sliderphotos")
public class SliderPhotoController {

    @Autowired
    private SliderPhotoService sliderPhotoService;

    // Get all SliderPhotos
    @GetMapping
    public List<SliderPhotoDto> getAllSliderPhotos() {
        return sliderPhotoService.getAllSliderPhotos();
    }

    // Get a SliderPhoto by ID
    @GetMapping("/{id}")
    public ResponseEntity<SliderPhotoDto> getSliderPhotoById(@PathVariable Long id) {
        return sliderPhotoService.getSliderPhotoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new SliderPhoto
    @PostMapping
    public ResponseEntity<SliderPhotoDto> createSliderPhoto(@RequestBody SliderPhotoDto sliderPhotoDto) {
        SliderPhotoDto createdSliderPhoto = sliderPhotoService.saveSliderPhoto(sliderPhotoDto);
        return ResponseEntity.ok(createdSliderPhoto);
    }

    // Update an existing SliderPhoto
    @PutMapping("/{id}")
    public ResponseEntity<SliderPhotoDto> updateSliderPhoto(@PathVariable Long id, @RequestBody SliderPhotoDto sliderPhotoDto) {
        try {
            SliderPhotoDto updatedSliderPhoto = sliderPhotoService.updateSliderPhoto(id, sliderPhotoDto);
            return ResponseEntity.ok(updatedSliderPhoto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}