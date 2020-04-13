<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
		<c:import var="naver" url="https://www.naver.com"></c:import>
		<c:import var="ddit" url="https://www.ddit.or.kr"></c:import>
	<div id="naver" style="width:400px;height:300px;overflow:hidden;">
		<c:if test="${param.index eq 'ddit' }">
			${ddit }
		</c:if>
		<c:if test="${param.index eq 'naver' }">
			${naver }
		</c:if>
	</div>
</body>
</html>