package com.example.sogong.domain.user;

import com.example.sogong.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by bangjinhyuk on 2021/11/27.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Manner extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @NotNull
    private double mannerTemp;

    @Builder
    public Manner(User userId, double mannerTemp) {
        this.userId = userId;
        this.mannerTemp = mannerTemp;
    }
}
