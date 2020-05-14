<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
<title>임직원 조회</title>
<style type="text/css" id="fontFamilyStyleSheet">
body { 
	font-family: 'Malgun Gothic', sans-serif !important; 
}
.fileDrop{
	width:90%;
	height:100px;
	border:1px dotted gray;
	margin:auto;
}
select:disabled {
	background: lightgray;
  	border:1px solid gray; 
}
  	
div#picturePreView{
	height:140px;
	width:100%;
	margin:0 auto;
	margin-top : 15px;	  		
	border : 1px solid lightgray;  		
	background-image:url("<%=request.getContextPath()%>/employee/picture/${employee.id}");
	background-repeat:no-repeat;
	background-position:center;
	background-size:cover;
}

input:read-only, 
textarea:read-only{
  cursor: not-allowed;
}

</style>
</head>
<body >
	<!-- Page Path Begins -->
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li>
				<i class="ace-icon fa fa-comments-o home-icon bigger-150"></i>
					임직원관리
			</li>
			<li class="active">
					임직원조회
			</li>
		</ul>		
	</div>
	<!-- Page Path Ends -->
	
	<!-- Page Content Begins -->
	<div class="page-content" style="padding-bottoms:8px;min-width:420px;">
	
		<!-- 상단 우측버튼 -->
		<div class="row">
			<div class="wizard-actions">
				<button type="button" class="btn btn-sm btn-white btn-bold"  onclick="modify_go();">
					<i class="red ace-icon fa fa-pencil bigger-120"></i><b>수정</b>
				</button>	
								
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="javascript:docPrint('document');">
					<i class="grey ace-icon fa fa-print bigger-120"></i><b>인쇄</b>
				</button>
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="closeDoc();">
					<i class="grey ace-icon fa fa-times bigger-120"></i><b>닫기</b>
				</button>
			</div>
		</div>
		<!-- 상단 우측버튼 -->
		
	<!-- <body style="margin:1px;"> -->
	
		<form role="form" id="registForm" class="form-horizontal" action="regist" method="post" enctype="multipart/form-data">
			<div class="hr_line">&nbsp;</div><br/><br/>
			<div class="col-xs-12 text-center" style="background:gray;color:white;" >개인 인적 사항</div>	
			<br/><br/>
			<div class="wrapper">
				<div class="col-xs-4 col-sm-2 control-label bolder g_label form-group">
					<div  role="picture">
						<div id="picturePreView"></div>						 
					</div>
				</div>
				<div class="col-xs-8 col-sm-10" style="padding-left:0;padding-right:0;">
					<div class="form-group" style="padding-right:2px;">
						<label for="writer" class="col-xs-4 col-sm-2 control-label bolder g_label ">
						등록자</label>
						<div class="col-xs-8 col-sm-10 g_value">	
							<div class="checkbox" style="inline;">				
								<span class="label">사원번호 : ${register.eno } | 이름 : ${register.name }</span>				
							</div>										
						</div>		
					</div>
					<div class="form-group">
						<label for="phone_p" class="col-xs-4 col-sm-2 control-label bolder g_label ">아이디</label>
						<div class="col-xs-8 col-sm-4 g_value">				
							<span class="col-sm-12">${employee.id }</span>
						</div>		
						<label for="pwd" class="col-xs-4 col-sm-2 control-label bolder g_label ">패스워드</label>
						<div class="col-xs-8 col-sm-4 g_value">													
							<span class="col-sm-12">${employee.pwd }</span>														
						</div>
					</div>	
					<div class="form-group" >
						<label for="name" class="col-xs-4 col-sm-2 control-label bolder g_label ">이&nbsp;&nbsp;름</label>
						<div class="col-xs-8 col-sm-4 g_value">				
							<span class="col-sm-12">${employee.name }</span>			
						</div>		
						<label for="ssn" class="col-xs-4 col-sm-2 control-label bolder g_label ">주민번호</label>
						<div class="col-xs-8 col-sm-4 g_value">													
							<span class="col-sm-12">${employee.ssn}</span>																
						</div>
					</div>
					<div class="form-group" style="padding-right:0;">
						<label for="phone_p" class="col-xs-4 col-sm-2 control-label bolder g_label ">휴대전화</label>
						<div class="col-xs-8 col-sm-4 g_value">				
							<span class="col-sm-12">${ employee.phone_p}</span>			
						</div>		
						<label for="phone_c" class="col-xs-4 col-sm-2 control-label bolder g_label">집전화</label>
						<div class="col-xs-8 col-sm-4 g_value">													
							<span class="col-sm-12">${employee.phone_c }</span>
														
						</div>
					</div>	
					<div class="form-group" style="padding-right:1px;">
						<label for="email" class="col-xs-4 col-sm-2 control-label bolder g_label ">이메일</label>
						<div class="col-xs-8 col-sm-10 g_value">				
							<span class="col-sm-12">${employee.email }</span>							
						</div>				
					</div>			
				</div>
			</div>	
			<div class="wrapper row">		
				<div class="col-sm-12">
					<div class="form-group" style="padding-right:3px;">
						<label for="address" class="col-xs-4 col-sm-2 control-label bolder g_label" style="height:52px;line-height:40px;">							
							주&nbsp;&nbsp;&nbsp;소							
						</label>
						<div class="form-group col-xs-8 col-sm-10 g_value">
							<div class="col-sm-12 no-padding " style="margin-bottom:3px;">
								<span class="col-sm-12"><span class="label">우편번호</span> ${employee.postCode }</span>								
							</div>
							<div class="col-sm-12 no-padding" style="margin-bottom:3px;">
								<span class="col-sm-12">${employee.address1}&nbsp;${employee.address2}</span>								
							</div>
						</div>											
					</div>						
					<br/>
					<div class="col-xs-12 text-center" style="background:gray;color:white;" >회사 소속 사항</div>
					<br/><br/>
					<!-- 회사 내역 -->		
					<div class="form-group">				
						<label for="dept" class="col-xs-4 col-sm-2 control-label bolder g_label ">
							부&nbsp;&nbsp;&nbsp;서</label>
						<div class="col-xs-8 col-sm-4 g_value">			
							<span class="col-sm-12">${employee.deptName }</span>
						</div>
						<label for="position" class="col-xs-4 col-sm-2 control-label bolder g_label ">
							직&nbsp;&nbsp;&nbsp;위</label>
						<div class="col-xs-8 col-sm-2 g_value">			
							<span class="col-sm-12 ">${employee.position }</span>
						</div>		
						<label for="position" class="col-xs-4 col-sm-1 control-label bolder g_label ">
							상&nbsp;&nbsp;&nbsp;태</label>
						<div class="col-xs-8 col-sm-1 g_value">			
							<span class="col-sm-12 no-padding">${employee.enabled==1 ? '재직' : (employee.enabled==0 ? '퇴사' : '휴직') }</span>
						</div>
						
					</div>	
					<div class="form-group" >
						<label for="eno" class="col-xs-4 col-sm-2 control-label bolder g_label ">사원번호</label> 
						<div class="col-xs-8 col-sm-4 g_value">
							<span class="col-sm-12">${employee.eno}</span>
						</div>
						<label for="regDate" class="col-xs-4 col-sm-2 control-label bolder g_label ">입사날짜</label> 
						<div class="col-xs-8 col-sm-4 g_value">
							<span class="col-sm-12"><fmt:formatDate value="${employee.regDate }" pattern="yyyy.MM.dd"/></span>
						</div>
					</div>
					
					<div class="form-group">											
						<label class="col-xs-4 col-sm-2 control-label bolder g_label" for="careers">경력사항</label>						
						<div class="col-xs-8 col-sm-10 g_value row" id="careers">							
							<div class="col-sm-2" id="coName" style="padding:2px 1px;">
								<label class="label col-sm-12" >회사명</label>
								<c:forEach var="career" items="${careers }">
									<input class="col-sm-12" type="text" value="${career.coName }" />
								</c:forEach>													
							</div>
							<div class="col-sm-4" id="job" style="padding:2px 1px;" >
								<label class="label col-sm-12" >주요업무</label><br/>
								<c:forEach var="career" items="${careers }">
									<input class="col-sm-12" type="text" value="${career.job}" />
								</c:forEach>	
							</div>
							<div class="col-sm-1" id="dept" style="padding:2px 1px;" >
								<label class="label col-sm-12" >부서</label><br/>				
								<c:forEach var="career" items="${careers }">
									<input class="col-sm-12 text-center" type="text" value="${career.position }" />
								</c:forEach>					
							</div>  
							<div class="col-sm-1" id="position" style="padding:2px 1px;" >
								<label class="label col-sm-12">직위</label><br/>					
								<c:forEach var="career" items="${careers }">
									<input class="col-sm-12 text-center" type="text" value="${career.dept }" />
								</c:forEach>				
							</div> 
							<div class="col-sm-4" id="year" style="padding:2px 1px;" >
								<label class="label col-sm-12" >업무기간</label>				
								<c:forEach var="career" items="${careers }">
									<div class="no-padding" style="text-align:center;">
										<input class="col-xs-12" type="text" style="text-align:center;" 
										 value="<fmt:formatDate value="${career.startDay }" pattern="yyyy.MM.dd" /> ~ <fmt:formatDate value="${career.endDay }" pattern="yyyy.MM.dd" />" />
									</div>
								</c:forEach>					
							</div>													
						</div>
					</div>
						
					<div class="form-group uploadFile ">						
						<label class="col-xs-4 col-sm-2 control-label bolder g_label" for="attach">
							<i class="ace-icon fa fa-folder-open" style="font-size:16px;"></i>
							<span>첨부서류</span>							
						</label>
						<div class="col-sm-10 g_value" data-role="attach">
							<div class="col-sm-4" style="padding:2px 1px;">								
								<label for="licenseDoc" class="col-sm-12 label">주민등록등본</label>	
								<c:if test="${!empty employee.licenseDoc }">
									<button class="col-sm-12 btn btn-xs btn-info" type="button" onclick="self.location='receiveDoc?fileName=${employee.licenseDoc}&id=${employee.id }';">다운로드</button>
								</c:if>
								<c:if test="${empty employee.licenseDoc }">
									<button class="col-sm-12 btn btn-xs btn-danger" type="button" onclick="alert('등록된 문서가 없습니다.');">미등록</button>
								</c:if>
							</div>
							<div class="col-sm-4" style="padding:2px 1px;">								
								<label for="graduDoc" class="col-sm-12 label">졸업증명서</label>	
								<c:if test="${!empty employee.graduDoc }">
									<button class="col-sm-12 btn btn-xs btn-info" type="button" onclick="self.location='receiveDoc?fileName=${employee.graduDoc}&id=${employee.id }';">다운로드</button>
								</c:if>
								<c:if test="${empty employee.graduDoc }">
									<button class="col-sm-12 btn btn-xs btn-danger" type="button" onclick="alert('등록된 문서가 없습니다.');">미등록</button>
								</c:if>									
							</div>
							<div class="col-sm-4" style="padding:2px 1px;">								
								<label for="scoreDoc" class="col-sm-12  label">성적증명서</label>	
								<c:if test="${!empty employee.scoreDoc }">
									<button class="col-sm-12 btn btn-xs btn-info" type="button" onclick="self.location='receiveDoc?fileName=${employee.scoreDoc}&id=${employee.id }';">다운로드</button>
								</c:if>
								<c:if test="${empty employee.scoreDoc }">
									<button class="col-sm-12 btn btn-xs btn-danger" type="button" onclick="alert('등록된 문서가 없습니다.');">미등록</button>
								</c:if>
								
							</div>
										
						</div>
					</div>					
					<div class="form-group">
						<label for="title" class="col-xs-4 col-sm-2 control-label bolder g_label" style="height:103px;line-height:80px;">비&nbsp;&nbsp;&nbsp;고</label>
						<div class="col-xs-8 col-sm-10 g_value">
							<textArea id="remark" name="remark" onkeydown="CheckTextCount(this, 200);" style="width:103%;height:90px;"></textArea>
						</div>
						<br/>
					</div>  
					
				</div>					
			</div>	
		</form>
	</div>
<%-- <%@ include file="detail_js.jsp" %> --%>
</body>


