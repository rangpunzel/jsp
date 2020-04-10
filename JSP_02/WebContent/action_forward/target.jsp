<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	alert("target.jsp 페이지로 이동합니다.");
</script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>target.jsp 입니다.</h1>
	<h1>이름 : <%=URLDecoder.decode(request.getParameter("name"),"utf-8") %></h1>
	<h1>나이 : <%=request.getParameter("age") %></h1>
</body>
</html>