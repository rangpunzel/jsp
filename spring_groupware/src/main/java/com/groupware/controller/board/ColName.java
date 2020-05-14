package com.groupware.controller.board;

public class ColName {
	private String colName;
	private String width;
	
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public ColName(String colName, String width) {
		super();
		this.colName = colName;
		this.width = width;
	}
	
}
