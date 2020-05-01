package com.spring.request;

import com.spring.dto.BoardVO;

public class BoardModifyRequest {
	private int bno;
	private String title;
	private String writer;
	private String content;
	
	public BoardVO toBoardVO() {
		BoardVO board = new BoardVO();
		board.setBno(bno);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
/*		board.setViewcnt(viewcnt);
		board.setRegDate(regDate);
		board.setUpdatedate(updatedate);
		board.setReplycnt(replycnt);*/
		
		return board;
	}
	
	public BoardModifyRequest() {	}

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

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	@Override
	public String toString() {
		return "BoardModifyRequest [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ "]";
	}

	public BoardModifyRequest(int bno, String title, String writer, String content) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}


	
	
	
	
	
	
}
