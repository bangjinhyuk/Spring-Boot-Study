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
@NoArgsConstructor
@AllArgsConstructor
public class Specdto {
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String value;
}
