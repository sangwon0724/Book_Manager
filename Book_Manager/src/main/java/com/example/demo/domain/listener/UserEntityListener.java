package com.example.demo.domain.listener;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.example.demo.domain.User;
import com.example.demo.domain.UserHistory;
import com.example.demo.repository.UserHistoryRepository;
import com.example.demo.support.BeanUtils;

public class UserEntityListener {
    //@PrePersist //insert 전에 작동
    //@PreUpdate //update 전에 작동
    @PostPersist //insert 후에 작동
    @PostUpdate //update 후에 작동
    public void prePersistAndPreUpdate(Object o) {
    	//빈 주입
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;

        //UserHistory 객체에 데이터 설정
        UserHistory userHistory = new UserHistory();
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setUser(user);

        //데이터 저장
        userHistoryRepository.save(userHistory);
    }
}