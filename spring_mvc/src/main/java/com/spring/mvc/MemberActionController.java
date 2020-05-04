package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.request.member.RegistMemberRequest;

@Controller
@RequestMapping("/member/*")
public class MemberActionController {
	//value : url
	@RequestMapping(value="regist",method=RequestMethod.GET)
	public void regist_GET()throws Exception{ }
	
/*	String url="member/regist";
	return url; */
	
	
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public String regist_POST(RegistMemberRequest registReq,
							@RequestParam(value="password",defaultValue="비번이없음",required=false)String pwd,
							@RequestParam(defaultValue="대전광역시")String address,
							@RequestParam(required=false)String authority)throws Exception{
		String url="redirect:https://www.ddit.or.kr";
		
		System.out.println(registReq);
		System.out.println(pwd);
		System.out.println(address);
		System.out.println(authority);
		
		return url;
	}
}
