package com.ecommerce.controller.user;

import com.ecommerce.dto.GharpattiDto;
import com.ecommerce.service.user.GharpattiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/gharpatti")
public class GharpattiController {

    @Autowired
    private GharpattiService gharpattiService;

    // Get all Gharpatti records
    @GetMapping
    public List<GharpattiDto> getAllGharpatti() {
        return gharpattiService.getAllGharpatti();
    }

    // Get a specific Gharpatti record by ID
    @GetMapping("/{id}")
    public ResponseEntity<GharpattiDto> getGharpattiById(@PathVariable Long id) {
        return gharpattiService.getGharpattiById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Gharpatti record
    @PostMapping
    public ResponseEntity<GharpattiDto> createGharpatti(@RequestBody GharpattiDto gharpattiDto) {
        GharpattiDto createdGharpatti = gharpattiService.saveGharpatti(gharpattiDto);
        return ResponseEntity.ok(createdGharpatti);
    }

    // Update an existing Gharpatti record by ID
    @PutMapping("/{id}")
    public ResponseEntity<GharpattiDto> updateGharpatti(@PathVariable Long id, @RequestBody GharpattiDto gharpattiDto) {
        try {
            GharpattiDto updatedGharpatti = gharpattiService.updateGharpatti(id, gharpattiDto);
            return ResponseEntity.ok(updatedGharpatti);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Gharpatti record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGharpatti(@PathVariable Long id) {
        try {
            gharpattiService.deleteGharpatti(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
