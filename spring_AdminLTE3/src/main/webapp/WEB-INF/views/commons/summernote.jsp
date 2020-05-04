<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.css">
</head>

<!-- Summernote -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.js"></script>
<script>
	$(function(){ /* 문서 다 읽고 실행, JS가 footer에 있으면 실행이 안됨 */
		$('#content').summernote({
			placeholder:'여기에 내용을 적으세요.',
			height:250,
			callbacks:{
				onImageUpload : function(files, editor, welEditable){
					//alert("image selected!");
					for(var i = files.length - 1;i>=0;i--){
						if(files[i].size > 1024*1024*5){
							alert("이미지는 5MB 미만입니다.");
							return;
						}
						for (var i=files.length -1;i>=0;i--){
							sendFile(files[i], this);
						}
					}
				},
				onMediaDelete : function(target){
					//alert("image delete");
					deleteFile(target[0].src);
				}
			}
		});
	});
	
	function sendFile(file, el){
		
		var form_data = new FormData();
		form_data.append("file",file);
		
		$.ajax({
			data: form_data,
			type:"POST",
			url:'<%=request.getContextPath()%>/uploadImg.do',
			cache:false,
			contentType:false,
			processData:false,
			success:function(img_url){
				/* editor.insertImage 이미지태그를 생성해줌 */
				$(el).summernote('editor.insertImage',img_url);
			}
	 	});
	}
	
	function deleteFile(src){
		var splitSrc=src.split("=");
		var fileName = splitSrc[splitSrc.length-1];
		
		//alert(fileName);
		var fileData = {
				fileName:fileName
		}
		
		$.ajax({
			url:"<%=request.getContextPath()%>/deleteImg.do",
			data : JSON.stringify(fileData),
			type:"post",
			success:function(res){
				console.log(res);
			}
		});
	}
</script>