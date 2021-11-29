package com.example.sogong.dto.user.request;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(example = "평가 당하는 사람 id")
    private Long id;

    @NotNull
    @ApiModelProperty(example = "0, 0.5, 1 ... 4.5, 5")
    private double mannerTemp;
}
