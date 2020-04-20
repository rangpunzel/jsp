package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dispatcher.ViewResolver;
import com.jsp.dto.MemberVO;
import com.jsp.request.MemberRegistRequest;
import com.jsp.service.MemberServiceImpl;

//@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/regist";
		
		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//회원등록창이 닫히므로 리다이렉트나 포워드는 필요없다. 스크립트로 자료 넘겨주기!
		String url="member/regist_success";
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String picture=request.getParameter("picture");
		String[] phone=request.getParameterValues("phone");
		String authority=request.getParameter("authority");
		String name=request.getParameter("name");
		
		MemberRegistRequest memberReq = new MemberRegistRequest(id,pwd,authority,email,phone,picture,name);
		
		MemberVO member = memberReq.toMemberVO();
		
		try {
			MemberServiceImpl.getInstance().regist(member);
		} catch (SQLException e) {
			e.printStackTrace();
			url="member/regist_fail";
		}
		
		ViewResolver.view(request, response, url);
	}

}
