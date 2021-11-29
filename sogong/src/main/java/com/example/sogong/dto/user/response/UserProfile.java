package com.example.sogong.dto.user.response;

import com.example.sogong.domain.user.Gender;
import com.example.sogong.domain.user.MannerTempPrivate;
import com.example.sogong.domain.user.Spec;
import com.example.sogong.domain.user.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bangjinhyuk on 2021/11/28.
 */
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    private long id;

    private String login_id;

    private String password;

    private String name;

    private String studentId;

    private String major;

    private MannerTempPrivate mannerTempPrivate;

    private Gender gender;

    private double mannerTemp;

    private int mannerCount;

    private List<ResponseSpec> responseSpecs = new ArrayList<>();

    @ToString
    @Getter
    static class ResponseSpec{
        String name;
        String value;

        public ResponseSpec(String name, String value) {
            this.name = name;
            this.value = value;
        }

    }

    public void UserToUserProfile(User user, List<Spec> specs, double mannerTemp, int mannerCount){
        this.id = user.getId();
        this.login_id = user.getLoginId();
        this.password = user.getPassword();
        this.name = user.getName();
        this.studentId = user.getStudentId();
        this.major = user.getMajor();
        this.gender = user.getGender();
        this.mannerTempPrivate = user.getMannerTempPrivate();
        specs.forEach(
                (spec -> this.responseSpecs.add(
                        new ResponseSpec(spec.getName(),spec.getValue()))
                )
        );
        this.mannerTemp = mannerTemp+36.5;
        this.mannerCount = mannerCount;
    }

}
