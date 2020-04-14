package com.jsp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*")
public class FilterTest implements Filter {
	
	public void destroy() {
		// 종료될떄 실행
		System.out.println("Filter : destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//
		HttpServletRequest httpReq = (HttpServletRequest)request;
		
		System.out.println("Filter : doFilter() :"+httpReq.getRequestURI());
		chain.doFilter(request, response); //포워드개념이랑 똑같음.. 다음 필터로 넘겨줌.
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 최초 요청이 들어올때 실행
		System.out.println("Filter : init()");
	}

}
