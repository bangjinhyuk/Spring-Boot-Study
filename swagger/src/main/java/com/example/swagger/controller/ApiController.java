package com.example.swagger.controller;

import com.example.swagger.dto.UserReq;
import com.example.swagger.dto.UserRes;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 Controller"}) //제목
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello(){
        return "hello Spring";
    }

    @GetMapping("/plus/{x}")
    public int plus(
            @ApiParam(value = "x값") //설명
            @PathVariable int x,
            @ApiParam(value = "y값")
            @RequestParam int y){
        return x + y;
    }

    @ApiImplicitParams({ //위에보단 가독성 높인 방법
                    @ApiImplicitParam(name = "x", value = "x 값",required = true, dataType = "int", paramType = "path"),
                    @ApiImplicitParam(name = "y", value = "y 값",required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/plus2/{x}")
    public int plus2(
            @PathVariable int x,
            @RequestParam int y){
        return x + y;
    }

    @ApiResponse(code = 502, message = "사용자 나이가 10살 이하일때")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴 하는 메소드" )
    @GetMapping("/user")
    public UserRes user(UserReq userReq){
        return new UserRes(userReq.getName(), userReq.getAge());
    }


    @PostMapping ("/user")
    public UserRes users(@RequestBody UserReq userReq){
        return new UserRes(userReq.getName(), userReq.getAge());
    }
}
