package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.ViewResolver;

@WebServlet("/member/abled")
public class MemberAbledServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/abled_success";
		String id = request.getParameter("id");
		
		try {
			MemberServiceImpl.getInstance().abled(id);
		} catch (SQLException e) {
			e.printStackTrace();
			url="member/abled_fail";
		}
		
		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
