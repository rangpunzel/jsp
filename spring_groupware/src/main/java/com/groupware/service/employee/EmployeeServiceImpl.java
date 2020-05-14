package com.groupware.service.employee;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.groupware.dao.employee.CareerDAO;
import com.groupware.dao.employee.EmployeeDAO;
import com.groupware.dto.CareerVO;
import com.groupware.dto.EmployeeVO;
import com.groupware.exception.IdNotFoundException;
import com.groupware.exception.InvalidPasswordException;
import com.groupware.request.PageMaker;
import com.groupware.request.SearchCriteria;
import com.groupware.utils.DataFormat;

public class EmployeeServiceImpl implements EmployeeService{

	
	// EmployeeDAO 
	private EmployeeDAO employeeDAO;
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO=employeeDAO;
	}
	
	//CareerDAO
	private CareerDAO careerDAO;
	public void setCareerDAO(CareerDAO careerDAO) {
		this.careerDAO=careerDAO;
	}
	
	@Override
	public void login(String id, String pwd) throws SQLException,
												    IdNotFoundException,
												    InvalidPasswordException {
		
		EmployeeVO employee = employeeDAO.selectEmployeeById(id);
		
		if(employee==null) throw new IdNotFoundException();
		if(!pwd.equals(employee.getPwd())) throw new InvalidPasswordException();
		
	}
	@Override
	public void regist(EmployeeVO employee,List<CareerVO> careers) throws SQLException {
		employeeDAO.insertEmployee(employee);
		
		for(CareerVO career:careers) {
			careerDAO.insertCareer(career);
		}
		
		
	}
	@Override
	public Map<String,Object> getEmployee(String id) throws SQLException {
		
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		EmployeeVO employee = employeeDAO.selectEmployeeById(id);
		
		employee.setSsn(DataFormat.parseSSN(employee.getSsn()));
		employee.setPhone_c(employee.getPhone_c());
		employee.setPhone_p(employee.getPhone_p());
		
		List<CareerVO> careers = careerDAO.selectCareerList(id);
		
		dataMap.put("employee", employee);
		dataMap.put("careers", careers);
		
		return dataMap; 
	}	
	@Override
	public List<EmployeeVO> getEmployeeList() throws SQLException {
		
		return employeeDAO.selectEmployeeList();
	}
	@Override
	public void modify(EmployeeVO employee,List<CareerVO> careers) throws SQLException {		
		employeeDAO.updateEmployee(employee);	
		
		careerDAO.deleteAllCareers(employee.getId());
		
		if(careers !=null) {
			for(CareerVO career : careers) {
				careerDAO.insertCareer(career);
			}
		}
	}
	@Override
	public void remove(String id) throws SQLException {
		employeeDAO.deleteEmployee(id);
	}
	@Override
	public void disable(String id) throws SQLException {
		employeeDAO.disableEmployee(id);
		
	}
	@Override
	public Map<String, Object> getEmployeeList(SearchCriteria cri) throws SQLException {
		
		List<EmployeeVO> employeeList=employeeDAO.selectEmployeeList(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(employeeDAO.selectEmployeeListCount(cri));
		
		Map<String,Object> dataMap=new HashMap<String,Object>();
		dataMap.put("employeeList", employeeList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public int getdeptEmpCount(String eno) throws SQLException {
		int count = employeeDAO.selectDeptEmpCount(eno);
		return count;
	}

	@Override
	public void recentLoginTime(String id) throws SQLException {
		employeeDAO.updateRecentLoginTime(id);
		
	}
	
	
}




