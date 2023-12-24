package com.delivery.domain.store.entity;

import com.delivery.domain.menu.entity.MenuEntity;
import com.delivery.domain.orderDelivery.entiy.OrderDelivery;
import com.delivery.domain.owner.entity.OwnerEntity;
import com.delivery.domain.review.entity.ReviewEntity;
import com.delivery.domain.store.dto.StoreDto;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;


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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_table_id")
    private OwnerEntity owner_table_id;


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

//    public static StoreEntity toEntity( StoreDto storeDto,MenuEntity menuEntity,
//                                        OrderDelivery orderDelivery,
//                                        ReviewEntity reviewEntity,
//                                        OwnerEntity ownerEntity
//                                        ) {
//        return new StoreEntity(
//                storeDto.getId(),
//                menuEntity,
//                orderDelivery,
//                reviewEntity,
//                ownerEntity,
//                storeDto.getName(),
//                storeDto.getPhone(),
//                storeDto.getAddress(),
//                storeDto.getOpen_time(),
//                storeDto.getClose_time(),
//                storeDto.getRest_day(),
//                storeDto.getContent(),
//                storeDto.getPhoto()
//        );
//    }

    public StoreEntity toCreate(StoreDto storeDto,  MenuEntity menuEntity,OrderDelivery orderDelivery
                                ){
        return new StoreEntity(id,  owner_table_id, name, phone, address, open_time, close_time, rest_day, content, photo);
    }
    public static StoreEntity toEntity(StoreDto storeDto, MenuEntity menuEntity,
                                       OrderDelivery orderDelivery,
                                       ReviewEntity reviewEntity,
                                       OwnerEntity ownerEntity) {
        return new StoreEntity();
    }
}
