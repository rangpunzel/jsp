package com.java.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.java.general.Calculator;

public class SpringMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:application-context.xml");
		
		Calculator cal = ctx.getBean("calculator",Calculator.class);
		
		cal.sum(3, 5);
		cal.sum(3, 5,10);
	}
}
