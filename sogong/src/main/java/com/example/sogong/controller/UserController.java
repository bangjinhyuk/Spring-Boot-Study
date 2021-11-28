package com.example.sogong.controller;

import com.example.sogong.dto.user.request.MannerEvaluate;
import com.example.sogong.dto.user.request.ModifyProfile;
import com.example.sogong.dto.user.request.Specdto;
import com.example.sogong.dto.user.response.UserProfile;
import com.example.sogong.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = {"유저 Controller"}) //제목
public class UserController {
    private final UserService userService;

    /**
     * 로그인, 가입 컨트롤러
     */
    @GetMapping("/join")
    @ApiOperation(value = "로그인", notes = "해당 아이디가 존재하지 않으면 생성후 넘어감")
    public ResponseEntity<String> join(@RequestParam String id, @RequestParam String password){
        log.info("id: {}, pw: {}",id,password);
        return userService.join(id,password);
    }

    /**
     * 프로필 가져오기
     */
    @GetMapping("/profile")
    @ApiOperation(value = "프로필 가져오기")
    public ResponseEntity<UserProfile> profile(@RequestParam String userId){
        log.info("userId: {}",userId);
        return userService.profile(userId);
    }

    /**
     * 프로필 수정
     */
    @PutMapping("/profile")
    @ApiOperation(value = "프로필 수정")
    public ResponseEntity<UserProfile> profile(@Valid @RequestBody ModifyProfile modifyProfile){
        log.info("modifyProfile: {}",modifyProfile);
        return userService.modifyProfile(modifyProfile);
    }
    /**
     * 매너 평가
     */
    @PostMapping("/manner")
    @ApiOperation(value = "매너온도 평가")
    public ResponseEntity<String> mannerEvaluate(@Valid @RequestBody MannerEvaluate mannerEvaluate){
        log.info("mannerEvaluate: {}",mannerEvaluate);
        return userService.mannerEvaluate(mannerEvaluate);
    }
    /**
     * 스펙 추가
     */
    @PostMapping("/spec")
    @ApiOperation(value = "스펙 추가")
    public ResponseEntity<String> addSpec(@Valid @RequestBody Specdto specdto){
        log.info("specdto: {}",specdto);
        return userService.addSpec(specdto);
    }
}
