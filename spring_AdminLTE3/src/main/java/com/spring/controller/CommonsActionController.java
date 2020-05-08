package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	//@RequestMapping(value= {"/","commons/loginForm.do"})
	@RequestMapping("loginForm.do")
	public String loginForm()throws Exception{
		String url="commons/loginForm";
				
		return url;
	}
	
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String loginPost(HttpServletRequest request,String id, String pwd,HttpSession session)throws Exception{
		String url="redirect:/member/list.do";
		
		//로그인 실패시 추가한 attribute를 삭제.
		session.removeAttribute("msg");
		
		String message=null;
		try {
			memberService.login(id, pwd);
			
			MemberVO loginUser=memberService.getMember(id);
			if(loginUser.getEnabled()==0) {
				message="사용중지된 아이디로 이용이 제한됩니다.";
				url="redirect:/commons/loginForm.do";
			}else {
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(60*6);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			url="error/500_error";
			request.setAttribute("exception", e);
		}catch(NotFoundIDException | InvalidPasswordException e) {
			message="아이디가 존재하지않거나 비밀번호가 일치하지않습니다.";
			url="redirect:/commons/loginForm.do";
		}
		request.setAttribute("msg", message);
		request.setAttribute("id", id);
		return url;
	}
	
	@RequestMapping("logout.do")
	public String logout()throws Exception{
		String url="redirect:/commons/loginForm.do";
		return url;
	}
}
