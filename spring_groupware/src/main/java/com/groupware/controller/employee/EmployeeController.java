package com.groupware.controller.employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.groupware.request.ModifyEmployeeRequest;
import com.groupware.request.RegistEmployeeRequest;
import com.groupware.request.SearchCriteria;
import com.groupware.security.CustomAuthentication;
import com.groupware.security.User;
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
	
	
	@Resource(name = "employeeAttachPath")
	private String employeeAttachPath;
		
	@RequestMapping("list") // @GetMapping("list") : spring 4.3
	public ModelAndView list(SearchCriteria cri, ModelAndView mnv) throws Exception {
		String url = "employee/employee_list";

		mnv.addAllObjects(employeeService.getEmployeeList(cri));
		mnv.setViewName(url);

		return mnv;
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registGet(Model model) throws Exception {
		String url = "employee/regist";

		model.addAttribute("positionList", positionService.getPosotionList());
		model.addAttribute("deptList", deptService.getDeptList());

		return url;
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPost(RegistEmployeeRequest empReq, Model model)
														throws Exception {
		String url = "employee/regist_ok";						
		
		EmployeeVO employee = empReq.toEmployeeVO();
		List<CareerVO> careers = new ArrayList<CareerVO>();
		
		if(careers!=null) {
			for (CareerVO career : empReq.getCareers()) {
				career.setId(employee.getId());
				careers.add(career);
			}
		}
		
		// 첨부파일 저장 : picture, licenseDoc, graduDoc, scoreDoc
		MultipartFile[] files = { empReq.getPicture(), empReq.getLicenseDoc(), 
								  empReq.getGraduDoc(),empReq.getScoreDoc() };
		List<String> saveFileName = new ArrayList<String>();		
		for (MultipartFile file : files) {
			if (file==null) continue;
			String fileName = UUID.randomUUID().toString().replace("-", "") + "$$" 
							  + file.getOriginalFilename();
			File savePath = new File(employeeAttachPath + File.separator + employee.getId());
			if (!savePath.exists()) {
				savePath.mkdirs();
			}

			file.transferTo(new File(savePath, fileName));
			saveFileName.add(fileName);
		}
		

		// EmployeeVO 에 각 attach set.
		employee.setPicture(saveFileName.get(0));
		employee.setLicenseDoc(saveFileName.get(1));
		employee.setGraduDoc(saveFileName.get(2));
		employee.setScoreDoc(saveFileName.get(3));
		
		System.out.println(employee);
		System.out.println(careers);

		employeeService.regist(employee, careers);

		model.addAttribute("employee", employee);
		
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
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String modifyGET(String id,Model model)throws Exception{
		String url="employee/modify";
		
		Map<String, Object> dataMap = employeeService.getEmployee(id);

		EmployeeVO employee = (EmployeeVO) dataMap.get("employee");
		EmployeeVO register 
		= (EmployeeVO) employeeService.getEmployee(employee.getRegister()).get("employee");

		dataMap.put("register", register);
		
		model.addAttribute("positionList", positionService.getPosotionList());
		model.addAttribute("deptList", deptService.getDeptList());
		
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	
	@RequestMapping("/checkId")
	@ResponseBody
	public ResponseEntity<Map<String, Boolean>> checkId(String id, 
									HttpServletResponse response) throws Exception {
		ResponseEntity<Map<String, Boolean>> entity = null;
		
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		
		try {
			employeeService.login(id, "");
		}catch(IdNotFoundException e) { //아이디가 없음.
			result.put("result", true);
		}catch(InvalidPasswordException e) { //아이디가 존재
			result.put("result", false);			
		}catch(Exception e) {
			e.printStackTrace();
			return  new ResponseEntity<Map<String, Boolean>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		entity = new ResponseEntity<Map<String, Boolean>>(result, HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping("/deptEmpCount")
	@ResponseBody
	public ResponseEntity<Integer> deptEmpCount(@RequestParam("dept_no") String deptNum)
																		throws Exception {
		
		ResponseEntity<Integer> entity=null;
		int count = employeeService.getdeptEmpCount(deptNum);
		
		entity=new ResponseEntity<Integer>(count,HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping("/receiveDoc")
	@ResponseBody
	public ResponseEntity<byte[]> recieveDoc(String fileName, String id) 
															throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		HttpHeaders headers = new HttpHeaders();

		String savePath = employeeAttachPath + File.separator + id;
		try {
			in = new FileInputStream(savePath + File.separator + fileName);

			fileName = fileName.substring(fileName.indexOf("$$") + 2);

			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition",
					"attachment;filename=\"" 
				    + new String(fileName.getBytes("utf-8"), "ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers,
																HttpStatus.CREATED);
		} catch (IOException e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			in.close();
		}
		return entity;
	}
	
	@Autowired
	private CustomAuthentication authProvider;
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPOST(ModifyEmployeeRequest modifyReq,HttpSession session,
							 Model model,Authentication auth)throws Exception{
		String url="employee/modify_ok";
		

		EmployeeVO employee = modifyReq.toEmployeeVO();
		List<CareerVO> careers = modifyReq.getCareerList();
				

		// 첨부파일 저장 : picture, licenseDoc, graduDoc, scoreDoc
		employee.setPicture(saveFile(modifyReq.getPicture(),modifyReq.getOld_picture()
										,modifyReq.getId()));
		employee.setLicenseDoc(saveFile(modifyReq.getLicenseDoc(),modifyReq.getOld_licenseDoc()
										,modifyReq.getId()));
		employee.setGraduDoc(saveFile(modifyReq.getGraduDoc(),modifyReq.getOld_graduDoc()
										,modifyReq.getId()));
		employee.setScoreDoc(saveFile(modifyReq.getScoreDoc(),modifyReq.getOld_scoreDoc()
										,modifyReq.getId()));

		employeeService.modify(employee, careers);
		
		EmployeeVO loginUser = (EmployeeVO)session.getAttribute("loginUser");
		
		
/*		if(loginUser!=null && loginUser.getId().equals(employee.getId())) {
			loginUser = (EmployeeVO)employeeService.getEmployee(employee.getId())
					.get("employee");			
			session.setAttribute("loginUser", loginUser);
		}*/
		
		/* 로그인 한 사용자의 권한을 동적으로 업데이트해야 할 경우(물론 변경 된 경우) 
		       로그 아웃하고 로그인 할 필요없이 Spring securityContextHolder의 Authentication 객체 (보안 토큰)를 재설정하면됩니다.*/
		
		if(auth.getName().equals(employee.getId())) {
			//변경된 로그인 사용자 정보를 가져온다.
			EmployeeVO updateEmployee = (EmployeeVO)employeeService.getEmployee(auth.getName()).get("employee");
			
			//권한을 갱신한다.
			List<GrantedAuthority> updatedAuthorities = new ArrayList<GrantedAuthority>();
			updatedAuthorities.add(new SimpleGrantedAuthority(updateEmployee.getAuthority()));
			
			//새로운 Authentication을 생성.
			UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(),auth.getCredentials(),updatedAuthorities);
			
			//SecurityContextHolder으로 새로 생성한 authentication을 setting
			SecurityContextHolder.getContext().setAuthentication(newAuth);
			
			//security의 userDetail을 갱신하기위한 User 생성.
			User user = new User(updateEmployee);
			
			//authentication detail과 session attribute를 교체한다.
			newAuth.setDetails(user);
			session.setAttribute("loginUser", updateEmployee);
			
		}
		model.addAttribute("employee", employee);
		
		return url;				
	}
	
	private String saveFile(MultipartFile file,String old_fileName,String id) 
																throws Exception{
		if (file==null || file.isEmpty()) { 
			if(old_fileName==null || old_fileName.isEmpty()) {
				File oldFile = new File(employeeAttachPath + File.separator 
							+ id,old_fileName);
				if(oldFile.exists()) oldFile.delete();
				return "";
			}
			return old_fileName;
		}		
			
		//기존 파일 삭제
		File oldFile = new File(employeeAttachPath + File.separator + id,old_fileName);
		if(oldFile.exists()) oldFile.delete();
		
		//신규 파일 저장
		String fileName = UUID.randomUUID().toString().replace("-", "") + "$$" 
									+ file.getOriginalFilename();
		File savePath = new File(employeeAttachPath + File.separator + id);
		
		if (!savePath.exists()) {
			savePath.mkdirs();
		}

		file.transferTo(new File(savePath, fileName));
		
		return fileName;
	}
	
	@RequestMapping("/picture/{id}")
	@ResponseBody
	public ResponseEntity<byte[]> sendPicture(@PathVariable("id") String id,
											  HttpServletResponse response)
													  		throws Exception {

		ResponseEntity<byte[]> entity = null;

		EmployeeVO emp = (EmployeeVO) employeeService.getEmployee(id).get("employee");

		String fileName = emp.getPicture();
		String savePath = employeeAttachPath + File.separator + emp.getId();

		FileInputStream in = null;

		try {
			in = new FileInputStream(savePath + File.separator + fileName);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
		} catch (IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		} finally {
			if(in!=null)in.close();
		}

		return entity;
	}

}









