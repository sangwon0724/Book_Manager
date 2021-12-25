package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Gender;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
class BookManagerApplicationTests {
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void userSaveTest() {
		User user = new User();
		user.setName("sangwon");
		user.setGender(Gender.MALE);
		
		userRepository.save(user);
	}

}
