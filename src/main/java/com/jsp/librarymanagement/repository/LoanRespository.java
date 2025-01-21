package com.jsp.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.librarymanagement.entity.Loan;

public interface LoanRespository extends JpaRepository<Loan, Integer>{

}
