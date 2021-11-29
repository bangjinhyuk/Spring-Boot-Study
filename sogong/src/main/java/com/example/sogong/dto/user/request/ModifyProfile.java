package com.example.sogong.dto.user.request;

import com.example.sogong.domain.user.Gender;
import com.example.sogong.domain.user.MannerTempPrivate;
import io.swagger.v3.oas.annotations.media.Schema;
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
@AllArgsConstructor
@NoArgsConstructor
public class ModifyProfile {
    @NotNull
    @Schema(example = "userId")
    private Long id;

    @NotBlank
    @Schema(example = "이름")
    private String name;

    @NotBlank
    @Schema(example = "학번")
    private String studentId;

    @NotBlank
    @Schema(example = "학과")
    private String major;

    @Schema(example = "성별 MALE,FEMALE")
    private Gender gender;

    @NotNull
    @Schema(example = "매너 온도 공개 여부 Y,N")
    private MannerTempPrivate mannerTempPrivate;
}
