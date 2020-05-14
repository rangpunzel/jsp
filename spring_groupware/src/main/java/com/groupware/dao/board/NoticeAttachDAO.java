package com.groupware.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.NoticeAttachVO;

public interface NoticeAttachDAO {
	
	public List<NoticeAttachVO> selectAttachesByNno(int nno)throws SQLException;
	public NoticeAttachVO selectAttachByNano(int nano)throws SQLException;
	
	public void insertAttach(NoticeAttachVO attach) throws SQLException;

	public void deleteAttach(int nano) throws SQLException;

	public void deleteAllAttach(int nno)throws SQLException;
}






