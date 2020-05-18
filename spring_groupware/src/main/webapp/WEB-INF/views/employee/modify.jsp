<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
<title>임직원 수정</title>
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

input:read-only,textarea:read-only{
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
					임직원수정
			</li>
		</ul>		
	</div>
	<!-- Page Path Ends -->
	
	<!-- Page Content Begins -->
	<div class="page-content" style="padding-bottoms:8px;min-width:420px;">
	
		<!-- 상단 우측버튼 -->
		<div class="row">
			<div class="wizard-actions">
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="goSubmit('post');">
					<i class="red ace-icon fa fa-check bigger-120"></i><b>저장</b>
				</button>
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="javascript:history.go(-1);">
					<i class="green ace-icon fa fa-arrow-left bigger-120"></i><b>뒤로</b>
				</button>
				<button type="button" class="btn btn-sm btn-white btn-bold" onclick="javascript:goSubmit('close');">
					<i class="grey ace-icon fa fa-times bigger-120"></i><b>닫기</b>
				</button>
			</div>
		</div>
		<!-- 상단 우측버튼 -->
		
	<!-- <body style="margin:1px;"> -->
	
		<form role="form" id="modifyForm" class="form-horizontal" action="modify" method="post" enctype="multipart/form-data">
			<div class="hr_line">&nbsp;</div><br/><br/>
			<div class="col-xs-12 text-center" style="background:gray;color:white;" >개인 인적 사항</div>	
			<br/><br/>
			<div class="wrapper">
				<div class="col-xs-4 col-sm-2 control-label bolder g_label form-group">
					<div  role="picture">
						<div id="picturePreView"></div>
						<label for="picture"  class="btn btn-xs btn-info" style="width:110px;margin-bottom:2px;">사진변경</label>
						<input type="file" id="picture" name="picture" style="display:none;"/>
						<input type="hidden" id="picture" name="old_picture" value="${employee.picture }"/>
					</div>
				</div>
				<div class="col-xs-8 col-sm-10" style="padding-left:0;">
					<div class="form-group">
						<label for="writer" class="col-xs-4 col-sm-2 control-label bolder g_label required">
						등록자</label>
						<div class="col-xs-8 col-sm-10 g_value">	
							<div class="checkbox" style="inline;">				
								<span class="label">사원번호 : ${register.eno } | 이름 : ${register.name }</span>				
							</div>
							<input id="regist" name="register" type="hidden" value="${register.id }" />			
						</div>		
					</div>
					<div class="form-group">
						<label for="phone_p" class="col-xs-4 col-sm-2 control-label bolder g_label required">아이디</label>
						<div class="col-xs-8 col-sm-4 g_value">				
							<input class="col-sm-12" id="id" name="id" type="text" maxlength="20" readonly 
									 onkeyup="this.value=this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣  ~!@#$%^&*()_+|<>?:{}\- ]/g, '');" 
									 placeholder="중복확인  필수" value="${employee.id }" />																	
						</div>		
						<label for="pwd" class="col-xs-4 col-sm-2 control-label bolder g_label required">패스워드</label>
						<div class="col-xs-8 col-sm-4 g_value">													
								<input class="col-sm-12" id="pwd" name="pwd" type="password" maxlength="20"							    
									   placeholder="암호를 입력하시오" value="${employee.pwd }"/>
														
						</div>
					</div>	
					<div class="form-group">
						<label for="name" class="col-xs-4 col-sm-2 control-label bolder g_label required">이&nbsp;&nbsp;름</label>
						<div class="col-xs-8 col-sm-4 g_value">				
							<input class="col-sm-12" id="name" name="name" type="text" value="${employee.name }" />			
						</div>		
						<label for="ssn1" class="col-xs-4 col-sm-2 control-label bolder g_label required">주민번호</label>
						<div class="col-xs-8 col-sm-4 g_value">													
								<input class="col-xs-5" id="ssn1" name="ssn" type="text" placeholder="앞 6자리" maxlength="6"
								       onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z]/g, '');"
								       value="${employee.ssn.split('-')[0] }"/>
								<span class="col-xs-2">-</span>
								<input class="col-xs-5" id="ssn2" name="ssn" type="text" placeholder="뒤 7자리" maxlength="7"
									   onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z]/g, '');"
									   value="${employee.ssn.split('-')[1] }"/>								
						</div>
					</div>
					<div class="form-group">
						<label for="phone_p" class="col-xs-4 col-sm-2 control-label bolder g_label required">휴대전화</label>
						<div class="col-xs-8 col-sm-4 g_value">				
							<input class="col-sm-12" id="phone_p" name="phone_p" type="text" maxlength="11" 
									 onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z ~!@#$%^&*()_+|<>?:{}\- ]/g, '');" 
									 placeholder="' - ' 없이 입력하시오" value="${employee.phone_p }" />			
						</div>		
						<label for="phone_c" class="col-xs-4 col-sm-2 control-label bolder g_label">집전화</label>
						<div class="col-xs-8 col-sm-4 g_value">													
								<input class="col-sm-12" id="phone_c" name="phone_c" type="text" maxlength="10"  
									   onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z ~!#$%^&*()_+|<>?:{}\- ]/g, '');" 
									   placeholder="' - ' 없이 입력하시오" value="${employee.phone_c }"/>
														
						</div>
					</div>	
					<div class="form-group">
						<label for="email" class="col-xs-4 col-sm-2 control-label bolder g_label required">이메일</label>
						<div class="col-xs-8 col-sm-10 g_value">				
							<c:set var="email" value="${employee.email.split('@') }" />
							<input class="col-sm-4" id="email" name="email" type="text"  
									 onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣  ~!#$@%^&*()_+|<>?:{}\- ]/g, '');" 
									 placeholder="아이디를 입력하시오" value="${email[0] }" />&nbsp;&nbsp;@&nbsp;&nbsp;
							<select name="email" >
								<option value="">-- 계정선택 --</option>
								<option value="gmail.com" ${email[1] eq 'gmail.com' ? 'selected':'' }>gamil.com</option>
								<option value="naver.com" ${email[1] eq 'naver.com' ? 'selected':'' }>naver.com</option>
								<option value="hanmail.net" ${email[1] eq 'hanmail.net' ? 'selected':'' }>hanmail.net</option>
								<option value="daum.net" ${email[1] eq 'daum.net' ? 'selected':'' }>daum.net</option>		
								<option value="yahoo.com" ${email[1] eq 'yahoo' ? 'selected':'' }>yahoo.com</option>				
								
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
								<input id="postCode" class="text-center" name="postCode" type="text" readonly placeholder="우편번호"  
									   value="${employee.postCode }" onclick="SearchAddress();"/>
								<input type="button" class="btn btn-xs btn-info" id="searchAddr" onclick="SearchAddress();" value="주소검색" /><br/>
							</div>
							<div class="col-sm-12 no-padding" style="margin-bottom:3px;">
								<input id="address[0]" type="text" name="address1" readonly onclick="$('#searchAddr').click();" 
								       value="${employee.address1 }" style="width:100%;"/>								
							</div>
							<div class="col-sm-12 no-padding" style="margin-bottom:3px;">
								<div class="col-sm-2 no-padding" style="line-height:16px;">								
									<label class="label" style="width:100%;margin-top:5px;">나머지주소</label>
								</div>																					
								<div class="col-sm-7 no-padding" >
									&nbsp;<input id="address[1]" type="text" name="address2" style="width:95%;" value="${employee.address2 }"/>
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
								<option value="${dept.dept_no }" ${employee.dept_no eq dept.dept_no ? 'selected':'' } >${dept.dept_name }</option>
								</c:forEach>				
							</select>
						</div>
						<label for="position" class="col-xs-4 col-sm-2 control-label bolder g_label required">
							직&nbsp;&nbsp;&nbsp;위</label>
						<div class="col-xs-8 col-sm-1 g_value" style="padding-left:2px;padding-right:2px;">			
							<select name="posi_no" style="width:100%;text-align-last: center;" required >
								<option value="" > --- 선 택 --- </option>
								<c:forEach var="position" items="${positionList }">	
								<option value="${position.posi_no }" ${employee.posi_no eq position.posi_no ? 'selected':'' }>${position.posi_name }</option>
								</c:forEach>				
							</select>
						</div>
						<label for="position" class="col-xs-4 col-sm-2 control-label bolder g_label required">
							상&nbsp;&nbsp;&nbsp;태</label>
						<div class="col-xs-8 col-sm-1 g_value" style="padding-left:2px;padding-right:2px;">			
							<select name="enabled" style="width:100%;text-align-last: center;" required >
								<option value="" >-선택-</option>									
								<option value="0" ${employee.enabled eq 0 ? 'selected':'' }>퇴사</option>
								<option value="1" ${employee.enabled eq 1 ? 'selected':'' }>재직</option>
								<option value="2" ${employee.enabled eq 2 ? 'selected':'' }>휴직</option>								
												
							</select>
						</div>
									
						
					</div>	
					<div class="form-group" >
						<label for="eno" class="col-xs-4 col-sm-2 control-label bolder g_label required">사원번호</label> 
						<div class="col-xs-8 col-sm-4 g_value">
							<input type="text" id="eno" name="eno" value="${employee.eno }" readonly style="text-align:center;width:100%;"/>
						</div>
						<label for="regDate" class="col-xs-4 col-sm-2 control-label bolder g_label required">입사날짜</label> 
						<div class="col-xs-8 col-sm-4 g_value">
							<input type="text" id="regDate" name="regDate" readonly placeholder="" readonly 
							       value="<fmt:formatDate value="${employee.regDate}" pattern="yyyy.MM.dd" />"
							       style="text-align:center;width:100%;"/>
						</div>
					</div>
					
					<div class="form-group">											
						<label class="col-xs-4 col-sm-2 control-label bolder g_label" for="careers">
							경력사항&nbsp;<button type="button" class="btn btn-xs btn-info" onclick="RegistCareer();">추가</button>						
						</label>
						<div class="col-xs-8 col-sm-10 g_value row" id="careers">																					
							<div class="col-sm-2" id="coName" style="padding:2px 1px;">
								<label class="label col-sm-12" >회사명</label>
								<c:forEach var="career" items="${careers }" varStatus="status">
									<input class="col-sm-12" name="careers[${status.index }].coName" type="text" value="${career.coName }" />
								</c:forEach>													
							</div>
							<div class="col-sm-4" id="job" style="padding:2px 1px;" >
								<label class="label col-sm-12" >주요업무</label><br/>
								<c:forEach var="career" items="${careers }" varStatus="status">
									<input class="col-sm-12" name="careers[${status.index}].job" type="text" value="${career.job}" />
								</c:forEach>	
							</div>
							<div class="col-sm-1" id="dept" style="padding:2px 1px;" >
								<label class="label col-sm-12" >부서</label><br/>				
								<c:forEach var="career" items="${careers }" varStatus="status">
									<input class="col-sm-12 text-center" name="careers[${status.index}].dept" type="text" value="${career.position }" />
								</c:forEach>					
							</div>  
							<div class="col-sm-1" id="position" style="padding:2px 1px;" >
								<label class="label col-sm-12">직위</label><br/>					
								<c:forEach var="career" items="${careers }" varStatus="status">
									<input class="col-sm-12 text-center" name="careers[${status.index}].position" type="text" value="${career.dept }" />
								</c:forEach>				
							</div> 
							<div class="col-sm-3" id="year" style="padding:2px 1px;" >
								<label class="label col-sm-12" >업무기간</label>				
								<c:forEach var="career" items="${careers }" varStatus="status">
									<div class="no-padding" name="careers[${status.index }].year" style="text-align:center;">
										<input class="col-xs-6" type="text" data-target="year" name="careers[${status.index }].startDay" 
											   style="text-align:center;" placeholder="입사일" readonly 
											   value="<fmt:formatDate value="${career.startDay }" pattern="yyyy.MM.dd" /> "/>	
										<span class="col-xs-1 text-center" style="margin:0;padding:0;">~</span>							
										<input class="col-xs-5" type="text" data-target="year" name="careers[${status.index }].endDay" 
										       style="text-align:center; padding-right:0;" placeholder="퇴사일"  readonly
										       value="<fmt:formatDate value="${career.endDay }" pattern="yyyy.MM.dd" /> "/>
									</div>
								</c:forEach>					
							</div>	
							<div class="col-sm-1 text-center" id="remove" style="padding:2px 1px;" >
								<label class="label" style="width:100%;">삭제</label><br/>
								<c:forEach var="career" items="${careers }" varStatus="status">	
								<div class="col-sm-12" >			
									<button type="button" name="${status.index }" class="checkbox btn btn-xs btn-danger remove" style="margin-bottom:2px;"><b>X</b></button><br/>
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
								<input type="file" id="licenseDoc" name="licenseDoc" style="display:none;"/>
								<input type="hidden" name="old_licenseDoc" value="${employee.licenseDoc }" />
								<div class="input-group input-group-sm" data-role="attach">							
									<div class="input-group-btn">
                  						<button type="button" class="btn btn-info" name="licenseDoc">변경</button>
                					</div>	
                					<input type="text" class="form-control" name="view_licenseDoc" placeholder="파일을 선택하세요." 
                						   value="${employee.licenseDoc.split('\\$\\$')[1]}">                					
                					<span class="input-group-btn">
				                      <button type="button" data-role="licenseDoc" class="btn btn-danger btn-flat">X</button>
				                    </span>								
								</div>
							</div>
							<div class="col-sm-4" style="padding:2px 1px;">								
								<label for="graduDoc" class="col-sm-12 label">졸업증명서</label>	
								<input type="file" id="graduDoc" name="graduDoc" style="display:none;"/>
								<input type="hidden" name="old_graduDoc" value="${employee.graduDoc }" />
								<div class="input-group input-group-sm" data-role="attach">							
									<div class="input-group-btn">
                  						<button type="button" class="btn btn-info" name="graduDoc">변경</button>
                					</div>	
                					<input type="text" class="form-control" name="view_graduDoc" placeholder="파일을 선택하세요." 
                						   value="${employee.graduDoc.split('\\$\\$')[1]}">
                					<span class="input-group-btn">
				                      <button type="button" data-role="graduDoc" class="btn btn-danger btn-flat">X</button>
				                    </span>								
								</div>									
							</div>
							<div class="col-sm-4" style="padding:2px 1px;">								
								<label for="scoreDoc" class="col-sm-12  label">성적증명서</label>	
								<input type="file" id="scoreDoc" name="scoreDoc" style="display:none;"/>
								<input type="hidden" name="old_scoreDoc" value="${employee.scoreDoc }" />
								<div class="input-group input-group-sm" data-role="attach">							
									<div class="input-group-btn">
									
                  						<button type="button" class="btn btn-info" name="scoreDoc">변경</button>
                					</div>	
                					<input type="text" class="form-control" name="view_scoreDoc" placeholder="파일을 선택하세요." 
                						   value="${employee.scoreDoc.split('\\$\\$')[1]}">
                					<span class="input-group-btn">
				                      <button type="button" data-role="scoreDoc" class="btn btn-danger btn-flat">X</button>
				                    </span>								
								</div>
							</div>
							
										
						</div>
					</div>					
					<div class="form-group">
						<label for="title" class="col-xs-4 col-sm-2 control-label bolder g_label" style="height:103px;line-height:80px;">비&nbsp;&nbsp;&nbsp;고</label>
						<div class="col-xs-8 col-sm-10 g_value">
							<textArea class="col-sm-12" id="remark" name="remark" onkeydown="CheckTextCount(this, 200);" style="height:90px;">${employee.remark }</textArea>
						</div>
						<br/>
					</div>  
					
				</div>					
			</div>	
		</form>
	</div>
<%@ include file="modify_js.jsp" %>
</body>


