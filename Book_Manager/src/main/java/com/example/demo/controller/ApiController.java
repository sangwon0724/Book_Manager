package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.BookEntity;
import com.example.demo.repository.BookRepository;

@RestController
public class ApiController {
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/add")
	public BookEntity add(BookEntity bookVo) {
		BookEntity bookData = bookRepository.save(bookVo);
		return bookData;
	}

	@GetMapping("/list")
	public List<BookEntity> list(Model model) {

		List<BookEntity> bookList = bookRepository.findAll();

		return bookList;
	}
}
