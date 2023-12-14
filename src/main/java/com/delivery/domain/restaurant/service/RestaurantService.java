package com.delivery.domain.restaurant.service;

import com.delivery.domain.restaurant.entiy.Restaurant;
import com.delivery.domain.restaurant.repositry.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Long join(Restaurant restaurant){
        restaurantRepository.save(restaurant);
        return restaurant.getId();
    }

    public Restaurant findOne(Long itemId){
        return restaurantRepository.findOne(itemId);
    }
}
