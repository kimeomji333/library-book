package org.sparta.spring_week2.repository;

import org.sparta.spring_week2.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    boolean existsByBookIdAndIsAvailableFalse(Long bookId);

    List<Rental> findByMemberId(Long memberId);


    // memberId로 대출된 bookId 조회하는 쿼리
    @Query(value = "SELECT book_id FROM Rental WHERE member_id = :memberId ORDER BY due_date ASC", nativeQuery = true)
    List<Long> findBookIdsByMemberId(Long memberId);
}
