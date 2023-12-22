package com.delivery.domain.store.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;

@Entity(name="owner_entity")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column
    private String title;

    @Column
    private int tel;

    @Column
    private Time opentime;

    @Column
    private Time endtime;

    @Column
    private Date restdate;

    @Column
    private String addr;

    @Column
    private String content;
}
