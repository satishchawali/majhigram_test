package com.ecommerce.controller.admin;

import com.ecommerce.dto.SliderPhotoDto;
import com.ecommerce.service.admin.AdminSliderPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/sliderphotos")
public class AdminSliderPhotoController {

    @Autowired
    private AdminSliderPhotoService adminSliderPhotoService;

    // Get all SliderPhotos
    @GetMapping
    public List<SliderPhotoDto> getAllSliderPhotos() {
        return adminSliderPhotoService.getAllSliderPhotos();
    }

    // Get a SliderPhoto by ID
    @GetMapping("/{id}")
    public ResponseEntity<SliderPhotoDto> getSliderPhotoById(@PathVariable Long id) {
        return adminSliderPhotoService.getSliderPhotoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new SliderPhoto
    @PostMapping
    public ResponseEntity<SliderPhotoDto> createSliderPhoto(@RequestBody SliderPhotoDto sliderPhotoDto) {
        SliderPhotoDto createdSliderPhoto = adminSliderPhotoService.saveSliderPhoto(sliderPhotoDto);
        return ResponseEntity.ok(createdSliderPhoto);
    }

    // Update an existing SliderPhoto
    @PutMapping("/{id}")
    public ResponseEntity<SliderPhotoDto> updateSliderPhoto(@PathVariable Long id, @RequestBody SliderPhotoDto sliderPhotoDto) {
        try {
            SliderPhotoDto updatedSliderPhoto = adminSliderPhotoService.updateSliderPhoto(id, sliderPhotoDto);
            return ResponseEntity.ok(updatedSliderPhoto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}