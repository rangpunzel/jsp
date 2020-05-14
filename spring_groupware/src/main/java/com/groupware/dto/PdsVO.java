package com.groupware.dto;

import java.util.Date;
import java.util.List;

public class PdsVO {
	private int pno;
	private String title;
	private String content;
	private String writer;
	private int viewcnt;
	private Date regDate;
	private Date updatedate;
	private Date startDate;
	private Date endDate;
	private int point;
	
	
	private List<PdsShareVO> pdsShareList;
	private List<PdsAttachVO> attachList;



	public int getPno() {
		return pno;
	}



	public void setPno(int pno) {
		this.pno = pno;
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



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public int getViewcnt() {
		return viewcnt;
	}



	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}



	public Date getRegDate() {
		return regDate;
	}



	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}



	public Date getUpdatedate() {
		return updatedate;
	}



	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public int getPoint() {
		return point;
	}



	public void setPoint(int point) {
		this.point = point;
	}



	public List<PdsAttachVO> getAttachList() {
		return attachList;
	}



	public void setAttachList(List<PdsAttachVO> attachList) {
		this.attachList = attachList;
	}



	public List<PdsShareVO> getPdsShareList() {
		return pdsShareList;
	}



	public void setPdsShareList(List<PdsShareVO> pdsShareList) {
		this.pdsShareList = pdsShareList;
	}



	@Override
	public String toString() {
		return "PdsVO [pno=" + pno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", viewcnt="
				+ viewcnt + ", regDate=" + regDate + ", updatedate=" + updatedate + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", point=" + point + ", pdsShareList=" + pdsShareList + ", attachList="
				+ attachList + "]";
	}

}
