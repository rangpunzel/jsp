package com.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.MemberVO;
import com.spring.request.SearchCriteria;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberActionController {
	
	@Autowired
	private MemberService memberService;
/*	public void setMemberService(MemberService memberService) {
		this.memberService=memberService;
	}*/
	
	@RequestMapping("list.do")
	public String list(SearchCriteria cri,Model model)throws Exception{
		String url="member/list.page";
		Map<String, Object> dataMap = memberService.getMemberList(cri);
		
		dataMap.put("title", "회원리스트");
//		model.addAttribute("pageMaker", (PageMaker)dataMap.get("getMaker"));
//		model.addAttribute("memberList", (List<MemberVO>)dataMap.get("memberList"));
		
		model.addAllAttributes(dataMap);
		return url;
	}
	
	@RequestMapping("registForm.do")
	public String registForm()throws Exception{
		String url="member/regist.open";
		return url;
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(MemberVO member,String[] phone, HttpServletResponse response)throws Exception{
		String url="member/regist_success";
		String tempPhone="";
		for(String data : phone){
			//System.out.println(data);
			tempPhone+=data;
		}
		member.setPhone(tempPhone);
		
		response.setContentType("text/html;charset=utf-8");
		
		try{
			System.out.println(member.getPicture());
			memberService.regist(member);
			
	
		}catch(SQLException e){
			e.printStackTrace();
			url="member/regist_fail";
		}
		
		return url;
	}
	
	@RequestMapping("detail.do")
	public String detail(Model model, String id)throws Exception{
		String url="member/detail.open";
		MemberVO member = memberService.getMember(id);
		model.addAttribute("member",member);
		return url;
	}
	
	@RequestMapping("modifyForm.do")
	public String modifyForm(Model model, String id)throws Exception{
		String url="member/modify.open";
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
	
	@RequestMapping("checkid.do")
	@ResponseBody
	public ResponseEntity<String> checkId(String id)throws Exception{
		ResponseEntity<String> entity=null;
		
		MemberVO mv=new MemberVO();
		
		try {
			mv = memberService.getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(mv==null) {
			entity = new ResponseEntity<String>(HttpStatus.OK);
			System.out.println("중복된 사람이 없습니다.");
		}else {
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			System.out.println("중복된 사람이 있습니다.");
		}
		
		return entity;
	}
	
	@Resource(name="picturePath")
	private String picturePath;
	
	@RequestMapping(value="/picture.do",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> picture(@RequestParam("pictureFile") MultipartFile multi, 
										  String oldPicture) throws Exception{
		
		ResponseEntity<String> entity=null;
		String result="";
		HttpStatus status=null;
		
		/* 파일유무확인 */
		if (multi.isEmpty()) {			
			result="파일이 없습니다.!";			
			status=HttpStatus.BAD_REQUEST;
		}else 
		/* 용량제한 5MB */
		if (multi.getSize() > 1024 * 1024 * 5) {			
			result="용량초과 입니다";			
			status=HttpStatus.BAD_REQUEST;
		}else{
			/* 파일저장폴더설정 */
			String uploadPath = picturePath;
			String fileName = UUID.randomUUID().toString().replace("-", "")+".jpg";	
			File storeFile = new File(uploadPath,fileName);
			
			// local HDD 에 저장.
			multi.transferTo(storeFile);
			
			if(!oldPicture.isEmpty()){
				File oldFile = new File(uploadPath,oldPicture);
				if (oldFile.exists()) {
					oldFile.delete();
				}
			}
			
			result=fileName;
			status=HttpStatus.OK;
			
		}
		return new ResponseEntity<String>(result,status);
	}
	
	@RequestMapping("/picture/get.do")
	@ResponseBody
	public ResponseEntity<byte[]> getPicture(String picture)throws Exception{
		InputStream in=null;
		ResponseEntity<byte[]> entity=null;
		String imgPath = this.picturePath;
		try{
			
			//in=new FileInputStream(imgPath+File.separator+picture);
			in=new FileInputStream(new File(imgPath,picture));
			
			entity=new ResponseEntity<byte[]>(IOUtils.toByteArray(in),HttpStatus.CREATED);
		}catch(IOException e){
			e.printStackTrace();
			entity=new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			in.close();
		}
		return entity;
	}
	
	
}
