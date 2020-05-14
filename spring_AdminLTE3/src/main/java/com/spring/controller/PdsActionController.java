package com.spring.controller;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.AttachVO;
import com.spring.dto.MemberVO;
import com.spring.dto.PdsVO;
import com.spring.request.ModifyPdsRequest;
import com.spring.request.RegistPdsRequest;
import com.spring.request.SearchCriteria;
import com.spring.service.PdsService;

@Controller
@RequestMapping("/pds/*")
public class PdsActionController {

	@Autowired
	private PdsService pdsService;
/*	public void setPdsService(PdsService pdsService) {
		this.pdsService=pdsService;
	}*/
	
	@RequestMapping("list.do")
	public ModelAndView list(SearchCriteria cri, ModelAndView mnv)throws Exception{
		String url="pds/list.page";
		Map<String, Object> dataMap = pdsService.getList(cri);
		
		mnv.addAllObjects(dataMap); //Model에 심기
		mnv.setViewName(url);		//view에 심기
		
		return mnv;
	}
	
	@RequestMapping("registForm.do")
	public ModelAndView registForm(ModelAndView mnv)throws Exception{
		String url = "pds/regist.open";
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping(value="regist.do",method=RequestMethod.POST,produces="text/plain;charset=utf-8")
	public String regist(RegistPdsRequest registReq, HttpServletRequest request, HttpServletResponse response)throws Exception{
		String url="pds/regist_success";
		
		List<AttachVO> attachList = saveFile(registReq,request,response);
		
		PdsVO pds = registReq.toPdsVO();
		pds.setAttachList(attachList);
		
		try {
			pdsService.regist(pds);
		}catch(SQLException e) {
			e.printStackTrace();
			url="pds/regist_fail";
		}
		
		return url;
	}
	
	@RequestMapping("detail.do")
	public ModelAndView detail(ModelAndView mnv,int pno)throws Exception{
		String url = "pds/detail.open";
		PdsVO pds = pdsService.getPds(pno);
		
		mnv.addObject("pds",pds); //Model에 심기
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping("modifyForm.do")
	public ModelAndView modifyForm(ModelAndView mnv,int pno)throws Exception{
		String url = "pds/modify.open";
		
		PdsVO pds = pdsService.getPds(pno);
		
		mnv.addObject("pds",pds); //Model에 심기
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping(value="modify.do",method=RequestMethod.POST,produces="text/plain;charset=utf-8")
	public String modify(ModifyPdsRequest modifyReq,HttpServletRequest request, HttpServletResponse response)throws Exception{
		String url="pds/modify_success";
		
		List<AttachVO> attachList = modifyFile(modifyReq,request,response);
		
		PdsVO pds=modifyReq.toPdsVO();
		
		try {
			pdsService.modify(pds);
		}catch(Exception e) {
			e.printStackTrace();
			url="pds/modify_fail";
		}
		return url;
	}
	
	@RequestMapping("remove.do")
	public String remove(int pno)throws Exception{
		String url="remove_success";
		// pno에 대한 attachList 확보
		List<AttachVO> attachList = null;
		try {
			attachList = pdsService.getPds(pno).getAttachList();

			// 각 attachlist 를 이용 파일을 삭제.
			if(attachList != null) {
				for (AttachVO attach : attachList) {
					String storedFilePath = attach.getUploadPath() + File.separator+ attach.getFileName();
					File file = new File(storedFilePath);
					if (file.exists()) {
						file.delete();
					}
				}
			}
			//DB 내용 삭제
			pdsService.remove(pno);
		
		} catch (Exception e1) {
			url="error/500";
			e1.printStackTrace();
		}
		
		return url;
	}
	
	//1. 파일경로 정하기
	@Resource(name = "fileUploadPath")
	private String fileUploadPath;
	
	private List<AttachVO> saveFile(RegistPdsRequest registReq,HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		List<AttachVO> attachList = new ArrayList<AttachVO>();
		
		if(registReq.getUploadFile() != null) {
			for(MultipartFile multi : registReq.getUploadFile()) {
				//2. 파일명 정하기
				String fileName = UUID.randomUUID().toString().replace("-", "")+"$$"+multi.getOriginalFilename();
				File target = new File(fileUploadPath,fileName);
				
				if(!target.exists()) {
					target.mkdirs();
				}
				
				//3.파일 저장
				multi.transferTo(target);
				
				//4. AttachVO 만들기
				AttachVO attach = new AttachVO();
				attach.setUploadPath(fileUploadPath);
				attach.setFileName(fileName);
				attach.setFileType(fileName.substring(fileName.lastIndexOf('.')+1).toUpperCase());
				MemberVO loginUser = (MemberVO)request.getSession().getAttribute("loginUser");
				attach.setAttacher(loginUser.getId());
				
				//5. attachList에 추가
				attachList.add(attach);
			}
		}
		
		return attachList;
	}
	
	private List<AttachVO> modifyFile(ModifyPdsRequest modifyReq,HttpServletRequest request,HttpServletResponse response)throws Exception{
		List<AttachVO> attachList =null;
		
		//0. 파일 삭제
		
		//1. 파일 경로 설정
		
		//2. 파일명 설정
		
		//3. 파일 저장
		
		//4. attachVO 만들기
		
		//5. attachList에 추가
		
		
		return attachList;
	}
}
