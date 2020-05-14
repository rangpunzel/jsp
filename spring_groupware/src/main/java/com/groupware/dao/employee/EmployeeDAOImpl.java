package com.groupware.dao.employee;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.groupware.dto.EmployeeVO;
import com.groupware.request.SearchCriteria;

@Repository("employeeDAO") 
public class EmployeeDAOImpl implements EmployeeDAO{
	
	private SqlSession session;
	
	//@Autowired
	public void setSession(SqlSession session) {
		this.session=session;
	} 
	
	@Override
	public List<EmployeeVO> selectEmployeeList() throws SQLException {		
		List<EmployeeVO> employeeList=
				session.selectList("Employee-Mapper.selectEmployeeList",null);
		return employeeList;
	}

	@Override
	public List<EmployeeVO> selectEmployeeListByDeptNo(String dept_no) throws SQLException {
		List<EmployeeVO> employees=
				session.selectList("Employee-Mapper.selectEmployeeListByDeptNo",dept_no);			
		return employees;
	}
	
	@Override
	public EmployeeVO selectEmployeeById(String id) throws SQLException {
		EmployeeVO employee=
				session.selectOne("Employee-Mapper.selectEmployeeById",id);			
		return employee;
	}	
	
	@Override
	public void insertEmployee(EmployeeVO employee) throws SQLException {
		session.update("Employee-Mapper.insertEmployee",employee);
	}

	@Override
	public void updateEmployee(EmployeeVO employee) throws SQLException {
		session.update("Employee-Mapper.updateEmployee",employee);
	}

	@Override
	public void deleteEmployee(String id) throws SQLException {
		session.update("Employee-Mapper.deleteEmployee",id);
	}
	@Override
	public void disableEmployee(String id) throws SQLException {
		session.update("Employee-Mapper.disableEmployee",id);
		
	}
	@Override
	public List<EmployeeVO> selectEmployeeList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<EmployeeVO> employeeList = null;
		
		employeeList=session.selectList("Employee-Mapper.selectSearchEmployeeList",cri,rowBounds);
		return employeeList;
	}
	@Override
	public int selectEmployeeListCount(SearchCriteria cri) throws SQLException {
		
		List<EmployeeVO> employeeList = null;
		
		employeeList=session.selectList("Employee-Mapper.selectSearchEmployeeList",cri);
		
		return employeeList.size();
	}

	@Override
	public int selectDeptEmpCount(String eno) throws SQLException {
		int count = session.selectOne("Employee-Mapper.deptEmpCount",eno);
		return count;
	}

	@Override
	public void updateRecentLoginTime(String id) throws SQLException {
		session.update("Employee-Mapper.updateRecentLoginTime",id);		
	}

}
