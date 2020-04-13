<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<script>
	 location.href="/commons/login";
	 alert("세션이 만료되었습니다.");
	 window.opener.location.reload(true);
	 window.close(); 

</script>

