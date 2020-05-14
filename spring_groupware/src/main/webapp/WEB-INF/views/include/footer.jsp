<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



 		</div>
	</div>
</div>

 
<!-- ace settings handler -->
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/garam-extra.min.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/html5shiv.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/respond.js"></script>
<![endif]-->


<!--[if !IE]> -->
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jquery.min.js"></script>
<!-- <![endif]-->

<!--[if IE]>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jquery1x.min.js"></script>
<![endif]-->

<script type="text/javascript">
	if('ontouchstart' in document.documentElement) document.write("<script src='<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/bootstrap.min.js"></script>
<!-- page specific plugin scripts start -->
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jquery-ui.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/bootbox.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/jquery-cookie/jquery.cookie.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/date-time/locales/bootstrap-datepicker.kr.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/jquery.gritter.min.js"></script>



<script src='<%=request.getContextPath()%>/resources/common/scripts/index.js' type="text/javascript"></script>
<!-- page specific plugin scripts end -->

<!-- ace scripts -->
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/garam-elements.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/libs/garam-admin-template/1.3.5/dist/js/garam.min.js"></script>

<!-- inline scripts related to this page start -->
<script src="<%=request.getContextPath()%>/resources/common/libs/bxslider/4.1.2/jquery.bxslider.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/scripts/common.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/scripts/garam.garam.js"></script>
<script src="<%=request.getContextPath()%>/resources/common/scripts/parent.reload.js"></script>
<!-- <script src="/configuration/dataModulesWidgetJson.htm"></script> -->

<script src="<%=request.getContextPath()%>/resources/common/libs/jquery-i18n-properties/1.2.7/jquery.i18n.properties.min.js"></script>
<script>
$(document).ready(function() {
	
	
	var containerFixed = true;
    ace.settingFunction.main_container_fixed(null, containerFixed);
    
    $('#ace-settings-add-container').change(function() {
        var value = $(this).is(":checked");
        setAceSetting("containerFixed", value); //garam.garam.js
    });
    
    loadSidebar("${empty mCode ? 'MENU00' : mCode}");
 	switchSidebar("${empty mCode ? 'MENU00' : mCode}"); 
    
    //skin save (no-skin: #438EB9, skin-1: 222a2d, skin-2: #C6487E, skin-3: #D0D0D0)
    $('.colorpick-btn').click(function() {
        var value = $(this).attr("data-color");
        //$.cookie('g_color', value);
        setAceSetting("skinColor", value); //garam.garam.js
    });
	
    $(window).bind('resize', function() { setTimeout(function() {
        ifListHeight();
    }, 0);}).trigger('resize');
    
    $("#if_list").on("load", function() { ifListHeight(); });
   
    initHash(); //헤쉬링크 처리   
    
   
  
  	
    var mCode='MENU00' 
	
	
	//clock
    setClock("ko");	//언어설정 추가   
      
    
    $.ajax({
		url: "<%=request.getContextPath()%>/commons/topMenuHql",
		dataType: "json",
		success: function(data) {			
		     $("#topMenuUl").html(menuA(data,"${mCode==null ? 'MENU00' : mCode }"));		     
		     <c:if test="${!empty mCode}" >
		     	onTopMenu('${mCode}','${mCode.substring(0,6)}');		     	
		     	if('${mCode}'.length>6) {
		     		reURL('${mCode}');
		     		onSubMenu('${mCode}');
		     	}
		     </c:if>
		     <c:if test="${empty mCode}">
		     	onTopMenu('MENU00','');
		     </c:if>
		},
		error:function(){
			alert("로그인하세요");
			location.href="<%=request.getContextPath()%>/commons/login";
		}
		
	});
    
    setInterval(function() {
		autoBgChange()
	}, 7000);
    
    $('.sidebar').data("ace_sidebar_hover").settings.sub_hover_delay = 300;
    
    $('.slider').bxSlider({
        controls: false,
        auto: true,
        autoControls: false,
        touchEnabled: true,
    	pager: false,
//    		slideWidth: 600,
        autoReload: true,
    	pause: 8000
    }).show();
  

});


ShowUserInfoSet();

function autoBgChange() {
	var number = Math.floor(Math.random() * 10) + 1;
	var bgList = 	["url('<%=request.getContextPath()%>/resources/common/images/bg/sunset-228.jpg')",
					"url('<%=request.getContextPath()%>/resources/common/images/bg/computer-228.jpg')",
					"url('<%=request.getContextPath()%>/resources/common/images/bg/golden-gate-bridge-228.jpg')",
					"url('<%=request.getContextPath()%>/resources/common/images/bg/ipad-228.jpg')",
					"url('<%=request.getContextPath()%>/resources/common/images/bg/landscape-228.jpg')",
					"url('<%=request.getContextPath()%>/resources/common/images/bg/laptop-228.jpg')",
					"url('<%=request.getContextPath()%>/resources/common/images/bg/macbook-228.jpg')",
					"url('<%=request.getContextPath()%>/resources/common/images/bg/workstation-228.jpg')",
// 					"url('<%=request.getContextPath()%>/resources/common/images/bg/sunset-3-228.jpg')",
// 					"url('<%=request.getContextPath()%>/resources/common/images/bg/red-rose-228.jpg')",
					"url('<%=request.getContextPath()%>/resources/common/images/bg/busan-night-scene-228.jpg')",
// 					"url('<%=request.getContextPath()%>/resources/common/images/bg/sunset-228.jpg')",
					"url('<%=request.getContextPath()%>/resources/common/images/bg/lion-228.jpg')"];
	
	$("div#sidebar-BG").css("background-image" , bgList[number] );
}

</script>

</body>








    