<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<ul>
		<li><a href="<%=request.getContextPath() %>/home/main">/home/main</a></li>
		<li><a href="<%=request.getContextPath() %>/admin/main">/admin/main</a></li>
		<li><a href="<%=request.getContextPath() %>/manager/main">/manager/main</a></li>
		<li><a href="<%=request.getContextPath() %>/member/main">/member/main</a></li>
	</ul>
	<a href="/security/spring_security_login">로그인</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="/security/j_spring_security_logout">로그아웃</a>
	
	
</body>
</html>




