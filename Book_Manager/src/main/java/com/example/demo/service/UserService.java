package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void put() {
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@fastcampus.com");

        //userRepository.save(user);

        entityManager.persist(user);
        //entityManager.detach(user);

        user.setName("newUserAfterPersist");
        entityManager.merge(user);
        //entityManager.flush();
        //entityManager.clear();

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);

        user1.setName("marrrrrrrtin");
        entityManager.merge(user1);
    }
}