package com.groupware.dto;

public class DynatreeAddress {

	String type; // 사원 및 부서 구분 : "D"/"P"
	String dpid; // 고유번호 : "20051014163130",
	String dpname; // 부서명 : "경영지원부",
	String dporder; // 정렬 순서
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDpid() {
		return dpid;
	}
	public void setDpid(String dpid) {
		this.dpid = dpid;
	}
	public String getDpname() {
		return dpname;
	}
	public void setDpname(String dpname) {
		this.dpname = dpname;
	}
	public String getDporder() {
		return dporder;
	}
	public void setDporder(String dporder) {
		this.dporder = dporder;
	}

	
	

}
