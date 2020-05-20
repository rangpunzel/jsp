package com.groupware.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.dto.EmployeeVO;
import com.groupware.dto.MenuVO;
import com.groupware.service.employee.EmployeeService;
import com.groupware.service.menu.MenuService;

@Controller
public class CommonController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/index.htm",method=RequestMethod.GET)
	public String mainGET(Model model,String mCode)throws Exception{
		model.addAttribute("mCode",mCode);
		return "main";
	}

	@RequestMapping("/commons/topMenuHql")
	@ResponseBody
	public ResponseEntity<Map<String, List<MenuVO>>> getMenu(HttpSession session)throws Exception{
		ResponseEntity<Map<String, List<MenuVO>>> result = null;
		
		Map<String, List<MenuVO>> menuMap = new HashMap<String, List<MenuVO>>();
		List<MenuVO> menuList = menuService.getTopMenuList();
		
		menuMap.put("subMenuCode", menuList);
		result = new ResponseEntity<Map<String, List<MenuVO>>>(menuMap, HttpStatus.OK);
		
		return result;
	}
	
	@RequestMapping("/commons/subMenuHql")
	public String getSubMenu(@RequestParam(defaultValue="MENU00") String mCode, Model model)throws Exception{
		String url="commons/subMenu";
		List<MenuVO> menuList = menuService.getSubMenuList(mCode);
		model.addAttribute("subMenuList",menuList);
		
		return url;
	}
	
	@RequestMapping("/commons/login")
	public void loginForm() {
	}
	
	@RequestMapping(value="/commons/userInfo",method=RequestMethod.GET)
	public String getUserInfo(String id, Model model) throws Exception{
		String url="commons/employee_info";
		
		Map<String,Object> dataMap = employeeService.getEmployee(id);
		
		EmployeeVO employee = (EmployeeVO)dataMap.get("employee");
		model.addAttribute("employee",employee);
		return url;
	}
	
	@RequestMapping("commons/loginTimeOut")
	public void loginTimeOut(HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('세션이 만료되었습니다.\\n다시 로그인 하세요!');");
		out.println("location.href='"+request.getContextPath()+"/commons/login';");
		out.println("</script>");
	}
	
	@RequestMapping("commons/loginExpired")
	public void loginExpired(HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('중복 로그인이 확인되었습니다. \\n다시 로그인하면 다른 장치에서 로그인은 취소됩니다.');");
		out.println("location.href='"+request.getContextPath()+"/commons/login';");
		out.println("</script>");
	}
}
