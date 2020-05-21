package com.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.MemberVO;

//bean등록할떄 ID부분
//annotation으로 빈등록 할때는 일일이 열어서 등록해야하는 단점이 있음.
@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	//의존주입 받는 부분 
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	public void insertMember(MemberVO member) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = dataSource.getConnection();
			
			String sql="insert into member(id,pwd,phone,email)"
					+ " values(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getEmail());
			
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {		
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}

	@Override
	public MemberVO selectMember(String id) throws SQLException {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql=null;
		
		MemberVO member = new MemberVO();
		
		try {
			conn=dataSource.getConnection();
			stmt=conn.createStatement();
			sql="select * from member where id='"+id+"'";
			
			rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				member.setEmail(rs.getString("email"));
				member.setId(rs.getString("id"));
				member.setPhone(rs.getString("phone"));
				member.setPwd(rs.getString("pwd"));				
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		
		return member;
	}
	
}






