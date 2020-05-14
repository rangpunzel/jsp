package com.groupware.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.PdsShareVO;

public interface PdsShareDAO {
	
	
	List<PdsShareVO> selectPdsShareListByPno(int pno)throws SQLException;
	void insertPdsShare(PdsShareVO psv)throws SQLException;
	void deletePdsShare(int pno)throws SQLException;
	
}
