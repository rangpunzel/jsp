package com.groupware.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.groupware.dto.EmployeeVO;
import com.groupware.service.employee.EmployeeService;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler{
	
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		
		if(auth != null && auth.getDetails()!=null) {
			try {
				User user = (User)auth.getDetails();
				EmployeeVO loginUser = user.getMemberVO();
				
				employeeService.recentLoginTime(loginUser.getId());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		response.sendRedirect(request.getContextPath()+"/commons/login");
	}
}
