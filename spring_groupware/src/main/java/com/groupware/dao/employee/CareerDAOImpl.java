package com.groupware.dao.employee;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.groupware.dto.CareerVO;

public class CareerDAOImpl implements CareerDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public List<CareerVO> selectCareerList(String id) throws SQLException {
		List<CareerVO> careerList = sqlSession.selectList("Career-Mapper.selectCareerList",id);
		return careerList;
	}

	@Override
	public void insertCareer(CareerVO career) throws SQLException {
		sqlSession.update("Career-Mapper.insertCareer",career);
		
	}

	@Override
	public void updateCareer(CareerVO career) throws SQLException {
		sqlSession.update("Career-Mapper.updateCareer", career);
	}

	@Override
	public void deleteCareer(int cno, String id) throws SQLException {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("cno", cno);
		paramMap.put("id", id);
		sqlSession.update("Career-Mapper.deleteCareer",paramMap);
		
	}

	@Override
	public void deleteAllCareers(String id) throws SQLException {
		sqlSession.update("Career-Mapper.deleteAllCareers",id);
		
	}

}
