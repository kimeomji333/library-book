package org.sparta.spring_week2.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class RentalRequestDto {

    // Rental
    private Long rentalId;
    private String is_return;
    private LocalDateTime returnedDate;
    private LocalDate dueDate;
    private String bookId;
    private String memberId;
}
