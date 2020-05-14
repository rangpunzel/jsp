<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach items="${subMenuList }" var="subMenu">

<li class="">
	<a data-mcode="${subMenu.MCode}" data-url="${subMenu.url }" href="javascript:reURL('${subMenu.MCode }')"
		onclick = "	   
	   	<c:if test="${empty subMenu.jsText}" >
	   		onSubMenu('${subMenu.MCode}');	
	   	</c:if>	   		
	   	<c:if test="${!empty subMenu.jsText}">
	   		${subMenu.jsText }
	   	</c:if>
	 ">		   						
		<i class="${subMenu.iconFile }" ></i>
		<span class="menu-text">${subMenu.codeName}</span>
	</a>
	<b class="arrow"></b>					
</li>	
</c:forEach>
			
