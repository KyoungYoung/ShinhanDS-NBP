package com.delivery.domain.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="store")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private String open_time;

    @Column
    private String close_time;

    @Column
    private String rest_day;

    @Column
    private String content;

    @Column
    private String photo;
}
