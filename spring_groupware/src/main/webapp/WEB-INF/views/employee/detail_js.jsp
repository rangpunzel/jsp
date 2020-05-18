<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>

$('input,textArea').prop("readonly",true).css("border","0px");


$('label[for="careers"]').css({	
	"height":$('div#coName').height()+14,
	"line-height":$('div#coName').height()-2+"px"
});


$('label[for="attach"]').css({	
	"height":$('div[data-role="attach"]').height()+9,
	"line-height":$('div[data-role="attach"]').height()-2+"px"
});


function modify_go(){
	self.location="modify?id=${employee.id}";
}
</script>




