package com.jsp.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.service.MemberService;

public class LoginAction implements Action {
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService=memberService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="redirect:/board/list.do";
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		try {
			memberService.login(id, pwd);
			
			MemberVO loginUser=memberService.getMember(id);
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(60*10);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotFoundIDException |InvalidPasswordException e) {
			e.printStackTrace();
			url="/commons/loginForm";
		}
		
		return url;
	}

}
