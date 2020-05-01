package com.spring.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dto.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/spring/context/root-context.xml")
public class TestBasicDataSource {
	
	//autowired는 스프링 패키지라서 스프링이랑 잘맞음
	@Autowired
	private BasicDataSource dataSource;
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//테스트 메서드 실행 할때마다 실행
	@Before
	public void init() throws SQLException{
		conn=dataSource.getConnection();
	}
	
	@Test
	public void testConnection()throws SQLException{
		//접근 가능하게 퍼블릭이여야하고 return,parameter는 없어야함.
		Connection conn = this.conn;
		
		//결과비교 ( conn이 null이 아닐꺼라고 기대한다) : null이 나오면 fail임
		Assert.assertNotEquals(null, conn);
	}
	
	@Test
	public void testSqlInjection()throws SQLException{
		String id="mimi";
		String sql="select * from member where id='"+id+"'";
		
		this.stmt = this.conn.createStatement();
		this.rs = this.stmt.executeQuery(sql);
		
		MemberVO member=null;
		if(rs.next()) {
			member = new MemberVO();
			member.setId(rs.getString("id"));
		}
		
		Assert.assertEquals(id,member.getId());
	}
	
	@After
	public void end()throws SQLException{
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	
}
