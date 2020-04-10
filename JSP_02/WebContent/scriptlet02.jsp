<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
Scanner scan = new Scanner(System.in);
int i=Integer.parseInt(scan.nextLine());
for(;i<=9;i++){
%>
<%=	i%>단<br/>
<%
	for(int j=1;j<=9;j++){
%>
<%=i%> * <%=j%> = <%=i*j%><br/>
<%		
	}
%>
<br/>
<%
}
%>
</body>
</html>