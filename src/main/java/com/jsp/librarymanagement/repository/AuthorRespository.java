package com.jsp.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.librarymanagement.entity.Author;

public interface AuthorRespository extends JpaRepository<Author, Integer> {

}
