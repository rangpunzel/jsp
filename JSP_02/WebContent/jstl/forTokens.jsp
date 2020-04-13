<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String source = "010-1234-5678";

	StringTokenizer stn = new StringTokenizer(source,"-");
	while(stn.hasMoreTokens()){
		out.println(stn.nextToken()+"<br/>");
	}
%>

<c:forTokens var="str" items="<%=source %>" delims="-" varStatus="status">
	${status.count } : ${str } <br/>
</c:forTokens>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>