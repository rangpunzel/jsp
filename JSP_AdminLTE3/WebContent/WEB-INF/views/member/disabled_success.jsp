<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
 alert("${param.id}님을 비활성화 하였습니다.");
 location.href="detail?id=${param.id}";
</script>