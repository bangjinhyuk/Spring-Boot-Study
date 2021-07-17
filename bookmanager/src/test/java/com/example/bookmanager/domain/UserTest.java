package com.example.bookmanager.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void test(){
        User user = new User();
        user.setEmail("123@123");
        user.setName("123");

        User user1 = User.builder()
                .name("123")
                .email("2323@2323")
                .build();
        System.out.println(user);
        System.out.println(user1);

    }

}