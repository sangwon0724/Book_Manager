package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long>{

}
