<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>

$('input#id').on('change',function(event){
	$('input[name=checkid]').val(0);
})

function idCheck_go(){
	var id= $('input#id').val();
	
	$.ajax({
		url:"<%=request.getContextPath()%>/member/checkid",
		data:{"id":id},
		type:'post',
		dataType:'text',
		success:function(data){
			if(data==id){
				$('input[name="checkid"]').val(1);
				alert("사용 가능한 아이디입니다.");
			}else{
				alert("이미 사용중인 아이디 입니다.");	
			}
		},
		error:function(xhr,exception){
			alert("파일 업로드를 실패했습니다.");
		}
	});
}

</script>