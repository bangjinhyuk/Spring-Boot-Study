package com.example.sogong.dto.room.request;

import com.example.sogong.domain.room.RoomCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by bangjinhyuk on 2021/11/28.
 */
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomOpen {
    @NotNull
    @ApiModelProperty(example = "userId")
    private Long userid;

    @NotBlank
    @ApiModelProperty(example = "방 이름")
    private String name;

    @NotBlank
    @ApiModelProperty(example = "과목명/주제")
    private String subject;

    @NotNull
    @ApiModelProperty(example = "인원수")
    private int setLimit;

    @NotNull
    @ApiModelProperty(example = "카테고리 TEAM, STUDY")
    private RoomCategory roomCategory;

    @NotBlank
    @ApiModelProperty(example = "과목 코드")
    private String code;
}
