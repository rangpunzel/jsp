package com.groupware.dao.employee;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.CareerVO;

public interface CareerDAO {
	List<CareerVO> selectCareerList(String id) throws SQLException;
	void insertCareer(CareerVO career) throws SQLException;
	void updateCareer(CareerVO career) throws SQLException;
	void deleteCareer(int cno, String id) throws SQLException;
	void deleteAllCareers(String id)throws SQLException;
}
