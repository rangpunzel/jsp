package com.spring.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.command.FileUploadCommand;
import com.spring.exception.EmptyMultipartFileException;
import com.spring.exception.OverflowFileSizeException;
import com.spring.utils.FileUpload;

@Controller
public class FileUploadController {
	
	@RequestMapping("/fileUploadForm")
	public void form() {}
	
	@RequestMapping(value = "/multipartFile", method = RequestMethod.POST)
	public String uploadByMultipartFile(String title, @RequestParam("file")MultipartFile multi,
										HttpServletRequest request, Model model)throws IOException{
		
		String url="fileUpload_success";
		
		try {
			File uploadFile = FileUpload.saveFile(multi,request);
			
			model.addAttribute("title", title);
			model.addAttribute("originalFileName", multi.getOriginalFilename());
			model.addAttribute("uploadedFileName", uploadFile.getName());
			model.addAttribute("uploadPath", uploadFile.getAbsolutePath());
		} catch (EmptyMultipartFileException | OverflowFileSizeException e) {
			e.printStackTrace();
			model.addAttribute("exception",e);
			url="fileUpload_fail";
		}
		return url;
	
	}
	
	
	@RequestMapping("multipartHttpServletRequest")
	public String uploadByMultipartHttpServletRequest(MultipartHttpServletRequest request, Model model)throws IOException{
		
		String url="fileUpload_success";
		
		String title = request.getParameter("title");
		MultipartFile multi = request.getFile("file");
		
		try {
			File uploadFile = FileUpload.saveFile(multi,request);
			
			model.addAttribute("title", title);
			model.addAttribute("originalFileName", multi.getOriginalFilename());
			model.addAttribute("uploadedFileName", uploadFile.getName());
			model.addAttribute("uploadPath", uploadFile.getAbsolutePath());
		} catch (EmptyMultipartFileException | OverflowFileSizeException e) {
			e.printStackTrace();
			model.addAttribute("exception",e);
			url="fileUpload_fail";
		}
		
		return url;
	}
	
	@RequestMapping(value="/commandObject",method=RequestMethod.POST)
	public String uploadByCommandObject(FileUploadCommand command, HttpServletRequest request, Model model)throws IOException{
		
		String url = "fileUpload_success";
		
		MultipartFile multi = command.getFile();
		String title = command.getTitle();
		
		try {
			File uploadFile = FileUpload.saveFile(multi,request);
			
			model.addAttribute("title", title);
			model.addAttribute("originalFileName", multi.getOriginalFilename());
			model.addAttribute("uploadedFileName", uploadFile.getName());
			model.addAttribute("uploadPath", uploadFile.getAbsolutePath());
		} catch (EmptyMultipartFileException | OverflowFileSizeException e) {
			e.printStackTrace();
			model.addAttribute("exception",e);
			url="fileUpload_fail";
		}
		
		return url;
	}
	
	
	
}











