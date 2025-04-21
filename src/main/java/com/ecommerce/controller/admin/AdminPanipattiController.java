package com.ecommerce.controller.admin;

import com.ecommerce.dto.PanipattiDto;
import com.ecommerce.service.admin.AdminPanipattiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/panipatti")
public class AdminPanipattiController {

    @Autowired
    private AdminPanipattiService adminPanipattiService;

    // Get all Panipatti records
    @GetMapping
    public List<PanipattiDto> getAllPanipatti() {
        return adminPanipattiService.getAllPanipatti();
    }

    // Get a Panipatti record by ID
    @GetMapping("/{id}")
    public ResponseEntity<PanipattiDto> getPanipattiById(@PathVariable Long id) {
        return adminPanipattiService.getPanipattiById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Panipatti record
    @PostMapping
    public ResponseEntity<PanipattiDto> createPanipatti(@RequestBody PanipattiDto panipattiDto) {
        PanipattiDto createdPanipatti = adminPanipattiService.savePanipatti(panipattiDto);
        return ResponseEntity.ok(createdPanipatti);
    }

    // Update an existing Panipatti record
    @PutMapping("/{id}")
    public ResponseEntity<PanipattiDto> updatePanipatti(@PathVariable Long id, @RequestBody PanipattiDto panipattiDto) {
        try {
            PanipattiDto updatedPanipatti = adminPanipattiService.updatePanipatti(id, panipattiDto);
            return ResponseEntity.ok(updatedPanipatti);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Panipatti record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanipatti(@PathVariable Long id) {
        try {
            adminPanipattiService.deletePanipatti(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
