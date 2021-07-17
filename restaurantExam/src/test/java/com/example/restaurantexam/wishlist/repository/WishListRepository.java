package com.example.restaurantexam.wishlist.repository;

import com.example.restaurantexam.restaurant.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListRepository {

    @Autowired
    private com.example.restaurantexam.restaurant.repository.WishListRepository wishListRepository;

    private WishListEntity create(){
        var wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("ca");
        wishList.setAddress("ad");
        wishList.setRoadAddress("rad");
        wishList.setHomePageLink("homepg");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);
        return wishList;
    }
    @Test
    public void Test1(){
        var wishList = create();
        var expected = wishListRepository.save(wishList);
        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1,expected.getIndex());
    }
    @Test

    public void Test2(){
        var wishList = create();
        wishListRepository.save(wishList);
        var expected = wishListRepository.findById(1);
        Assertions.assertEquals(true,expected.isPresent());
        Assertions.assertEquals(1,expected.get().getIndex());

    }
    @Test
    public void Test3(){

    }
    @Test
    public void Test4(){

    }
}
