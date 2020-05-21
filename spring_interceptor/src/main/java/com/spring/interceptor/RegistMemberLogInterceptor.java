package com.spring.interceptor;

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

import com.spring.dto.MemberVO;

public class RegistMemberLogInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		Map<String,Object> model=modelAndView.getModel();
		MemberVO registMember=(MemberVO)model.get("registMember");
		
		if(registMember==null) return;
		
		HttpSession session = request.getSession();
		MemberVO loginUser=(MemberVO)session.getAttribute("loginUser");
		
		String logStr="[User:regist],"
				+loginUser.getId()+","
				+registMember.getId()+","
				+registMember.getPhone()+","
				+registMember.getEmail()+","
				+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		String savePath="d:\\log";
		if(!new File(savePath).exists()) {
			new File(savePath).mkdirs();
		}
		
		String logFilePath=savePath+File.separator+"regist_user_log.csv";
		
		BufferedWriter out= new BufferedWriter(new FileWriter(logFilePath,true));
		
		//로그를 기록
		out.write(logStr);
		out.newLine();
		
		out.close();
	}
	

}
