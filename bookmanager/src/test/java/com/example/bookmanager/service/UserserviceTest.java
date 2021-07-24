package com.example.bookmanager.service;

import com.example.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bangjinhyuk on 2021/07/24.
 */
@SpringBootTest
class UserserviceTest {
    @Autowired
    private Userservice userservice;
    @Autowired
    private UserRepository userRepository;

    @Test
    void test(){
        userservice.put4();
        userRepository.findAll().forEach(System.out::println);
    }


}