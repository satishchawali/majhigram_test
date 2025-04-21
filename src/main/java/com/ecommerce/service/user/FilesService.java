package com.ecommerce.service.user;


import com.ecommerce.dto.FilesDto;

import java.util.List;
import java.util.Optional;

public interface FilesService {
    List<FilesDto> getAllFiles();
    Optional<FilesDto> getFileById(Long id);
    FilesDto saveFile(FilesDto fileDTO);
    FilesDto updateFile(Long id, FilesDto updatedFileDto);
    void deleteFile(Long id);
}