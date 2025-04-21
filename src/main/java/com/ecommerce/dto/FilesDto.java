package com.ecommerce.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilesDto {

    private Long id;
    private String name;
    private String owner;
    private Long size;
    private String path;
    private String description;
    private LocalDate date;
    private String type;
    private String whatsnew;
}
