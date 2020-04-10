<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	out.println("<h1> header.jsp : "+request.getParameter("msg")+"</h1>");
%>
<hr/>