package com.groupware.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuVO {
	@JsonProperty("mCode")
	private String mCode;
	private String codeName;
	private String url;
	private String upCode;
	private String iconFile;	
	private int enable;
	private int isCategory;
	private int urlFlag;
	private String iconColor;
	private int codeLevel;
	private String jsText;
	
	
	private List<MenuVO> subMenuCode;

	public String getMCode() {
		return mCode;
	}

	public void setMCode(String mCode) {
		this.mCode = mCode;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconFile() {
		return iconFile;
	}

	public void setIconFile(String iconFile) {
		this.iconFile = iconFile;
	}

	
	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getIsCategory() {
		return isCategory;
	}

	public void setIsCategory(int isCategory) {
		this.isCategory = isCategory;
	}

	public int getUrlFlag() {
		return urlFlag;
	}

	public void setUrlFlag(int urlFlag) {
		this.urlFlag = urlFlag;
	}

	public String getIconColor() {
		return iconColor;
	}

	public void setIconColor(String iconColor) {
		this.iconColor = iconColor;
	}

	public int getCodeLevel() {
		return codeLevel;
	}

	public void setCodeLevel(int codeLevel) {
		this.codeLevel = codeLevel;
	}

	public List<MenuVO> getSubMenuCode() {
		return subMenuCode;
	}

	public void setSubMenuCode(List<MenuVO> subMenuCode) {
		this.subMenuCode = subMenuCode;
	}

	public String getmCode() {
		return mCode;
	}

	public void setmCode(String mCode) {
		this.mCode = mCode;
	}

	public String getJsText() {
		return jsText;
	}

	public void setJsText(String jsText) {
		this.jsText = jsText;
	}

	public String getUpCode() {
		return upCode;
	}

	public void setUpCode(String upCode) {
		this.upCode = upCode;
	}

	@Override
	public String toString() {
		return "MenuVO [mCode=" + mCode + ", codeName=" + codeName + ", url=" + url + ", upCode=" + upCode
				+ ", iconFile=" + iconFile + ", enable=" + enable + ", isCategory=" + isCategory + ", urlFlag="
				+ urlFlag + ", iconColor=" + iconColor + ", codeLevel=" + codeLevel + ", jsText=" + jsText
				+ ", subMenuCode=" + subMenuCode + "]";
	}

	
	
	
	
}
