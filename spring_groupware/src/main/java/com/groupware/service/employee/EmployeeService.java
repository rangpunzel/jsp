package com.groupware.service.employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.groupware.dto.CareerVO;
import com.groupware.dto.EmployeeVO;
import com.groupware.exception.IdNotFoundException;
import com.groupware.exception.InvalidPasswordException;
import com.groupware.request.SearchCriteria;

public interface EmployeeService {
	
	// 로그인 기능
	void login(String id, String pwd)throws SQLException,
											IdNotFoundException,
											InvalidPasswordException;
	
	// 회원가입
	void regist(EmployeeVO employee, List<CareerVO> careers)throws SQLException;
	
	// 회원조회
	Map<String,Object> getEmployee(String id)throws SQLException;
	
	//같은 부서원 명수
	int getdeptEmpCount(String eno)throws SQLException;
	
	// 회원리스트
	List<EmployeeVO> getEmployeeList()throws SQLException;
	
	Map<String,Object> getEmployeeList(SearchCriteria cri)throws SQLException;
	
	//회원수정
	void modify(EmployeeVO employee,List<CareerVO> careers)throws SQLException;
	
	//회원삭제
	void remove(String id)throws SQLException;
	
	//회원 비활성
	void disable(String id)throws SQLException;
	
	//최종로그인 시간 수정
	void recentLoginTime(String id)throws SQLException;
	
	
}







