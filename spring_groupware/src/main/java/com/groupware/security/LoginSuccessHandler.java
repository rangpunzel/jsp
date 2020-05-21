package com.groupware.security;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		//로그인 로그 작성
		try {
			writeLoginLog(request,response,loginUser);
		} catch (Exception e) {
			writeLoginLog(loginUser.getId());
		}
		
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
	
	
	private void writeLoginLog(HttpServletRequest request, HttpServletResponse response, EmployeeVO loginUser)throws Exception{
		
		if(loginUser==null) return;
		
		
		//로그인 정보를 스트링으로 저장.
		String tag ="[login]";
		String log =tag+","
					+loginUser.getEno()+","
					+loginUser.getId()+","					
					+loginUser.getPhone_c()+","
					+loginUser.getPhone_p()+","
					+loginUser.getEmail()+","
					+request.getRemoteAddr()+","
					+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		//로그 파일 생성.
		String savePath="d:\\log";
		File file=new File(savePath);
		if(!file.exists()){
			file.mkdirs();
		}
		
		String logFilePath=savePath+File.separator+"login_employee_log.csv";		
		BufferedWriter out=
				new BufferedWriter(new FileWriter(logFilePath,true));
		
		//로그를 기록
		out.write(log);
		out.newLine();
		
		out.close();
	}
	
	private void writeLoginLog(String id){
		System.out.println("[LoginLog]"+id+" 생성 실패"+new Date());
	}
	
}
