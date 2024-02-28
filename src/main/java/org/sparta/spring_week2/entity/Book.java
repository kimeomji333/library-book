package org.sparta.spring_week2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.spring_week2.dto.BookRequestDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "book")
public class Book extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "writer", nullable = false)
    private String writer;

    // 대출 상태 가져온 것! 지우면 안돼요!
    @Column(name = "is_available", nullable = false)
    private boolean is_available;

    public Book(BookRequestDto requestDto) {
        this.language = requestDto.getLanguage();
        this.publisher = requestDto.getPublisher();
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
    }

}