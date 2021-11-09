package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	//저장
	public Book add(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> list(){
		//org.springframework.data.domain.Sort & org.springframework.data.domain.Sort.Direction ▼
		List<Book> bookList = bookRepository.findAll(Sort.by(Direction.DESC,"name"));
		
		return bookList;
	}
	/*public Page<BookEntity> list(Pageable pageable){ Page<BookEntity> bookList = bookRepository.findAll(pageable); return bookList; }*/
}
