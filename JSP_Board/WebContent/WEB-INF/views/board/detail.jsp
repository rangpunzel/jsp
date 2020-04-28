<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
    <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<br>
				<div class="row">
					<c:if test="${loginUser.id eq board.writer }">
						<div class="col-md-2">
							<button type="button" class="btn btn-block btn-default btn-flat" id="updateBtn">수 정</button>
						</div>
						<div class="col-md-2">
							<button type="button" class="btn btn-block btn-default btn-flat" id="deleteBtn">삭 제</button>
						</div>
					</c:if>
					<div class="col-md-2">
						<button type="button" class="btn btn-block btn-default btn-flat" id="listgo"><i class="fas fa-bars">&nbsp;목 록</i></button>
					</div>
				</div>
				<br>
				<div class="card card-outline card-info">
					<div class="card-body">
						<div class="form-group col-sm-12">
							<label for="title">제 목</label>
							<input type="text" class="form-control" id="title" 
								value="${board.title }" readonly />							
						</div>
						<div class="row">	
							<div class="form-group col-sm-4" >
								<label for="writer">작성자</label>
								<input type="text" class="form-control" id="writer" 
									value="${board.writer }" readonly />
							</div>		
							
							<div class="form-group col-sm-4" >
								<label for="regDate">작성일</label>
								<input type="text" class="form-control" id="regDate" 
									value="<fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd" />" readonly />
							
							</div>
							<div class="form-group col-sm-4" >
								<label for="viewcnt">조회수</label>
								<input type="text" class="form-control" id="viewcnt" 
									value="${board.viewcnt }" readonly />
							</div>
						</div>		
						<div class="form-group col-sm-12">
							<label for="content">내 용</label>
							<div id="content">${board.content }</div>	
						</div>
						
								<div class="card-header">
									<label for="file">첨부파일</label>
								</div>			
								<div class="card-footer">
									<div class="row">
										<c:forEach items="${board.attachList }" var="attach">
											<div class="col-md-4 col-sm-4 col-xs-12"  style="cursor:pointer;" onclick="location.href='<%=request.getContextPath()%>/attach/getFile.do?bno=${board.bno }&ano=${attach.ano }';">
												<div class="info-box">	
												 	<span class="info-box-icon bg-yellow">
														<i class="fa fa-copy"></i>
													</span>
													<div class="info-box-content">
														<span class ="info-box-text">
															<fmt:formatDate value="${attach.regDate }" pattern="yyyy-MM-dd" />	
														</span>
														<span class ="info-box-number">${attach.fileName }</span>
													</div>
												</div>
											 </div>											 
										</c:forEach>
									</div>
								</div>				
						
												
					</div>
					<div class="card-footer">

					</div>									
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row  -->
		
		<!-- reply component start --> 
		<div class="row">
			<div class="col-md-12">
				<div class="card card-info">					
					<div class="card-body">
						<!-- The time line -->
							<div class="timeline">
							<!-- timeline time label -->
							<div class="time-label" id="repliesDiv">
								<span class="bg-default">Replies List </span>
							</div>
						</div>
						<div class='text-center'>
							<ul id="pagination" class="pagination justify-content-center m-0">
			
							</ul>
						</div>
					</div>
					<div class="card-footer">
						<input class="form-control" type="hidden" placeholder="USER ID" 
							   id="newReplyWriter" readonly value="${loginUser.id }"> 
							   
							   
						<div class="input-group input-group-lg">
						<input class="form-control" type="text"	placeholder="comment" id="newReplyText">
						<span class="input-group-append">
							<button type="button" class="btn btn-default btn-flat" id="replyAddBtn">등 록</button>
                 		</span>
						</div>
					</div>				
				</div>			
				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
		
    </section>
    <!-- /.content -->
    
   <form role="form">
  	<input type='hidden' name='bno' value ="${board.bno}">
  	<input type='hidden' name='page' value ="${param.page}">
    <input type='hidden' name='perPageNum' value ="${param.perPageNum}">
    <input type='hidden' name="searchType" 
		         value="${param.searchType }" />
	<input type='hidden' name="keyword" 
		         value="${param.keyword }" />
  </form>
  
  <!-- Modal -->
<div id="modifyModal" class="modal modal-default fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" style="display:none;"></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>        
      </div>
      <div class="modal-body" data-rno>
        <p><input type="text" id="replytext" class="form-control"></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
        <button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
  
  	<%@ include file="./reply_js.jsp" %>
    <script>
	var formObj = $("form[role='form']");
    
    	$('#updateBtn').on('click',function(){
			formObj.attr("action", "modifyForm.do");
			formObj.attr("method", "post");
			formObj.submit();
    	});
    	$('#deleteBtn').on('click',function(){
    		var answer = confirm("정말 삭제하시겠습니까?");
    		if(answer){		
    			formObj.attr("action", "remove.do");
    			formObj.attr("method", "post");
    			formObj.submit();
    		}
    	});
    	$('#listgo').on('click',function(){
    		location.href="/board/list.do?page=${param.page}"
    	});
    </script>
</body>
</html>