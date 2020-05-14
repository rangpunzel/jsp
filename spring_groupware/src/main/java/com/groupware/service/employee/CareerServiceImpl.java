package com.groupware.service.employee;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dao.employee.CareerDAO;
import com.groupware.dto.CareerVO;

public class CareerServiceImpl implements CareerService{
	
	private CareerDAO careerDAO;
	public void setCareerDAO(CareerDAO careerDAO) {
		this.careerDAO=careerDAO;
	}

	@Override
	public List<CareerVO> getCareerList(String id) throws SQLException {
		List<CareerVO> careerList = careerDAO.selectCareerList(id);		
		return careerList;
	}

	@Override
	public void regist(CareerVO career) throws SQLException {
		careerDAO.insertCareer(career);
		
	}

	@Override
	public void modify(CareerVO career) throws SQLException {
		careerDAO.updateCareer(career);		
	}

	@Override
	public void remove(int cno, String id) throws SQLException {
		careerDAO.deleteCareer(cno, id);
	}
	
	
}
