<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("수정이 정상적으로 완료되었습니다.");
	location.href="detail.do${pageMaker.makeQuery()}&pno=${pds.pno}&from=modify";
	window.opener.location.reload(true);
</script>