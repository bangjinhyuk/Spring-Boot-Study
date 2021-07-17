package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;


@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional // getOne 사용시 필요
    void crud() { // create, read, update, delete

//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"name")); //이름순 소트 하기

        // findAllById
        List<User> users = userRepository.findAllById(Lists.newArrayList(1L,3L,5L)); //원하는 id를 가져오기
        users.forEach(System.out::println);

        // saveAll
        User user1 = new User("jack","jack@mail");
        User user2 = new User("steve","steve@mail");

        userRepository.saveAll(Lists.newArrayList(user1, user2));
        userRepository.findAll().forEach(System.out::println);

        // getOne
        User user3 = userRepository.getOne(1L);
        System.out.println(">>>getOne>>>" +user3);

        // findById
        User user4 = userRepository.findById(1L).orElse(null); //orElse를 통해 optional 로 안씌워도 댐
        System.out.println(">>>findById>>>" +user4);

        // saveAndFlush
        userRepository.saveAndFlush(new User("new martin","new martin@mail"));
        userRepository.findAll().forEach(System.out::println);

        //count
        long count = userRepository.count();
        System.out.println(">>>count>>>" +count);

        //existsById
        boolean exists = userRepository.existsById(1L);
        System.out.println(">>>exists>>>" +exists);

        //delete
        userRepository.delete(userRepository.findById(1L).orElseThrow(null));
        userRepository.findAll().forEach(System.out::println);

        //deletebyid
        userRepository.deleteById(2L);
        userRepository.findAll().forEach(System.out::println);

        //deleteAll
//        userRepository.deleteAll();
        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(3L,4L)));
        userRepository.findAll().forEach(System.out::println);

        //deleteAllInBatch findall 성능 이슈 해결 방안
        userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(5L,6L)));
//        userRepository.deleteAll();
        userRepository.findAll().forEach(System.out::println);

        //Page
        Page<User> users1 = userRepository.findAll(PageRequest.of(0,3)); //한페이지 크기는 3 0페이지를 비춰라
        System.out.println("page: "+ users1);
        System.out.println("totalElements: "+ users1.getTotalElements());
        System.out.println("totalPages: " +users1.getTotalPages());
        System.out.println("numberOfElements: "+ users1.getNumberOfElements());
        System.out.println("sort: "+ users1.getSort());
        System.out.println("size: "+ users1.getSize());
        users1.getContent().forEach(System.out::println);

        // Example ,ExampleMatcher
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name") //무시할수 있음
                .withMatcher("email",startsWith()); //endswith, contains 등등 많음

        Example<User> example = Example.of(new User("ma","new"),matcher); //matcher 빼면 해당 객체와 같은 값을 불러오게 댐
        userRepository.findAll(example).forEach(System.out::println);
        


//        userRepository.findAll().forEach(System.out::println);

//        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
//        Example<User> example = Example.of(user, matcher);
//
//        userRepository.findAll(example).forEach(System.out::println);
    }
}