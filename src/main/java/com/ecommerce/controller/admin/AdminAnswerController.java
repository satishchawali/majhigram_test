package com.ecommerce.controller.admin;

import com.ecommerce.dto.AnswerDto;
import com.ecommerce.service.admin.AdminAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/answers")
public class AdminAnswerController {

    @Autowired
    private AdminAnswerService adminAnswerService;

    @GetMapping
    public List<AnswerDto> getAllAnswers() {
        // Directly retrieve DTOs from the service
        return adminAnswerService.getAllAnswers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDto> getAnswerById(@PathVariable Long id) {
        // Directly retrieve the DTO from the service
        AnswerDto answerDto = adminAnswerService.getAnswerById(id);
        if (answerDto != null) {
            return ResponseEntity.ok(answerDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AnswerDto> createAnswer(@RequestBody AnswerDto answerDto) {
        // Create and return the saved DTO
        AnswerDto createdAnswer = adminAnswerService.createAnswer(answerDto);
        return ResponseEntity.ok(createdAnswer);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<AnswerDto> updateAnswer(@PathVariable Long id, @RequestBody AnswerDto answerDto) {
        try {
            // Update and return the updated DTO
            AnswerDto updatedAnswer = adminAnswerService.updateAnswer(id, answerDto);
            return ResponseEntity.ok(updatedAnswer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        adminAnswerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}
