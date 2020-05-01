package com.spring.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIDException;
import com.spring.request.SearchCriteria;

public interface MemberService {
	
	//로그인
	void login(String id, String pwd)throws SQLException,NotFoundIDException,InvalidPasswordException;
	
	//회원 리스트 조회
	List<MemberVO> getMemberList()throws SQLException;
	Map<String,Object> getMemberList(SearchCriteria cri)throws SQLException;
	
	//회원정보조회
	MemberVO getMember(String id)throws SQLException;
	
	//회원등록
	void regist(MemberVO member) throws SQLException;
	
	//회원수정
	void modify(MemberVO member)throws SQLException;
	
	//회원삭제
	void remove(String id)throws SQLException;
	
	//회원 비활성화
	void disabled(String id)throws SQLException;
	
	//회원 활성화
	void abled(String id)throws SQLException;
	
}
