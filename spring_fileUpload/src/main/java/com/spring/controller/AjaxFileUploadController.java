package com.spring.controller;

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.utils.FileUpload;
import com.spring.utils.MediaUtils;

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
		
		try {
			sourcePath = FileUpload.uploadFile(file, uploadPath);
			entity = new ResponseEntity<String>(sourcePath,HttpStatus.CREATED); //200
		}catch(Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		//파일에 저장하는 정보가 없는 컨트롤러면 중간에 인터셉터가 그 정보를 가지고 디비에 저장한다. 인터셉터도 프록시에 올라감
		
		return entity;
	}
	
	@RequestMapping(value="/deleteFile",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> deleteFile(@RequestBody Map<String,String> dataMap)throws Exception{
		
		ResponseEntity<String> entity=null;
		
		String fileName = dataMap.get("fileName");
		
		String formatName=fileName.substring(fileName.lastIndexOf(".")+1);
		System.out.println(formatName);
		MediaType mType=MediaUtils.getMediaType(formatName);
		
		try {
			if(mType!=null) {
				String front=fileName.substring(0,12);
				String end=fileName.substring(14);
				new File(uploadPath+(front+end).replace('/', File.separatorChar)).delete();
				
			}
				new File(uploadPath+fileName.replace('/', File.separatorChar)).delete();
				entity =new ResponseEntity<String>("deleted",HttpStatus.OK);
		}catch(Exception e) {
			entity=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			return entity;
	}
	
}