package com.groupware.dao.employee;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.groupware.dto.DepartmentVO;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public List<DepartmentVO> selectDeptList() throws SQLException {
		List<DepartmentVO> deptList = sqlSession.selectList("Department-Mapper.selectDeptList");
		return deptList;
	}

}
