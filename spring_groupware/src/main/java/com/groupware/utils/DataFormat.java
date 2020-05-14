package com.groupware.utils;

public class DataFormat {
	public static String parseSSN(String ssn) {
		ssn=ssn.substring(0,6)+"-"+ssn.substring(6);
		
		return ssn;
	}
	
	public static String parsePhone(String phone) {
		if(phone.length()>10) {
			phone=phone.substring(0,3)+"-"+phone.substring(3,7)+"-"+phone.substring(7);
		}else {
			phone=phone.substring(0,3)+"-"+phone.substring(3,6)+"-"+phone.substring(7);
		}
		return phone;
	}
}
