package com.ecommerce.controller.admin;

import com.ecommerce.dto.FilesDto;
import com.ecommerce.service.admin.AdminFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/files")
public class AdminFilesController {

    @Autowired
    private AdminFilesService adminFilesService;

    // Get all files
    @GetMapping
    public ResponseEntity<List<FilesDto>> getAllFiles() {
        List<FilesDto> files = adminFilesService.getAllFiles();
        return ResponseEntity.ok(files);
    }

    // Get file by ID
    @GetMapping("/{id}")
    public ResponseEntity<FilesDto> getFileById(@PathVariable Long id) {
        return adminFilesService.getFileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Save a new file
    @PostMapping
    public ResponseEntity<FilesDto> saveFile(@RequestBody FilesDto fileDto) {
        FilesDto savedFile = adminFilesService.saveFile(fileDto);
        return ResponseEntity.ok(savedFile);
    }

    // Update an existing file
    @PutMapping("/{id}")
    public ResponseEntity<FilesDto> updateFile(@PathVariable Long id, @RequestBody FilesDto updatedFileDto) {
        try {
            FilesDto updatedFile = adminFilesService.updateFile(id, updatedFileDto);
            return ResponseEntity.ok(updatedFile);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a file
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long id) {
        adminFilesService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }
}
