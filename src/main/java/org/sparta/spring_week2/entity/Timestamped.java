package org.sparta.spring_week2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)  // 자동으로 시간을 넣어줌
public abstract class Timestamped {

    @CreatedDate  // entity 객체가 생성되어 저장이 될 때, 시간이 자동으로 저장됨. 최초 시간만 저장되고, 그 이후에는 수정이 되면 안되니깐
    @Column(updatable = false)  // 시간 업데이트가 되지 않게 막아줌.
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

//    @LastModifiedDate // 조회하는 entity 객체의 값을 변경할 때, 변경된 시간이 자동으로 저장됨.
//    @Column
//    @Temporal(TemporalType.TIMESTAMP)  // 자바의 date, calender 처럼 날짜 데이터를 매핑할 때 사용
//    private LocalDateTime modifiedAt;
}