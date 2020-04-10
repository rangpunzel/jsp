package com.jsp.kjs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.kjs.dto.MemberVO;
import com.jsp.kjs.service.MemberServiceImpl;
import com.jsp.kjs.utils.ViewResolver;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/list";
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		if(member==null) {
			url="redirect:/commons/login";
			ViewResolver.view(request, response, url);
			return;
		}
		
		try {
			List<MemberVO> memberList = MemberServiceImpl.getInstance().getMemberList();
			
			request.setAttribute("memberList", memberList);
		} catch (SQLException e) {
			e.printStackTrace();
			url="error/500_error";
			request.setAttribute("exception", e);
		}
		
		ViewResolver.view(request, response, url);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
