package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.domain.BookEntity;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	//저장
	public BookEntity add(BookEntity book) {
		return bookRepository.save(book);
	}
	
	public List<BookEntity> list(){
		//org.springframework.data.domain.Sort & org.springframework.data.domain.Sort.Direction ▼
		List<BookEntity> bookList = bookRepository.findAll(Sort.by(Direction.DESC,"name"));
		
		return bookList;
	}
	/*public Page<BookEntity> list(Pageable pageable){ Page<BookEntity> bookList = bookRepository.findAll(pageable); return bookList; }*/
}
