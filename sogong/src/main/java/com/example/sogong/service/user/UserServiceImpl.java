package com.example.sogong.service.user;

import com.example.sogong.domain.user.*;
import com.example.sogong.dto.user.request.MannerEvaluate;
import com.example.sogong.dto.user.request.ModifyProfile;
import com.example.sogong.dto.user.request.Specdto;
import com.example.sogong.dto.user.response.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bangjinhyuk on 2021/11/28.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SpecRepository specRepository;
    private final MannerRepository mannerRepository;

    @Override
    public ResponseEntity<String> join(String id, String password) {
        if(userRepository.findByLoginId(id).isEmpty()){
            User user = User.builder().loginId(id).password(password).mannerTempPrivate(MannerTempPrivate.Y).build();
            return ResponseEntity.ok(String.valueOf(userRepository.save(user).getId()));
        }else {
            if (userRepository.findByLoginId(id).get().getPassword().equals(password)) {
                return ResponseEntity.ok(String.valueOf(userRepository.findByLoginId(id).get().getId()));
            } else return ResponseEntity.ok("password Error");
        }
    }

    @Override
    public ResponseEntity<UserProfile> profile(String userId) {
        UserProfile userProfile = new UserProfile();
        double mannerSum = 0;

        List<Manner> mannerList = mannerRepository.findMannersByMannerUserId(userRepository.findById(Long.valueOf(userId)).get());

        for(int i = 0; i<mannerList.size(); i++){
            mannerSum+= mannerList.get(i).getMannerTemp()-2.5;
        }

        if(userRepository.findById(Long.valueOf(userId)).isPresent()){
            userProfile.UserToUserProfile(
                    userRepository.findById(Long.valueOf(userId)).get(),
                    specRepository.findSpecBySpecUserId(userRepository.findById(Long.valueOf(userId)).get()),
                    mannerSum/5,
                    mannerList.size()
                    );
            return ResponseEntity.ok(userProfile);
        }return ResponseEntity.badRequest().body(null);
    }

    @Override
    public ResponseEntity<UserProfile> modifyProfile(ModifyProfile modifyProfile) {
        User user = userRepository.findById(modifyProfile.getId()).get();
        user.modifyUser(modifyProfile);
        userRepository.save(user);
        UserProfile userProfile = new UserProfile();
        double mannerSum = 0;

        List<Manner> mannerList = mannerRepository.findMannersByMannerUserId(userRepository.findById(modifyProfile.getId()).get());

        for(int i = 0; i<mannerList.size(); i++){
            mannerSum+= mannerList.get(i).getMannerTemp()-2.5;
        }

        if(userRepository.findById(modifyProfile.getId()).isPresent()){
            userProfile.UserToUserProfile(
                    userRepository.findById(modifyProfile.getId()).get(),
                    specRepository.findSpecBySpecUserId(userRepository.findById(modifyProfile.getId()).get()),
                    mannerSum/5,
                    mannerList.size()
            );
            return ResponseEntity.ok(userProfile);
        }return ResponseEntity.badRequest().body(null);
    }

    @Override
    public ResponseEntity<String> mannerEvaluate(MannerEvaluate mannerEvaluate) {
        Manner manner = Manner.builder()
                .mannerTemp(mannerEvaluate.getMannerTemp())
                .mannerUserId(userRepository.getById(mannerEvaluate.getId()))
                .build();
        mannerRepository.save(manner);
        return ResponseEntity.ok("success");
    }

    @Override
    public ResponseEntity<String> addSpec(Specdto specdto) {
        Spec spec = Spec.builder()
                .specUserId(userRepository.getById(specdto.getId()))
                .name(specdto.getName())
                .value(specdto.getValue())
                .build();
        specRepository.save(spec);
        return ResponseEntity.ok("success");
    }

}
