package com.jsp.test;

public class Main {

	public static void main(String[] args) {
		
		Parent parent = Parent.getInstance();
		
		String result="";
		try {
			result=parent.resultSum(4, 5);
		} catch (Exception e) {
			e.printStackTrace();
			result="오류가 발생했습니다.";
		}
		
		System.out.println(result);
		
	}

}
