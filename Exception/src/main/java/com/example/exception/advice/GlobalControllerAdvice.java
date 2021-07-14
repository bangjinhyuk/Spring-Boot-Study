package com.example.exception.advice;

import com.example.exception.controller.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice(basePackageClasses = ApiController.class)
public class GlobalControllerAdvice {


    //아래 함수들을 컨트롤러 안에 넣으면 컨트롤러 안으로 타게 됨
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e){
        System.out.println("Advice: " +  e.getLocalizedMessage());
        System.out.println("Advice: " +  e.getClass().getName());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");

    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity NullPointerException(NullPointerException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hi");
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity ConstraintViolationException(ConstraintViolationException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ConstraintViolationException");
    }
}
