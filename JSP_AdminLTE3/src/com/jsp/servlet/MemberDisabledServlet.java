package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.ViewResolver;

@WebServlet("/member/disabled")
public class MemberDisabledServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/disabled_success";

		String id = request.getParameter("id");

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (id.equals(loginUser.getId())) { // 로그인 사용자일 경우 불허함.
			url = "member/disabled_denied";
		} else { //로그인 사용자가 아닐경우 실행.
			try {
				MemberServiceImpl.getInstance().disabled(id);
			} catch (SQLException e) {
				e.printStackTrace();
				url = "member/disabled_fail";
			}
		}

		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
