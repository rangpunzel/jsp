<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
/* 사진 업로드 */
$('input#picture').on('change',function(event){
	var fileFormat=this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
	//이미지 확장자 jpg 확인
	if(fileFormat!="JPG"){
		alert("이미지는 jpg 형식만 가능합니다.");
		return;
	}
	//이미지 파일 용량 체크
	if(this.files[0].size>1024*1024*1){
		alert("사진 용량은 1MB 이하만 가능합니다.");
		return;
	}
	
	if(this.files && this.files[0]){
		
		var reader = new FileReader();
		
		reader.onload = function (e){
			//이미지 미리보기
			$('div#picturePreView').css({
				'background-image':'url('+e.target.result+')',
				'background-position':'center',
				'background-size':'cover',
				'background-repeat':'no-repeat'
			});
		}
		
		reader.readAsDataURL(this.files[0]);
	}
	
});

/* 아이디 중복체크 */
function CheckID(){
	var id= $('input#id').val();
	if(!id){
		alert("아이디를 입력하세요.");
		return;
	}
	$.ajax({
		url:"<%=request.getContextPath()%>/employee/regist/checkId",
		data:{"id":id},
		type:'post',
		dataType:'text',
		success:function(data){
			$('input[name="checkID"]').val(id);
			alert("중복된 아이디가 없습니다.");
		},
		error:function(error){
			alert("이미 사용중인 아이디입니다.");
			$('input#id').focus();
		}
	});
}



/* 직접입력 선택하면 계정선택 비활성화 활성화 */
$('input#directInput').on('change',function(event){
	if($('input#directInput').prop("checked")){
		$('select[name=email]').prop('disabled',true);
	}else{
		$('select[name=email]').prop('disabled',false);
	}
});

/* 주소검색 */
function SearchAddress(){
	$('#postCode').val("");
	$('input[name=address1]').val("");
	
    new daum.Postcode({
        oncomplete: function(data) {
        	$('#postCode').val(data.zonecode);
        	$('input[name=address1]').val(data.address);
        }
    }).open();
}

/* 데이트픽커 */
$('#regDate').datepicker("option", "minDate", $("#regDate").val() );

/* 사원번호 자동완성 */
$('#eno').on('click',function(){
	//입사일
	var reg=$('#regDate').val().replace(/-/gi, "").substring(2)
	//부서번호
	var dept=$("select[name=dept_no] option:selected").val();
	
	$.ajax({
		url:"<%=request.getContextPath() %>/employee/regist/getDeptCount",
		data:{"dept":dept},
		type:'post',
		dataType:'text',
		success:function(data){
			
			var cnt='00'+data;
			cnt=cnt.slice(-3);
			
			$('#eno').val(reg+dept+cnt);
			
		},
		error:function(error){
			alert("값을 가져오지 못했음");
		}
	});

});


/* 경력추가 */
function RegistCareer(){
	var input1=$('<input>').attr({"class":"col-sm-2","type":"text","name":"coname"}).css("display","inline"); 
	var input2=$('<input>').attr({"class":"col-sm-4","type":"text","name":"job"}).css("display","inline"); 
	var input3=$('<input>').attr({"class":"col-sm-1","type":"text","name":"dept"}).css("display","inline"); 
	var input4=$('<input>').attr({"class":"col-sm-1","type":"text","name":"position"}).css("display","inline"); 
	var input5=$('<input>').attr({"class":"col-sm-3","type":"text","name":"day"}).css("display","inline"); 
	var div=$('<div>').addClass("inputRow");
	div.append(input1).append(input2).append(input3).append(input4).append(input5).append("<button style='border:0;outline:0;' class='col-sm-1 btn btn-xs btn-danger' type='button'>X</button");
	div.appendTo('.g_value.row');
}

$('div.row').on('click','div.inputRow > button',function(event){
	$(this).parent('div.inputRow').remove();
});


</script>