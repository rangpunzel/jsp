package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIDException;
import com.spring.request.SearchCriteria;

public class TestMemberServiceImpl {

	private MemberDAO memberDAO=new MockMemberDAO();
	
	private MemberServiceImpl service;
	
	@Before
	public void init(){
		service = new MemberServiceImpl();
		service.setMemberDAO(new MockMemberDAO());		
	}
	
	
	@Test
	public void testGetList()throws SQLException{
		
		List<MemberVO> memberList = service.getMemberList();
		
		Assert.assertEquals(3,memberList.size());
	}
	
	@Test
	public void testGetSearchList()throws SQLException{
		
		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword("mimi");
		cri.setSearchType("i");
		
		List<MemberVO> memberList = 
				(List<MemberVO>)service.getMemberList(cri).get("memberList");
		
		Assert.assertEquals(2,memberList.size());
	}
	@Test
	public void testLogin()throws SQLException{
		String testID = "kkk";
		String testPWD ="kkk";
		
		try{
			service.login(testID, testPWD);
		}catch(NotFoundIDException e){
			Assert.assertEquals(1,1);
		}catch(InvalidPasswordException e){
			Assert.assertEquals(1,0);
		}
		
		testID="mimi";
		try{
			service.login(testID,testPWD);
		}catch(InvalidPasswordException e){
			Assert.assertEquals(1,1);
		}catch(NotFoundIDException e){
			Assert.assertEquals(1,2);
		}
		
		testPWD="1234";
		try{
			service.login(testID,testPWD);
		}catch(InvalidPasswordException e){
			Assert.assertEquals(1,3);
		}catch(NotFoundIDException e){
			Assert.assertEquals(1,4);
		}
		
	
	}
		
}

