package com.example.hello.controller;

import com.example.hello.dto.putRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public putRequestDto put(@RequestBody putRequestDto putRequestDto){
        System.out.println(putRequestDto.toString());
        return putRequestDto;
    }

    @PutMapping("/put/{userId}")
    public putRequestDto put2(@RequestBody putRequestDto putRequestDto, @PathVariable Long userId){
        System.out.println(putRequestDto.toString());
        System.out.println(userId);
        return putRequestDto;
    }
}
