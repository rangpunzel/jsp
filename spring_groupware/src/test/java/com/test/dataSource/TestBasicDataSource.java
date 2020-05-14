package com.test.dataSource;

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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/groupware/context/root-context.xml")
public class TestBasicDataSource {
	
	@Autowired
	private BasicDataSource dataSource;
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	@Before
	public void init() throws SQLException{
		conn=dataSource.getConnection();		
	}
	
	@Test
	public void testConnection()throws SQLException{
		
		Connection conn = this.conn;
		
		
		Assert.assertNotEquals(null, conn);		
	}
	
	/*@Test
	public void testSqlInjection()throws SQLException{		
		
		final String id="mimi";
		
		String sql="select * from member where id='"+id+"'";
		
		this.stmt = this.conn.createStatement(); 
		this.rs = this.stmt.executeQuery(sql);
		
		MemberVO member=null;
		if(rs.next()){
			member = new MemberVO();
			member.setId(rs.getString("id"));
		}
		
		Assert.assertEquals(id, member.getId());		
	}
*/
	@After  
	public void end()throws SQLException{
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	
}








