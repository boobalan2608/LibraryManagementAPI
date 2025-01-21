package com.jsp.librarymanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.librarymanagement.entity.Book;
import com.jsp.librarymanagement.repository.BookRespository;

@Repository
public class BookDao {

	@Autowired
	private BookRespository bookRespository;
	
//Save Book
	public Book saveBook(Book book) {
		return bookRespository.save(book);
	}
	
//	Get All Book Details
	public List<Book> getAllBookDetails(){
		return bookRespository.findAll();
	}

//	Get Book Detail By Id
	public Optional<Book> getBookById(int id) {
		return bookRespository.findById(id);
	}

//	Delete Book By Id
	public void deleteBookId(Book book) {
		bookRespository.delete(book);
	}

//	Get Book Detail By Genre
	public List<Book> getBookByGenre(String genre) {
		return bookRespository.findByGenre(genre);
	}
}
