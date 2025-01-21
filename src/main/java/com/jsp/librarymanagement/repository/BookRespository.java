package com.jsp.librarymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.librarymanagement.entity.Book;

public interface BookRespository extends JpaRepository<Book, Integer> {

	public List<Book> findByGenre(String genre);
}
