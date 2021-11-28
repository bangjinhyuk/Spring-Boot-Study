package com.example.sogong.domain.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bangjinhyuk on 2021/11/27.
 */
@Repository
public interface UserAndRoomRepository extends JpaRepository<UserAndRoom,Long> {
}
