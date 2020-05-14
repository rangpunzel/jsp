package com.groupware.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.BoardVO;
import com.groupware.request.SearchCriteria;

public interface PageBoardDAO extends BoardDAO {
	
	List<BoardVO> selectBoardSearchCriteria(SearchCriteria cri)	throws SQLException;
	int selectBoardSearchCriteriaTotalCount(SearchCriteria cri) throws SQLException;
}
