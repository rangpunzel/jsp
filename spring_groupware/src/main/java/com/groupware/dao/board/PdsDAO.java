package com.groupware.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.PdsVO;
import com.groupware.request.SearchCriteria;

public interface PdsDAO {
	
	List<PdsVO> selectPdsSearchCriteria(SearchCriteria cri)	throws SQLException;
	int selectPdsSearchCriteriaTotalCount(SearchCriteria cri) throws SQLException;
	
	PdsVO selectPdsByPno(int pno)throws SQLException;
	
	void insertPds(PdsVO pds)throws SQLException;
	void updatePds(PdsVO pds)throws SQLException;
	void deletePds(int pno)throws SQLException;
	
	//viewcnt  증가
	void increaseViewCnt(int pno)throws SQLException;
	
	//pds_seq.nextval 가져오기
	int getSeqNextValue() throws SQLException;
}
