<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head>
<title>게시판&nbsp;새문서</title>
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

</style>
</head>

	<!-- Page Path Begins -->
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li>
				<i class="ace-icon fa fa-comments-o home-icon bigger-150"></i>
					커뮤니티
			</li>
			<li class="active">
					새문서
			</li>
		</ul>
		<%@ include file="/WEB-INF/views/commons/user_label.jsp" %>
	</div>
	<!-- Page Path Ends -->
	
	<!-- Page Content Begins -->
	<div class="page-content" style="padding-bottoms:8px;">
	
		<!-- 상단 우측버튼 -->
		<div class="row">
			<div class="wizard-actions">
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="goSubmit('post','');">
					<i class="red ace-icon fa fa-check bigger-120"></i><b>저장</b>
				</button>
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="javascript:closeDoc();">
					<i class="grey ace-icon fa fa-times bigger-120"></i><b>닫기</b>
				</button>
			</div>
		</div>
		<!-- 상단 우측버튼 -->
		
<!-- <body style="margin:1px;"> -->
<!-- <div id="pageScroll" class="wrapper"> -->
<form role="form" id="registForm" class="form-horizontal" action="/upload" method="post" enctype="multipart/form-data">

	<div class="hr_line">&nbsp;</div>
	<div class="form-group">
		<label for="writer" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required">
		작성자</label>
		<div class="col-xs-8 col-sm-4 g_value">			
			<input id="writer" name="writer" style="width:70%;" class="form-control required" 
				   type="text" value="${loginUser.id }" readonly
				   style="background:#aaa;"/>			
		</div>		
	</div>
	<div class="form-group" style="display:;">
		<label for="bbs.category" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
			분&nbsp;&nbsp;&nbsp;류</label>
		<div class="col-xs-8 col-sm-10 g_value">			
			<select name="category" onchange="fnChangeCategory();">
				<option value="" >---분류선택---</option>	
				<option value="notice" >공지사항</option>				
				<option value="free" >자유게시판</option>
				<option value="pds" >자료실</option>				
			</select>
		</div>
	</div>	
	<div class="form-group" style="display:none;">
		<label for="dms.hotFlag" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label"></label> 
			<div class="col-xs-8 col-sm-10 g_value"></div>
	</div>
	<div class="form-group openDate" style="display: none;"><!-- 2018-01-18 게시기간 사용안함 -->
		<label for="dms.subject" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
			게시기간
		</label>
		<div class="col-xs-8 col-sm-10 g_value">
			<input id="sDate" class="dateInput" name="startDate" readonly type="text" value='${startDate }'/>			
				~
			<input id="eDate" class="dateInput" name="endDate" readonly type="text" value="${endDate }"/>			
			<div class="checkbox" style="display:inline;">
				&nbsp;
				<label>
					<input type="checkbox" class="ace" id="never" name="never"><span class="lbl">&nbsp;영구게시</span>
				</label>
			</div>
		</div>
	</div>	
	<div class="form-group bbsId" style="display:none;">
		<label for="dms.subject" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
		구&nbsp;&nbsp;&nbsp;분</label>
		<div class="col-xs-8 col-sm-10 g_value">
			<select id="point" name="point" disabled>				
				<option value="">-선택-</option>
				
			</select>
		</div>
	</div> 

	<!-- 공유권한 -->
	<div class="form-group shareList" style="display:none;">
		<label for="" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required">
			공유대상
		</label>
		<div class="col-xs-8 col-sm-10 g_value">
			<select id="sharelist" name="bbsShares" style="height:60px;width:70%;display:none;" class="fld_550" multiple="multiple">				
			</select>
			<div id="sharelist_view" class="ui-corner-all w100p" style="color: rgb(0, 0, 0); font-size: inherit; font-family: inherit; display: inline-block; 
				border: 1px solid rgb(213, 213, 213); padding: 4px 0px 4px 4px; cursor: pointer; word-break: break-all; overflow-wrap: break-word;">
				<span style="white-space:nowrap;display:inline-block;">대덕인재개발원[+]</span>
			</div>
		</div>
	</div>
	
	<div class="form-group title" style="display:none;">
		<label for="title" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required">
		제&nbsp;&nbsp;&nbsp;목</label>
		<div class="col-xs-8 col-sm-10">
			<input id="title" name="title" onkeydown="CheckTextCount(this, 100);" class="form-control required" required="required " type="text" value=""/>
		</div>
	</div>  
	<div class="form-group content" style="display:none;">
		<textarea rows="10" cols="" id="content" name="content" onkeydown="CheckTextCount(this, 1000);" class="form-control required" ></textarea>			
	</div>  
	<br/>
	<div class="form-group uploadFile " style="display:none">
		<i class="ace-icon fa fa-folder-open" style="font-size:16px;"></i>
		<i class="ace-icon fa fa-level-down" style="font-size:16px;"></i>
		<span style="">이곳에 파일을 끌어다 놓으십시오</span>
		<div class="fileDrop col-xs-18">
			<ul class="mailbox-attachments clearfix uploadedList"></ul>
		</div>
	</div>		
</form>

</div>

<%-- <%@ include file="./regist_file.jsp" %>	 --%>

<%@ include file="./regist_js.jsp" %>

</body>


