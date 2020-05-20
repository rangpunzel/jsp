<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>



<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath() %>/resources/common/images/favicon.ico">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<meta name="robots" content="noindex,nofollow">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<title>대덕인재개발원 Groupware System</title>

<style type="text/css" id="fontFamilyStyleSheet">
body { font-family: 'Open Sans', sans-serif !important; }
</style>

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/common/libs/garam-admin-template/1.3.5/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/common/libs/garam-admin-template/1.3.5/dist/css/font-awesome.min.css" />
		
<!-- page specific plugin styles start -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/common/libs/garam-admin-template/1.3.5/dist/css/jquery-ui.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/common/libs/garam-admin-template/1.3.5/dist/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/common/libs/garam-admin-template/1.3.5/dist/css/jquery.gritter.min.css" />
<!-- page specific plugin styles end -->

<!-- text fonts -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/common/libs/garam-admin-template/1.3.5/dist/css/garam-fonts.min.css" />

<!-- ace styles -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/common/libs/garam-admin-template/1.3.5/dist/css/garam.min.css" class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/common/libs/garam-admin-template/1.3.5/dist/css/garam-part2.min.css" class="ace-main-stylesheet" />
<![endif]-->

<!--[if lte IE 9]>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/common/libs/garam-admin-template/1.3.5/dist/css/garam-ie.min.css" />
<![endif]-->

<!-- inline styles related to this page start -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/common/libs/bxslider/4.1.2/jquery.bxslider.css">
<style>.bx-wrapper { margin-bottom: 0px !important; box-shadow: 0 0 5px transparent; margin: auto;}</style>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/common/css/garam.garam.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/common/css/index.css" />
<style type="text/css">
.marquee { width: 100%; overflow: hidden; background: transparent; } /* 뉴스티커 *//**/
</style>

<!-- inline styles related to this page end -->
<decorator:head />
<style>
div#logo {
   background-image:
      url('<%=request.getContextPath()%>/resources/images/logo.png');
   background-position: center;
   background-repeat: no-repeat;
   background-size: contain;
}
</style>

</head>

<body class="no-skin">

<div id="navbar" class="navbar navbar-default navbar-collapse h-navbar ace-save-state">
	<div class="navbar-container ace-save-state" id="navbar-container">
		
		<button title="Full Menu" class=" navbar-toggle collapsed pull-left" type="button" id="menu-toggler" data-toggle="collapse" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>


         
		<button title="Sub Menu" data-target="#sidebar2" type="button" class="pull-left menu-toggler navbar-toggle" style="background-color: transparent!important; width: 25px;">
			<span class="sr-only">Toggle sidebar</span>
			<i class="ace-icon fa fa-chevron-down white bigger-150"></i>
		</button>
		
		<div class="navbar-header pull-left">
			<a href="/" class="navbar-brand" style="padding:8px;">
               <div id="logo" style="height: 29px; width: 220px;"></div> <!--             <span style="font-size: 20px; font-weight: bold; padding-left:15px; font-family: sans-serif !important;"></span>   -->
            </a>

        </div>
		
		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="blue user-info" style="padding:0px 7px;border: 0px;  max-width: 170px; z-index: auto;"> 
					<div class="clock user-info" style="max-width: 170px;">
						<div id="Date"></div>
						<ul style="list-style: none;">
							<li id="hours"></li>
						    <li id="point"></li>
						    <li id="min"></li>
						    <li id="point1"></li>
						    <li id="sec"></li>
						</ul>
					</div>			
				</li>
				
				<li class="blue">					
					<button class="btn btn-xs btn-info" style="margin: 5px 3px 7px 3px;" onclick="getTelInfoHtml();"  title="Company Organization">
						<i class="ace-icon fa fa-address-card-o bigger-120"></i>
						<!-- <span class="user-info">Message</span> -->
						<!-- <span class="badge" id="appr_idx6">0</span> -->
					</button>
				</li>
				
				<li class="blue" id="site-map">					
					<button class="btn btn-xs btn-purple" style="margin: 5px 3px 7px 3px;" onclick="fnSitemapPop();"  title="Groupware Sitemap">
						<i class="ace-icon fa fa-sitemap bigger-130"></i>
					</button>
				</li>
				
				<li class="blue" id="favorite-tool">
					<div class="inline dropdown-hover">
						<button data-toggle="dropdown" class="btn btn-xs btn-success dropdown-toggle" style="margin: 5px 3px 7px 3px;"  title="Create Document">
							<i class="ace-icon fa fa-pencil bigger-110"></i>
						</button>
							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-globe"></i>
									Web Utilities
								</li>

								<li class="dropdown-content ace-scroll" style="position: relative;">
								<!-- <div class="scroll-track scroll-active" style="display: block; height: 200px;"><div class="scroll-bar" style="height: 111px; top: 0px;"></div></div> -->
								<div class="scroll-content" >
									<ul class="dropdown-menu dropdown-navbar">
										<li>
											<a href="http://www.weather.go.kr/weather/main.jsp" target="_blank" class="clearfix">
												<i class="grey ace-icon fa fa-cloud bigger-200 msg-photo" style="padding: 0px 8px 0px 8px;"></i>
												<span class="msg-body">
													<span class="msg-title">
														<span class="blue">날씨정보</span>

														<i class="ace-icon fa fa-Example of external-link-square"></i>
													</span>
												</span>
											</a>
										</li>
									
										<li>
											<a href="http://ddit.or.kr" target="_blank" class="clearfix">											
												<i class="green ace-icon fa bigger-200 msg-photo" style="padding: 0px 8px 0px 8px;">
													<span style="display:block;height:100%;background-image:url('<%=request.getContextPath()%>/resources/images/symbole.png');
												           background-size:cover;background-position:left;background-repeat:no-repeat;" >&nbsp;&nbsp;&nbsp;&nbsp;</span>
												</i>
												<span class="msg-body">
													<span class="msg-title">
														<span class="blue">대덕인재개발원</span>

														<i class="ace-icon fa fa-Example of external-link-square"></i>
													</span>
												</span>
											</a>
										</li>
									
										<li>
											<a href="https://www.naver.com" target="_blank" class="clearfix">
												<i class="green ace-icon fa fa-desktop bigger-200 msg-photo" style="padding: 0px 8px 0px 8px;"></i>
												<span class="msg-body">
													<span class="msg-title">
														<span class="blue">네이버</span>

														<i class="ace-icon fa fa-Example of external-link-square"></i>
													</span>
												</span>
											</a>
										</li>
									
										<li>
											<a href="https://www.google.com" target="_blank" class="clearfix">
												<i class="red ace-icon fa fa-google bigger-200 msg-photo" style="padding: 0px 8px 0px 8px;"></i>
												<span class="msg-body">
													<span class="msg-title">
														<span class="blue">구글</span>

														<i class="ace-icon fa fa-Example of external-link-square"></i>
													</span>
												</span>
											</a>
										</li>
									</ul>
								</div>
							</li>
						</ul>
					</div>
					<!-- </div> -->
				</li>
				
				<li class="orange" style="display:none;">
					
				</li>
				
				<li class="purple" style="display:none;">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#" onclick="onTopMenu('MENU020201', '');">
						<i class="ace-icon fa fa-tasks"></i>
						<span class="badge" id="appr_idx1">0</span>
					</a>
					
				</li>
				
				<li class="green" id="notice-tool">
					<button data-toggle="dropdown" class="green btn btn-xs btn-warning dropdown-toggle" style="margin: 5px 3px 7px 3px;">
						<i class="ace-icon fa fa-bell bigger-110"></i>
						<!-- <span class="user-info">Message</span> -->
						<!-- <span class="badge" id="appr_idx6">0</span> -->
					</button>
					
					<ul class="dropdown-menu-right dropdown-navbar navbar-blue dropdown-menu dropdown-caret dropdown-close">
						<li class="dropdown-header">
							<i class="ace-icon fa fa-exclamation-triangle"></i>
							<span class="notifications_count">0</span> Notifications
						</li>

						<li class="dropdown-content ace-scroll" style="position: relative;"><div class="scroll-track" style="display: none;"><div class="scroll-bar"></div></div><div class="scroll-content">
							<ul class="dropdown-menu dropdown-navbar navbar-pink">
								<li>
									<a href="#" onclick="onTopMenu('MENU0102', '');">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-primary fa fa-envelope"></i>
												읽지않은 메일
											</span>
											<span class="pull-right badge badge-primary">
												<span class="widget_count_14" data-before="+">0</span>
											</span>
										</div>
									</a>
								</li>

								<li>
									<a href="#" onclick="onTopMenu('MENU020201', '');">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-purple fa fa-book"></i>
												결재할 문서
											</span>
											<span class="pull-right badge badge-purple"><span class="widget_count_1" data-before="+">0</span></span>
										</div>
									</a>
								</li>

								<li>
									<a href="#" onclick="onTopMenu('MENU070902', '');">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-success fa fa-server"></i>
												할당된 작업
											</span>
											<span class="pull-right badge badge-success"><span class="widget_count_16" data-before="+">0</span></span>
										</div>
									</a>
								</li>

								<li>
									<a href="#" onclick="onTopMenu('MENU0411', '');">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-danger fa fa-calendar"></i>
												개인.공유일정
											</span>
											<span class="pull-right badge badge-danger"><span class="widget_count_13" data-before="+">0</span></span>
										</div>
									</a>
								</li>
							</ul>						
						</li>						
					</ul>
				</li>
				<li class="red">
					<sec:authorize access="isAuthenticated()">
					<button class="btn btn-xs btn-danger" style="margin: 5px 3px 7px 3px;" title="System Log Out"
							onclick="self.location='<%=request.getContextPath()%>/commons/logout';">
						<i class="ace-icon fa fa-power-off bigger-130"></i>
						<!-- Log Out -->
						<!-- <i class="ace-icon fa fa-arrow-right icon-on-right"></i> -->
					</button>
					</sec:authorize>
				</li>
				<li class="blue" id="people-info">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle"> 
						<img class="nav-user-photo" src="<%=request.getContextPath() %>/employee/picture/${loginUser.id}" onerror="this.src='<%=request.getContextPath() %>/resources/images/avatar4.png'" width="36" height="36" />
						<span class="user-info" style="sdisplay:none;"> <small style="font-size:100%;">반갑습니다 ,</small> ${loginUser.name } 님 </span>
						<i class="ace-icon fa fa-caret-down"></i>
					</a>
					<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li><a href="javascript:fnSelfEdit('0');"> <i style="width: 18px !important;" class="ace-icon fa fa-pencil-square-o"></i> 기본정보 </a></li>
						<li><a href="javascript:fnSelfEdit('1');"> <i style="width: 18px !important;" class="ace-icon fa fa-key"></i> 비밀번호 </a></li>
						<li><a href="javascript:fnSelfEdit('2');"> <i style="width: 18px !important;" class="ace-icon fa fa-user"></i> 개인정보 </a></li>
						<li><a href="javascript:fnSelfEdit('3');"> <i style="width: 18px !important;" class="ace-icon fa fa-cog"></i> 환경정보 </a></li>
						<li class="divider"></li>
						<li><a href="<%=request.getContextPath() %>/commons/logout" class="fnlogout"> <i style="width: 18px !important;" class="ace-icon fa fa-power-off"></i> Logout </a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>   
</div>      
<div class="main-container ace-save-state" id="main-container">
   	<script type="text/javascript">try { ace.settings.loadState('main-container') } catch (e) {}</script>
   	<div id="sidebar" class="sidebar h-sidebar navbar-collapse collapse ace-save-state"
       	 style="margin-top: 0px;" data-sidebar="true" data-sidebar-scroll="true" data-sidebar-hover="true">
        	<script type="text/javascript">
            try {
               ace.settings.loadState('sidebar')
            } catch (e) {
            }
        	</script>
        	<ul class="nav nav-list" id="topMenuUl" style="min-height: 39px; top: 0px;">
   
        	</ul>
     	</div>
   	  <div class="main-content">
   		<div class="main-content-inner">   		
   			<div id="sidebar2" class="sidebar responsive" style="" data-sidebar="true" data-sidebar-scroll="true" data-sidebar-hover="true">
				
				<!-- 김정국 테스트 중 -->
				<div class="sidebar-shortcuts" id="sidebar-shortcuts" style="display:inline;">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large" style="padding:0px 0px 3px;">
						<button class="btn btn-success" onclick="javascript:newContents(1);" data-rel="tooltip" data-placement="bottom" title="New Mail" data-original-title="Bottm Info">
							<i class="ace-icon fa fa-envelope-square bigger-130"></i>
						</button>

						
					
						<button class="btn btn-info" onclick="javascript:newContents(2);" data-rel="tooltip" data-placement="bottom" title="New Approval Doc" data-original-title="Bottm Info">
							<i class="ace-icon fa fa-edit bigger-130"></i>
						</button>
						
						<button class="btn btn-warning" onclick="javascript:newContents(3);" data-rel="tooltip" data-placement="bottom" title="New Schedule" data-original-title="Bottm Info">
							<i class="ace-icon fa fa-calendar-plus-o bigger-130"></i>
						</button>
						
						<button class="btn btn-danger" onclick="javascript:newContents(4);" data-rel="tooltip" data-placement="bottom" title="New Task" data-original-title="Bottm Info">
							<i class="ace-icon fa fa-server bigger-130"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>
						<span class="btn btn-info"></span>
						<span class="btn btn-warning"></span>
						<span class="btn btn-danger"></span>
					</div>
				</div>
				
				
				<ul class="nav nav-list" style="top: 0px;">   <!-- 서브메누  -->
				</ul>
				<div class="sidebar-toggle sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
				<div id="sidebar-BG" class="" style="background-image: url(&quot;/resources/common/images/bg/laptop-228.jpg&quot;);">
				</div>
			</div> 		
 			
   