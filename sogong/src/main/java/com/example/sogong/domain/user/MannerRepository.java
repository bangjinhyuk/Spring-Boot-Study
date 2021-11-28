package com.example.sogong.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bangjinhyuk on 2021/11/27.
 */
@Repository
public interface MannerRepository extends JpaRepository<Manner,Long> {
    List<Manner> findMannerById(Long id);
}
