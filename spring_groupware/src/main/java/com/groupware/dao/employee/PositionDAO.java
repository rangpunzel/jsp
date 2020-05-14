package com.groupware.dao.employee;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.PositionVO;

public interface PositionDAO {

	
	List<PositionVO> selectPositionList()throws SQLException;
	
}
