package com.ecommerce.entity;

import com.ecommerce.dto.FilesDto;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "files")
@Data
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "owner")
    private String owner;

    @Column(name = "size")
    private Long size;

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "type")
    private String type;

    @Column(name = "whatsnew")
    private String whatsnew;

    // Method to convert Files to FilesDto
    public FilesDto getFilesDto() {
        FilesDto filesDto = new FilesDto();
        filesDto.setId(id);
        filesDto.setName(name);
        filesDto.setOwner(owner);
        filesDto.setSize(size);
        filesDto.setPath(path);
        filesDto.setDescription(description);
        filesDto.setDate(date);
        filesDto.setType(type);
        filesDto.setWhatsnew(whatsnew);
        return filesDto;
    }
}
