package com.groupware.dto;

public class PdsShareVO {
	private int sno; //쉐어번호
	private int pno; // 본문번호
	private String diff; //구분 P:사원, D:부서
	private String identity; // 아이디 혹은 부서번호
	private String name; // 이름 혹은 부서명
	
	public PdsShareVO() {}
	public PdsShareVO(int pno, String diff, String identity,String name) {
		super();
		this.pno = pno;
		this.diff = diff;
		this.identity = identity;
		this.name=name;
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getDiff() {
		return diff;
	}
	public void setDiff(String diff) {
		this.diff = diff;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PdsShareVO [sno=" + sno + ", pno=" + pno + ", diff=" + diff + ", identity=" + identity + ", name="
				+ name + "]";
	}	
}
