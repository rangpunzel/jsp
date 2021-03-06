package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;
import com.jsp.request.SearchCriteria;

public interface MemberDAO {
	
	//회원리스트
	List<MemberVO> selectMemberList() throws SQLException;
	List<MemberVO> selectMemberList(SearchCriteria cri) throws SQLException;
	
	//전체 회원리스트 개수
	int selectMemberListCount() throws SQLException;
	
	//검색 결과의 전체 리스트 개수
	int selectMemberListCount(SearchCriteria cri) throws SQLException;
	
	//회원정보
	MemberVO selectMemberById(String id) throws SQLException;
	
	//회원정보 추가
	void insertMember(MemberVO member) throws SQLException;
	
	//회원정보 수정
	void updateMember(MemberVO member) throws SQLException;
	
	//회원정보 삭제
	void deleteMember(String id) throws SQLException;
	
	//회원 비활성화
	void disabledMember(String id) throws SQLException;
	
	//회원 활성화
	void abledMember(String id) throws SQLException;
	
}
