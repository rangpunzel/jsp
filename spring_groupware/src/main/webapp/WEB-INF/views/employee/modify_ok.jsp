<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<script>
	alert("${employee.name}님의 정보를 수정하였습니다.");
	self.location="detail?id=${employee.id}";
</script>