<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- Page Path Begins -->
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li>
				<i class="ace-icon fa fa-comments-o home-icon bigger-150"></i>
					게시판
			</li>
			<li class="active">
					편집
			</li>
		</ul>
		<%-- <%@ include file="/WEB-INF/views/commons/user_label .jsp" %>--%>
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
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="history.go(-1);">
					<i class="grey ace-icon fa fa-times bigger-120"></i><b>취소</b>
				</button>
			</div>
		</div>
		<!-- 상단 우측버튼 -->
		
<!-- <body style="margin:1px;"> -->
<!-- <div id="pageScroll" class="wrapper"> -->
<form role="form" id="modifyForm" class="form-horizontal" method="post">
	
	<input type="hidden" name="bno" value="${board.bno }" />
	
	<div class="hr_line">&nbsp;</div>
	<div class="form-group">
		<label for="writer" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required">
		작성자</label>
		<div class="col-xs-8 col-sm-4 g_value">			
			<input id="writer" name="writer" style="width:70%;" class="form-control required" 
				   type="text" value="${board.writer }" readonly
				   style="background:#aaa;"/>			
		</div>		
	</div>
	<div class="form-group">
		<label for="bbs.category" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
			분&nbsp;&nbsp;&nbsp;류</label>
		<div class="col-xs-8 col-sm-10 g_value">			
			<select name="category" disabled>
				<option value="" >---분류선택---</option>	
				<option value="notice" ${category eq 'notice' ? 'selected':''}>공지사항</option>				
				<option value="free" ${category eq 'free' ? 'selected':''}>자유게시판</option>
				<option value="pds" ${category eq 'pds' ? 'selected':''}>자료실</option>				
			</select>
		</div>
	</div>	
	<div class="form-group" style="display:none;">
		<label for="dms.hotFlag" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label"></label> 
			<div class="col-xs-8 col-sm-10 g_value"></div>
	</div>
	<div class="form-group" style="display:${category eq 'free' ? 'none':'block'};"><!-- 2018-01-18 게시기간 사용안함 -->
		<label for="dms.subject" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
			게시기간
		</label>
		<div class="col-xs-8 col-sm-10 g_value">
			<input id="openDate" name="bbs.openDate" style="color:#919191;" class="dateInput" readonly="readonly" type="text" value="2019-05-30"/>
				~
			<input id="closeDate" name="bbs.closeDate" class="dateInput" readonly="readonly" type="text" value="2019-06-30"/>
			<div class="checkbox" style="display:inline;">
				&nbsp;
				<label>
					<input type="checkbox" class="ace" id="never" name="never"><span class="lbl">&nbsp;영구게시</span>
				</label>
			</div>
		</div>
	</div>	
	<div class="form-group bbsId" style="display:${category eq 'free' ? 'none':'block'};" >
		<label for="dms.subject" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
		구&nbsp;&nbsp;&nbsp;분</label>
		<div class="col-xs-8 col-sm-10 g_value">
			<select id="bbs.bbsId" name="bbs.bbsId" disabled>				
				<option value="">사용안함</option>
			</select>
		</div>
	</div> 
	<div class="form-group preserveId"  style="display:${category eq 'free' ? 'none':'block'};">
		<label for="dms.subject" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required">
		보존년한
		</label>
		<div class="col-xs-8 col-sm-10 g_value">
			<select id="bbs.preservePeriod.preserveId" name="bbs.preservePeriod.preserveId" class="fld_100" disabled="disabled">
				<option value="1" selected="selected">사용안함</option>
				<option value="2">2 년</option>
				<option value="3">3 년</option>
				<option value="4">4 년</option>
				<option value="5">5 년</option>
				<option value="10">10 년</option>
				<option value="99">영구보존</option>
			</select>
		</div>
	</div>  

	<!-- 공유권한 -->
	<div class="form-group sharelist" style="display:${category eq 'free' ? 'none':'block'};">
		<label for="" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required">
			공유대상
		</label>
		<div class="col-xs-8 col-sm-10 g_value">
			<select id="sharelist" name="bbsShares" style="height:60px;width:70%;display:none;" class="fld_550" multiple="multiple" disabled="disabled">
				<option value="">사용안함</option>
			</select>
			<input type="hidden" name="_bbsShares" value="1"/>
		</div>
	</div>
	
	<div class="form-group">
		<label for="title" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required">
		제&nbsp;&nbsp;&nbsp;목</label>
		<div class="col-xs-8 col-sm-10 g_value">
			<input id="title" name="title" onkeydown="CheckTextCount(this, 100);" class="form-control required" required="required " type="text" value="${board.title }"/>
		</div>
	</div>  
	<div class="form-group">
		<label for="content" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required">
		내 용</label>
		<div class="col-xs-8 col-sm-10 g_value">
			<textarea rows="10" cols="" id="content" name="content" onkeydown="CheckTextCount(this, 1000);" class="form-control required" >${board.content }</textarea>			
		</div>
	</div>  

<input type="hidden" name="filepath" value="bbs" /> 
<input type="hidden" name="nanotime" value="2019053011524995" /> 
<input type="hidden" id="fileuploadstartconfirm" name="fileuploadstartconfirm" value="0" />


<div class="bline" ></div>
<div id="upload" class="upload" style="display:${category eq 'free' ? 'none':'block'};background-color:#f9f9f9; height:166px; max-height:166px; border:1px solid  #6fb3e0; border-radius:2px; ">
	<div class="row______________ fileupload-buttonbar">
<!-- 		<span class="btn btn-success fileinput-button"> -->
		<span class="fileinput-button btn btn-minier btn-inverse">
<!-- 				<i class="ace-icon fa fa-file-text-o"></i> -->
			<span><b>Add files...</b></span>
			<input type="file" name="files[]" data-url="/upload" multiple style="border-width: 0;">
		</span>
		<span style="float:left; margin:6px;">
		<i class="ace-icon fa fa-folder-open" style="font-size:16px;"></i>
		<i class="ace-icon fa fa-level-down" style="font-size:16px;"></i>
		<span style="">이곳에 파일을 끌어다 놓으십시오</span>
		</span>
		<button type="submit" class="btn btn-minierall btn-white start hide">
			<i class="icon-upload icon-white"></i>
			<span><b>Start</b></span>
		</button>
		<button type="button" class="btn btn-minier btn-white delete">
			<i class="red ace-icon fa fa-trash-o bigger-120"></i>
			<span><b>Delete</b></span>
		</button> 
		<button type="reset" class="btn btn-minier btn-white cancel" style="margin-left: 9px; margin-right: 4px;">
<!-- 			<i class="icon-ban-circle icon-white"></i> -->
			<i class="red ace-icon fa fa-ban bigger-120"></i>
			<span><b>Reset</b></span>
		</button>
		
		<div style="height:130px; max-height:130px; width:100%; overflow-y:auto;">
		<table id="fileresult" border="1" cellpadding="0" cellspacing="0" width="100%" role="presentation" class="table_________ table-striped___">
			<thead>
				<tr class="fade______________">
					<th width="25" class="row fileupload-buttonbar">
						<input type="checkbox" class="toggle">
						<input type="hidden" name="ufileno" value="0">
						<input type="hidden" name="ufilenm" value="0">
					</th>
					<th>Attach Files <span id="allSize"></span></th>
					<th width="90">Size</th>
					<th width="85">Button</th>
				</tr>
			</thead>
			<tbody class="files"></tbody> <!-- 파일이 추가되는 곳.  -->
		</table>
		</div>
	</div>
</div>

<div class="span5 fileupload-progress fade___" style="display:none;">
	<div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" style="margin-bottom:0px;">
		<div class="bar" style="width:0%;"></div>
	</div>
	<div class="progress-extended">&nbsp;</div>
</div>

<div class="fileupload-loading"></div>

<style>

/* .ui-button-text-icon-primary .ui-button-text, .ui-button-text-icons .ui-button-text { */
/*     padding: .2em .5em .2em 1.1em; */
/* } */
.ui-button-text-icon-primary .ui-button-text, .ui-button-text-icons .ui-button-text {
    padding: 0px 5px 2px;
}
table#fileresult > span.ui-buttojn-text { padding:0px; }

.upload td.name a, .upload td.name span, #dmstbl td.name span {

}
.fileupload-buttonbar .ui-button{margin-bottom:none;}
.fileupload-buttonbar .ui-button, .fileupload-buttonbar .toggle { margin: 1px;}
.upload td.name { font-weight: normal; }

.upload table td { height:25px; padding: 0px 5px; font-weight:normal; '}
.upload td.name { font-weight: normal; }

</style>
<!-- 	</td> -->
<!-- 	</tr> -->
<!-- 	</tbody> -->
<!-- </table> -->


</form>

</div>
<%@ include file="./modify_js.jsp" %>
<%@ include file="../summernote_js.jsp" %>

</body>


