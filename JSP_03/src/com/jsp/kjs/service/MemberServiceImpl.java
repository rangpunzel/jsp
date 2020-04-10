package com.jsp.kjs.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.kjs.dao.IMemberDao;
import com.jsp.kjs.dao.MemberDaoImpl;
import com.jsp.kjs.dto.MemberVO;
import com.jsp.kjs.exception.InvalidPasswordException;
import com.jsp.kjs.exception.NotFoundIDException;

public class MemberServiceImpl implements IMemberService {
	
	private static MemberServiceImpl instance = new MemberServiceImpl();
	private MemberServiceImpl() {}
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	private IMemberDao memberDAO = MemberDaoImpl.getInstance();
	public void setMemberDAO(IMemberDao memberDAO) {
		this.memberDAO=memberDAO;
	}

	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException {
		MemberVO member=memberDAO.selectMemberById(id);
		if(member ==null) throw new NotFoundIDException();
		if(!pwd.equals(member.getPwd())) throw new InvalidPasswordException();
	}
	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memberList = memberDAO.selectMemberList();
		return memberList;
	}
	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO mv = memberDAO.selectMemberById(id);
		return mv;
	}
	@Override
	public void regist(MemberVO mv) throws SQLException {
		memberDAO.insertMember(mv);
	}
	@Override
	public void modify(MemberVO mv) throws SQLException {
		memberDAO.updateMember(mv);
	}
	@Override
	public void remove(MemberVO mv) throws SQLException {
		memberDAO.deleteMember(mv);
	}

}
