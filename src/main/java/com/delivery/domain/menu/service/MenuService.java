package com.delivery.domain.menu.service;

import com.delivery.domain.menu.dto.MenuDto;
import com.delivery.domain.menu.entity.MenuEntity;
import com.delivery.domain.menu.repository.MenuRepository;
import com.delivery.domain.store.entity.StoreEntity;
import com.delivery.domain.store.repository.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Transactional
@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;

    public MenuEntity create(MenuDto menuDto) {
        StoreEntity storeEntity = storeRepository.findById(menuDto.getStore_id().getId())
                .orElseThrow(() -> new EntityNotFoundException("해당 가게를 찾을 수 없습니다."));

        MenuEntity menuEntity = MenuEntity.toEntity(menuDto, storeEntity);

        return menuRepository.save(menuEntity);
    }
}
