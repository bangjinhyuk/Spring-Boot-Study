package com.example.sogong.domain.user;

import com.example.sogong.domain.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bangjinhyuk on 2021/11/27.
 */
@Repository
public interface SpecRepository extends JpaRepository<Spec,Long> {
    List<Spec> findSpecById(Long id);

}
