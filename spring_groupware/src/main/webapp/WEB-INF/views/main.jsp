<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>



		<div class="page-content main-content" style="padding:0px;margin-left:0px;" >
			<div class="main-style hide" style="background: #fff; /* #fff;*/ /*#eef5f9;*/ ">				
				<div id="main-widget-container" style="padding: 10px 0px;">
					<div class="row" style="/*background-color:#f8f8f8;*/">
				        <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3" style="border-top:0px; border-bottom:0px; padding:4px 10px; border-bottom:0px;">
	    					<!-- log-in user info -->
		    				<div class="panel panel-default" style="height:128px; border: 1px solid #e5e5e5 !important;"> 
			    				<div class="panel-heading" style="padding:5px; text-align:center; border: none;">
				    					<h3 class="panel-title" style="font-size:12px; font-family: inherit;"><b>${loginUser.name } 님</b>
				    					 / 최근 접속 : <span id="lastLoginTime" style="font-size:10px;">
				    					 	<fmt:formatDate value="${loginUser.recentLoginTime }" pattern="yyyy-MM-dd HH:mm:dd"/>
				    					 </span>
				    					</h3>
				    					
				    			</div>
			    				<div class="panel-body" style="padding:3px;">  
<!-- 				        	<br/>최근 접속일시<br>: <span id="lastLoginTime" style="font-size:10px;"></span></span> -->								
									<div class="infobox infobox-blue2" onclick="onTopMenu('MENU0102', '');" role="button">
										<div class="infobox-icon">
											<i class="ace-icon fa fa-envelope"></i>
		<!-- 								icon-animated-bell icon-animated-vertical : 5초 동안. 0개가 아니면 해당 클래스 추가 -->
										</div>
	
										<div class="infobox-data">
											<span class="infobox-data-number" ><span class="widget_count_14" data-icon="fa-envelope">0</span> 개</span>
											<div class="infobox-content">읽지않은 메일</div>
										</div>
									</div>					
								<div class="infobox infobox-purple" onclick="onTopMenu('MENU020201', '');" role="button">
									<div class="infobox-icon">
										<i class="ace-icon fa fa-book"></i>
									</div>
									<div class="infobox-data">
										<span class="infobox-data-number"><span class="widget_count_1" data-icon="fa-book">0</span> 개</span>
										<div class="infobox-content">결재할 문서</div>
									</div>
								</div>
							
								<div class="infobox infobox-green" onclick="onTopMenu('MENU0411', '');" role="button">
									<div class="infobox-icon">
										<i class="ace-icon fa fa-calendar"></i>
									</div>
		
									<div class="infobox-data">
										<span class="infobox-data-number"><span class="widget_count_13" data-icon="fa-calendar">0</span> 개</span>
										<div class="infobox-content">개인.공유일정</div>
									</div>
								</div>				
							</div>
	    				</div>
					</div>
					<!--  skin image -->	
					<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6" style="borders:1px solid #000; padding:6px 6px 0px 16px;">				
						<div class="slider">	
							<img class="bx-clone" id="skinImage" width="100%" height="128" src="https://placeimg.com/682/128/tech" width="100%" height="128">
			        		<img class="bx-clone" id="skinImage" width="100%" height="128" src="https://placeimg.com/682/128/animal" width="100%" height="128">
			        		<img class="bx-clone" id="skinImage" width="100%" height="128" src="https://placeimg.com/682/128/arch" width="100%" height="128">
			        		<img class="bx-clone" id="skinImage" width="100%" height="128" src="https://placeimg.com/682/128/people" width="100%" height="128">
						</div>
						
					</div>						        
			        <!--  main content count -->
	      		 	<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3 infobox-container" style="padding:0px 0px 0px 3px;">				 
					 	<div class="widget-box" id="my-widget-37" style="border:0px !important; text-align:center; margin-top:5px; margin-bottom: 3px;">
							<a href="javascript:OpenWindow('/mail/mail_form.htm', '', '850', '620');" class="btn btn-app btn-primary btn-xs no-radius" style="border-radius: 3px !important; min-height: 62px; font-size:12px; swidth:63px; padding: 4px 2px 4px 2px  !important;">
								<i class="ace-icon fa fa-pencil-square-o bigger-180"></i>
								<span class="q-menu-span">편지작성</span>
							</a>
							<a href="javascript:onTopMenu('MENU020101', '');" class="btn btn-app btn-primary btn-xs no-radius" style="border-radius: 3px !important; min-height: 62px; font-size:12px; swidth:63px; padding: 4px 2px 4px 2px  !important;">
								<i class="ace-icon fa fa-star bigger-180"></i>
								<span class="q-menu-span">기안서 작성</span>
							</a>
							<a href="javascript:onTopMenu('MENU0411', '');" class="btn btn-app btn-primary btn-xs no-radius" style="border-radius: 3px !important; min-height: 62px; font-size:12px; swidth:63px; padding: 4px 2px 4px 2px  !important;">
								<i class="ace-icon fa fa-calendar bigger-180"></i>
								<span class="q-menu-span">일정관리</span>
							</a>
							<a href="javascript:onTopMenu('MENU070901', '');" class="btn btn-app btn-primary btn-xs no-radius" style="border-radius: 3px !important; min-height: 62px; font-size:12px; swidth:63px; padding: 4px 2px 4px 2px  !important;">
								<i class="ace-icon fa fa-star bigger-180"></i>
								<span class="q-menu-span">작업관리</span>
							</a>
							<a href="javascript:onTopMenu('MENU070206', '');" class="btn btn-app btn-primary btn-xs no-radius" style="border-radius: 3px !important; min-height: 62px; font-size:12px; swidth:63px; padding: 4px 2px 4px 2px  !important;">
								<i class="ace-icon fa fa-building-o bigger-180"></i>
								<span class="q-menu-span">자원 사용현황</span>
							</a>
							<a href="javascript:onTopMenu('MENU0112', '');" class="btn btn-app btn-primary btn-xs no-radius" style="border-radius: 3px !important; min-height: 62px; font-size:12px; swidth:63px; padding: 4px 2px 4px 2px  !important;">
								<i class="ace-icon fa fa-stack-overflow bigger-180"></i>
								<span class="q-menu-span">전체메일</span>
							</a>
							<a href="javascript:onTopMenu('MENU011702', '');" class="btn btn-app btn-primary btn-xs no-radius" style="border-radius: 3px !important; min-height: 62px; font-size:12px; swidth:63px; padding: 4px 2px 4px 2px  !important;">
								<i class="ace-icon fa fa-envelope-square bigger-180"></i>
								<span class="q-menu-span">쪽지</span>
							</a>
							<a href="javascript:onTopMenu('MENU0102', '');" class="btn btn-app btn-primary btn-xs no-radius" style="border-radius: 3px !important; min-height: 62px; font-size:12px; swidth:63px; padding: 4px 2px 4px 2px  !important;">
								<i class="ace-icon fa fa-envelope-o bigger-180"></i>
								<span class="q-menu-span">전자메일</span>
							</a>
						</div>				
					</div>
				</div>
		    </div>
			<div class="row" style="margin-top: 5px;">
				<div id="widget-container-1" class="col-xs-12 col-sm-3 col-md-3 col-lg-3 widget-container-col">				
					<div class="widget-box" id="20180508142423657">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-calendar  bigger-100"></i>오늘의 일정
							</h5>
							<div class="widget-toolbar">
								<a href="#" class="actionMore" data-link="onTopMenu('MENU04', 'MENU0411')"><i class="grey ace-icon fa fa-external-link-square"></i></a>
								<a href="javascript:;" class="actionRefresh" data-id="20180508142423657" data-url="/schedule/widget.htm?listcount=999&ctype=1&date=" data-type="sche"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180514180144254">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-newspaper-o  bigger-100"></i>영업공지
							</h5>
							<div class="widget-toolbar">
								
								<a href="javascript:;" class="actionRefresh" data-id="20180514180144254" data-url="/bbs/widget.htm?listCount=3&bbsId=bbs20180514174226" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180510170240404">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-rss-square brown bigger-100"></i>ZDNet Korea
							</h5>
							<div class="widget-toolbar">
								
								<a href="javascript:;" class="actionRefresh" data-id="20180510170240404" data-url="http://www.zdnet.co.kr/Include2/ZDNetKorea_News.xml?listCount=5" data-type="rss"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180510154020397">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-rss-square brown bigger-100"></i>미디어다음 IT과학
							</h5>
							<div class="widget-toolbar">
								
								<a href="javascript:;" class="actionRefresh" data-id="20180510154020397" data-url="http://media.daum.net/rss/part/primary/digital/rss2.xml?listCount=5" data-type="rss"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180508142916150">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-calendar  bigger-100"></i>생일자
							</h5>
							<div class="widget-toolbar">
								
								<a href="javascript:;" class="actionRefresh" data-id="20180508142916150" data-url="/schedule/widgetBirthday.htm" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180508143331598">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-money  bigger-100"></i>환율정보
							</h5>
							<div class="widget-toolbar">								
								<a href="javascript:;" class="actionRefresh" data-id="20180508143331598" data-url="https://spot.wooribank.com/pot/Dream?withyou=FXCNT0002&rc=0&divType=1&lang=KOR" data-type="iframe"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180508143048820">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-envelope  bigger-100"></i>전자메일
							</h5>
							<div class="widget-toolbar">
								<a href="#" class="actionMore" data-link="onTopMenu('MENU01', 'MENU0102')"><i class="grey ace-icon fa fa-external-link-square"></i></a>
								<a href="javascript:;" class="actionRefresh" data-id="20180508143048820" data-url="/mail/widget.htm?listCount=5" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180508143140580">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-book  bigger-100"></i>전자결재
							</h5>
							<div class="widget-toolbar">
								<a href="#" class="actionMore" data-link="onTopMenu('MENU02', 'MENU020201')"><i class="grey ace-icon fa fa-external-link-square"></i></a>
								<a href="javascript:;" class="actionRefresh" data-id="20180508143140580" data-url="/approval/widget.htm?listCount=5&ctype=1" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180508143352907">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-coffee orange bigger-100"></i>식단표
							</h5>
							<div class="widget-toolbar">
								<a href="#" class="actionMore" data-link="onTopMenu('MENU04', 'MENU0414')"><i class="grey ace-icon fa fa-external-link-square"></i></a>
								<a href="javascript:;" class="actionRefresh" data-id="20180508143352907" data-url="/schedule/widget_menu.htm" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
				</div>		
				<div id="widget-container-2" class="col-xs-12 col-sm-6 col-md-6 col-lg-6 widget-container-col">
					<div class="widget-box" id="20180514180043856">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-newspaper-o  bigger-100"></i>관리공지
							</h5>
							<div class="widget-toolbar">
								
								<a href="javascript:;" class="actionRefresh" data-id="20180514180043856" data-url="/bbs/widget.htm?listCount=3&bbsId=bbs20180514174246" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180510170930703">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-rss-square brown bigger-100"></i>구글 뉴스
							</h5>
							<div class="widget-toolbar">
								
								<a href="javascript:;" class="actionRefresh" data-id="20180510170930703" data-url="https://news.google.com/news/rss/?ned=kr&gl=KR&hl=ko&listCount=5" data-type="rss"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180508143245760">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-rss orange bigger-100"></i>공지사항
							</h5>
							<div class="widget-toolbar">
								<a href="#" class="actionMore" data-link="onTopMenu('MENU05', 'MENU0513')"><i class="grey ace-icon fa fa-external-link-square"></i></a>
								<a href="javascript:;" class="actionRefresh" data-id="20180508143245760" data-url="/bbs/widget.htm?listCount=3&bbsId=bbs00000000000000" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180508143205315">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-comments  bigger-100"></i>최근게시글
							</h5>
							<div class="widget-toolbar">
								<a href="#" class="actionMore" data-link="onTopMenu('MENU05', 'MENU0512')"><i class="grey ace-icon fa fa-external-link-square"></i></a>
								<a href="javascript:;" class="actionRefresh" data-id="20180508143205315" data-url="/bbs/widget_board.htm?endNum=10" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180508143228430">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-archive  bigger-100"></i>문서관리
							</h5>
							<div class="widget-toolbar">
								<a href="#" class="actionMore" data-link="onTopMenu('MENU03', 'MENU0301')"><i class="grey ace-icon fa fa-external-link-square"></i></a>
								<a href="javascript:;" class="actionRefresh" data-id="20180508143228430" data-url="/dms/widget.htm?listCount=5&listMode=alllist" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
				</div>
				<div id="widget-container-3" class="col-xs-12 col-sm-3 col-md-3 col-lg-3 widget-container-col">
					<div class="widget-box" id="20180510151356365">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-bullhorn green bigger-100"></i>경조사
							</h5>
							<div class="widget-toolbar">
								<a href="#" class="actionMore" data-link="onTopMenu('MENU05', 'MENU05bbs20180514164254');"><i class="grey ace-icon fa fa-external-link-square"></i></a>
								<a href="javascript:;" class="actionRefresh" data-id="20180510151356365" data-url="/bbs/widget.htm?listCount=5&bbsId=bbs20180514164254" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180510140357997">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-users  bigger-100"></i>전자결재현황									
							</h5>
							<div class="widget-toolbar">
								
								<a href="javascript:;" class="actionRefresh" data-id="20180510140357997" data-url="/approval/widgetCount.htm" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180509113829182">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-pencil-square  bigger-100"></i>Hot Links
							</h5>
							<div class="widget-toolbar">
								<a href="#" class="actionMore" data-link="onTopMenu('MENU08', 'MENU0804');"><i class="grey ace-icon fa fa-external-link-square"></i></a>
								<a href="javascript:;" class="actionRefresh" data-id="20180509113829182" data-url="/configuration/utilityWidget.htm?listCount=10" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180510151547659">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-cubes blue bigger-100"></i>TQM Links
							</h5>
							<div class="widget-toolbar">
								<a href="#" class="actionMore" data-link="onTopMenu('MENU05', 'MENU05bbs20180514164323');"><i class="grey ace-icon fa fa-external-link-square"></i></a>
								<a href="javascript:;" class="actionRefresh" data-id="20180510151547659" data-url="/bbs/widget.htm?listCount=5&bbsId=bbs20180514164323" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180508143407617">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-ship orange bigger-100"></i>휴가현황
							</h5>
							<div class="widget-toolbar">
								
								<a href="javascript:;" class="actionRefresh" data-id="20180508143407617" data-url="/configuration/widget_vacation.htm" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180510144105343">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-line-chart  bigger-100"></i>2017년 월별 계획 및 실적
							</h5>
							<div class="widget-toolbar">
								
								<a href="javascript:;" class="actionRefresh" data-id="20180510144105343" data-url="/commons/getChatData3.htm" data-type="chart.line"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>					
					<div class="widget-box" id="20180508143426418">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-bars orange bigger-100"></i>작업관리
							</h5>
							<div class="widget-toolbar">
								<a href="#" class="actionMore" data-link="onTopMenu('MENU07', 'MENU070901')"><i class="grey ace-icon fa fa-external-link-square"></i></a>
								<a href="javascript:;" class="actionRefresh" data-id="20180508143426418" data-url="/todo/widget.htm?listCount=6&dscd=20&stcd='10','20'" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>
					<div class="widget-box" id="20180508143001844">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-bar-chart  bigger-100"></i>설문조사	
							</h5>
							<div class="widget-toolbar">
								<a href="#" class="actionMore" data-link="onTopMenu('MENU07','MENU070302')"><i class="grey ace-icon fa fa-external-link-square"></i></a>
								<a href="javascript:;" class="actionRefresh" data-id="20180508143001844" data-url="/poll/widget.htm?pollState=2&pollId=00000000000000&rowCnt=5&workType=1" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
							</div>
						</div>
						<div class="widget-body"></div>
					</div>		
					<div class="widget-box" id="20180510151631339">
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 class="widget-title" style="font-family: inherit;"> 
								<i class="ace-icon fa fa-check blue bigger-100"></i>Hot News										
							</h5>
						<div class="widget-toolbar">
							<a href="#" class="actionMore" data-link="onTopMenu('MENU05', 'MENU05bbs20180514164344');"><i class="grey ace-icon fa fa-external-link-square"></i></a>
							<a href="javascript:;" class="actionRefresh" data-id="20180510151631339" data-url="/bbs/widget.htm?listCount=5&bbsId=bbs20180514164344" data-type="html"><i class="ace-icon fa fa-refresh"></i></a>
						</div>
					</div>
					<div class="widget-body"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- main end -->
	<div id="if_list_div" style="position:relative;padding:0;" class="hide">
			<iframe id="if_list" name="if_list" frameborder="0" scrolling="0" src="" style="position: absolute; top: 0px; left: 0px; bottom: 0px; height: 830px; width: 100%; border: 0px;"></iframe>
		</div>	
	</div>		
