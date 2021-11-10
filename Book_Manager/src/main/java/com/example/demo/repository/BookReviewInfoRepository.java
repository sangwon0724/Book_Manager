package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.BookReviewInfo;

public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long> {
	
}