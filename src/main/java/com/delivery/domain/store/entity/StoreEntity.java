package com.delivery.domain.store.entity;

import com.delivery.domain.member.entity.MemberEntity;
import com.delivery.domain.menu.dto.MenuDto;
import com.delivery.domain.menu.entity.MenuEntity;
import com.delivery.domain.orderDelivery.dto.OrderDeliveryDto;
import com.delivery.domain.orderDelivery.entiy.OrderDelivery;
import com.delivery.domain.store.dto.StoreDto;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name="store")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class StoreEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
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

    public static StoreEntity toEntity( StoreDto storeDto ) {
        return new StoreEntity(
                storeDto.getId(),
                storeDto.getName(),
                storeDto.getPhone(),
                storeDto.getAddress(),
                storeDto.getOpen_time(),
                storeDto.getClose_time(),
                storeDto.getRest_day(),
                storeDto.getContent(),
                storeDto.getPhoto()
        );
    }

    public StoreEntity toCreate(StoreDto storeDto){
        return new StoreEntity(id, name, phone, address, open_time, close_time, rest_day, content, photo);
    }
    public static StoreEntity toEntity(StoreDto storeDto, MenuEntity menuEntity) {

        return new StoreEntity();
    }
}
