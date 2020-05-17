package com.groupware.controller.employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.EmployeeVO;
import com.groupware.request.SearchCriteria;
import com.groupware.service.employee.DepartmentService;
import com.groupware.service.employee.EmployeeService;
import com.groupware.service.employee.PositionService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService deptService;
	
	@Autowired
	private PositionService positionService;
	
	@Resource(name="employeeAttachPath")
	private String employeeAttachPath;
	
	@Resource(name="picture")
	private String picturePath;
	
	@RequestMapping("list") //@GetMapping("list") : spring 4.3
	public ModelAndView list(SearchCriteria cri, ModelAndView mnv) throws Exception{
		String url="employee/employee_list";
		
		mnv.addAllObjects(employeeService.getEmployeeList(cri));
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public String registGet(Model model)throws Exception{
		String url="employee/regist";
		
		model.addAttribute("positionList",positionService.getPosotionList());
		model.addAttribute("deptList",deptService.getDeptList());
		
		return url;
	}
	
	@RequestMapping("detail")
	public String detail(String id, Model model)throws Exception{
		String url="employee/detail";
		
		Map<String, Object> dataMap=employeeService.getEmployee(id);
		
		EmployeeVO employee = (EmployeeVO) dataMap.get("employee");
		EmployeeVO register = (EmployeeVO) employeeService.getEmployee(employee.getRegister()).get("employee");
		
		dataMap.put("register", register);
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	@RequestMapping("/regist/checkId")
	@ResponseBody
	public ResponseEntity<String> checkId(String id)throws Exception{
		ResponseEntity<String> entity=null;
		try {
			Map<String, Object> dataMap= employeeService.getEmployee(id);
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(NullPointerException e) {
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}
		return entity;
	}
	
	@RequestMapping("/regist/getDeptCount")
	@ResponseBody
	public ResponseEntity<Integer> getDeptCount(String dept)throws Exception{
		ResponseEntity<Integer> entity=null;
		
		try {
			int cnt = employeeService.getdeptEmpCount(dept);
			entity = new ResponseEntity<Integer>(cnt+1,HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	@RequestMapping(value="regist",method=RequestMethod.POST,produces="text/plain;charset=utf-8")
	public void regist(EmployeeVO employee, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		System.out.println(employee);
		
	}

}
