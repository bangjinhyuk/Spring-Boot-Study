package com.example.sogong.controller;

import com.example.sogong.dto.user.request.MannerEvaluate;
import com.example.sogong.dto.user.request.ModifyProfile;
import com.example.sogong.dto.user.request.Specdto;
import com.example.sogong.dto.user.response.UserProfile;
import com.example.sogong.service.user.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by bangjinhyuk on 2021/11/28.
 */
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "유저 Controller") //제목
public class UserController {
    private final UserService userService;

    /**
     * 로그인, 가입 컨트롤러
     */
    @GetMapping("/join")
    @Operation(summary = "로그인", description = "해당 아이디가 존재하지 않으면 생성후 넘어감")
    public ResponseEntity<String> join(@RequestParam String id, @RequestParam String password){
        log.info("id: {}, pw: {}",id,password);
        return userService.join(id,password);
    }

    /**
     * 프로필 가져오기
     */
    @GetMapping("/profile")
    @Operation(summary = "프로필 가져오기", description = "유저 프로필 리턴")
    public ResponseEntity<UserProfile> profile(@RequestParam String userId){
        log.info("userId: {}",userId);
        return userService.profile(userId);
    }

    /**
     * 프로필 수정
     */
    @PutMapping("/profile")
    @Operation(summary = "프로필 수정" , description = "유저 프로필 리턴")
    public ResponseEntity<UserProfile> profile(@Valid @RequestBody ModifyProfile modifyProfile){
        log.info("modifyProfile: {}",modifyProfile);
        return userService.modifyProfile(modifyProfile);
    }
    /**
     * 매너 평가
     */
    @PostMapping("/manner")
    @Operation(summary = "매너온도 평가" , description = "성공시 success 리턴")
    public ResponseEntity<String> mannerEvaluate(@Valid @RequestBody MannerEvaluate mannerEvaluate){
        log.info("mannerEvaluate: {}",mannerEvaluate);
        return userService.mannerEvaluate(mannerEvaluate);
    }
    /**
     * 스펙 추가
     */
    @PostMapping("/spec")
    @Operation(summary = "스펙 추가" , description = "성공시 success 리턴")
    public ResponseEntity<String> addSpec(@Valid @RequestBody Specdto specdto){
        log.info("specdto: {}",specdto);
        return userService.addSpec(specdto);
    }
}
