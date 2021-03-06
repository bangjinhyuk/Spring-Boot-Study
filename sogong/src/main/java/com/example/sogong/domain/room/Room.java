package com.example.sogong.domain.room;

import com.example.sogong.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bangjinhyuk on 2021/11/27.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Room extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String subject;

    @NotNull
    private int setLimit;

    @NotNull
    private RoomCategory roomCategory;

    @NotBlank
    private String code;

    @OneToMany(mappedBy = "userRoomroomId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<UserAndRoom> userAndRoomList = new ArrayList<>();

    @Builder
    public Room(String name, String subject, int setLimit, RoomCategory roomCategory, String code, List<UserAndRoom> userAndRoomList) {
        this.name = name;
        this.subject = subject;
        this.setLimit = setLimit;
        this.roomCategory = roomCategory;
        this.code = code;
        this.userAndRoomList = userAndRoomList;
    }

    public void addUserAndRoomList(UserAndRoom userAndRoom) {
        System.out.println(userAndRoom);
        System.out.println(userAndRoomList);
        this.userAndRoomList.add(userAndRoom);
    }
}
