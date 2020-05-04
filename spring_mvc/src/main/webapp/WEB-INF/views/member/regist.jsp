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
	<form action="regist" method="post">
		아이디 : <input name="id" type="text" /><br/>
		패스워드 : <input name="password" type="password" /><br/>
		이름 : <input name="name" type="text" /><br/>
		이메일 : <input name="email" type="email" /><br/>
		핸드폰 : <input name="phone" type="text" /><br/>
		<input type="submit" value="가입하기" />
	</form>
</body>
</html>