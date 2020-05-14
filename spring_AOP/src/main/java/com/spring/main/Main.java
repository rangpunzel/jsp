package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.behavior.행동;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx=
	new GenericXmlApplicationContext("classpath:com/spring/context/root-context.xml");
		
		행동 behavior = (행동)ctx.getBean("behavior");
		
		behavior.밥먹기();
		behavior.정신수양();
		behavior.밥먹기();
		behavior.공부하기();
		behavior.놀기();
		behavior.데이트();
		behavior.운동();
		behavior.밥먹기();
		behavior.잠자기();

	}

}
