package com.jsp.request;

import com.jsp.dto.BoardVO;
import com.jsp.dto.PdsVO;

public class PdsModifyRequest {
	private int pno;
	private String writer;
	private String title;
	private String content;
	
	public PdsVO toPdsVO() {
		PdsVO pds = new PdsVO();
		pds.setPno(pno);
		pds.setTitle(title);
		pds.setWriter(writer);
		pds.setContent(content);
		return pds;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
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

	public PdsModifyRequest(int pno, String writer, String title, String content) {
		super();
		this.pno = pno;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
}
