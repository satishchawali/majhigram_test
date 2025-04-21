package com.ecommerce.controller.user;

import com.ecommerce.dto.GraminfoDto;
import com.ecommerce.service.user.GraminfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user/graminfo")
public class GraminfoController {

    @Autowired
    private GraminfoService graminfoService;

    // Get all Graminfo records
    @GetMapping
    public List<GraminfoDto> getAllGraminfo() {
        return graminfoService.getAllGraminfo();
    }

    // Get a specific Graminfo record by ID
    @GetMapping("/{id}")
    public ResponseEntity<GraminfoDto> getGraminfoById(@PathVariable Long id) {
        return graminfoService.getGraminfoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Graminfo record
    @PostMapping
    public ResponseEntity<GraminfoDto> createGraminfo(@RequestBody GraminfoDto graminfoDto) {
        GraminfoDto createdGraminfo = graminfoService.saveGraminfo(graminfoDto);
        return ResponseEntity.ok(createdGraminfo);
    }

    // Update an existing Graminfo record by ID
    @PutMapping("/{id}")
    public ResponseEntity<GraminfoDto> updateGraminfo(@PathVariable Long id, @RequestBody GraminfoDto graminfoDto) {
        try {
            GraminfoDto updatedGraminfo = graminfoService.updateGraminfo(id, graminfoDto);
            return ResponseEntity.ok(updatedGraminfo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Graminfo record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGraminfo(@PathVariable Long id) {
        try {
            graminfoService.deleteGraminfo(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
