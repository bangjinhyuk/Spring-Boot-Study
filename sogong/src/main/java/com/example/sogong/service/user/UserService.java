package com.example.sogong.service.user;

import com.example.sogong.dto.user.request.MannerEvaluate;
import com.example.sogong.dto.user.request.ModifyProfile;
import com.example.sogong.dto.user.request.Specdto;
import com.example.sogong.dto.user.response.UserProfile;
import org.springframework.http.ResponseEntity;

/**
 * Created by bangjinhyuk on 2021/11/28.
 */
public interface UserService {
    ResponseEntity<String> join(String id, String password);

    ResponseEntity<UserProfile> profile(String userId);

    ResponseEntity<UserProfile> modifyProfile(ModifyProfile modifyProfile);

    ResponseEntity<String> mannerEvaluate(MannerEvaluate mannerEvaluate);

    ResponseEntity<String> addSpec(Specdto specdto);
}
