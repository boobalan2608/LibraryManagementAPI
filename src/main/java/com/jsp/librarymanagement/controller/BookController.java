package com.jsp.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.librarymanagement.dto.ResponseStructure;
import com.jsp.librarymanagement.entity.Book;
import com.jsp.librarymanagement.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

//	Save Book
	@PostMapping("/{authorId}")
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book, @PathVariable int authorId) {
		return bookService.saveBook(book, authorId);
	}

//	Get All Book Details
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBookDetails() {
		return bookService.getAllBookDetails();
	}

//	Get Book By ID
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Book>> getAllBookDetails(@PathVariable int id) {
		return bookService.getBookById(id);
	}

//	Get Book By Genre
	@GetMapping("/g/{genre}")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByGenre(@PathVariable String genre) {
		return bookService.getBookByGenre(genre);
	}

// Update Book
	@PutMapping
	public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}

//	Delete Book By ID
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseStructure<Book>> deleteBookById(@PathVariable int id) {
		return bookService.deleteBookById(id);
	}
}