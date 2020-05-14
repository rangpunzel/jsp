package com.groupware.service.employee;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dao.employee.PositionDAO;
import com.groupware.dto.PositionVO;

public class PositionServiceImpl implements PositionService {
	
	private PositionDAO positionDAO;
	public void setPositionDAO(PositionDAO positionDAO) {
		this.positionDAO = positionDAO;
	}
	@Override
	public List<PositionVO> getPosotionList() throws SQLException {
		List<PositionVO> positionList = positionDAO.selectPositionList();
		return positionList;
	}
	
	
	
	
}
