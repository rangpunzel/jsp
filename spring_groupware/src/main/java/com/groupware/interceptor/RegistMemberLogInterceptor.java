package com.groupware.interceptor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.groupware.dto.EmployeeVO;

public class RegistMemberLogInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(HttpServletRequest request, 
						   HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
		
		Map<String,Object> model = modelAndView.getModel();		
		EmployeeVO registMember = (EmployeeVO)model.get("registMember");
		
		if(registMember==null) return;
		
		HttpSession session = request.getSession();
		EmployeeVO loginUser=(EmployeeVO)session.getAttribute("loginUser");
		
		String logStr="[regist],"
				  +loginUser.getId()+","
			      +registMember.getEno()+","
			      +registMember.getId()+","
			      +registMember.getPhone_c()+","
			      +registMember.getPhone_p()+","
			      +registMember.getEmail()+","				      
			      +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		String savePath="d:\\log";
		if(!new File(savePath).exists()){
			new File(savePath).mkdirs();
		}
		
		String logFilePath=savePath+File.separator+"regist_employee_log.csv";
		
		BufferedWriter out=
				new BufferedWriter(new FileWriter(logFilePath,true));
		
		 out.write(logStr);
		 out.newLine();
		 out.close();
		
	}
}










