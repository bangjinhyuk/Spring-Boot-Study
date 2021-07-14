package com.example.async.controller;

import com.example.async.service.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Apicontroller {

    private final AsyncService asyncService;

    @GetMapping("/hello")
    public CompletableFuture hello(){
        log.info("competable future init");
        asyncService.run();
        asyncService.run();
        asyncService.run();
        return asyncService.run();


    }

}
