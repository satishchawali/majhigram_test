package com.ecommerce.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FeedsDto {

    private Long id;
    private String title;
    private String text;
    private String type;
    private LocalDate date;
    private String whatsnew;
    private String author;
    private Boolean deleted;

    public FeedsDto(Long id, String title, String text, String type, LocalDate date, String whatsnew, String author, Boolean deleted) {
    }

    public FeedsDto() {

    }
}
