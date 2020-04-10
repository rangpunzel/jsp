package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/login.html")
public class LoginServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();*/
		
		//Dispatcher는 총괄
		request.getRequestDispatcher("/WEB-INF/views/loginForm.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		//MemberVo member = memberService.getMember(id);
		
		request.getRequestDispatcher("/WEB-INF/views/login_success.jsp").forward(request,response);
		
/*		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('로그인 성공입니다.');");
		out.println("location.href='https://www.naver.com';");
		out.println("</script>");
		
		System.out.println("doPost() execute!!");*/
		
	}

}
