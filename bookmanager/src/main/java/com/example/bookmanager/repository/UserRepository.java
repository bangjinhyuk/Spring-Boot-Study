package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findUsersByName(String name);

    //처음 하나
    User findFirst1By(String name);
    //처음 둘
    List<User>findFirst2By(String name);

    //모두 동일 쿼리 아래 모두 select 쿼리들임 by 전에 다른 entity이름을 넣어도 상관 없긴 함 by같은 단어는 런타임 오류 발생
    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);



}
