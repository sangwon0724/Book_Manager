package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;

@RestController
public class ApiController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/add")
	public Book add(Book book) {
		return bookService.add(book);
	}

	@GetMapping("/list")
	public List<Book> list(Model model) {

		return bookService.list();
	}
	
	/*@GetMapping("/list")
	public Page<BookEntity> list(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		return bookService.list(pageable);
	}*/
}
