package com.groupware.service.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.groupware.dto.NoticeVO;
import com.groupware.request.SearchCriteria;

public interface NoticeService {
	
	public Map<String,Object> getNoticeList(SearchCriteria cri)throws SQLException;
	public List<NoticeVO> getPointNoticeList(SearchCriteria cri)throws SQLException;
	public NoticeVO getNotice(int nno)throws SQLException;
		
	public void regist(NoticeVO notice)throws SQLException;
	public void modify(NoticeVO notice)throws SQLException;
	public void remove(int nno)throws SQLException;
	
	public NoticeVO read(int nno)throws SQLException;	
	

}
