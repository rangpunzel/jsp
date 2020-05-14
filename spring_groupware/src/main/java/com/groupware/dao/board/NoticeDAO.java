package com.groupware.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.NoticeVO;
import com.groupware.request.SearchCriteria;

public interface NoticeDAO {
	
	public List<NoticeVO> selectSearchNoticeList(SearchCriteria cri) throws SQLException;
	public int selectSearchNoticeListCount(SearchCriteria cri) throws SQLException;
	public List<NoticeVO> selectPointNoticeList(SearchCriteria cri)throws SQLException;
	public NoticeVO selectNoticeByNno(int nno)throws SQLException;
	
	public int selectNoticeSeqNext()throws SQLException;
	
	public void increaseViewCnt(int nno)throws SQLException;	
	
	public void insertNotice(NoticeVO notice)throws SQLException;
	public void updateNotice(NoticeVO notice)throws SQLException;
	public void deleteNotice(int nno)throws SQLException;
}
