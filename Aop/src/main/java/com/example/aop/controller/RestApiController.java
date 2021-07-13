package com.example.aop.controller;

import com.example.aop.annotaion.Decode;
import com.example.aop.annotaion.Timer;
import com.example.aop.dto.user;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.ResponseWrapper;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String  get(@PathVariable Long id , @RequestParam String name){
        System.out.println("get method");
        return id+ " "+ name;

    }
    @PostMapping("/post")
    public user post(@RequestBody user user){
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        Thread.sleep(1000*2);
    }
    @Decode
    @PutMapping("/put")
    public user put(@RequestBody user user){
        System.out.println("user");
        return user;
    }
}
