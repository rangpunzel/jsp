package com.jsp.utils;

import javax.servlet.http.HttpServletRequest;

import com.jsp.request.PageMaker;
import com.jsp.request.SearchCriteria;

public class CreatePageMaker {
	//static : .class 로딩할때 올림
	public static PageMaker make(HttpServletRequest request)throws Exception{
		PageMaker pageMaker = new PageMaker();

		int page = Integer.parseInt(request.getParameter("page"));
		int perPageNum = Integer.parseInt(request.getParameter("perPageNum"));
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setKeyword(keyword);
		cri.setSearchType(searchType);
		
		pageMaker.setCri(cri);
		
		return pageMaker;
	}
}
