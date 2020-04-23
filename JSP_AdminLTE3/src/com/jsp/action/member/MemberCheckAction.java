package com.jsp.action.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;

public class MemberCheckAction implements Action {

	
	private MemberService memberService;// = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url =null;
		
		String id = request.getParameter("id");
		
		MemberVO mv=new MemberVO();
		
		try {
			mv = memberService.getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(mv==null) {
			System.out.println("중복된 사람이 없습니다.");
			PrintWriter out = response.getWriter();
			out.print(id);
		}else {
			System.out.println("중복된 사람이 있습니다.");
		}
		
		return url;
	}

}
