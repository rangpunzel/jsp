package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIDException;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/commons/*")
public class CommonsActionController {
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService=memberService;
	}
	
	@RequestMapping("loginForm.do")
	public String loginForm()throws Exception{
		String url="commons/loginForm";
				
		return url;
	}
	
	@RequestMapping("login.do")
	public String login(HttpServletRequest request,String id, String pwd)throws Exception{
		String url="redirect:/member/list.do";
		
		try {
		memberService.login(id, pwd);
		HttpSession session = request.getSession();
		
		MemberVO loginUser=memberService.getMember(id);
		session.setAttribute("loginUser", loginUser);
		session.setMaxInactiveInterval(60*6);
		}catch(SQLException e) {
			e.printStackTrace();
			url="error/500_error";
			request.setAttribute("exception", e);
		}catch(NotFoundIDException | InvalidPasswordException e) {
			url="redirect:/commons/loginForm.do";
			request.setAttribute("msg", e.getMessage());
		}
		return url;
	}
	
	@RequestMapping("logout.do")
	public String logout()throws Exception{
		String url="redirect:/commons/loginForm.do";
		return url;
	}
}
