package org.sparta.spring_week2.dto;

import lombok.Getter;

@Getter
public class BookRequestDto {

    // Book
    private Long bookId;
    private String title;
    private String writer;
    private String language;
    private String publisher;
}
