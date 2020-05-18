<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<script>
	//날짜 datepicker
	$('input[data-target="year"]').datepicker({});
	
	/* 이메일 직접선택 */
	$('#directInput').on('change',function(){
		if($(this).prop("checked")){			
			$('select[name="email"]').prop("disabled",true);
		}else{
			$('select[name="email"]').prop("disabled",false);			
		}
	});
	
	/* 사진업로드 */
	$('input[name="picture"]').on('change',function(){
		$('input[name="checkUpload"]').val(0);
		
		//이미지 확장자 jpg 확인
		var fileFormat=
			this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
		if(fileFormat!="JPG" && fileFormat!="JPEG"){
			alert("이미지는 jpg 형식만 가능합니다.");			
			return false;
		}
		
		//이미지 파일 용량 체크
		if(this.files[0].size>1024*1024*1){
			alert("사진 용량은 1MB 이하만 가능합니다.");
			return false;
		};	
		
		if (this.files && this.files[0]) {
			
	        var reader = new FileReader();
	        
	        reader.onload = function (e) {
	        	//이미지 미리보기	        	
	        	$('div#picturePreView')
	        	.css({'background-image':'url('+e.target.result+')',
					  'background-position':'center',
					  'background-size':'cover',
					  'background-repeat':'no-repeat'
	        		});
	        }
	        
	        reader.readAsDataURL(this.files[0]);
		}
	});	
	
</script>

<!-- 주소 검색 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function SearchAddress(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	 // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }                

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("postCode").value = data.zonecode;
                document.getElementById("address[0]").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("address[1]").focus();
	        }
	    }).open();
    }
</script>


<!-- 경력사항 추가 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.3/handlebars.min.js" ></script>
<script id="year-template" type="text/x-handlebars-template">
	<div class="no-padding" name="career[{{index}}].year" style="text-align:center;">
		<input class="col-xs-6" type="text" readonly data-target="year" name="careers[{{index}}].startDay" style="text-align:center;" placeholder="입사일"/>	
		<span class="col-xs-1 text-center" style="margin:0;padding:0;">~</span>							
		<input class="col-xs-5" type="text" readonly data-target="year" name="careers[{{index}}].endDay" style="text-align:center;" placeholder="퇴사일"/>
	</div>
</script>
<script id="remove-template" type="text/x-handlebars-template">
	<div class="col-sm-12" >
		<button type="button" name="{{index}}" class="checkbox btn btn-xs btn-danger remove" style="margin-bottom:2px;"><b>X</b></button><br/>
	</div>
</script>

<script>
var careerIndex=${careers.size()};
//compile the template


// 경력 추가 
function RegistCareer(){
	
	var names = ["coName","job","dept","position"];
	var input;	
			
	for(var i=0; i<names.length; i++){
		input=$('<input>').attr({
			"type":"text",
			"name":"careers["+careerIndex+"]."+names[i]
		}).css({
			"textAlign":"center",
			"width":"100%"		
		});
		
		$('div#'+names[i]).append(input);
	}
	
	var career_year= Handlebars.compile($('#year-template').html());
	var career_remove= Handlebars.compile($('#remove-template').html());
	$('div#year').append(career_year({index:careerIndex}));
	$('div#remove').append(career_remove({index:careerIndex}));	
	
	labelHight();
	$('input[data-target="year"]').datepicker({});
	careerIndex++;
	
}

// 경력삭제 버튼 이벤트 
$('div#remove').on('click','button',function(){
	$('input[name="careers['+this.name+'].coName"]').remove();
	$('input[name="careers['+this.name+'].job"]').remove();
	$('input[name="careers['+this.name+'].dept"]').remove();
	$('input[name="careers['+this.name+'].position"]').remove();
	$('div[name="careers['+this.name+'].year"]').remove();	
	$(this).parent('div').remove();
});

//첨부문서파일 추가 이벤트
$('div[data-role="attach"] button.btn-info').on('click',function(){
	$('input[name='+$(this).attr('name')+']').click();	
});
$('div[data-role="attach"] input[type="file"]').on('change',function(){
	$('input[name="view_'+$(this).attr("name")+'"]').val(this.value);
});


//첨부문서파일 삭제 이벤트
$('div[data-role="attach"] button.btn-danger').on('click',function(){
	$('input[name="'+$(this).attr("data-role")+'"]').val("");
	$('input[name="old_'+$(this).attr("data-role")+'"]').val("");
	$('input[name="view_'+$(this).attr("data-role")+'"]').val("");
	
});



//라벨 높이 조정
labelHight();
function labelHight(){
	$('label[for="careers"]').css({	
		"height":$('div#coName').height()+15,
		"line-height":$('div#coName').height()-2+"px"
	});
	
	
	$('label[for="attach"]').css({	
		"height":$('div[data-role="attach"]').height()+4,
		"line-height":$('div[data-role="attach"]').height()-2+"px"
	});
	
	
}

function addDocument(msg,target){
	if(confirm(msg)){
		$('div[name="'+target+'"]').css("display","block");
		$('button[name="'+target+'"]').css("display","none");
	}
}
</script>


<!-- form submit -->
<script>
function goSubmit(cmd){ 
	var frm = document.getElementById("modifyForm");
	switch(cmd) {
		case "post":
			docSubmit();			
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

function validCheck(){
	
   	var isValid = validator.form();
   	if(!isValid) validator.focusInvalid();
	return isValid;
}

var fileFormData = new FormData();
var modifyForm = $('form#modifyForm');
var validator = null;




function docSubmit(){
	var form = document.getElementById("modifyForm");
	// setEditorForm(); // 에디터의 데이터를 폼에 삽입
    if (!validCheck()) return false;
	if (!confirm("저장 하시겠습니까?")) return false;

	$(window).unbind("beforeunload");
	
	
	waitMsg();	/* Processing message */
	
	form.submit();
}


</script>








