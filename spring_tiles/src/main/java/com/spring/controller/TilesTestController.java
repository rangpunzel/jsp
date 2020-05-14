package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesTestController {
	
	/**
	 * Tiles를 사용하지 않은 일반적인 형태
	 */
	@RequestMapping("/test.do")
	public String test() {
		return "test";
	}
	@RequestMapping("/testPage.do")
	public String testPage() {
		return "test.page";
	}
	@RequestMapping("/testPart.do")
	public String testPart() {
		return "test.part";
	}
}
