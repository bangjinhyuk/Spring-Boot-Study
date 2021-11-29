package com.example.sogong.domain.room;

import com.example.sogong.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bangjinhyuk on 2021/11/27.
 */
@Repository
public interface UserAndRoomRepository extends JpaRepository<UserAndRoom,Long> {
    List<UserAndRoom> findUserAndRoomsByUserRoomroomId(Room room);
    List<UserAndRoom> findUserAndRoomsByUserRoomroomIdAndUserRoomUserId(Room room, User user);
}
