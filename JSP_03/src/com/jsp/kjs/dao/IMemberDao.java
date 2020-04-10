package com.jsp.kjs.dao;

import java.sql.SQLException;
import java.util.List;

import com.jsp.kjs.dto.MemberVO;

public interface IMemberDao {
	
	MemberVO selectMemberById(String id) throws SQLException;
	
	//전체 회원조회
	List<MemberVO> selectMemberList() throws SQLException;
	
	//회원수 조회
	int selectMemberListCount() throws SQLException;
	
	//회원 등록
	void insertMember(MemberVO mv) throws SQLException;
	
	//회원 수정
	void updateMember(MemberVO mv) throws SQLException;
	
	//회원 삭제
	void deleteMember(MemberVO mv) throws SQLException;
	
}
