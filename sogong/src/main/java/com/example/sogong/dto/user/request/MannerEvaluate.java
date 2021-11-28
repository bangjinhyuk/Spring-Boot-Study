package com.example.sogong.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Created by bangjinhyuk on 2021/11/28.
 */

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MannerEvaluate {
    @NotNull
    private Long id;

    @NotNull
    private double mannerTemp;
}
