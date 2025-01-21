package com.jsp.librarymanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.librarymanagement.entity.Member;
import com.jsp.librarymanagement.repository.MemberRespository;

@Repository
public class MemberDao {

	@Autowired
	private MemberRespository memberRespository;
// Save Member
	public Member saveMember(Member member) {
		return memberRespository.save(member);
	}
//	Get All Member
	public List<Member> getAllMember(){
		return memberRespository.findAll();
	}
//	Get Member Detail by ID
	public Optional<Member> getMemberById(int id){
		return memberRespository.findById(id);
	}
//	Delete Member By ID
	public void deleteMember(Member member) {
		memberRespository.delete(member);
	}
}
