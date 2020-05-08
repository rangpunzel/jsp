package com.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadImgController {
	
	@Resource(name="imgPath")
	private String imgPath;
	
	@RequestMapping(value="/uploadImg",produces="text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> uploadImg(MultipartFile file, HttpServletRequest request)throws Exception{
		
		ResponseEntity<String> result=null;
		
		int fileSize = 5 * 1024 * 1024;//5MB 제한
		if(file.getSize()>fileSize) {
			return new ResponseEntity<String>("용량 초과입니다",HttpStatus.BAD_REQUEST);
		}
		
		String savePath = this.imgPath;
		String fileName = UUID.randomUUID().toString().replace("-", "");
		String fileFormat = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		fileName = fileName+fileFormat;
		
		File saveFile = new File(savePath, fileName);
		
		if(!saveFile.exists()) {
			saveFile.mkdirs();
		}
		
		try {
			file.transferTo(saveFile);
			result = new ResponseEntity<String>(request.getContextPath()+"/getImg?fileName="+fileName,HttpStatus.OK);
		}catch(Exception e) {
			result = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@RequestMapping("/getImg")
	@ResponseBody
	public ResponseEntity<byte[]> getImg(String fileName)throws Exception{
		InputStream in=null;
		ResponseEntity<byte[]> entity=null;
		
		String savePath = this.imgPath;
		
		in=new FileInputStream(savePath+File.separator+fileName);
		
		try {
			entity=new ResponseEntity<byte[]>(IOUtils.toByteArray(in),HttpStatus.CREATED);
		}catch(IOException e) {
			e.printStackTrace();
			entity=new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}finally {
			in.close();
		}
		
		return entity;
	}
	
	@RequestMapping("/deleteImg")
	@ResponseBody
	public ResponseEntity<String> deleteImg(@RequestBody Map<String,String> data)throws Exception{
		ResponseEntity<String> result=null;
		
		String savePath = this.imgPath;
		String fileName = data.get("fileName");
		
		File target = new File(savePath+File.separator+fileName);
		
		if(!target.exists()) {
			result = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}else {
			try {
				target.delete();
				result=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
				result=new ResponseEntity<String>("FAIL",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return result;
	}
}
