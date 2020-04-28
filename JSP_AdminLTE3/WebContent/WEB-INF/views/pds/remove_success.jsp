<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("글을 삭제합니다.");
	window.close();
	opener.parent.searchList_go(${pageMaker.cri.page},"<%=request.getContextPath()%>/pds/list.do");
</script>