package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    @NotBlank
    private String name;
    @Min(value = 10)@Max(value = 40)
    private int age ;
    @Email  // 이메일 정규화
    private String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$" ,message = "핸드폰의 양식과 맞지 않습니다.") //휴대폰 번호 정규식
    private String phoneNumber;

    @YearMonth()
    private String reqYearMonth; //yyyyMM

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


//    //날짜 판별 validation => 함수명 boolean일때 is 꼭 넣기
//    @AssertTrue
//    public boolean isreqYearMonthValidation(){
//
//        try {
//            LocalDate localDate = LocalDate.parse(this.reqYearMonth+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
//
//        }catch (Exception e){
//            return false;
//        }
//
//        return true;
//    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                '}';
    }
}
