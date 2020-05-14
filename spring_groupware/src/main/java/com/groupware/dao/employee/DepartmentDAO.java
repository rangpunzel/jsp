package com.groupware.dao.employee;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.DepartmentVO;

public interface DepartmentDAO {

	
	List<DepartmentVO> selectDeptList()throws SQLException;
}
