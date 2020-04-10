package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberVO;
import com.jsp.request.MemberModifyRequest;
import com.jsp.request.MemberRegistRequest;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.ViewResolver;

@WebServlet("/member/modify")
public class MemberModifyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/modify";
		
		String id = request.getParameter("id");
		
		MemberVO member=null;
		try {
			member = MemberServiceImpl.getInstance().getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
			url="error/500_error";
		}
		
		request.setAttribute("member", member);
		
		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String url="/member/modify_success";
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String picture=request.getParameter("picture");
		String[] phone=request.getParameter("phone").split("-");
		String name=request.getParameter("name");
		
		MemberModifyRequest memberReq = new MemberModifyRequest(id,pwd,email,phone,picture,name);
		
		MemberVO member = memberReq.toMemberVO();
		

		try {
			MemberServiceImpl.getInstance().modify(member);
		} catch (SQLException e) {
			e.printStackTrace();
			url="member/regist_fail";
		}
		
		request.setAttribute("member", member);
		
		ViewResolver.view(request, response, url);
		
	}

}
