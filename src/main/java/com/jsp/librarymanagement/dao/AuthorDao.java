package com.jsp.librarymanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.librarymanagement.entity.Author;
import com.jsp.librarymanagement.repository.AuthorRespository;

@Repository
public class AuthorDao {

	@Autowired
	private AuthorRespository authorRespository;

//	Save Author
	public Author saveAuthor(Author author) {
		return authorRespository.save(author);
	}

//	Get All Author Details
	public List<Author> getAllAuthor() {
		return authorRespository.findAll();
	}

//	Get Author Detail By Id
	public Optional<Author> getAuthorById(int id) {
		return authorRespository.findById(id);
	}

//	Delete Author By Id
	public void deleteAuthorId(Author author) {
		authorRespository.delete(author);
	}
}
