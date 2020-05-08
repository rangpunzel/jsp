package com.spring.request;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.PdsVO;

public class RegistPdsRequest {
	
	private String title;
	private String content;
	private String writer;
	private MultipartFile[] uploadFile;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public MultipartFile[] getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile[] uploadFile) {
		this.uploadFile = uploadFile;
	}
	@Override
	public String toString() {
		return "RegistPdsRequest [title=" + title + ", content=" + content + ", writer=" + writer + ", uploadFile="
				+ Arrays.toString(uploadFile) + "]";
	}
	public PdsVO toPdsVO() {
		PdsVO pds = new PdsVO();
		pds.setContent(this.content);
		pds.setTitle(this.title);
		pds.setWriter(this.writer);
		
		return pds;
	}
	
	
	
}
