package com.example.bookmanager.service;

import com.example.bookmanager.domain.User;
import com.example.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Created by bangjinhyuk on 2021/07/24.
 */
@Service
public class Userservice {

    //비영속 상태
    @Transactional
    public void put(){
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@email");
    }
    //영속 상태 save 또는 아래와 같은 entity manager를 통한 방식
    @Autowired
    private EntityManager entityManager;
    @Transactional
    public void put2(){
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@email");
        entityManager.persist(user);

        user.setName("newUserAfterPersist");
    }
    //준영속 상태 detached
    @Transactional
    public void put3(){
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@email");
        entityManager.persist(user);
        entityManager.detach(user);
        user.setName("newUserAfterPersist");
        entityManager.merge(user); //예약

        entityManager.clear(); // 모두 드랍
    }
    //삭제 상태
    @Autowired
    private UserRepository userRepository;
    @Transactional
    public void put4(){
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@email");

        entityManager.persist(user);

        user.setName("newUserAfterPersist");
        entityManager.merge(user); //예약

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);
    }
}
