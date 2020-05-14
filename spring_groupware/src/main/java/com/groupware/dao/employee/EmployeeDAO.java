package com.groupware.dao.employee;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.EmployeeVO;
import com.groupware.request.SearchCriteria;

public interface EmployeeDAO {
		
	//EmployeeVO 리스트
	List<EmployeeVO> selectEmployeeList()throws SQLException;
	List<EmployeeVO> selectEmployeeList(SearchCriteria cri)throws SQLException;
	//같은 부서 조회 EmployeeVO
	List<EmployeeVO> selectEmployeeListByDeptNo(String dept_no)throws SQLException;
	
	// 검색 결과의 전체 리스트 개수
	int selectEmployeeListCount(SearchCriteria ci)throws SQLException; 
	
	//id 조회 EmployeeVO
	EmployeeVO selectEmployeeById(String id)throws SQLException;
	
	
	//같은 부서원 명수
	int selectDeptEmpCount(String eno)throws SQLException;
	
	//insert EmployeeVO
	void insertEmployee(EmployeeVO employee)throws SQLException;
	
	//update EmployeeVO
	void updateEmployee(EmployeeVO employee)throws SQLException;
	
	//id를 받아서 delete EmployeeVO  
	void deleteEmployee(String id)throws SQLException;
	
	//id를 받아서 disable EmployeeVO
	void disableEmployee(String id)throws SQLException;
	
	//recentLoginTime 갱신
	void updateRecentLoginTime(String id)throws SQLException;
}



