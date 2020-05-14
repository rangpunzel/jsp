package com.groupware.dao.board;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.groupware.dto.PdsShareVO;

public class PdsShareDAOImpl implements PdsShareDAO {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}

	@Override
	public List<PdsShareVO> selectPdsShareListByPno(int pno) throws SQLException {
		List<PdsShareVO> pdsShareList = sqlSession.selectList("PdsShare-Mapper.selectPdsShareListByPno", pno);
		return pdsShareList;
	}

	@Override
	public void insertPdsShare(PdsShareVO psv) throws SQLException {
		sqlSession.update("PdsShare-Mapper.insertPdsShare",psv);

	}

	@Override
	public void deletePdsShare(int pno) throws SQLException {
		sqlSession.update("PdsShare-Mapper.deletePdsShare",pno);

	}

}
