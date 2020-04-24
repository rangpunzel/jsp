<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
$('#registBtn').on('click',function(){
	
	var form=document.registForm;
/* 	
	var form = new FormData($('form[role="form"]')[0]);
		
	for(var a of form.values()){
		console.log(a.value);
	}
*/
	if(form.title.value==""){
		alert("제목은 필수입니다.");
		return;
	}
	form.submit();
	
});

</script>