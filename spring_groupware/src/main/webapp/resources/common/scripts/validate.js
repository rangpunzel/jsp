
	$("#openDate, #closeDate, #sDate, #eDate").datepicker({})
	.on('changeDate', function(e) {
		var minDate = new Date(e.date.valueOf());
		//팝업기간
		if ($(this).attr('id') == 'sDate') {
			$('input[id=eDate]').datepicker('setStartDate', minDate);
		} else if ($(this).attr('id') == 'eDate') {
			$('input[id=sDate]').datepicker('setEndDate', minDate);
		//게시기간
		} else if ($(this).attr('id') == 'openDate') {
			$('input[id=closeDate]').datepicker('setStartDate', minDate);
		} else if ($(this).attr('id') == 'closeDate') {
			$('input[id=openDate]').datepicker('setEndDate', minDate);
		}
	});
	/*
	jQuery.validator.addMethod("datetimePeriod", function(value, element) {
		var sDateTime = $("#sDate").datepicker("getDate");
		var eDateTime = $("#eDate").datepicker("getDate");
		var isSTimePM = $("#sTimeAMPM").val() == "PM";
		var isETimePM = $("#eTimeAMPM").val() == "PM";
		var sTimeHour = parseInt($("#sTimeHour").val());
		var eTimeHour = parseInt($("#eTimeHour").val());
		var sTimeMinute = parseInt($("#sTimeMinute").val());
		var eTimeMinute = parseInt($("#eTimeMinute").val());
		if(isSTimePM) sTimeHour += 12;
		if(isETimePM) eTimeHour += 12;
		sDateTime.setHours(sTimeHour, sTimeMinute);
		eDateTime.setHours(eTimeHour, eTimeMinute);
	    return eDateTime > sDateTime;
	}, "기간선택이 올바르지 않습니다");
	*/
	
	
	// 영구보존 관련 추가
	var cdate = "";
	 $('#never').click(function() {		 
		 var ischecked = $('#never').is(":checked");
	      if(ischecked){
	          // 이전 값 보존 후, 영구설정.
	          cdate = $("#closeDate").val();
	          $("#closeDate").val( "-----" );
	          $("#openDate").attr("readonly", "true" );
	          $("#closeDate").prop("disabled", true );
	      }else{
	          // 이전 값 보존.
	   	   $("#closeDate").val( cdate );
	   	   $("#openDate").attr("readonly", "false");
	          $("#closeDate").removeAttr("readonly");
	      }
	   });
	 
	 function validCheck(){
			
		   	var isValid = validator.form();
		   	if(!isValid) validator.focusInvalid();
			return isValid;
		}
	 
	 validator = $("form[role='form']").validate({
			rules:{
				"witer":{ required:true },
				"title":{ required:true },
				"cotent":{ required:true },				
		 		"endDate":{ required:true }
			},
			messages:{
				"writer":{ required:"작성자를 입력해 주십시오 !" },
				"title":{ required:"제목을 입력해 주십시오 !" },
				"content":{ required:"내용을 입력해 주십시오 !" },				
				"endDate":{ required:"게시기간 종료일을 선택하십시요" }
			},
			focusInvalid:true
		});
