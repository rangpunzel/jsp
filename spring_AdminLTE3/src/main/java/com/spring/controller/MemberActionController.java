package com.spring.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.MemberVO;
import com.spring.request.SearchCriteria;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberActionController {
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService=memberService;
	}
	
	@RequestMapping("list.do")
	public String list(SearchCriteria cri,Model model)throws Exception{
		String url="member/list";
		Map<String, Object> dataMap = memberService.getMemberList(cri);
		
//		model.addAttribute("pageMaker", (PageMaker)dataMap.get("getMaker"));
//		model.addAttribute("memberList", (List<MemberVO>)dataMap.get("memberList"));
		
		model.addAllAttributes(dataMap);
		return url;
	}
	
	@RequestMapping("registForm.do")
	public String registForm()throws Exception{
		String url="member/regist";
		return url;
	}
	
	@RequestMapping("detail.do")
	public String detail(Model model, String id)throws Exception{
		String url="member/detail";
		MemberVO member = memberService.getMember(id);
		model.addAttribute("member",member);
		return url;
	}
	
	@RequestMapping("modifyForm.do")
	public String modifyForm(Model model, String id)throws Exception{
		String url="member/modify";
		MemberVO member=memberService.getMember(id);
		model.addAttribute("member",member);
		return url;
	}
	
	@RequestMapping("modify.do")
	public String modify(Model model, MemberVO member)throws Exception{
		String url="member/modify_success";
		member.setPhone(member.getPhone().replace("-", ""));
		try {
		memberService.modify(member);
		}catch(SQLException e) {
			e.printStackTrace();
			url="member/modify_fail";
		}
		model.addAttribute("member",member);
		return url;
	}
	
	@RequestMapping("disabled.do")
	public String disabled(HttpSession session, String id)throws Exception{
		String url="member/disabled_success";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (id.equals(loginUser.getId())) { // 로그인 사용자일 경우 불허함.
			url = "member/disabled_denied";
		} else { 
			try {
			memberService.disabled(id);
			}catch(SQLException e) {
				e.printStackTrace();
				url="member/disabled_fail";
			}
		}
		return url;
	}
	
	@RequestMapping("enabled.do")
	public String enabled(HttpSession session, String id)throws Exception{
		String url="member/enabled_success";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (id.equals(loginUser.getId())) { // 로그인 사용자일 경우 불허함.
			url = "member/disabled_denied";
		} else {
			try {
				memberService.abled(id);
			}catch(SQLException e) {
				e.printStackTrace();
				url="member/enabled_fail";
			}
		}
		return url;
	}
	
	@RequestMapping("remove.do")
	public String remove(String id,HttpSession session)throws Exception{
		String url="member/remove_success";

		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (id.equals(loginUser.getId())) { // 로그인 사용자일 경우 불허함.
			url = "member/remove_denied";
		}else {
			try {
				memberService.remove(id);
			} catch (SQLException e) {
				e.printStackTrace();
				url = "member/remove_fail";
			}
		}
		return url;
	}
	
	@RequestMapping("checkPassword.do")
	@ResponseBody
	public ResponseEntity<String> checkPassword(String pwd, HttpSession session, HttpServletResponse response)throws Exception{
		ResponseEntity<String> entity=null;
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if(pwd.equals(loginUser.getPwd())) {
			entity=new ResponseEntity<String>(HttpStatus.OK);
		}else {
			entity=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	
}
