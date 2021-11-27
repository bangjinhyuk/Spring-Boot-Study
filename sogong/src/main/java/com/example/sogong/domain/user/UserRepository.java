package com.example.sogong.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bangjinhyuk on 2021/11/27.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
