<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String msg=request.getParameter("msg");
	
%>    
<script>
	alert("<%out.print(msg);%>");
</script>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<form action="login.html" method="post">
		아이디 : <input type="text" name="id" /><br/>
		패스워드 : <input type="password" name="pwd" /><br/>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>