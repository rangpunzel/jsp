<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <!-- jQuery -->
  <script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
</head>
<body>
<!-- Main content -->
<br>
    <section class="content container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-9" style="max-width:960px;">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h3 class="card-title p-1">글수정</h3>
						<div class ="card-tools">
							<button type="button" class="btn btn-default btn-flat" id="modifyBtn">수 정</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="btn btn-default btn-flat" id="cancelBtn">취 소</button>
						</div>
					</div><!--end card-header  -->
					<div class="card-body pad">
						<form role="form" method="post" action="modify.do" name="modifyForm">
						    <input type="hidden" name="bno" value="${board.bno }" />
							<input type='hidden' name='page' value="${param.page}">
							<input type='hidden' name='perPageNum' value="${param.perPageNum}">
							<input type='hidden' name='searchType' value="${param.searchType}">
							<input type='hidden' name='keyword' value="${param.keyword}">
						
							<div class="form-group">
								<label for="title">제 목</label> 
								<input type="text" id="title" value="${board.title }" name='title' class="form-control" placeholder="제목을 쓰세요" >
							</div>							
							<div class="form-group">
								<label for="writer">작성자</label> 
								<input type="text" id="writer" readonly	name="writer" class="form-control" value="${loginUser.id }">
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea class="textarea" name="content" id="content" rows="20"
									placeholder="1000자 내외로 작성하세요." style="display: none;">${board.content }</textarea>
							</div>
						</form>
					</div><!--end card-body  -->
					<div class="card-footer" style="display:none">
					
					</div><!--end card-footer  -->
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>
    <!-- /.content -->

    
 <%@ include file="/WEB-INF/views/commons/summernote.jsp" %>
 <script>
 
 $('#modifyBtn').on('click',function(){
	var form=document.modifyForm;
		form.submit();
 });
 $('#cancelBtn').on('click',function(){
	history.go(-1); 
 });
 </script>
</body>
</html>