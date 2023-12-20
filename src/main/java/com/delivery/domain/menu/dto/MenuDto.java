package com.delivery.domain.menu.dto;


import com.delivery.domain.menu.entity.MenuEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.orm.jpa.JpaOptimisticLockingFailureException;

@AllArgsConstructor
@ToString
public class MenuDto {

    private Long id;
    private String name;
    private String price;
    private String content;
    private String popular;
    private String photo;

    public MenuEntity toEntity(){
        return new MenuEntity(id, name, price, content, popular, photo);
    }
}
