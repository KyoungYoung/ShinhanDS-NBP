package com.delivery.domain.menu.entity;

import com.delivery.domain.menu.dto.MenuDto;
import com.delivery.domain.store.dto.StoreDto;
import com.delivery.domain.store.entity.StoreEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Table(name = "store_menu")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class MenuEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menuId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private StoreEntity store_id;

    @Column
    private String name;
    @Column
    private int menu_price;
    @Column
    private String content;
    @Column
    private String popular;
    @Column
    private String photo;



    public MenuEntity toCreate(MenuDto menuDto){
        return new MenuEntity(id, store_id, name, menu_price, content, popular, photo);
    }
    public static MenuEntity toEntity(MenuDto menuDto, StoreEntity storeEntity) {

        return new MenuEntity();
    }

}


