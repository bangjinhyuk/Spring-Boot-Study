package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class userRequest {
    private String name;
    private String email;

//    @JsonProperty("AAGE") //다른 이름으로 받아올수도 있음
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "userRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
