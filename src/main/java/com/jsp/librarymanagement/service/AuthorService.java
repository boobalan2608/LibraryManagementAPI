package com.jsp.librarymanagement.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.librarymanagement.exceptions.IdNotFoundException;
import com.jsp.librarymanagement.exceptions.ResourceNotFoundException;
import com.jsp.librarymanagement.dao.AuthorDao;
import com.jsp.librarymanagement.dto.ResponseStructure;
import com.jsp.librarymanagement.entity.Author;


@Service
public class AuthorService {

	@Autowired
	private AuthorDao authorDao;

//                                            <----| Save Author |---->
	
	
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(Author author) {
		Author authorDb = authorDao.saveAuthor(author);
		ResponseStructure<Author> authorResponseStructure = new ResponseStructure<Author>();
		authorResponseStructure.setStatusCode(HttpStatus.CREATED.value());
		authorResponseStructure.setMessage("Success");
		authorResponseStructure.setData(authorDb);
		return new ResponseEntity<ResponseStructure<Author>>(authorResponseStructure, HttpStatus.CREATED);

	}

	
//	                                       <----| Get All Author Details |---->
	
	
	public ResponseEntity<ResponseStructure<List<Author>>> getAllAuthor() {
		List<Author> authorListDb = authorDao.getAllAuthor();

		if (!authorListDb.isEmpty()) {

			ResponseStructure<List<Author>> authorResponseStructure = new ResponseStructure<List<Author>>();
			authorResponseStructure.setStatusCode(HttpStatus.OK.value());
			authorResponseStructure.setMessage("Success");
			authorResponseStructure.setData(authorListDb);
			return new ResponseEntity<ResponseStructure<List<Author>>>(authorResponseStructure,HttpStatus.OK);
			
		} else {
			
			throw new ResourceNotFoundException("Author Details are Empty..!");
		}
	}
	
//	                                          <----| Get Author By ID |---->
	
	
	public ResponseEntity<ResponseStructure<Author>> getAuthorByID(int id){
		Optional<Author> authorOptionalDb = authorDao.getAuthorById(id);
		
		ResponseStructure<Author> authorResponseStructure = new ResponseStructure<Author>();		
		if(authorOptionalDb.isPresent()) {
			authorResponseStructure.setStatusCode(HttpStatus.OK.value());
			authorResponseStructure.setMessage("Success");			
			authorResponseStructure.setData(authorOptionalDb.get());
			return new ResponseEntity<ResponseStructure<Author>>(authorResponseStructure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFoundException("Author ID is not Found in Database");
		}
	}
	
	
//	                                           <----| Delete Author By ID |---->
	
	
	public ResponseEntity<ResponseStructure<Author>> deleteAuthorById(int id){
		Optional<Author> authorOptionalDb = authorDao.getAuthorById(id);
		
		ResponseStructure<Author> authorResponseStructure = new ResponseStructure<Author>();		
		if(authorOptionalDb.isPresent()) {
			authorResponseStructure.setStatusCode(HttpStatus.OK.value());
			authorResponseStructure.setMessage("Success");			
			authorResponseStructure.setData(authorOptionalDb.get());
			authorDao.deleteAuthorId(authorOptionalDb.get());
			return new ResponseEntity<ResponseStructure<Author>>(authorResponseStructure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFoundException("Author ID is not Found in Database");
		}
		
	}
	

// 	                                           <----| Update Author |---->
	
	
	public  ResponseEntity<ResponseStructure<Author>> updateAuthor(Author author){
		Author authorDb = authorDao.saveAuthor(author);
		ResponseStructure<Author> authorResponseStructure = new ResponseStructure<Author>();
		authorResponseStructure.setStatusCode(HttpStatus.OK.value());
		authorResponseStructure.setMessage("Success");
		authorResponseStructure.setData(authorDb);
		return new ResponseEntity<ResponseStructure<Author>>(authorResponseStructure, HttpStatus.OK);
	}
}
