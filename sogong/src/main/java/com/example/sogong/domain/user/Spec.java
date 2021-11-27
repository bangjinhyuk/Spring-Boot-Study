package com.example.sogong.domain.user;

import com.example.sogong.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by bangjinhyuk on 2021/11/27.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Spec extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @NotBlank
    private String name;

    @Builder
    public Spec(User userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
