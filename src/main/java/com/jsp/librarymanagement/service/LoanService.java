package com.jsp.librarymanagement.service;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.librarymanagement.exceptions.IdNotFoundException;
import com.jsp.librarymanagement.exceptions.ResourceNotFoundException;
import com.jsp.librarymanagement.repository.LoanRespository;
import com.jsp.librarymanagement.dao.BookDao;
import com.jsp.librarymanagement.dao.LoanDao;
import com.jsp.librarymanagement.dao.MemberDao;
import com.jsp.librarymanagement.dto.ResponseStructure;
import com.jsp.librarymanagement.entity.Book;
import com.jsp.librarymanagement.entity.Loan;
import com.jsp.librarymanagement.entity.Member;
@Service
public class LoanService {
	
	@Autowired
	private LoanDao loanDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BookDao bookDao;
	
	
//	                                                   <--- | Save Loan |--->
	
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(Loan loan,int bookId,int memberId) {
		Optional<Book> bookDb = bookDao.getBookById(bookId);
		Optional<Member> memberDb = memberDao.getMemberById(memberId);
		ResponseStructure<Loan> loanResponseStructure = new ResponseStructure<Loan>();
		if(bookDb.isPresent() && memberDb.isPresent()) {
			loan.setBook(bookDb.get());
			loan.setMember(memberDb.get());
			Loan loanDb = loanDao.saveLoan(loan);
			loanResponseStructure.setStatusCode(HttpStatus.CREATED.value());
			loanResponseStructure.setMessage("Success");
			loanResponseStructure.setData(loanDb);
			return new ResponseEntity<ResponseStructure<Loan>>(loanResponseStructure,HttpStatus.CREATED);			
		}
		else if(bookDb.isEmpty()) {
			throw new IdNotFoundException("Book Id is not Found");
		}
		else {
			throw new IdNotFoundException("Member Id is not Found");
		}
	}
	
//	                                                  <--- | Get All Loan |--->
	
	public ResponseEntity<ResponseStructure<List<Loan>>> getAllLoan(){
		List<Loan> loanListDb = loanDao.getAllLoan();
		
		ResponseStructure<List<Loan>> loanResponseStructure = new ResponseStructure<List<Loan>>();
		if(!loanListDb.isEmpty()) {
			loanResponseStructure.setStatusCode(HttpStatus.OK.value());
			loanResponseStructure.setMessage("Success");
			loanResponseStructure.setData(loanListDb);
			return new ResponseEntity<ResponseStructure<List<Loan>>>(loanResponseStructure,HttpStatus.OK);
		}
		else {
			throw new ResourceNotFoundException("Loan List is Empty..!");
		}
	}
	
//	                                               <--- | Get Loan Detail By Id |--->
	
	public ResponseEntity<ResponseStructure<Loan>> getLoanById(int id){
		Optional<Loan> loanOptionalDb = loanDao.getLoanById(id);
		ResponseStructure<Loan> loanResponseStructure = new ResponseStructure<Loan>();		
		if(loanOptionalDb.isPresent()) {
			loanResponseStructure.setStatusCode(HttpStatus.OK.value());
			loanResponseStructure.setMessage("Success");
			loanResponseStructure.setData(loanOptionalDb.get());
			return new ResponseEntity<ResponseStructure<Loan>>(loanResponseStructure,HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Loan ID is not Present in DataBase");
		}
	}
//                                                   <--- | Update Loan Detail |--->
	public ResponseEntity<ResponseStructure<Loan>> updateLoan(Loan loan) {
		Optional<Loan> loanOptinoalDb = loanDao.getLoanById(loan.getId());
		if(loanOptinoalDb.isPresent()) {
			Loan loanDataDb = loanOptinoalDb.get();
			ResponseStructure<Loan> loanResponseStructure = new ResponseStructure<Loan>();
			loan.setBook(loanDataDb.getBook());
			loan.setMember(loanDataDb.getMember());
			Loan loanDb = loanDao.saveLoan(loan);
			loanResponseStructure.setStatusCode(HttpStatus.CREATED.value());
			loanResponseStructure.setMessage("Success");
			loanResponseStructure.setData(loanDb);
			return new ResponseEntity<ResponseStructure<Loan>>(loanResponseStructure,HttpStatus.CREATED);				
		}
		else {
			throw new IdNotFoundException("Loan Id isn't Present in Database..!");
		}
	}
	
//	                                                <--- | Delete Loan By Id |--->
	
	public ResponseEntity<ResponseStructure<Loan>> deleteLoan(int id){
		Optional<Loan> loanOptional = loanDao.getLoanById(id);
		ResponseStructure<Loan> loanrespoResponseStructure = new ResponseStructure<Loan>();
		if(loanOptional.isPresent()) {
			loanrespoResponseStructure.setStatusCode(HttpStatus.OK.value());
			loanrespoResponseStructure.setMessage("Success");
			loanrespoResponseStructure.setData(loanOptional.get());
			loanDao.deleteLoan(loanOptional.get());
			return new ResponseEntity<ResponseStructure<Loan>>(loanrespoResponseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Loan Id is Present in Database");
		}
	}
	

}
