package com.groupware.controller.employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.CareerVO;
import com.groupware.dto.EmployeeVO;
import com.groupware.exception.IdNotFoundException;
import com.groupware.exception.InvalidPasswordException;
import com.groupware.request.RegistEmployeeRequest;
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
	
	@RequestMapping(value="regist",method=RequestMethod.POST,produces="text/plain;charset=utf-8")
	public String registPost(RegistEmployeeRequest empReq, Model model)throws Exception{
		String url="employee/regist_ok";
		
		EmployeeVO employee = empReq.toEmployeeVO();
		List<CareerVO> careers = new ArrayList<CareerVO>();
		
		if(careers !=null) {
			for(CareerVO career : empReq.getCareers()) {
				career.setId(employee.getId());
				careers.add(career);
			}
		}
		
		//첨부파일 저장 : picture, licenseDoc, graduDoc, scoreDoc
		MultipartFile[] files = {empReq.getPicture(), empReq.getLicenseDoc(), empReq.getGraduDoc(),empReq.getScoreDoc()};
		List<String> saveFileName = new ArrayList<String>();
		for(MultipartFile file : files) {
			if(file==null) continue;
			String fileName = UUID.randomUUID().toString().replace("-", "")+"$$"+file.getOriginalFilename();
			File savePath = new File(employeeAttachPath + File.separator+employee.getId());
			if(!savePath.exists()) {
				savePath.mkdirs();
			}
			
			file.transferTo(new File(savePath, fileName));
			saveFileName.add(fileName);
		}
		
		//EmployeeVO에 각 attach set.
		employee.setPicture(saveFileName.get(0));
		employee.setLicenseDoc(saveFileName.get(1));
		employee.setGraduDoc(saveFileName.get(2));
		employee.setScoreDoc(saveFileName.get(3));
		
		System.out.println(employee);
		System.out.println(careers);
		
		employeeService.regist(employee,careers);
		
		model.addAttribute("employee",employee);
		
		return url;
	}
	
	@RequestMapping("/detail")
	public String detail(String id, Model model) throws Exception {
		String url = "employee/detail";

		Map<String, Object> dataMap = employeeService.getEmployee(id);

		EmployeeVO employee = (EmployeeVO) dataMap.get("employee");
		EmployeeVO register = 
		(EmployeeVO) employeeService.getEmployee(employee.getRegister()).get("employee");

		dataMap.put("register", register);
		model.addAllAttributes(dataMap);

		return url;
	}
	
	@RequestMapping("/checkId")
	@ResponseBody
	public ResponseEntity<Map<String,Boolean>> checkId(String id,HttpServletResponse response)throws Exception{
		ResponseEntity<Map<String,Boolean>> entity=null;
		
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		
		try {
			employeeService.login(id, "");
		}catch(IdNotFoundException e) { //중복 아이디 없음
			result.put("result", true);
		}catch(InvalidPasswordException e) {//아이디가 존재
			result.put("result", false);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Map<String, Boolean>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
			entity = new ResponseEntity<Map<String, Boolean>>(result,HttpStatus.OK);
			return entity;
	}
	
	@RequestMapping("/deptEmpCount")
	@ResponseBody
	public ResponseEntity<Integer> deptEmpCount(@RequestParam("dept_no") String deptNum)throws Exception{
		ResponseEntity<Integer> entity=null;
		
		try {
			int count = employeeService.getdeptEmpCount(deptNum);
			entity = new ResponseEntity<Integer>(count+1,HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	@RequestMapping("receiveDoc")
	@ResponseBody
	public ResponseEntity<byte[]> recieveDoc(String fileName, String id)throws Exception{
		ResponseEntity<byte[]> entity=null;
		
		InputStream in = null;
		
		HttpHeaders headers = new HttpHeaders();
		
		String savePath=employeeAttachPath + File.pathSeparator+id;
		try {
			in = new FileInputStream(savePath + File.separator + fileName);
			
			fileName = fileName.substring(fileName.indexOf("$$")+2);
			
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment;filename=\""+new String(fileName.getBytes("utf-8"),"ISO-8859-1")+"\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
		}catch(IOException e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}finally {
			in.close();
		}
		
		return entity;
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String modifyGET(String id, Model model)throws Exception{
		String url="employee/modify";
		
		Map<String,Object> dataMap=employeeService.getEmployee(id);
		
		EmployeeVO employee = (EmployeeVO) dataMap.get("employee");
		EmployeeVO register = (EmployeeVO) employeeService.getEmployee(employee.getRegister()).get("employee");
		
		dataMap.put("register", register);
		
		model.addAttribute("positionList",positionService.getPosotionList());
		model.addAttribute("deptList",deptService.getDeptList());
		
		model.addAllAttributes(dataMap);
		
		return url;
		
	}

}
