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

<table border=1>
	<tr>
		<th>메소드</th>
		<th>값</th>
	</tr>
	<tr>
		<td>getContextPath()</td>
		<td><%=request.getContextPath() %></td>
	</tr>
	<tr>
		<td>getMethod()</td>
		<td><%=request.getMethod() %></td>
	</tr>
	<tr>
		<td>getSession()</td>
		<td><%=request.getSession() %></td>
	</tr>
	<tr>
		<td>getProtocol()</td>
		<td><%=request.getProtocol() %></td>
	</tr>
	<tr>
		<td>getRequestURL()</td>
		<td><%=request.getRequestURL() %></td>
	</tr>
	<tr>
		<td>getRequestURI()</td>
		<td><%=request.getRequestURI() %></td>
	</tr>
	<tr>
		<td>getQueryString()</td>
		<td><%=request.getQueryString() %></td>
	</tr>
	<tr>
		<td>getRemoteHost()</td>
		<td><%=request.getRemoteHost() %></td>
	</tr>
	<tr>
		<td>getRemoteHost()</td>
		<td><% System.out.print(request.getRemoteHost()); %></td>
	</tr>
</table>
</body>
</html>