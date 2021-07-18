package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findUsersByName(String name);
    //위 코드와 같지만 가독성 높이는 코드임
    List<User> findUsersByNameIs(String name);
    List<User> findUsersByNameEquals(String name);

    //처음 하나
    User findFirst1ByEmail(String name);
//    //처음 둘
//    List<User>findFirst2ByEmail(String name);

    //모두 동일 쿼리 아래 모두 select 쿼리들임 by 전에 다른 entity이름을 넣어도 상관 없긴 함 by같은 단어는 런타임 오류 발생
    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    // and , or
    List<User> findByEmailAndName (String email, String name);

    List<User> findByEmailOrName (String email, String name);

    //after 주어진 변수보다 크면 모두 선택 * equal포함 안함 *
    List<User> findByCreatedAtAfter(LocalDateTime yesterday);
    //위아래 두개 모두 같으 쿼리
    //GreaterThan
    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);
    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    //Between
    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<User> findByIdBetween(Long id1, Long id2);


    List<User> findByIdIsNotNull();

    List<User> findByNameIn(List<String> list);



    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndingWith(String name);

    List<User> findByNameContaining(String name);

    //가독성이 떨어짐
    List<User> findByNameLike(String name);




}
