package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.UserHistory;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
	List<UserHistory> findByUserId(Long userId);
}