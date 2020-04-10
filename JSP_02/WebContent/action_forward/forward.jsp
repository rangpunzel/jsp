<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!-- //target.jsp에 넣어야함 
	<script>
	alert("target.jsp 페이지로 이동합니다.");
</script> -->
<jsp:forward page="/action_forward/target.jsp">
	<jsp:param value='<%=URLEncoder.encode("홍길동","utf-8")%>' name="name"/>
	<jsp:param value="12" name="age"/>
</jsp:forward>