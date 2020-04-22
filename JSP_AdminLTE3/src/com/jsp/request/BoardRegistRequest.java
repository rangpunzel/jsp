package com.jsp.request;

import com.jsp.dto.BoardVO;

public class BoardRegistRequest {
	private String title;
	private String writer;
	private String content;
	
	public BoardVO toBoardVO() {
		BoardVO board = new BoardVO();
		//board.setBno(bno);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
/*		board.setViewcnt(viewcnt);
		board.setRegDate(regDate);
		board.setUpdatedate(updatedate);
		board.setReplycnt(replycnt);*/
		
		return board;
	}
	
	public BoardRegistRequest() {	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardRegistRequest [title=" + title + ", writer=" + writer + ", content=" + content + "]";
	}

	public BoardRegistRequest(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	
	
	
	
	
}
