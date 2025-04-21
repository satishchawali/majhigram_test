package com.ecommerce.controller.admin;

import com.ecommerce.dto.EcoYearDto;
import com.ecommerce.service.admin.AdminEcoYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ecoyears")
public class AdminEcoyearController {

    @Autowired
    private AdminEcoYearService adminEcoYearService;

    @GetMapping
    public List<EcoYearDto> getAllEcoyears() {
        return adminEcoYearService.getAllEcoyears();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EcoYearDto> getEcoyearById(@PathVariable Long id) {
        EcoYearDto ecoYearDto = adminEcoYearService.getEcoyearById(id);
        if (ecoYearDto != null) {
            return ResponseEntity.ok(ecoYearDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EcoYearDto> createEcoyear(@RequestBody EcoYearDto ecoYearDto) {
        EcoYearDto createdEcoYear = adminEcoYearService.saveEcoyear(ecoYearDto);
        return ResponseEntity.ok(createdEcoYear);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EcoYearDto> updateEcoyear(@PathVariable Long id, @RequestBody EcoYearDto updatedEcoYearDto) {
        try {
            EcoYearDto updatedEcoYear = adminEcoYearService.updateEcoyear(id, updatedEcoYearDto);
            return ResponseEntity.ok(updatedEcoYear);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEcoyear(@PathVariable Long id) {
        adminEcoYearService.deleteEcoyear(id);
        return ResponseEntity.noContent().build();
    }
}
