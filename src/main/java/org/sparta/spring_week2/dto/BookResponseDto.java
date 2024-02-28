package org.sparta.spring_week2.dto;


import lombok.Getter;
import org.sparta.spring_week2.entity.Book;

import java.time.LocalDateTime;
@Getter
//@Setter
public class BookResponseDto {

    // Book
    private Long bookId;
    private String title;
    private String writer;
    private String language;
    private String publisher;
    private LocalDateTime createdAt;  // createdAt 도서등록일로 사용
    //private LocalDateTime modifiedAt;  // 도서등록수정일이 필요할까?


    public BookResponseDto(Book book) {
        this.bookId = book.getBookId();
        this.language = book.getLanguage();
        this.publisher = book.getPublisher();
        this.title = book.getTitle();
        this.writer = book.getWriter();
        this.createdAt = book.getCreatedAt();
    }
}
