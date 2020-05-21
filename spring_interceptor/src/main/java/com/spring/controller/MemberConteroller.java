package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.MemberVO;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberConteroller {
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public void registGET() {}
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String registPOST(MemberVO member, Model model)throws Exception{
		String url="redirect:/main";
		service.regist(member);
		
		//인터셉터에 이용하려고 model에 심음
		model.addAttribute("registMember",member);
		
		return url;
	}
}
