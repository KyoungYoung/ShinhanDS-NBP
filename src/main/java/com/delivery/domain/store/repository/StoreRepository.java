package com.delivery.domain.store.repository;


import com.delivery.domain.store.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

    Optional<StoreEntity> findById(Long storeId);
}
