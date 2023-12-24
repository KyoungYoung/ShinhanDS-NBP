package com.delivery.domain.menu.dto;


import com.delivery.domain.menu.entity.MenuEntity;
import com.delivery.domain.store.entity.StoreEntity;
import lombok.*;


@AllArgsConstructor
@ToString
@Getter
@Setter
public class MenuDto {

    private Long id;
    private String name;
    private int menu_price;
    private String content;
    private String popular;
    private String photo;
    private StoreEntity store_id;


    public MenuEntity toCreate(){
        return new MenuEntity(id, store_id, name, menu_price, content, popular, photo);
    }

}





