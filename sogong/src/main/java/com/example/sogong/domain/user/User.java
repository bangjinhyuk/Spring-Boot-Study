package com.example.sogong.domain.user;

import com.example.sogong.domain.BaseTimeEntity;
import com.example.sogong.domain.room.UserAndRoom;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Created by bangjinhyuk on 2021/11/27.
 */
@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String login_id;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String studentId;

    @NotBlank
    private String major;

    @NotBlank
    private MannerTempPrivate mannerTempPrivate;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Spec> specList;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Manner> mannerList;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserAndRoom> userAndRoomList;

    @Builder
    public User(String login_id, String password, String name, String studentId, String major, MannerTempPrivate mannerTempPrivate, List<Spec> specList, List<Manner> mannerList, List<UserAndRoom> userAndRoomList) {
        this.login_id = login_id;
        this.password = password;
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.mannerTempPrivate = mannerTempPrivate;
        this.specList = specList;
        this.mannerList = mannerList;
        this.userAndRoomList = userAndRoomList;
    }
}
