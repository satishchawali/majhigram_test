package com.ecommerce.controller.user;

import com.ecommerce.dto.PanipattiDto;
import com.ecommerce.service.user.PanipattiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/panipatti")
public class PanipattiController {

    @Autowired
    private PanipattiService panipattiService;

    // Get all Panipatti records
    @GetMapping
    public List<PanipattiDto> getAllPanipatti() {
        return panipattiService.getAllPanipatti();
    }

    // Get a Panipatti record by ID
    @GetMapping("/{id}")
    public ResponseEntity<PanipattiDto> getPanipattiById(@PathVariable Long id) {
        return panipattiService.getPanipattiById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new Panipatti record
    @PostMapping
    public ResponseEntity<PanipattiDto> createPanipatti(@RequestBody PanipattiDto panipattiDto) {
        PanipattiDto createdPanipatti = panipattiService.savePanipatti(panipattiDto);
        return ResponseEntity.ok(createdPanipatti);
    }

    // Update an existing Panipatti record
    @PutMapping("/{id}")
    public ResponseEntity<PanipattiDto> updatePanipatti(@PathVariable Long id, @RequestBody PanipattiDto panipattiDto) {
        try {
            PanipattiDto updatedPanipatti = panipattiService.updatePanipatti(id, panipattiDto);
            return ResponseEntity.ok(updatedPanipatti);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Panipatti record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanipatti(@PathVariable Long id) {
        try {
            panipattiService.deletePanipatti(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
