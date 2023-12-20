package com.delivery.domain.store.dto;

import com.delivery.domain.store.entity.StoreEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
public class StoreDto {

    private Long id;
    private String name;
    private String phone;
    private String address;
    private String open_time;
    private String close_time;
    private String rest_day;
    private String content;
    private String photo;

    public StoreEntity toEntity(){
        return new StoreEntity(id, name, phone, address, open_time, close_time, rest_day, content, photo);
    }
}
