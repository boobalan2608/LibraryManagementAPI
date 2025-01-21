package com.jsp.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.librarymanagement.entity.Member;


public interface MemberRespository extends JpaRepository<Member, Integer>{

}
