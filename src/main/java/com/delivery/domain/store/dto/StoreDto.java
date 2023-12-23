package com.delivery.domain.store.dto;

import com.delivery.domain.menu.dto.MenuDto;
import com.delivery.domain.menu.entity.MenuEntity;
import com.delivery.domain.store.entity.StoreEntity;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
@Getter @Setter
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

    public StoreEntity toCreate(){
        return new StoreEntity(id, name, phone, address, open_time, close_time, rest_day, content, photo);
    }

    public static StoreDto toDto(StoreEntity storeEntity) {
        return new StoreDto(
                storeEntity.getId(),
                storeEntity.getName(),
                storeEntity.getPhone(),
                storeEntity.getAddress(),
                storeEntity.getOpen_time(),
                storeEntity.getClose_time(),
                storeEntity.getRest_day(),
                storeEntity.getContent(),
                storeEntity.getPhoto()
        );
    }
}
