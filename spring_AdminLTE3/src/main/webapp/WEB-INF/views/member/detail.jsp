<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <%@ include file="/WEB-INF/views/include/open_header.jsp" %> --%>

<body>
  <div class="content-wrapper">
	<!-- Content Header (Page header) -->
	  <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>회원상세</h1>
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
				        <li class="breadcrumb-item">
				        	<a href="lis">
					        	<i class="fa fa-dashboard"></i> 회원관리
					        </a>
				        </li>
				        <li class="breadcrumb-item active">
				        	상세보기
				        </li>		        
   	  				</ol>
 				</div>
 			</div>
		</div>
	</section>
  
    <section class="content register-page" style="height: 586.391px;">       
		<div class="register-box" style="min-width:450px;">
	    	<form role="form" class="form-horizontal" action="regist.do" method="post">
	        	<div class="register-card-body" >
	        		<div class="card-header">
 	
	        		</div>
	            	<div class="row"  style="height:200px;">
						<div class="mailbox-attachments clearfix col-md-12" style="text-align: center;">							
							<div id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>														
						</div>
					</div>
					<br />
	                <div class="form-group row" >
	                  <label for="inputEmail3" class="col-sm-3 control-label text-right">아이디</label>
	                  <div class="col-sm-9">
	                    <input name="id" type="text" class="form-control" id="inputEmail3" value="${member.id }">
	                  </div>
	                </div>
	
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">패스워드</label>
	                  <div class="col-sm-9">
	                    <input name="pwd" type="password" class="form-control" id="inputPassword3" value="${member.pwd }">
	                  </div>
	                </div>
	                <div class="form-group row">
	                  <label for="name" class="col-sm-3 control-label text-right">이&nbsp;&nbsp;름</label>
	                  <div class="col-sm-9">
	                    <input name="name" type="text" class="form-control" id="name" value="${member.name }">
	                  </div>
	               </div>
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">이메일</label>
	                  <div class="col-sm-9">
	                    <input name="email" type="email" class="form-control" id="inputPassword3" value="${member.email }">
	                  </div>
	                </div>
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">전화번호</label>
	                  <div class="col-sm-9">   
	                  	<input name="phone" type="text" class="form-control" id="inputPassword3" value="${member.phone.substring(0,3) }-${member.phone.substring(3,7)}-${member.phone.substring(7) }">	                
	                  </div>                  
	                </div>               
  
	              <div class="card-footer">
	              		    <div class="row">
			          		<div class="col-sm-3 text-center">
			          			<button type="button" id="modifyBtn" class="btn btn-warning ">수 정</button>
			          		</div>
			          		<div class="col-sm-3 text-center">
				          		<button type="button" id="deleteBtn" class="btn btn-danger" >삭 제</button>
			          		</div>
			          		<c:if test="${member.enabled eq 1}">
				          		<div class="col-sm-3 text-center">
				          			<button type="button" id="disabledBtn" class="btn btn-info" >정 지</button>
				          		</div>
			          		</c:if>
			          		<c:if test="${member.enabled eq 0}">
				          		<div class="col-sm-3 text-center">
				          			<button type="button" id="enabledBtn" class="btn btn-info" >활성화</button>
				          		</div>
			          		</c:if>
			          		
			          		<div class="col-sm-3 text-center">
			            		<button type="button" id="listBtn" onclick="CloseWindow();" class="btn btn-primary pull-right">닫 기</button>
			            	</div>
		          	    </div> 
	              </div>
	             </div>		          	     
	      	  </form>
      	  </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

<!-- post parameter -->
<form name="postForm">
	<input type="hidden" name="id" value="${member.id }" />
</form>

<script>
	var imageURL="picture/get.do?picture=${member.picture}";
	$('div#pictureView').css({'background-image':'url('+imageURL+')',
			'background-position':'center',
			'background-size':'cover',
			'background-repeat':'no-repeat'
	});
	
	$('#modifyBtn').on('click',function(){
		location.href="modifyForm.do?id=${member.id}";
	});
	
	$('#deleteBtn').on('click',function(){
		var pwd = prompt("암호를 입력하세요.");
		
		$.ajax({
			url:"checkPassword.do?pwd="+pwd,
			type:"get",
			success:function(data){
				if(data=="SUCCESS"){
					location.href="remove.do?id=${member.id}";
				}else{
					alert("패스워드가 일치하지 않습니다.");
				}
			}
		});
/* 		if(pwd=="${loginUser.pwd}"){
			location.href="remove?id=${member.id}";
		}else{
			alert("패스워드가 일치하지 않습니다.");
			return;
		} */
		
/* 		$.getJSON("checkPassword?pwd="+pwd,function(data){
			if(data=="SUCCESS"){
				alert(data);
			}else{
				return;
			}
		}) */
	});
	
	$('#disabledBtn').on('click',function(){
		location.href="disabled.do?id=${member.id}";
	});
	$('#enabledBtn').on('click',function(){
		location.href="enabled.do?id=${member.id}";
	});

</script>

</body>
