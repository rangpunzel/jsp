package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dto.MemberVO;
import com.jsp.request.SearchCriteria;

public class MemberDAOImpl implements MemberDAO {
	private SqlSessionFactory sessionFactory; 
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		SqlSession session=sessionFactory.openSession();
		MemberVO member=session.selectOne("Member-Mapper.selectMemberById",id);
		session.close();
		return member;
	}


}
