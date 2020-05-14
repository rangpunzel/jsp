package com.groupware.service.employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.groupware.dao.employee.DepartmentDAO;
import com.groupware.dao.employee.EmployeeDAO;
import com.groupware.dto.DepartmentVO;
import com.groupware.dto.DynatreeAddress;
import com.groupware.dto.DynatreeAddressUser;
import com.groupware.dto.DynatreeVO;
import com.groupware.dto.EmployeeVO;

public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentDAO deptDAO;
	public void setDeptDAO(DepartmentDAO deptDAO) {
		this.deptDAO=deptDAO;
	}
	
	private EmployeeDAO employeeDAO;
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	public List<DepartmentVO> getDeptList() throws SQLException {
		List<DepartmentVO> deptList = deptDAO.selectDeptList();
		return deptList;
	}

	@Override
	public List<DynatreeVO> getDynaTree(String key) throws SQLException {
		
		List<DynatreeVO> dynaList = new ArrayList<DynatreeVO>();
				
		if(key.equals("00000000000000")) {			
			List<DepartmentVO> depts = deptDAO.selectDeptList();
			
			for(DepartmentVO dept : depts) {
				DynatreeVO dyna = new DynatreeVO();				
				dyna.setTitle(dept.getDept_name());
				dyna.setFolder(true);
				dyna.setLazy(true);
				dyna.setKey(dept.getDept_no());
				dyna.setType("department");
				
				DynatreeAddress address = new DynatreeAddress();				
				address.setType("D");
				address.setDpid(""+dept.getDept_no());
				address.setDpname(dept.getDept_name());
				address.setDporder(""+dept.getDept_order());
				
				dyna.setAddress(address);
				
				dynaList.add(dyna);
			}			
		}else {
			List<EmployeeVO> employees = employeeDAO.selectEmployeeListByDeptNo(key);
			for(EmployeeVO employee : employees) {
				DynatreeVO dyna = new DynatreeVO();				
				dyna.setTitle(employee.getName());
				dyna.setFolder(false);
				dyna.setLazy(false);
				dyna.setKey(employee.getId());
				dyna.setType("user");
				
				DynatreeAddressUser address = new DynatreeAddressUser();				
				address.setType("P");				
				//address.setUpname(employee.getDeptName());				
				address.setDporder(""+(20-Integer.parseInt(employee.getPosi_no())));
				
				address.setCellTel(employee.getPhone_c());
				address.setDpid(employee.getId());
				address.setDpname("대덕인재개발원");
				address.setDporder(""+(20-Integer.parseInt(employee.getPosi_no())));
				address.setEmailid(employee.getEmail());
				address.setSabun(employee.getEno());
				address.setTel(employee.getPhone_c());
				address.setTopdpname("대덕인재개발원");
				address.setUdname(employee.getPosition());
				address.setUpname(employee.getPosition());
				address.setUserid(employee.getId());
				address.setUsername(employee.getName());
				
				dyna.setAddress(address);
				
				dynaList.add(dyna);
			}
			
		}
		return dynaList;
	}
	
	

}
