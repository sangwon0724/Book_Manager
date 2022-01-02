package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;
    private final AuthorService authorService;
    
	//@Transactional(propagation = Propagation.REQUIRED)
	public void putBookAndAuthor() {
		Book book = new Book();
		book.setName("JPA 시작하기");
		
		bookRepository.save(book);
		
		try {
		authorService.putAuthor();
		}
		catch (RuntimeException e) { }
		
		throw new RuntimeException("오류가 발생하였습니다. transaction은 어떻게 될까요?");
		
		//Author author = new Author();
		//author.setName("martin");
		  
		//authorRepository.save(author);
		
		//throw new RuntimeException("오류가 나서 DB commit이 발생하지 않습니다");
	}

    //@Transactional(isolation = Isolation.SERIALIZABLE)
	public void get(Long id) {
		System.out.println(">>> " + bookRepository.findById(id));
		System.out.println(">>> " + bookRepository.findAll());
		
		entityManager.clear();
		
		System.out.println(">>> " + bookRepository.findById(id));
		System.out.println(">>> " + bookRepository.findAll());
		
		bookRepository.update();
		
		entityManager.clear();
		
		//Book book = bookRepository.findById(id).get();
		//book.setName("바뀔까?");
		//bookRepository.save(book);
	}
	
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
