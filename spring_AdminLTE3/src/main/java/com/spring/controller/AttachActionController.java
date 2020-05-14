package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.PdsService;

@Controller
public class AttachActionController {
	
	@Autowired
	private PdsService pdsService;

	@RequestMapping("attach/getFile.do")
	public void getAttach()throws Exception{
		System.out.println("여기서 파일 가져오는거 구현하면 됩미다.");
	}

}
