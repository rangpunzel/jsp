<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head>
	<style>
		table{
			width:100%;
		}
	</style>	
	<script>
		$('.maninfo').each(function(){}).click(function(event) { event.preventDefault(); });		
	</script>

</head>



<div class="page-content main-content" style="padding: 0px;">	
	<div id="if_list_div" style="position:relative;sheight:0;padding:0;soverflow:hidden;" class="show">
		<div id="if_list" name="if_list" style="position: absolute; top: 0px; left: 0px; bottom: 0px; height: 796px; width: 100%; border: 0px;" class="no-skin listBody">
			<div class="breadcrumbs" id="breadcrumbs" style="border:none;">
				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-comments-o home-icon bigger-150"></i>
						&nbsp;임직원관리
					</li>
					<li class="active">
						<a href="list">임직원명부</a>
					</li>
				</ul>
			</div>
			<!-- page content -->		
			<div class="page-content main-content" style="padding:0;">
				<div class="page-content">		
					<form id="search" action="list" method="post">
						<input name="page" type="hidden" value="${pageMaker.cri.page }">
						<input name="perPageNum" type="hidden" value="${pageMaker.cri.perPageNum }">
							
					<!-- 상단 우측버튼 -->
					<div class="wizard-actions-L">
						<button type="button" class="btn btn-sm btn-white btn-bold" onclick="OpenWindow('<%=request.getContextPath()%>/employee/regist','','850','620');">
									<i class="red ace-icon fa fa-pencil-square-o bigger-120"></i>
							<b>임직원등록</b>
						</button>
						<div class="wizard-inner-R">
							<select id="searchType" name="searchType" style="width:100px;" class="form-control">
								<option value="">검색구분</option>
								<option value="n" ${pageMaker.cri.searchType eq 'n' ? 'selected':'' }>이 름</option>
								<option value="i" ${pageMaker.cri.searchType eq 'i' ? 'selected':'' }>아이디</option>
								<option value="p" ${pageMaker.cri.searchType eq 'p' ? 'selected':'' }>전화번호</option>
								<option value="e" ${pageMaker.cri.searchType eq 'e' ? 'selected':'' }>이메일</option>
								
							</select>
							
							<div class="input-group">
								<input id="searchValue" name="keyword" style="width:100px; margin-left:5px; border-radius: 0px !important;" placeholder="Search for ..." class="form-control" type="text" value="${pageMaker.cri.keyword }">
								<span id="gridSearch" class="input-group-btn" style="display: inline;">
									<button type="button" id="searchBtn" class="btn btn-sm btn-white">검색</button>
								</span>
							</div>
							<span id="gridSearchReset" style="display:none;">
								<button type="button" class="btn btn-sm btn-white">
									<i class="red ace-icon fa fa-times bigger-120"></i>
								</button>
							</span>
						</div>
						
					</div>
					<!-- 상단 우측버튼 -->
					
					</form>
					<br/>	
					
					<!-- 선긋기 -->
					<div class="bline"></div>
					<div class="hr_line1">&nbsp;</div>
					<div class="bline"></div>
					
					<!-- jqGrid Begins -->
					<div class="row">
						<div class="col-xs-12">
							<div id="grid_container">
								<div class="ui-jqgrid ui-widget ui-widget-content ui-corner-all" id="gbox_grid-table" dir="ltr" >
								<div class="loading ui-state-default ui-state-active" id="load_grid-table" style="display: none;"> Data Loading...</div><div class="ui-jqgrid-view " role="grid" id="gview_grid-table">
								<div class="ui-jqgrid-titlebar ui-jqgrid-caption ui-widget-header ui-corner-top ui-helper-clearfix" style="display: none;"><a role="link" class="ui-jqgrid-titlebar-close HeaderButton ui-corner-all" title="Toggle Expand Collapse Grid" style="right: 0px;"><span class="ui-jqgrid-headlink ui-icon ui-icon-circle-triangle-n"></span></a><span class="ui-jqgrid-title"></span></div><div class="ui-jqgrid-hdiv ui-state-default ui-corner-top" >
									<div class="ui-jqgrid-hbox">
										<table class="ui-jqgrid-htable ui-common-table " role="presentation" aria-labelledby="gbox_grid-table">											
												<tr class="ui-jqgrid-labels">													
													<th class="ui-th-column ui-th-ltr" style="width:12%;"><div class="text-center">사원번호</div></th>
													<th class="ui-th-column ui-th-ltrre" style="width:13%;"><div class="text-center">아이디</div></th>										
													<th class="ui-th-column ui-th-ltr" style="width:10%;"><div class="text-center">이름</div></th>		
													<th class="ui-th-column ui-th-ltr" style="width:10%;"><div class="text-center">부서</div></th>
													<th class="ui-th-column ui-th-ltr" style="width:10%;"><div class="text-center">직위</div></th>
													<th class="ui-th-column ui-th-ltr" style="width:15%;"><div class="text-center">전화번호</div></th>
													<th class="ui-th-column ui-th-ltr" style="width:15%;"><div class="text-center">이메일</div></th>
													<th class="ui-th-column ui-th-ltr" style="width:15%;"><div class="text-center">입사일</div></th>
												</tr>
											
										</table>
									</div>
								</div>
								
								<div class="ui-jqgrid-bdiv" style="min-width: 440px;">
									<div style="position:relative;">										
										<table id="grid-table" tabindex="0" role="presentation" aria-multiselectable="false" aria-labelledby="gbox_grid-table" class="ui-jqgrid-btable ui-common-table">
											<tr class="jqgfirstrow" role="row">
												<td role="gridcell" style="width:12%;"></td>
												<td role="gridcell" style="width:13%;"></td>
												<td role="gridcell" style="width:10%;"></td>												
												<td role="gridcell" style="width:10%;"></td>
												<td role="gridcell" style="width:10%;"></td>
												<td role="gridcell" style="width:15%;"></td>
												<td role="gridcell" style="width:15%;"></td>
												<td role="gridcell" style="width:15%;"></td>		
											</tr>
											<c:forEach var="employee" items="${employeeList }" varStatus="status">
											<tr role="row" class="jqgrow ui-row-ltr ui-widget-content">
												<td role="gridcell" style="text-align:center;" >
													<a href="#" onclick="OpenWindow('detail?id=${employee.id }','','850','620');">${employee.eno }</a>
												</td>
												<td role="gridcell" style="text-align:center;" >${employee.id }</td>
												<td role="gridcell" style="text-align:center;" >${employee.name }</td>
												<td role="gridcell" style="text-align:center;" >${employee.deptName }</td>														
												<td role="gridcell" style="text-align:center;" >${employee.position }</td>
												<td role="gridcell" style="text-align:center;" >
													<div class="row" >
														<a href="tel:${employee.phone_p }">
															<span class="col-sm-5" style="margin:0;padding:0;text-align:right;overflow:hidden; text-overflow:ellipsis; white-space:nowrap;">mobile : </span>
															<span class="col-sm-7" style="margin:0;padding:0;text-align:left;overflow:hidden; text-overflow:ellipsis; white-space:nowrap;">&nbsp;${employee.phone_p }</span>
														</a>
													</div>
													<div class="row">
														<a href="tel:${employee.phone_c }" style="">
															<span class="col-sm-5" style="margin:0;padding:0;text-align:right;overflow:hidden; text-overflow:ellipsis; white-space:nowrap;">tel : </span>
															<span class="col-sm-7" style="margin:0;padding:0;text-align:left;overflow:hidden; text-overflow:ellipsis; white-space:nowrap;">&nbsp;${employee.phone_c }</span>
														</a>
													</div>
													
												</td>
												<td role="gridcell" style="text-align:center;" >${employee.email }</td>
												<td role="gridcell" style="text-align:center;" >
													<fmt:formatDate value="${employee.regDate }" pattern="yyyy년 MM월 dd일"/>
												</td>
												
											</tr>
											</c:forEach>
										
										</table>
									</div>
								</div>
									<div id="grid-pager" class="ui-jqgrid-pager ui-state-default ui-corner-bottom" dir="ltr">
										<div id="pg_grid-pager" class="ui-pager-control" role="group">
											<table class="ui-pg-table ui-common-table ui-pager-table ">
												<tr>
													<td id="grid-pager_left" align="left">
														<div class="ui-pg-div">
															<span class="ui-icon ace-icon"></span>
														</div>														
													</td>
													<td id="grid-pager_center" align="center" style="width:320px;">
														<table class="ui-pg-table ui-common-table ui-paging-pager">
															<tr>
																<td id="first_grid-pager" class="ui-pg-button ui-corner-all ui-state-disabled" title="First Page" style="cursor: default;">
																	<span class="ui-icon ace-icon"><b> << </b></span>
																</td>
																<td id="prev_grid-pager" class="ui-pg-button ui-corner-all ui-state-disabled" title="Previous Page" style="cursor: default;">
																	<span class="ui-icon ace-icon"><b> < </b></span>
																</td>
																<td class="ui-pg-button ui-state-disabled">
																	<span class="ui-separator"></span>
																</td>
																<td id="input_grid-pager" dir="ltr">
																	<input id="pageNum" class="ui-pg-input ui-corner-all" type="text" size="2" maxlength="7" value="${pageMaker.cri.page }" style="width:40px;"> / <span id="sp_1_grid-pager">${pageMaker.realEndPage }</span>
																</td>
																<td class="ui-pg-button ui-state-disabled">
																	<span class="ui-separator"></span>
																</td>
																<td id="next_grid-pager" class="ui-pg-button ui-corner-all ui-state-disabled" title="Next Page" style="cursor: default;">
																	<span class="ui-icon ace-icon"><b> > </b></span>
																</td>
																<td id="last_grid-pager" class="ui-pg-button ui-corner-all ui-state-disabled" title="Last Page" style="cursor: default;">
																	<span class="ui-icon ace-icon"><b> >> </b></span>
																</td>
																<td dir="ltr">
																	<select id="perPageNum" class="ui-pg-selbox ui-widget-content ui-corner-all" role="listbox" title="Records per Page">
																		<option role="option" value="10" ${pageMaker.cri.perPageNum ==10 ? 'selected' : '' }>10</option>
																		<option role="option" value="20" ${pageMaker.cri.perPageNum ==20 ? 'selected' : '' }>20</option>
																		<option role="option" value="30" ${pageMaker.cri.perPageNum ==30 ? 'selected' : '' }>30</option>
																		<option role="option" value="50" ${pageMaker.cri.perPageNum ==50 ? 'selected' : '' }>50</option>
																		<option role="option" value="100" ${pageMaker.cri.perPageNum ==100 ? 'selected' : '' }>100</option>
																	</select>
																</td>
															</tr>
														</table>
													</td>
													<td id="grid-pager_right" align="right">
														<div dir="ltr" style="text-align:right" class="ui-paging-info">10 건</div>
													</td>
												</tr>
											</table>
										</div>
									</div>
								</div>								
							</div>
						</div>
					</div>
					<!-- jqGrid Ends -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%-- <%@ include file="/WEB-INF/views/board/list_js.jsp" %> --%>







