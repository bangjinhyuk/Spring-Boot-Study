package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public Object user(@Valid  @RequestBody User user){
        System.out.println(user);
        return user;
    }

    @PostMapping("/userentity")
    public ResponseEntity userentity(@Valid @RequestBody User user, BindingResult bindingResult){

        //validation 확인후 에러 표출
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();
                System.out.println(field.getField() + message);

                sb.append("field: "+ field.getField());
                sb.append("message: "+message);
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());

        }

        //logic 부분

        return ResponseEntity.ok(user);
    }
}
