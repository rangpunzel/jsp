package com.jsp.kjs.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.kjs.dto.MemberVO;
import com.jsp.kjs.mybatis.OracleMyBatisSqlSessionFactoryBuilder;


public class MemberDaoImpl implements IMemberDao {
	
	private static MemberDaoImpl instance=new MemberDaoImpl();
	private MemberDaoImpl() {}
	public static MemberDaoImpl getInstance() {
		return instance;
	}
	
	private SqlSessionFactory sessionFactory = OracleMyBatisSqlSessionFactoryBuilder.getSqlSessionFactory();


	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		SqlSession session=sessionFactory.openSession();
		MemberVO member=session.selectOne("Member-Mapper.selectMemberById",id);
		session.close();
		return member;
	}
	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		SqlSession session=sessionFactory.openSession();
		List<MemberVO> memberlist=session.selectList("Member-Mapper.selectMemberList");
		session.close();
		return memberlist;
	}
	@Override
	public int selectMemberListCount() throws SQLException {
		SqlSession session=sessionFactory.openSession();
		int cnt = session.selectOne("Member-Mapper.selectMemberListCount");
		session.close();
		return cnt;
	}
	@Override
	public void insertMember(MemberVO mv) throws SQLException {
		SqlSession session=sessionFactory.openSession();
		session.update("Member-Mapper.insertMember", mv);
		session.close();
	}
	@Override
	public void updateMember(MemberVO mv) throws SQLException {
		SqlSession session=sessionFactory.openSession();
		session.update("Member-Mapper.updateMember",mv);
		session.close();
	}
	@Override
	public void deleteMember(MemberVO mv) throws SQLException {
		SqlSession session=sessionFactory.openSession();
		session.update("Member-Mapper.deleteMember",mv);
		session.close();
	}

}
