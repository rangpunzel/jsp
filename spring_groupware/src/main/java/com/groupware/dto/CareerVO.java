package com.groupware.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CareerVO {
	private int cno; //번호
	private String id; //아이디
	private String coName; //회사명
	private String dept; //부서
	private String position; //직위
	private Date startDay; //입사일
	private Date endDay;//퇴사일
	private String job; //주요업무
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getStartDay() {
		return startDay;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public Date getEndDay() {
		return endDay;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}
	@Override
	public String toString() {
		return "CareerVO [cno=" + cno + ", id=" + id + ", coName=" + coName + ", dept=" + dept + ", position="
				+ position + ", startDay=" + startDay + ", endDay=" + endDay + ", job=" + job + "]";
	}
	
	
}
