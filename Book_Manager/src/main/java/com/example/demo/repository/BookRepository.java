package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    @Modifying
    @Query(value = "update book set category='none'", nativeQuery = true)
    void update();
    
    List<Book> findByCategoryIsNull();

    List<Book> findAllByDeletedFalse();

    List<Book> findByCategoryIsNullAndDeletedFalse();
}
