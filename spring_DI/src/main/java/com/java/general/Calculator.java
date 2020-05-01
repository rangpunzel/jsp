package com.java.general;

public class Calculator {
	
	private Sumation sumation;// = new Sumation();
	public void setSumation(Sumation sumation) {
		this.sumation=sumation;
	}
	
	public void sum(int a, int b) {
		
		sumation.setA(a);
		sumation.setB(b);
		
		System.out.println("두 정수 "+a+", "+b+"의 합은 "+sumation.sum()+"입니다.");
	}
	
	public void sum(int a, int b, int c) {
		if(sumation instanceof TripleSumation) {
			((TripleSumation) sumation).setC(c);
			int result = sumation.sum();
			System.out.println("세 정수 "+a+"," +b+", "+c+"의 합은 "+result+"입니다.");
		}else {
			System.out.println("세 정수 합은 제공되지 않습니다.");
		}
	}
}
