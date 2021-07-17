package com.example.restaurantexam.naver;

import com.example.restaurantexam.naver.dto.SearchImageReq;
import com.example.restaurantexam.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class NaverClientTest {
    @Autowired
    private NaverClient naverClient;


    @Test
    public void localSearchTest(){
        var search = new SearchLocalReq();
        search.setQuery("갈비찜");
        var result = naverClient.SearchLocal(search);
        System.out.println(result);
    }

    @Test
    public void localImageTest(){
        var search = new SearchImageReq();
        search.setQuery("갈비찜");
        var result = naverClient.SearchImage(search);
        System.out.println(result);
    }
}
