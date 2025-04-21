package com.ecommerce.entity;

import com.ecommerce.dto.FeedsDto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "feeds")
@Data
public class Feeds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "whatsnew")
    private String whatsnew;

    @Column(name = "author")
    private String author;

    @Column(name = "deleted")
    private Boolean deleted;

    // Method to convert Feeds to FeedsDto
    public FeedsDto getFeedsDto() {
        FeedsDto feedsDto = new FeedsDto();
        feedsDto.setId(id);
        feedsDto.setTitle(title);
        feedsDto.setText(text);
        feedsDto.setType(type);
        feedsDto.setDate(date);
        feedsDto.setWhatsnew(whatsnew);
        feedsDto.setAuthor(author);
        feedsDto.setDeleted(deleted);
        return feedsDto;
    }
}
