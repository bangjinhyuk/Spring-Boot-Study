package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/api/server")
public class ApiController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age){
        User user = new User(name,age);
        return  user;
    }
    @PostMapping("/hi/{userId}")
    public User hi(@RequestBody User user,@PathVariable(name = "userId") int userId){
        log.info("userId: {} ",userId);
        return  user;
    }

    @PostMapping("/hi2/{userId}")
    public User hi2(@RequestBody User user,
                    @PathVariable(name = "userId") int userId,
                    @RequestHeader("x-authorization") String authorization,
                    @RequestHeader("custom-header") String customAuthorization){
        log.info("userId: {} ",userId);
        log.info("x-authorization: {} ",authorization);
        log.info("custom-header: {} ",customAuthorization);

        return  user;
    }
    @PostMapping("/hi3/{userId}")
    public Req<User> hi3(
//            HttpEntity<String> entity, //뭘 받았는지 알수 있는 코드 or filter를 통해 확인 가능
            @RequestBody Req<User> user,
            @PathVariable(name = "userId") int userId,
            @RequestHeader("x-authorization") String authorization,
            @RequestHeader("custom-header") String customAuthorization){
        log.info("userIdd: {} ",user);
//        log.info("entity: {} ",entity);

        log.info("userIdd: {} ",userId);
        log.info("x-authorization: {} ",authorization);
        log.info("custom-header: {} ",customAuthorization);

        Req<User> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );
        response.setRbody(user.getRbody());
        return  response;
    }
}
