package com.ecommerce.service.admin.impl;

import com.ecommerce.dto.FilesDto;
import com.ecommerce.entity.Files;
import com.ecommerce.repo.FilesRepository;
import com.ecommerce.service.admin.AdminFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminFilesServiceImpl implements AdminFilesService {

    @Autowired
    private FilesRepository filesRepository;

    @Override
    public List<FilesDto> getAllFiles() {
        return filesRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FilesDto> getFileById(Long id) {
        return filesRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public FilesDto saveFile(FilesDto fileDTO) {
        Files file = convertToEntity(fileDTO);
        Files savedFile = filesRepository.save(file);
        return convertToDTO(savedFile);
    }

    @Override
    public FilesDto updateFile(Long id, FilesDto updatedFileDTO) {
        return filesRepository.findById(id).map(existingFile -> {
            existingFile.setName(updatedFileDTO.getName());
            existingFile.setOwner(updatedFileDTO.getOwner());
            existingFile.setSize(updatedFileDTO.getSize());
            existingFile.setPath(updatedFileDTO.getPath());
            existingFile.setDescription(updatedFileDTO.getDescription());
            existingFile.setDate(updatedFileDTO.getDate());
            existingFile.setType(updatedFileDTO.getType());
            existingFile.setWhatsnew(updatedFileDTO.getWhatsnew());
            return convertToDTO(filesRepository.save(existingFile));
        }).orElseThrow(() -> new RuntimeException("File not found with id " + id));
    }

    @Override
    public void deleteFile(Long id) {
        filesRepository.deleteById(id);
    }

    private FilesDto convertToDTO(Files file) {
        if (file == null) {
            return null;
        }
        return new FilesDto(
                file.getId(),
                file.getName(),
                file.getOwner(),
                file.getSize(),
                file.getPath(),
                file.getDescription(),
                file.getDate(),
                file.getType(),
                file.getWhatsnew()
        );
    }

    private Files convertToEntity(FilesDto dto) {
        Files file = new Files();
        file.setId(dto.getId());
        file.setName(dto.getName());
        file.setOwner(dto.getOwner());
        file.setSize(dto.getSize());
        file.setPath(dto.getPath());
        file.setDescription(dto.getDescription());
        file.setDate(dto.getDate());
        file.setType(dto.getType());
        file.setWhatsnew(dto.getWhatsnew());
        return file;
    }
}