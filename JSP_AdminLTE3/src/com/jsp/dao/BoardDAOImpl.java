package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dto.BoardVO;
import com.jsp.dto.MemberVO;
import com.jsp.request.SearchCriteria;

public class BoardDAOImpl implements BoardDAO {
	
	private SqlSessionFactory sessionFactory;
	
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public List<BoardVO> selectBoardCriteria(SearchCriteria cri) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		List<BoardVO> boardList = session.selectList("Board-Mapper.selectBoardList",cri);
		session.close();
		return boardList;
	}

	@Override
	public int selectBoardCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		int count = 0;
		SqlSession session = sessionFactory.openSession();
		count=session.selectOne("Board-Mapper.selectBoardListCount",cri);
		session.close();
		return count;
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		BoardVO board=session.selectOne("Board-Mapper.selectBoardByBno",bno);
		session.close();
		return board;
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		session.update("Member-Mapper.insertBoard",board);
		session.close();
		
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		session.update("Member-Mapper.updateBoard",board);
		session.close();
		
	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		session.update("Member-Mapper.deleteBoard",bno);
		session.close();
		
	}

	@Override
	public void increaseViewCnt(int bno) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		session.close();
		
	}

	@Override
	public int selectBoardSeqNext() throws SQLException {
		SqlSession session = sessionFactory.openSession();
		session.close();
		return 0;
	}

}
