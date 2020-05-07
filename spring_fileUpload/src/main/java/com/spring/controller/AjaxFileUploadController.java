package com.spring.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.utils.FileUpload;

@Controller
public class AjaxFileUploadController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping("/ajaxFileUploadForm")
	public void ajaxFileUploadForm() {}
	
	//한글깨짐 방지
	@RequestMapping(value="/uploadAjax",method=RequestMethod.POST,produces="text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		
		ResponseEntity<String> entity=null;
	
		String sourcePath = null;
		
		sourcePath = FileUpload.uploadFile(file, uploadPath);
		
		entity = new ResponseEntity<String>(sourcePath,HttpStatus.CREATED); //200
		//파일에 저장하는 정보가 없는 컨트롤러면 중간에 인터셉터가 그 정보를 가지고 디비에 저장한다. 인터셉터도 프록시에 올라감
		
		return entity;
	}
	
}