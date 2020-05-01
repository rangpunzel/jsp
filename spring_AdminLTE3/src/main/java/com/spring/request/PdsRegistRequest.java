package com.spring.request;

import com.spring.dto.BoardVO;
import com.spring.dto.PdsVO;

public class PdsRegistRequest {
	
	private String writer;
	private String title;
	private String content;
	
	public PdsVO toPdsVO() {
		PdsVO pds = new PdsVO();
		pds.setTitle(title);
		pds.setWriter(writer);
		pds.setContent(content);
		return pds;
	}
	public PdsRegistRequest(String writer, String title, String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
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
	
	
	
}
