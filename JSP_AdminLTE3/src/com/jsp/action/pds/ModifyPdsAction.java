package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.PdsVO;
import com.jsp.request.PdsModifyRequest;
import com.jsp.service.PdsService;

public class ModifyPdsAction implements Action {
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "pds/modify_success";
		
		int pno=Integer.parseInt(request.getParameter("pno"));
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		PdsModifyRequest pdsReq=new PdsModifyRequest(pno, writer, title, content);
		PdsVO pds = pdsReq.toPdsVO();
		
		try {
			pdsService.modify(pds);
		} catch (SQLException e) {
			e.printStackTrace();
			url="pds/modify_fail";
		}
		request.setAttribute("pno", pno);
		return url;
	}

}
