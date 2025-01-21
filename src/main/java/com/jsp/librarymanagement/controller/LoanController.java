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
import com.jsp.librarymanagement.entity.Loan;
import com.jsp.librarymanagement.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	private LoanService loanService;
	
//	Save Loan Detail
	@PostMapping("/{bookId}/{memberId}")
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(@RequestBody Loan loan,@PathVariable int bookId,@PathVariable int memberId){
		return loanService.saveLoan(loan,bookId,memberId);
	}
	
//	Get All Loan Details
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Loan>>> getAllLoan(){
		return loanService.getAllLoan();
	}
	
//	Get Loan Detail By Id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Loan>> getLoanById(@PathVariable int id){
		return loanService.getLoanById(id);
	}
	
//	Update the Loan Detail
	@PutMapping
	public ResponseEntity<ResponseStructure<Loan>> updateLoan(@RequestBody Loan loan){
		return loanService.updateLoan(loan);
	}

//	Delete Loan Detail By Id
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseStructure<Loan>> deleteLoan(@PathVariable int id){
		return loanService.deleteLoan(id);
	}
}
