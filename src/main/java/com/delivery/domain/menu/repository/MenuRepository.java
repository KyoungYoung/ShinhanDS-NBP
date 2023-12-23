package com.delivery.domain.menu.repository;

import com.delivery.domain.article.entity.ArticleEntity;
import com.delivery.domain.menu.dto.MenuDto;
import com.delivery.domain.menu.entity.MenuEntity;
import com.delivery.domain.orderDelivery.entiy.OrderDelivery;
import com.delivery.domain.store.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

    Optional<MenuEntity> findById(Long menuId);


}
