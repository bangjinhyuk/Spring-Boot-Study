package com.example.restaurantexam.restaurant.repository;

import com.example.restaurantexam.db.MemoryDbRepositoryAbstract;
import com.example.restaurantexam.restaurant.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
}
