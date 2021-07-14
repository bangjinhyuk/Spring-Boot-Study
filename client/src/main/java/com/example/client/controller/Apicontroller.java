package com.example.client.controller;

import com.example.client.dto.Req;
import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class Apicontroller {

    private final RestTemplateService restTemplateService;

    public Apicontroller(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/get")
    public UserResponse getHello(){

        return restTemplateService.hello();
    }
    @GetMapping("/post")
    public UserResponse postHello(){

        return restTemplateService.hi();
    }
    @GetMapping("/exchange")
    public UserResponse postHello2(){

        return restTemplateService.exchange();
    }

    @GetMapping("/genericexchange")
    public Req<UserResponse> postHello3(){

        return restTemplateService.genericExchange();
    }
}
