package com.jsp.request;

//VO는 데이터베이스를 받아오려고 쓰는거.
//사용자에게 받아오는 데이터는 언제든지 바뀔수있음. ex)수정할떄는 스트링으로 받아오는걸 삭제에서는 int로 받아올수도 있다. 그래서 걍 request를 만든거임.
public class DeleteReplyRequest {
	private int bno;
	private int rno;
	private int page;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	

}
