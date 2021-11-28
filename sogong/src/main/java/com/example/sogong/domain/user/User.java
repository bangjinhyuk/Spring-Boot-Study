package com.example.sogong.domain.user;

import com.example.sogong.domain.BaseTimeEntity;
import com.example.sogong.domain.room.UserAndRoom;
import com.example.sogong.dto.user.request.ModifyProfile;
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
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;

    private String name;

    private String studentId;

    private String major;

    @NotNull
    private MannerTempPrivate mannerTempPrivate;

    @OneToMany(mappedBy = "specUserId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Spec> specList = new ArrayList<>();

    @OneToMany(mappedBy = "mannerUserId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Manner> mannerList = new ArrayList<>();

    @OneToMany(mappedBy = "userAndRoomUserId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<UserAndRoom> userAndRoomList = new ArrayList<>();;

    @Builder
    public User(String loginId, String password, String name, String studentId, String major, MannerTempPrivate mannerTempPrivate, List<Spec> specList, List<Manner> mannerList, List<UserAndRoom> userAndRoomList) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.mannerTempPrivate = mannerTempPrivate;
        this.specList = specList;
        this.mannerList = mannerList;
        this.userAndRoomList = userAndRoomList;
    }

    public void modifyUser(ModifyProfile modifyProfile){
        this.name = modifyProfile.getName();
        this.major = modifyProfile.getMajor();
        this.studentId = modifyProfile.getStudentId();
    }

}
