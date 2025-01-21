package com.jsp.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonWriter.Members;
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
import com.jsp.librarymanagement.entity.Member;
import com.jsp.librarymanagement.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
//	Save Member Detail
	@PostMapping
	public ResponseEntity<ResponseStructure<Member>> saveMember(@RequestBody Member member){
		return memberService.saveMember(member);
	}
	
//  Get All The Memeber Details
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Member>>> getAllMember(){
		return memberService.getAllMember();
	}
	
//	Get Member Detail By Id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Member>> getMemberById(@PathVariable int id){
		return memberService.getMemberById(id);
	}
	
//	Delete Member By Id
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Member>> deleteMemberById(@PathVariable int id){
		return memberService.deleteMember(id);
	}
	
//	Update Member Detail
	@PutMapping
	public ResponseEntity<ResponseStructure<Member>> updateMember(@RequestBody Member member){
		return memberService.updateMember(member);
	}
}
