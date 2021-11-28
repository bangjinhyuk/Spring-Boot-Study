package com.example.sogong.dto.user.request;

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
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String studentId;

    @NotBlank
    private String major;
}
