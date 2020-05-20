<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>User Info.</title>
<style>
td {font-size:9pt;}
</style>
</head>
<body text="000000" bgcolor="ffffff" style="margin:1px;">
<!-- 전체 div 사이즈 353px 임 -->
<!-- 타이틀 바 사이즈 -->
<table width=100% cellspacing=0 cellpadding=0 border=0 style="border:1px solid #ADADAD;">
<tr height=26>
<td width=* background="<%=request.getContextPath() %>/resources/common/images/etc_infor_ti_bg.gif">
	<font color="#5a7f10" style="font-size:9pt"><b>&nbsp;&nbsp;${employee.name }</b></font>
</td>
<td width=20 align=center background="<%=request.getContextPath() %>/resources/common/images/etc_infor_ti_bg.gif">
<!-- <a href="#" onClick="parent.HideUserInfo()"><img src="<%=request.getContextPath()%>/resources/common/images/close.gif" border=0></A>  -->
</td>
</tr>
</table>
<table border="0" style="font-size:9pt; width:100%;" cellspacing=0 cellpadding=0>
	<tr>
		<td valign="middle" align=center width=110>
<!-- 		<img id='userphoto'  SRC="../userdata/photos/00000000000000" BORDER=0 width="100" height="120"  -->
<!-- 		onerror="this.src='<%=request.getContextPath()%>/resources/common/images/photo_user_default.gif';"> -->
		<img id='userphoto'  src="<%=request.getContextPath() %>/employee/picture/${employee.id}" BORDER=0 width="100" height="120" 
		onerror="this.src='<%=request.getContextPath() %>/resources/common/images/photo_user_default.gif';">
		</td>
		<td valign="center">
			<table id=Info width=99% border=0 cellpadding=0 cellspacing=0>
				<tr height=22>
					<td>&nbsp;<img src="<%=request.getContextPath()%>/resources/common/images/etc_infor_dot.gif" border=0>&nbsp;부서 : ${employee.deptName }</td>
				</tr>
				<tr><td background="<%=request.getContextPath()%>/resources/common/images/etc_infor_vline.gif" height=1></td></tr>
				<tr height=22>
					<td>&nbsp;<img src="<%=request.getContextPath()%>/resources/common/images/etc_infor_dot.gif" border=0>&nbsp;직급 : ${employee.position }</td>
				</tr>
				<tr><td background="<%=request.getContextPath()%>/resources/common/images/etc_infor_vline.gif" height=1></td></tr>
				<tr height=22>
					<td>&nbsp;<img src="<%=request.getContextPath()%>/resources/common/images/etc_infor_dot.gif" border=0>&nbsp;입사일 : ${employee.regDate }
						<fmt:formatDate value="${employee.regDate }" pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr><td background="<%=request.getContextPath()%>/resources/common/images/etc_infor_vline.gif" height=1></td></tr>
				<tr height=22>
					<td>&nbsp;<img src="<%=request.getContextPath()%>/resources/common/images/etc_infor_dot.gif" border=0>&nbsp;회사전화 : ${employee.phone_c }</td>
				</tr>
				
				<tr><td background="<%=request.getContextPath()%>/resources/common/images/etc_infor_vline.gif" height=1></td></tr>
				<tr height=22>
					<td>&nbsp;<img src="<%=request.getContextPath()%>/resources/common/images/etc_infor_dot.gif" border=0>&nbsp;휴대폰 : ${employee.phone_p }</td>
				</tr>
				<tr><td background="<%=request.getContextPath()%>/resources/common/images/etc_infor_vline.gif" height=1></td></tr>
				<tr height=22>

					<td>&nbsp;<img src="<%=request.getContextPath()%>/resources/common/images/etc_infor_dot.gif" border=0>&nbsp;이메일 : <a href="mailto:${employee.email }">${employee.email }</a></td>
				</tr>
			</table>
		</td>
	</tr>
	</table>
</body>
</html>




