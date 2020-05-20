package com.groupware.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.groupware.dto.EmployeeVO;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
/*		ApplicationContext ctx=new GenericXmlApplicationContext("classpath:com/groupware/context/root-context.xml");
		
		EmployeeService service = (EmployeeService) ctx.getBean("employeeService");
		
		String id=authentication.getName();
		
		try {
			EmployeeVO loginUser = (EmployeeVO)service.getEmployee(id).get("employee");
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
		}catch(SQLException e) {
			e.printStackTrace();
		}*/
		
		User user = (User)authentication.getDetails();
		EmployeeVO loginUser = user.getMemberVO();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("loginUser", loginUser);
		session.setMaxInactiveInterval(20*60); //second
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(!user.isAccountNonLocked()) {
			out.println("<script>");
			out.println("alert('휴직상태로 권한이 일반사용자로 제한됩니다.');");
			out.println("location.href='/"+request.getContextPath()+"';");
			out.println("</script>");
		}else {
			super.onAuthenticationSuccess(request, response, authentication);
		}
	}
	
}
