package com.groupware.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DynatreeVO {

	private String title; // 명칭 : "나대표/사장",
	
	@JsonProperty("isFolder") //변수명에 is가 붙으면 생략되는 것을 방지
	private boolean isFolder; // 폴더유형 : false,
	
	@JsonProperty("isLazy")//변수명에 is가 붙으면 생략되는 것을 방지
	private boolean isLazy; // false,
	private String key; // 고유번호 : "20180117182355" 
	private String type; // 구분 : "user"/"department"
	private DynatreeAddress address;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isFolder() {
		return isFolder;
	}
	public void setFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}
	public boolean isLazy() {
		return isLazy;
	}
	public void setLazy(boolean isLazy) {
		this.isLazy = isLazy;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public DynatreeAddress getAddress() {
		return address;
	}
	
	 public void setAddress(DynatreeAddress address) {
		this.address = address;
	}
		
	
}

