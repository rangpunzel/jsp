package com.groupware.service.employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.groupware.dto.DepartmentVO;
import com.groupware.dto.DynatreeVO;

public interface DepartmentService {

	
	List<DepartmentVO> getDeptList()throws SQLException;
	
	List<DynatreeVO> getDynaTree(String key)throws SQLException;
}
