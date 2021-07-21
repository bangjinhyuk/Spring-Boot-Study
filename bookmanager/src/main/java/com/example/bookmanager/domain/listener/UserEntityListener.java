package com.example.bookmanager.domain.listener;

import com.example.bookmanager.domain.User;
import com.example.bookmanager.domain.UserHistory;
import com.example.bookmanager.repository.UserHistoryRepository;
import com.example.bookmanager.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class UserEntityListener {


    @PostPersist
    @PostUpdate
    public void preUpdate(Object o){
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;
        UserHistory userHistory = new UserHistory();
        userHistory.setUser(user);
        userHistory.setEmail(user.getEmail());
        userHistory.setName(user.getName());

        userHistoryRepository.save(userHistory);


    }
}
