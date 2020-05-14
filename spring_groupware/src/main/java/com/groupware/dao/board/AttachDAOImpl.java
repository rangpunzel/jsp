package com.groupware.dao.board;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.groupware.dto.PdsAttachVO;

public class AttachDAOImpl implements AttachDAO{	
	
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session=session;
	}
	
	@Override
	public void insertAttach(PdsAttachVO attach) throws SQLException {
		session.update("PdsAttach-Mapper.insertAttach",attach);
	}

	@Override
	public void deleteAttach(int ano) throws SQLException {
		session.update("PdsAttach-Mapper.deleteAttach",ano);		
		
	}

	@Override
	public List<PdsAttachVO> selectAttachesByPno(int pno) throws SQLException {
		List<PdsAttachVO> attachList=
				session.selectList("PdsAttach-Mapper.selectAttachByPno",pno);
		return attachList;
	}

	@Override
	public void deleteAllAttach(int pno) throws SQLException {
		session.update("PdsAttach-Mapper.deleteAllAttach",pno);		
	}
	@Override
	public PdsAttachVO selectAttachByAno(int ano) throws SQLException {
		PdsAttachVO attach=
			session.selectOne("PdsAttach-Mapper.selectAttachByAno",ano);
		
		return attach;
	}

}
