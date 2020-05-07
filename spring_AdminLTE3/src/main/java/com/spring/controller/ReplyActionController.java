package com.spring.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.ReplyVO;
import com.spring.request.DeleteReplyRequest;
import com.spring.request.ModifyReplyRequest;
import com.spring.request.PageMaker;
import com.spring.request.RegistReplyRequest;
import com.spring.request.SearchCriteria;
import com.spring.service.ReplyService;

@Controller
@RequestMapping("/replies/*")
public class ReplyActionController {

	@Autowired
	private ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService=replyService;
	}
	
	//ResponseBody는 스트링을 body에 붙여서 내보낸다.
	@RequestMapping("list.do")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> list(int bno, SearchCriteria cri)throws Exception{
		
		ResponseEntity<Map<String,Object>> entity =null;
		
		try {
			//String이 아닌 데이터는 Jackson이 String으로 바꿔서 어댑터한테 보내고 어댑터는 스트링을 Body에 붙여서 그대로 보낸다.
			Map<String,Object> dataMap = replyService.getReplyList(bno, cri);
			
			//if(true) throw new SQLException();
			
			entity = new ResponseEntity<Map<String,Object>>(dataMap,HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	@RequestMapping("regist.do")
	@ResponseBody
	public ResponseEntity<Integer> regist(@RequestBody RegistReplyRequest registReq)throws Exception{
		
		//String result="";
		ResponseEntity<Integer> entity = null;
		
		ReplyVO reply = registReq.toReplyVO();
		try {
			replyService.registReply(reply);
			
			//if(true) throw new SQLException();
			
			Map<String,Object> dataMap = replyService.getReplyList(registReq.getBno(), new SearchCriteria());
			PageMaker pageMaker = (PageMaker)dataMap.get("pageMaker");
			int realEndPage = pageMaker.getRealEndPage();
			
			entity = new ResponseEntity<Integer>(realEndPage,HttpStatus.OK); //응답코드 200
			
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR); //응답코드 500
		}
		return entity;
	}
	
	@RequestMapping("modify.do")
	@ResponseBody
	public ResponseEntity<String> modify(@RequestBody ModifyReplyRequest modifyReq)throws Exception{
		ResponseEntity<String> entity=null;
		
		ReplyVO reply = modifyReq.toReplyVO();
		try {
			replyService.modifyReply(reply);
			//if(true) throw new SQLException();
			entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	@RequestMapping("remove.do")
	@ResponseBody
	public ResponseEntity<Integer> remove(@RequestBody DeleteReplyRequest deleteReq)throws Exception{
		ResponseEntity<Integer> entity=null;
		
		try {
			replyService.removeReply(deleteReq.getRno());
			
			//if(true) throw new SQLException();
			
			Map<String,Object> dataMap = replyService.getReplyList(deleteReq.getBno(), new SearchCriteria());
			PageMaker pageMaker = (PageMaker)dataMap.get("pageMaker");
			int page = deleteReq.getPage();
			int realEndPage=pageMaker.getRealEndPage();
			if(page>realEndPage) {page=realEndPage;}
			
			entity=new ResponseEntity<Integer>(page,HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	
}
