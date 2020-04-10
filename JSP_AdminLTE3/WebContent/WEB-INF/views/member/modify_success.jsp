<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("${member.id}님 수정이 정상적으로 완료되었습니다.");
	location.href="detail?id=${member.id}";
	window.opener.location.reload(true);
</script>