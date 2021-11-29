package com.example.sogong.dto.user.request;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(example = "평가 당하는 사람 id")
    private Long id;

    @NotNull
    @Schema(example = "0, 0.5, 1 ... 4.5, 5")
    private double mannerTemp;
}
