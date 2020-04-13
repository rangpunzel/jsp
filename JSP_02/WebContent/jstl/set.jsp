<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	pageContext.setAttribute("id", "mimi");
%>

<c:set var="id" value="<%="mimi" %>" scope="page" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>스크립트릿 : <%=pageContext.getAttribute("id") %></h1>
	<h1> EL : ${id }</h1>
</body>
</html>

<%
	pageContext.removeAttribute("id");
%>
<c:remove var="id" scope="page"/>