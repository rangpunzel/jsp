<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>

$('input#id').on('change',function(event){
	$('input[name=checkid]').val(0);
})

function idCheck_go(){
	var id= $('input#id').val();
	if(!id){
		alert("아이디를 입력하세요.");
		return;
	}
	$.ajax({
		url:"<%=request.getContextPath()%>/member/checkid.do",
		data:{"id":id},
		type:'post',
		dataType:'text',
		success:function(data){
				$('input[name="checkid"]').val(1);
				alert("사용 가능한 아이디입니다.");
		},
		error:function(error){
				alert("이미 사용중인 아이디 입니다.");	
				$('input#id').focus();
		}
	});
}

</script>