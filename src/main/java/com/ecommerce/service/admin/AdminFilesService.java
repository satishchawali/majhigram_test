package com.ecommerce.service.admin;


import com.ecommerce.dto.FilesDto;

import java.util.List;
import java.util.Optional;

public interface AdminFilesService {
    List<FilesDto> getAllFiles();
    Optional<FilesDto> getFileById(Long id);
    FilesDto saveFile(FilesDto fileDTO);
    FilesDto updateFile(Long id, FilesDto updatedFileDto);
    void deleteFile(Long id);
}