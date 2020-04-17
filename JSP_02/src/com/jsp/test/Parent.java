package com.jsp.test;

public class Parent {
	
	private static Parent instance = new Parent();
	public Parent() {	}
	public static Parent getInstance() {
		return instance;
	}
	
	private Child child;
	public void setChild(Child child) {
		this.child=child;
	}
	
	public String resultSum(int a, int b) throws Exception{
		String resultSum = "";
		int result = child.sum(a, b);
		
		resultSum = a + "와 "+b+"를 더한 결과는 "+ result+"입니다.";
		
		return resultSum;
	}
}
