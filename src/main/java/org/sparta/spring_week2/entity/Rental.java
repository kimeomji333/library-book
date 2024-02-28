package org.sparta.spring_week2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "rental")
@NoArgsConstructor
public class Rental extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id; // Rental 클래스의 id이고, 테이블명이 rental이므로 자동으로 rentalId로 인식하게 된다.

    private Long memberId; // 필드값으로 가져오면 해당 필드를 사용할 수 있다.

    private Long bookId;

//    @ManyToOne // 다대일 관계를 나타냄
//    @JoinColumn(name = "book_id") // 외래 키를 매핑
//    private Book book; // Book 엔터티 클래스와의 관계를 매핑

    // 반납일
    @Column(name = "returnedDate", nullable = false)
    private LocalDateTime returnedDate;

    // 대출일
    @Column(name = "dueDate", nullable = false)
    private LocalDate dueDate;

    // 반납 상태
    @Column(name = "is_returned", nullable = false)
    private boolean is_returned;

    @Column(name = "is_available", nullable = false)
    private boolean isAvailable;

    public void putIs_returned(boolean is_returned) {
        this.is_returned = is_returned;
    }


    // ??? @ManyToOne 사용하지 않으려면, 필드와 인스턴스화를 직접 작성해야하나요?
    public void setMemberId(Long memberId) {
        Member member = new Member();
        member.setMemberId(memberId);
        this.memberId = memberId;
    }

    public void setBookId(Long bookId) {
        Book book = new Book();
        book.setBookId(bookId);
        this.bookId = bookId;
    }

    public void update() {
        this.is_returned = true;
        this.returnedDate = LocalDateTime.now();
    }

    public void setReturnStatus(boolean is_returned) {
        this.is_returned = is_returned;
    }
}
