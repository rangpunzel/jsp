<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>



<!-- inline scripts related to this page end -->

<script type="text/javascript">
	function validCheck(){
		
    	var isValid = validator.form();
    	if(!isValid) validator.focusInvalid();
		return isValid;
	}
	
	function docSubmit(){
		var form = document.getElementById("modifyForm");
		// setEditorForm(); // 에디터의 데이터를 폼에 삽입
        if (!validCheck()) return false;
		if (!confirm("저장 하시겠습니까?")) return false;

		$(window).unbind("beforeunload");
		
		$("#closeDate").removeAttr("disabled");
		
		
		waitMsg();	/* Processing message */
		
		if ($('.template-upload') && $('.template-upload').length > 0) {
			//$('#fileuploadstartconfirm').val(1);
			$('.fileupload-buttonbar').find('.start').click();
//			$('button[type=submit]').click();
			//return false;
		} else {			
			controlSubmit(form);			
		}
		
	}

	function goSubmit(cmd,docId){ 
		var frm = document.getElementById("modifyForm");
		switch(cmd) {
			case "post":				 
				//if (!docSubmit()) return;
				docSubmit();
				//frm.submit();
				break;
			case "close":
				if(confirm("편집중인 문서는 저장되지 않습니다 !\n창을 닫으시겠습니까 ?")){
					window.close();
				}
				return;
				break;
			default:
				return;
				break;
		}
	}
	
</script>
<script type="text/javascript">
var validator = null;
$(document).ready(function(){
	
	inputHiddenTagMove();	//ace theme - checkbox 오류해결을 위한 함수
	
	
	pageScroll();	// page Scroll을 위해 사용. 2013-08-31
	
	setTimeout( "popupAutoResize2();", "500");		//팝업창 resize
	
	fnSendCheck();
});

fnChangeCategory();
function fnChangeCategory(){
	var form = $("#modifyForm");	
	form.attr("enctype","application/x-www-form-urlencoded");
	form.attr("action","modify");
	form.attr("method","post");
}

</script>




