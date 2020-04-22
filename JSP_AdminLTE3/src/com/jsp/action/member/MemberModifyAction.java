package com.jsp.action.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.MemberVO;
import com.jsp.request.MemberModifyRequest;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

public class MemberModifyAction implements Action {
	private MemberService memberService;// = MemberServiceImpl.getInstance();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			memberService.modify(member);
			HttpSession session = request.getSession();
			MemberVO loginUser=(MemberVO)session.getAttribute("loginUser");
			if(member.getId().equals(loginUser.getId())) {
				session.setAttribute("loginUser", member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			url="member/modify_fail";
		}
		
		request.setAttribute("member", member);
		
		return url;
	}

}
