package com.spring.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;
import com.spring.request.SearchCriteria;

public class MockMemberDAO implements MemberDAO{
	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		MemberVO member1=new MemberVO("mimi","mimi","mimi","000-0000-1234","mimi@mimi.com",
				                      "noImage.jpg","ROLE_ADMIN",1, null);
		MemberVO member2=new MemberVO("mimi1","mimi1","mimi","000-111-1234","mimi1@mimi.com",
                "noImage.jpg","ROLE_ADMIN",1, null);
		MemberVO member3=new MemberVO("mama","mama","mama","000-111-1234","mimi1@mimi.com",
                "noImage.jpg","ROLE_ADMIN",1, null);
		
		memberList.add(member1);
		memberList.add(member2);
		memberList.add(member3);

		return memberList;
	}
	@Override
	public int selectMemberListCount() throws SQLException {
		
		return 3;
	}
	@Override
	public List<MemberVO> selectMemberList(SearchCriteria cri) throws SQLException {
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		if(cri.getSearchType().equals("i") && cri.getKeyword().equals("mimi")) {
		
			MemberVO member1=new MemberVO("mimi","mimi","mimi","000-0000-1234","mimi@mimi.com",
					                      "noImage.jpg","ROLE_ADMIN",1, null);
			MemberVO member2=new MemberVO("mimi1","mimi1","mimi","000-111-1234","mimi1@mimi.com",
	                "noImage.jpg","ROLE_ADMIN",1, null);
			
			memberList.add(member1);
			memberList.add(member2);
		}
		return memberList;
	}

	@Override
	public int selectMemberListCount(SearchCriteria cri) throws SQLException {
		int count=0;
		if(cri.getSearchType().equals("i") && cri.getKeyword().equals("mimi")) {
			count=2;
		}
		return count;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		MemberVO member=null; 
		if(!id.equals("mimi"))return member;
		
		member=new MemberVO();
		member.setId(id);
		member.setPwd("1234");
		member.setEnabled(1);
		member.setPhone("010-1234-5678");
		member.setEmail(id+"@"+id+".com");
		member.setPicture("noImage.jpg");
		
		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		if(member==null) throw new SQLException();
		if(member.getId().isEmpty() || member.getId()==null) 
				throw new SQLException("1111:부적합한 열유형"); 
		
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disabledMember(String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void abledMember(String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
}
