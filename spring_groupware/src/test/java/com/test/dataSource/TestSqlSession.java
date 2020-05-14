package com.test.dataSource;

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

import com.groupware.dto.EmployeeVO;
import com.groupware.request.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/groupware/context/root-context.xml")
public class TestSqlSession {
	
	@Autowired
	private SqlSession session;
	
	@Before
	public void init(){}
	
	@Test
	public void testSession(){
		Assert.assertNotEquals(null, session);
	}
	
	@Test
	public void testSelectMember()throws SQLException{
		
		String id="mimi";
		
		EmployeeVO member = session.selectOne("Employee-Mapper.selectEmployeeById",id);
		
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
		
		List<EmployeeVO> memberList = 
				session.selectList("Employee-Mapper.selectSearchEmployeeList",cri,rowBounds);
		
		Assert.assertEquals(1, memberList.size());
		
		EmployeeVO member = memberList.get(0);
		
		Assert.assertEquals(cri.getKeyword(), member.getId());
				
	}
	
}
