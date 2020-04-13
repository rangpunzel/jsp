<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	int score=85;
	String scoreLevel="F";
	if(score>90){
		scoreLevel="A";
	}else if(score>80){
		scoreLevel="B";
	}else if(score>70){
		scoreLevel="C";
	}else{
		scoreLevel="F";
	}
	
	out.println(scoreLevel);
%>
<c:set var="score" value="85" />
<c:set var="scoreLevel" value="" />
<c:choose>
	<c:when test="${score>90 }">
		<c:set var="scoreLevel" value="A" />
	</c:when>
	<c:when test="${score>80 }">
		<c:set var="scoreLevel" value="B" />
	</c:when>
	<c:when test="${score>70 }">
		<c:set var="scoreLevel" value="C" />
	</c:when>
	<c:otherwise>
		<c:set var="scoreLevel" value="F" />
	</c:otherwise>
</c:choose>

<c:out value="scoreLevel" />