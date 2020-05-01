package com.spring.test;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dto.MemberVO;
import com.spring.request.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/spring/context/root-context.xml")
public class TestSqlSession { //classpath : 클래스가 시작되는 지점. JVM에 쓰려면 절대경로를 줘야해서 ""를 뺴야함.
	
	@Autowired
	private SqlSession session;
	//세션을 열지 않아도 알아서 열고 닫는다.
	
	@Before
	public void init(){}
	
	@Test
	public void testSession(){
		Assert.assertNotEquals(null, session);
	}
	
	@Test
	public void testSelectMember()throws SQLException{
		
		String id="mimi";
		
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById",id);
		
		Assert.assertEquals(id, member.getId());
	}
	
	@Test
	public void testSelectList()throws SQLException{
		
		SearchCriteria cri=new SearchCriteria();
		cri.setPage(1);
		cri.setPerPageNum(5);
		cri.setSearchType("i");
		cri.setKeyword("mimi");
		
		
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<MemberVO> memberList = 
				session.selectList("Member-Mapper.selectSearchMemberList",cri,rowBounds);
		
		Assert.assertEquals(1, memberList.size());
		
		MemberVO member = memberList.get(0);
		
		Assert.assertEquals(cri.getKeyword(), member.getId());
				
	}
	
}
