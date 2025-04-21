package com.ecommerce.controller.user;

import com.ecommerce.dto.FilesDto;
import com.ecommerce.service.user.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/files")
public class FilesController {

    @Autowired
    private FilesService filesService;

    // Get all files
    @GetMapping
    public List<FilesDto> getAllFiles() {
        return filesService.getAllFiles();
    }

    // Get file by ID
    @GetMapping("/{id}")
    public ResponseEntity<FilesDto> getFileById(@PathVariable Long id) {
        Optional<FilesDto> file = filesService.getFileById(id);
        return file.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Save new file
    @PostMapping
    public ResponseEntity<FilesDto> saveFile(@RequestBody FilesDto fileDTO) {
        FilesDto savedFile = filesService.saveFile(fileDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFile);
    }

    // Update file by ID
    @PutMapping("/{id}")
    public ResponseEntity<FilesDto> updateFile(@PathVariable Long id, @RequestBody FilesDto updatedFileDTO) {
        try {
            FilesDto updatedFile = filesService.updateFile(id, updatedFileDTO);
            return ResponseEntity.ok(updatedFile);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete file by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long id) {
        try {
            filesService.deleteFile(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
