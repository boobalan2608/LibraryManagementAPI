package com.jsp.librarymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.librarymanagement.exceptions.IdNotFoundException;
import com.jsp.librarymanagement.exceptions.ResourceNotFoundException;
import com.jsp.librarymanagement.dao.MemberDao;
import com.jsp.librarymanagement.dto.ResponseStructure;
import com.jsp.librarymanagement.entity.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
//	                                               <--- | Save Member |--->
	public ResponseEntity<ResponseStructure<Member>> saveMember(Member member){
		Member memberDb = memberDao.saveMember(member);
		
		ResponseStructure<Member> memberResponseStructure = new ResponseStructure<Member>();
		memberResponseStructure.setStatusCode(HttpStatus.CREATED.value());
		memberResponseStructure.setMessage("Success");
		memberResponseStructure.setData(memberDb);
		
		return new ResponseEntity<ResponseStructure<Member>>(memberResponseStructure,HttpStatus.CREATED);
		
	}

//                                                 <--- | Get all Member |--->
	public ResponseEntity<ResponseStructure<List<Member>>> getAllMember(){
		List<Member> memberListDb = memberDao.getAllMember();
		if(!memberListDb.isEmpty()) {
			
		ResponseStructure<List<Member>> memberResponseStructure = new ResponseStructure<List<Member>>();
		memberResponseStructure.setStatusCode(HttpStatus.OK.value());
		memberResponseStructure.setMessage("Success");
		memberResponseStructure.setData(memberListDb);
		
		return new ResponseEntity<ResponseStructure<List<Member>>>(memberResponseStructure,HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Member list is Empty...!");
		}
	}
//	                                           <--- | Get Member Detail by Id |--->
	public ResponseEntity<ResponseStructure<Member>> getMemberById(int id){
		Optional<Member> memberOptionalDb = memberDao.getMemberById(id);
		ResponseStructure<Member> memberResponseStructure = new ResponseStructure<Member>();
		if(memberOptionalDb.isPresent()) {
			memberResponseStructure.setStatusCode(HttpStatus.OK.value());
			memberResponseStructure.setMessage("Success");
			memberResponseStructure.setData(memberOptionalDb.get());
			return new ResponseEntity<ResponseStructure<Member>>(memberResponseStructure,HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Member ID is not Present in Database");
		}
	}
	
//	                                             <--- | Delete Member By Id |--->
	
	public ResponseEntity<ResponseStructure<Member>> deleteMember(int id){
		Optional<Member> memberOptionalDb = memberDao.getMemberById(id);
		ResponseStructure<Member> memberResponseStructure = new ResponseStructure<Member>();
		if(memberOptionalDb.isPresent()) {
			memberResponseStructure.setStatusCode(HttpStatus.OK.value());
			memberResponseStructure.setMessage("Success");
			memberResponseStructure.setData(memberOptionalDb.get());
			memberDao.deleteMember(memberOptionalDb.get());
			return new ResponseEntity<ResponseStructure<Member>>(memberResponseStructure,HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Member ID is not Present in Database");
		} 
	}
	
//	                                                <--- | Update Member |--->
	
	
	public ResponseEntity<ResponseStructure<Member>> updateMember(Member member){
		Member memberDb = memberDao.saveMember(member);
		ResponseStructure<Member> memberResponseStructure = new ResponseStructure<Member>();
		memberResponseStructure.setStatusCode(HttpStatus.OK.value());
		memberResponseStructure.setMessage("Success");
		memberResponseStructure.setData(memberDb);
		return new ResponseEntity<ResponseStructure<Member>>(memberResponseStructure,HttpStatus.OK);
	}
}
