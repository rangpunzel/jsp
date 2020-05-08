package com.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.utils.MediaUtils;

@Controller
public class DisplayFileController {
	
	@Resource(name="uploadPath")
	String uploadPath; //root-context에서 가져옴
	
	
	@RequestMapping(value="/displayFile",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		
		InputStream in=null;
		ResponseEntity<byte[]> entity=null;
		
		try {
			String formatName=fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType=MediaUtils.getMediaType(formatName);
			HttpHeaders headers=new HttpHeaders();
			
			fileName=fileName.replace('/', File.separatorChar);
			in=new FileInputStream(uploadPath+fileName);
			
			if(mType!=null) {
				headers.setContentType(mType);
			}else {
				fileName=fileName.substring(fileName.indexOf("$$")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment;filename=\""+new String(fileName.getBytes("utf-8"),"ISO-8859-1")+"\"");
			}
			
			entity=new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
		}catch(IOException e) {
			e.printStackTrace();
			entity=new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}finally {
			in.close();
		}
		return entity;
	}

}
