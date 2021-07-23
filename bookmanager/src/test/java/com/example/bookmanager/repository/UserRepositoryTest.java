package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Gender;
import com.example.bookmanager.domain.User;
import com.example.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;


@SpringBootTest
@Transactional
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

//        //delete
//        userRepository.delete(userRepository.findById(1L).orElseThrow(null));
//        userRepository.findAll().forEach(System.out::println);

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

    @Test
    void crud2(){
        userRepository.save(new User("david", "david@email")); //요때는 save가 insert id == null
        userRepository.findAll().forEach(System.out::println);

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("updated@email");
        userRepository.save(user); //요때는 save가 update id != null
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void select(){
        System.out.println(userRepository.findUsersByName("leo"));
        userRepository.findUsersByName("martin").stream().forEach(System.out::println);

        //모두 동일 쿼리
//        System.out.println("findByEmail"+ userRepository.findByEmail("leo@slowcampus.com"));
//        System.out.println("getByEmail"+ userRepository.getByEmail("leo@slowcampus.com"));
//        System.out.println("readByEmail"+ userRepository.readByEmail("leo@slowcampus.com"));
//        System.out.println("queryByEmail"+ userRepository.queryByEmail("leo@slowcampus.com"));
//        System.out.println("searchByEmail"+ userRepository.searchByEmail("leo@slowcampus.com"));
//        System.out.println("streamByEmail"+ userRepository.streamByEmail("leo@slowcampus.com"));
//        System.out.println("findUserByEmail"+userRepository.findUserByEmail("leo@slowcampus.com"));
//
        //and 사용
        System.out.println("findByEmailAndName"+userRepository.findByEmailAndName("leo@slowcampus.com","leo"));
        //or 사용
        System.out.println("findByEmailOrName"+userRepository.findByEmailOrName("leo@slowcampus.com","hi"));


        System.out.println("findByCreatedAtAfter"+userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtGreaterThan"+userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtGreaterThanEqual"+userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

        //between 사용
        System.out.println("findByCreatedAtBetween"+userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L),LocalDateTime.now().plusDays(1L)));

        System.out.println("findByIdBetween"+userRepository.findByIdBetween(2L,4L));

        System.out.println("findByIdIsNotNull"+userRepository.findByIdIsNotNull());

        System.out.println("findByNameIn"+userRepository.findByNameIn(Lists.newArrayList("leo","dennis")));


        System.out.println("findByNameStartingWith"+userRepository.findByNameStartingWith("de"));
        System.out.println("findByNameEndingWith"+userRepository.findByNameEndingWith("is"));
        System.out.println("findByNameContaining"+userRepository.findByNameContaining("nn"));

        System.out.println("findByNameLike"+userRepository.findByNameLike("%n%"));



    }

    @Test
    void sortandpage(){
        //sort
        System.out.println("findByNameStartingWith"+userRepository.findByNameOrderByIdDesc("martin")); //asc 정순 desc역순
        System.out.println("findFirstByNameOrderByIdDescEmailAsc"+userRepository.findFirstByNameOrderByIdDescEmailAsc("martin")); //asc 정순 desc역순
        System.out.println("findFirstByName&sort"+userRepository.findFirstByName("martin",Sort.by(Sort.Order.desc("id"),Sort.Order.asc("email"))));

        //page
        System.out.println("findFirstByName&page"+userRepository.findByName("martin",PageRequest.of(1,1,Sort.by(Sort.Order.desc("id")))).getContent());


    }
    @Test
    void enumTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.Male);
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
        System.out.println(userRepository.findRowRecord().get("gender"));
    }
    @Test
    void listenerTest(){
        User user = new User();
        user.setEmail("bang@email");
        user.setName("bang");
        userRepository.save(user);
        //insert
        User user1 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        //select
        user1.setName("maaaaartin");

        userRepository.save(user1);
        //select-> update
        userRepository.deleteById(2L);
        //select -> delete
        userRepository.findAll().forEach(System.out::println);
        //select
    }

    @Test
    void prePersistTest(){
        User user = new User();
        user.setEmail("bang@email");
        user.setName("bang");
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);


    }
    @Test
    void preUpdateTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setName("bang");
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);


    }

    @Autowired
    private UserHistoryRepository userHistoryRepository;
    @Test
    void userHistoryRepository() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setName("leo");
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
        userHistoryRepository.findAll().forEach(System.out::println);
    }

    @Test
    void userRelationTest(){
        User user = new User();
        user.setName("david");
        user.setEmail("david@fastcampus.com");
        user.setGender(Gender.Male);
        userRepository.save(user);

        user.setName("daniel");
        userRepository.save(user);

        user.setEmail("daniel@fastcampus.com");
        userRepository.save(user);

//        userHistoryRepository.findAll().forEach(it -> it.getUser().getId());

//        List<UserHistory> result = userHistoryRepository.findByUserId(
//            userRepository.findByEmail("daniel@fastcampus.com").getId());

//        userRepository.findAll().forEach(System.out::println);
        List<UserHistory> result = userRepository.findByEmail("daniel@fastcampus.com").getUserHistories();

        result.forEach(System.out::println);
    }


}