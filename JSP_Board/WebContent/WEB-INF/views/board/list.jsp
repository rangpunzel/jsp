<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head>
<title></title>
<style>
table th,td{
	text-align:center;		
}
</style>
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
  <c:set var="pageMaker" value="${dataMap.pageMaker }" />
    <!-- Main content -->
    <section class="content">	
		<div class="col-12">
            <div class="card">
              <div class="card-header">
							<button type="button" class="btn btn-default btn-flat float-left" id="registBtn">글 쓰 기</button>
                <div class="card-tools">
                  <div class="input-group input-group-sm">
                  		<select class="form-control col-md-6" name="searchType" id="searchType">
							<option value="tcw"  ${pageMaker.cri.searchType eq 'tcw' ? 'selected':'' }>전 체</option>
							<option value="t" ${pageMaker.cri.searchType eq 't' ? 'selected':'' }>제 목</option>
							<option value="w" ${pageMaker.cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
						</select>	
                    <input type="text" name="table_search" class="form-control float-right col-md-6" placeholder="Search">

                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover">
                    <tr style="font-size:0.95em;">
                      <th style="width:10%;">번호</th>
                      <th style="width:50%;">제목</th>
                      <th style="width:10%;">첨부파일</th>
                      <th style="width:10%;">작성자</th>
                      <th style="width:10%;">작성일</th>
                      <th style="width:10%;">조회수</th>
                    </tr>
                 	<c:if test="${empty dataMap.boardList }" >
					<tr>
						<td colspan="5">
							<strong>해당 내용이 없습니다.</strong>
						</td>
					</tr>
				</c:if>	
				
					<c:forEach items="${dataMap.boardList }" var="board">
						<tr style='font-size:0.85em;'>
							<td>${board.bno }</td>
							<td id="boardTitle" style="text-align:left;max-width: 100px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
							<a href="detail.do?bno=${board.bno }">
								<span class="col-sm-12 ">${board.title }
									<c:if test="${board.replycnt ne 0 }">		
										<span class="nav-item">															
										&nbsp;&nbsp;<i class="fa fa-comment"></i>
										<span class="badge badge-warning navbar-badge">${board.replycnt}</span>
										</span>
										
									</c:if>
								</span>
							</a>
							</td>
							<td>${board.isattach }</td>
							<td>${board.writer }</td>
							<td>
								<fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/>
							</td>
							<td><span class="badge bg-red">${board.viewcnt }</span></td>
						</tr>
					</c:forEach>

                </table>
              </div>
              <!-- /.card-body -->
            </div>
	          	<div class="card-footer">
					<%@ include file="/WEB-INF/views/pagination/pagination.jsp" %>				
				</div>
            <!-- /.card -->
         		 </div>
            </section>
          
    <form id="jobForm">
		  <input type='hidden' name="page" value="${pageMaker.cri.page}" />
		  <input type='hidden' name="perPageNum" 
		  		 value="${pageMaker.cri.perPageNum}"/>
		  <input type='hidden' name="searchType" 
		         value="${pageMaker.cri.searchType }" />
		  <input type='hidden' name="keyword" 
		         value="${pageMaker.cri.keyword }" />
	</form>
	<script>
		$('#registBtn').on('click',function(){
			//alert("글등록 버튼");
			location.href="/board/registForm.do";
		});
	</script>
  <!-- common.js -->
<script src="<%=request.getContextPath() %>/resources/js/common.js"></script>        
</body>






  