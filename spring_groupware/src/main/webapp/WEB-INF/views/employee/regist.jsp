<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
<title>임직원 등록</title>
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
	margin:3px auto;	  		
	border : 1px solid lightgray;  		
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
					임직원등록
			</li>
		</ul>		
	</div>
	<!-- Page Path Ends -->
	
	<!-- Page Content Begins -->
	<div class="page-content" style="padding-bottoms:8px;min-width:400px;">
	
		<!-- 상단 우측버튼 -->
		<div class="row">
			<div class="wizard-actions">
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="goSubmit('post');">
					<i class="red ace-icon fa fa-check bigger-120"></i><b>등록</b>
				</button>
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="javascript:goSubmit('close');">
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
						<label for="picture"  class="btn btn-xs btn-info" style="width:110px;margin-bottom:2px;">사진등록</label>
						<input type="file" id="picture" name="picture" style="display:none;"/> 
					</div>
				</div>
				<div class="col-xs-8 col-sm-10" style="padding-left:0;">
					<div class="form-group">
						<label for="writer" class="col-xs-4 col-sm-2 control-label bolder g_label required">
						등록자</label>
						<div class="col-xs-8 col-sm-10 g_value">	
							<div class="checkbox" style="inline;">				
								<span class="label">사원번호 : ${loginUser.eno } | 이름 : ${loginUser.name }</span>				
							</div>
							<input id="regist" name="register" type="hidden" value="${loginUser.id }" />			
						</div>		
					</div>
					<div class="form-group">
						<label for="phone_p" class="col-xs-4 col-sm-2 control-label bolder g_label required">아이디</label>
						<div class="col-xs-8 col-sm-4 g_value">				
							<input class="col-sm-7" id="id" name="id" type="text" maxlength="20" 
									 onkeyup="this.value=this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣  ~!@#$%^&*()_+|<>?:{}\- ]/g, '');" 
									 placeholder="중복확인  필수" value="" />
							<input type="hidden" name="checkID" value="" />
							<button type="button" class="col-sm-4 btn btn-xs btn-info" style="margin-left:2px;" onclick="CheckID();">중복확인</button>			
						</div>		
						<label for="pwd" class="col-xs-4 col-sm-2 control-label bolder g_label required">패스워드</label>
						<div class="col-xs-8 col-sm-4 g_value">													
								<input class="col-sm-12" id="pwd" name="pwd" type="password" maxlength="20"							    
									   placeholder="암호를 입력하시오" value=""/>
														
						</div>
					</div>	
					<div class="form-group">
						<label for="name" class="col-xs-4 col-sm-2 control-label bolder g_label required">이&nbsp;&nbsp;름</label>
						<div class="col-xs-8 col-sm-4 g_value">				
							<input class="col-sm-12" id="name" name="name" type="text" value="" />			
						</div>		
						<label for="ssn1" class="col-xs-4 col-sm-2 control-label bolder g_label required">주민번호</label>
						<div class="col-xs-8 col-sm-4 g_value">													
								<input class="col-xs-5" id="ssn1" name="ssn" type="text" placeholder="앞 6자리" maxlength="6"
								       onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z]/g, '');"/>
								<span class="col-xs-2">-</span>
								<input class="col-xs-5" id="ssn2" name="ssn" type="text" placeholder="뒤 7자리" maxlength="7"
									   onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z]/g, '');"/>								
						</div>
					</div>
					<div class="form-group">
						<label for="phone_p" class="col-xs-4 col-sm-2 control-label bolder g_label required">휴대전화</label>
						<div class="col-xs-8 col-sm-4 g_value">				
							<input class="col-sm-12" id="phone_p" name="phone_p" type="text" maxlength="11" 
									 onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z ~!@#$%^&*()_+|<>?:{}\- ]/g, '');" 
									 placeholder="' - ' 없이 입력하시오" value="" />			
						</div>		
						<label for="phone_c" class="col-xs-4 col-sm-2 control-label bolder g_label">집전화</label>
						<div class="col-xs-8 col-sm-4 g_value">													
								<input class="col-sm-12" id="phone_c" name="phone_c" type="text" maxlength="9"  
									   onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z ~!#$%^&*()_+|<>?:{}\- ]/g, '');" 
									   placeholder="' - ' 없이 입력하시오" value=""/>
														
						</div>
					</div>	
					<div class="form-group">
						<label for="email" class="col-xs-4 col-sm-2 control-label bolder g_label required">이메일</label>
						<div class="col-xs-8 col-sm-10 g_value">				
							<input class="col-sm-4" id="email" name="email" type="text"  
									 onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣  ~!#$@%^&*()_+|<>?:{}\- ]/g, '');" 
									 placeholder="아이디를 입력하시오" value="" />&nbsp;&nbsp;@&nbsp;&nbsp;
							<select name="email" >
								<option value="">-- 계정선택 --</option>
								<option value="gmail.com">gamil.com</option>
								<option value="naver.com">naver.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="daum.net">daum.net</option>		
								<option value="yahoo.com">yahoo.com</option>				
								
							</select>		
							&nbsp;&nbsp;<input type="checkbox" id="directInput" ><label for="directInput">직접입력</label>
						</div>				
					</div>			
				</div>
			</div>	
			<div class="wrapper row">		
				<div class="col-sm-12">
					<div class="form-group" >
						<label for="address" class="col-xs-4 col-sm-2 control-label bolder g_label" style="height:102px;line-height:92px;">							
							주&nbsp;&nbsp;&nbsp;소							
						</label>
						<div class="form-group col-xs-8 col-sm-10 g_value">
							<div class="col-sm-12 no-padding " style="margin-bottom:3px;">
								<input id="postCode" class="text-center" name="postCode" type="text" readonly placeholder="우편번호" />
								<input type="button" class="btn btn-xs btn-info" id="searchAddr" onclick="SearchAddress();" value="주소검색" /><br/>
							</div>
							<div class="col-sm-12 no-padding" style="margin-bottom:3px;">
								<input id="address[0]" type="text" name="address1" readonly onclick="$('#searchAddr').click();" style="width:100%;"/>								
							</div>
							<div class="col-sm-12 no-padding" style="margin-bottom:3px;">
								<div class="col-sm-2 no-padding" style="line-height:16px;">								
									<label class="label" style="width:100%;margin-top:5px;">나머지주소</label>
								</div>																					
								<div class="col-sm-7 no-padding" >
									&nbsp;<input id="address[1]" type="text" name="address2" style="width:95%;"/>
								</div>
							</div>
							
						</div>											
					</div>						
					<br/>
					<div class="col-xs-12 text-center" style="background:gray;color:white;" >회사 소속 사항</div>
					<br/><br/>
					<!-- 회사 내역 -->		
					<div class="form-group">				
						<label for="dept" class="col-xs-4 col-sm-2 control-label bolder g_label required">
							부&nbsp;&nbsp;&nbsp;서</label>
						<div class="col-xs-8 col-sm-4 g_value">			
							<select name="dept_no" style="width:100%;center;text-align-last: center;" required >
								<option value=""  > --- 선 택 --- </option>
								<c:forEach var="dept" items="${deptList }">	
								<option value="${dept.dept_no }" >${dept.dept_name }</option>
								</c:forEach>				
							</select>
						</div>
						<label for="position" class="col-xs-4 col-sm-2 control-label bolder g_label required">
							직&nbsp;&nbsp;&nbsp;위</label>
						<div class="col-xs-8 col-sm-4 g_value">			
							<select name="posi_no" style="width:100%;text-align-last: center;" required >
								<option value="" > --- 선 택 --- </option>
								<c:forEach var="position" items="${positionList }">	
								<option value="${position.posi_no }" >${position.posi_name }</option>
								</c:forEach>				
							</select>
						</div>		
						
					</div>	
					<div class="form-group" >
						<label for="eno" class="col-xs-4 col-sm-2 control-label bolder g_label required">사원번호</label> 
						<div class="col-xs-8 col-sm-4 g_value">
							<input type="text" id="eno" name="eno" placeholder="클릭 후 자동완성" style="text-align:center;width:100%;"/>
						</div>
						<label for="regDate" class="col-xs-4 col-sm-2 control-label bolder g_label required">입사날짜</label> 
						<div class="col-xs-8 col-sm-4 g_value">
							<input type="text" id="regDate" name="regDate" readonly placeholder="" style="text-align:center;width:100%;"/>
						</div>
					</div>
					
					<div class="form-group">											
						<label class="col-xs-4 col-sm-2 control-label bolder g_label" style="height:79px;">
							경력사항
							<button type="button" class="btn btn-xs btn-info" style="width:100%;" onclick="RegistCareer();">추가</button>
						</label>						
						<div class="col-xs-8 col-sm-10 g_value row">							
							<div class="col-sm-2" id="coName" style="padding:2px 1px;">
								<label class="label" style="width:100%;">회사명</label>													
							</div>
							<div class="col-sm-4" id="job" style="padding:2px 1px;" >
								<label class="label" style="width:100%;">주요업무</label><br/>
							</div>
							<div class="col-sm-1" id="dept" style="padding:2px 1px;" >
								<label class="label" style="width:100%;">부서</label><br/>								
							</div>  
							<div class="col-sm-1" id="position" style="padding:2px 1px;" >
								<label class="label" style="width:100%;">직위</label><br/>								
							</div> 
							<div class="col-sm-3" id="year" style="padding:2px 1px;" >
								<label class="label" style="width:100%;">업무기간</label>								
							</div>
							<div class="col-sm-1 text-center" id="remove" style="padding:2px 1px;" >
								<label class="label" style="width:100%;">삭제</label><br/>								
							</div>							
						</div>
					</div>
					<div class="form-group"></div>	
					<div class="form-group uploadFile ">						
						<label class="col-xs-4 col-sm-2 control-label bolder g_label">
							<i class="ace-icon fa fa-folder-open" style="font-size:16px;"></i>
							<span>첨부서류</span>							
						</label>
						<div class="col-sm-10 g_value" data-role="attach">
							<div class="col-sm-4" style="padding:2px 1px;">								
								<label for="licenseDoc" class="label" style="width:100%;">주민등록등본</label>	
								<div class="input-group">							
									<input class="col-sm-12 no-padding" type="file" id="licenseDoc" name="licenseDoc"/>
									<span class='input-group-btn'>
										<button class="btn btn-xs btn-danger" type='button' data-role="licenseDoc"  ><b>X</b></button>
									</span>
								</div>
							</div>
							<div class="col-sm-4" style="padding:2px 1px;">								
								<label for="graduDoc" class="label" style="width:100%;">졸업증명서</label>	
								<div class="input-group">							
									<input class="col-sm-12 no-padding" type="file" id="graduDoc" name="graduDoc" />
									<span class='input-group-btn'>
										<button class="btn btn-xs btn-danger" type='button' data-role="graduDoc" ><b>X</b></button>
									</span>
								</div>
							</div>
							<div class="col-sm-4" style="padding:2px 1px;">								
								<label for="scoreDoc" class="label" style="width:100%;">성적증명서</label>	
								<div class="input-group">							
									<input class="col-sm-12 no-padding" type="file" id="scoreDoc" name="scoreDoc" />
									<span class='input-group-btn'>
										<button class="btn btn-xs btn-danger" type='button' data-role="scoreDoc" ><b>X</b></button>
									</span>
								</div>
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
<%@ include file="regist_js.jsp" %>
</body>


