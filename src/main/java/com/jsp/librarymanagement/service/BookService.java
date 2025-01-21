package com.jsp.librarymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.librarymanagement.exceptions.IdNotFoundException;
import com.jsp.librarymanagement.exceptions.ResourceNotFoundException;
import com.jsp.librarymanagement.dao.AuthorDao;
import com.jsp.librarymanagement.dao.BookDao;
import com.jsp.librarymanagement.dto.ResponseStructure;
import com.jsp.librarymanagement.entity.Author;
import com.jsp.librarymanagement.entity.Book;
import com.jsp.librarymanagement.repository.AuthorRespository;
import com.jsp.librarymanagement.repository.BookRespository;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private AuthorDao authorDao;

//	                                                <----| Save Book |---->

	public ResponseEntity<ResponseStructure<Book>> saveBook(Book book, int authorId) {
		Optional<Author> authorOptionalDb = authorDao.getAuthorById(authorId);

		if (authorOptionalDb.isPresent()) {
			book.setAuthor(authorOptionalDb.get());
			Book bookDb = bookDao.saveBook(book);
			ResponseStructure<Book> bookResponseStructure = new ResponseStructure<Book>();
			bookResponseStructure.setStatusCode(HttpStatus.CREATED.value());
			bookResponseStructure.setMessage("Success");
			bookResponseStructure.setData(bookDb);
			return new ResponseEntity<ResponseStructure<Book>>(bookResponseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundException("Author Id is not Present in Database");
		}
	}

//                                                  <----| Get All Book Details |---->

	public ResponseEntity<ResponseStructure<List<Book>>> getAllBookDetails() {
		List<Book> bookListDb = bookDao.getAllBookDetails();
		if (!bookListDb.isEmpty()) {
			ResponseStructure<List<Book>> bookResponseStructure = new ResponseStructure<List<Book>>();
			bookResponseStructure.setStatusCode(HttpStatus.OK.value());
			bookResponseStructure.setMessage("Success");
			bookResponseStructure.setData(bookListDb);
			return new ResponseEntity<ResponseStructure<List<Book>>>(bookResponseStructure, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Book List is Empty..");
		}
	}

//                                                   <----| Get Book By ID |---->

	public ResponseEntity<ResponseStructure<Book>> getBookById(int id) {
		Optional<Book> bookOptionalDb = bookDao.getBookById(id);

		ResponseStructure<Book> bookResponseStructure = new ResponseStructure<Book>();
		if (bookOptionalDb.isPresent()) {
			bookResponseStructure.setStatusCode(HttpStatus.OK.value());
			bookResponseStructure.setMessage("Success");
			bookResponseStructure.setData(bookOptionalDb.get());
			return new ResponseEntity<ResponseStructure<Book>>(bookResponseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Book ID is not Found in Database");
		}
	}
//                                                <----| Get Book By Genre |---->
	
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByGenre(String genre){
		List<Book> bookListDb = bookDao.getBookByGenre(genre);
		
		ResponseStructure<List<Book>> bookreResponseStructure = new ResponseStructure<List<Book>>();
		if(!bookListDb.isEmpty()) {
			bookreResponseStructure.setStatusCode(HttpStatus.OK.value());
			bookreResponseStructure.setMessage("Success");
			bookreResponseStructure.setData(bookListDb);
			return new ResponseEntity<ResponseStructure<List<Book>>>(bookreResponseStructure,HttpStatus.OK);
		}
		else {
			throw new ResourceNotFoundException("Genre is not Present in Database..!");
		}
	}
	
//                                                  <----| Delete Book By ID |---->

	
	public ResponseEntity<ResponseStructure<Book>> deleteBookById(int id) {
		Optional<Book> bookOptionalDb = bookDao.getBookById(id);

		ResponseStructure<Book> bookResponseStructure = new ResponseStructure<Book>();
		if (bookOptionalDb.isPresent()) {
			bookResponseStructure.setStatusCode(HttpStatus.OK.value());
			bookResponseStructure.setMessage("Success");
			bookResponseStructure.setData(bookOptionalDb.get());
			bookDao.deleteBookId(bookOptionalDb.get());
			return new ResponseEntity<ResponseStructure<Book>>(bookResponseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Book ID is not Found in Database");
		}

	}
	
//                                                  <----| Update Book |---->

	
	public ResponseEntity<ResponseStructure<Book>> updateBook(Book book) {
		Optional<Book> bookOptionalDb = bookDao.getBookById(book.getId());

		if (bookOptionalDb.isPresent()) {
			book.setAuthor(bookOptionalDb.get().getAuthor());
			Book bookDb = bookDao.saveBook(book);
			ResponseStructure<Book> bookResponseStructure = new ResponseStructure<Book>();
			bookResponseStructure.setStatusCode(HttpStatus.CREATED.value());
			bookResponseStructure.setMessage("Success");
			bookResponseStructure.setData(bookDb);
			return new ResponseEntity<ResponseStructure<Book>>(bookResponseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundException("Book Id is not Present in Database");
		}
	}

}
