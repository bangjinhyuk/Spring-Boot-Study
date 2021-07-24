package com.example.bookmanager.service;

import com.example.bookmanager.domain.User;
import com.example.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;

/**
 * Created by bangjinhyuk on 2021/07/23.
 */


@SpringBootTest
@Transactional
public class EntityManagerTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    @Test
    void entityManagerTest(){
        System.out.println(entityManager.createQuery("select u from User u").getResultList());
    }
    @Test
    void cacheFindTest(){
        System.out.println(userRepository.findByEmail("leo@slowcampus.com"));
        System.out.println(userRepository.findByEmail("leo@slowcampus.com"));
        System.out.println(userRepository.findByEmail("leo@slowcampus.com"));
    }

    @Test
    void cacheFindTest2(){

        User user = userRepository.findById(1L).get();
        user.setName("marrrrrrtin");

        userRepository.save(user);

//        userRepository.flush();

        user.setEmail("marrrrrrrrtin@email");

        userRepository.save(user);

        userRepository.flush();
        System.out.println(">>>>>>>1" + userRepository.findByEmail("martin@fastcampus.com"));

        userRepository.flush();

        System.out.println(">>>>>>>2" + userRepository.findByEmail("martin@fastcampus.com"));

    }
}
