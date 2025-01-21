package com.jsp.librarymanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.librarymanagement.entity.Loan;
import com.jsp.librarymanagement.repository.LoanRespository;

@Repository
public class LoanDao {
	
	@Autowired
	
	private LoanRespository loanRespository;
//	Save Loan
	public Loan saveLoan(Loan loan) {
		return loanRespository.save(loan);
	}
//	Get All Loan 
	public List<Loan> getAllLoan(){
		return loanRespository.findAll();
	}
	
//	Get Loan Detail By Id
	public Optional<Loan> getLoanById(int id) {
		return loanRespository.findById(id);
	}
//	Delete  By Id
	public void deleteLoan(Loan loan) {
		loanRespository.delete(loan);
	}

}
