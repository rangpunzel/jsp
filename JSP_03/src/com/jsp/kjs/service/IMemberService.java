package com.jsp.kjs.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.kjs.dto.MemberVO;
import com.jsp.kjs.exception.InvalidPasswordException;
import com.jsp.kjs.exception.NotFoundIDException;

public interface IMemberService {
	
	//로그인
	void login(String id, String pwd)throws SQLException,NotFoundIDException,InvalidPasswordException;
	
	//회원 리스트 조회
	List<MemberVO> getMemberList()throws SQLException;
	
	//회원정보조회
	MemberVO getMember(String id)throws SQLException;
	
	//회원등록
	void regist(MemberVO mv) throws SQLException;
	
	//회원수정
	void modify(MemberVO mv)throws SQLException;
	
	//회원삭제
	void remove(MemberVO mv)throws SQLException;
}
