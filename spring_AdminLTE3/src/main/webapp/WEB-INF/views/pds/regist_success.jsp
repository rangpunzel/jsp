<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("자료 등록이 정상적으로 완료되었습니다.");
	window.close();
	window.opener.location.href="list.do?page=1&perPageNum=10";
</script>