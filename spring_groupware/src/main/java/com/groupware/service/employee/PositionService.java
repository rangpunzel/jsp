package com.groupware.service.employee;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.PositionVO;

public interface PositionService {

	List<PositionVO> getPosotionList()throws SQLException;
	
}
