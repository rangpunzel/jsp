package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jsp.dao.MemberDAO;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.request.PageMaker;
import com.jsp.request.SearchCriteria;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO=memberDAO;
	}

	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException {
		MemberVO member=memberDAO.selectMemberById(id);
		if(member ==null) throw new NotFoundIDException();
		if(!pwd.equals(member.getPwd())) throw new InvalidPasswordException();
		
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
		return member;
	}


}
