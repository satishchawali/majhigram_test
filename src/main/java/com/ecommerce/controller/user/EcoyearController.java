package com.ecommerce.controller.user;

import com.ecommerce.dto.EcoYearDto;
import com.ecommerce.service.user.EcoYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/user/ecoyears")
public class EcoyearController {

    @Autowired
    private EcoYearService ecoYearService;

    @GetMapping
    public List<EcoYearDto> getAllEcoyears() {
        return ecoYearService.getAllEcoyears();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EcoYearDto> getEcoyearById(@PathVariable Long id) {
        EcoYearDto ecoYearDto = ecoYearService.getEcoyearById(id);
        if (ecoYearDto != null) {
            return ResponseEntity.ok(ecoYearDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EcoYearDto> createEcoyear(@RequestBody EcoYearDto ecoYearDto) {
        EcoYearDto createdEcoYear = ecoYearService.saveEcoyear(ecoYearDto);
        return ResponseEntity.ok(createdEcoYear);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EcoYearDto> updateEcoyear(@PathVariable Long id, @RequestBody EcoYearDto updatedEcoYearDto) {
        try {
            EcoYearDto updatedEcoYear = ecoYearService.updateEcoyear(id, updatedEcoYearDto);
            return ResponseEntity.ok(updatedEcoYear);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEcoyear(@PathVariable Long id) {
        ecoYearService.deleteEcoyear(id);
        return ResponseEntity.noContent().build();
    }
}
