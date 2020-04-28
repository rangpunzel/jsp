package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.request.PageMaker;
import com.jsp.service.PdsService;
import com.jsp.utils.CreatePageMaker;
import com.jsp.utils.MakeFileName;

public class ModifyPdsFormAction implements Action {
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "pds/modify";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		try {
			PdsVO pds = pdsService.getPds(pno);
			List<AttachVO> renamedAttachList=MakeFileName.parseFileNameFromAttaches(pds.getAttachList(), "\\$\\$");
			pds.setAttachList(renamedAttachList);
			
			PageMaker pageMaker = CreatePageMaker.make(request);
			
			request.setAttribute("pageMaker", pageMaker);
			
			request.setAttribute("pds", pds);
		} catch (Exception e) {			
			e.printStackTrace();
			url="error/500_error";
		}	
		
		return url;
	}

}
