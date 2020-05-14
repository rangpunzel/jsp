package com.groupware.controller.board;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.dto.ReplyVO;
import com.groupware.request.SearchCriteria;
import com.groupware.service.board.ReplyService;

//url : /replies
///replies/all/{bno}		list : GET방식, bno번 게시글의 댓글 목록
///replies/{rno}			modify : PUT,PATCH방식, rno 댓글의 수정 
///replies/{rno}			remove : DELETE 방식, rno 댓글의 삭제
///replies 					regist : POST 방식 : 댓글 입력
///replies/{bno}/{page} 	page list: GET방식 
//bno번 게시글의 페이징 처리된 댓글 목록

@Controller
@RequestMapping("/replies")
public class FreeBoardReplyController {
	
	//required=true는 bean등록이 안되어있으면 터짐. false:당장 bean이 없다고 터지진않음.주입이 안되면 null터짐.
	@Autowired
	private ReplyService service;
	
	@RequestMapping(value="/{bno}/{page}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String,Object>> listPage(@PathVariable("bno") int bno,
														@PathVariable("page")int page)throws Exception{
		ResponseEntity<Map<String,Object>> entity = null;
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		
		try {
			Map<String,Object> dataMap=service.getReplyList(bno, cri);
			entity=new ResponseEntity<Map<String,Object>>(dataMap,HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> register(@RequestBody ReplyVO reply)throws Exception{
		ResponseEntity<String> entity =null;
		try {
			service.registReply(reply);
			entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{rno}",method= {RequestMethod.PUT,RequestMethod.PATCH})
	@ResponseBody
	public ResponseEntity<String> update(@PathVariable("rno") int rno, @RequestBody ReplyVO reply)throws Exception{
		ResponseEntity<String> entity=null;
		
		reply.setRno(rno);
		try {
			service.modifyReply(reply);
			entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	@RequestMapping(value="/{rno}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> remove(@PathVariable("rno") int rno)
					throws Exception{
		ResponseEntity<String> entity=null;
		try {
			service.removeReply(rno);
			entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
}
