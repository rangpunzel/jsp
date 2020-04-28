package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dto.MemberVO;
import com.jsp.request.SearchCriteria;

public interface MemberDAO {
	
	//회원정보
	MemberVO selectMemberById(String id) throws SQLException;
	
}
