<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<script>
	var message = "${employee.eno}:${employee.name} 님을\n";
	message+="정상적으로 등록하였습니다.\n";
	message+="임직원 명단으로 이동합니다.\n 아무키나 누르세요.";
	alert(message);
	window.opener.location.href="<%=request.getContextPath()%>/employee/list";
	window.close();
</script>