package com.groupware.dto;

public class DynatreeAddressUser extends DynatreeAddress{
	

	String userid; // 아이디
	String username; // 이름
	String upname; // 직급
	String udname; // 직책
	String tel; // 집전화
	String cellTel; // 핸드폰번호
	String emailid; // 이메일주소
	String topdpname; // 부서명
	String sabun; // 사번

	
	public String getUpname() {
		return upname;
	}

	public void setUpname(String upname) {
		this.upname = upname;
	}

	public String getUdname() {
		return udname;
	}

	public void setUdname(String udname) {
		this.udname = udname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCellTel() {
		return cellTel;
	}

	public void setCellTel(String cellTel) {
		this.cellTel = cellTel;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getTopdpname() {
		return topdpname;
	}

	public void setTopdpname(String topdpname) {
		this.topdpname = topdpname;
	}

	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}
}
