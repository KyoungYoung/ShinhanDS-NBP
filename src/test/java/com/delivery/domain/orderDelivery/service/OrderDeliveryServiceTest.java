package com.delivery.domain.orderDelivery.service;

import com.delivery.domain.orderDelivery.dto.OrderDeliveryDto;
import com.delivery.domain.orderDelivery.entiy.OrderDelivery;
import com.delivery.domain.orderDelivery.entiy.Status;
import com.delivery.domain.orderDelivery.repositry.OrderDeliveryRepository;
import com.delivery.domain.store.entity.StoreEntity;
import com.delivery.domain.store.repository.StoreRepository;
import groovy.util.logging.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDeliveryServiceTest {

    @Autowired
    private OrderDeliveryService orderDeliveryService;

    @Autowired
    private StoreRepository storeRepository;


}