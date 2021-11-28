package com.example.sogong.domain.room;

import com.example.sogong.domain.BaseTimeEntity;
import com.example.sogong.domain.user.User;
import lombok.*;

import javax.persistence.*;

/**
 * Created by bangjinhyuk on 2021/11/27.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserAndRoom extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userAndRoomUserId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;

    @Builder
    public UserAndRoom(User userAndRoomUserId, Room roomId) {
        this.userAndRoomUserId = userAndRoomUserId;
        this.roomId = roomId;
    }
}
