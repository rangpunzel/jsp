package com.groupware.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.ReplyVO;
import com.groupware.request.SearchCriteria;

public interface ReplyDAO {
	
	void insertReply(ReplyVO reply)throws SQLException;
	void updateReply(ReplyVO reply)throws SQLException;
	void deleteReply(int rno)throws SQLException;
	
	List<ReplyVO> selectReplyListPage(int bno,SearchCriteria cri)	
								throws SQLException;
	int countReply(int bno) throws SQLException;
}





