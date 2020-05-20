package com.groupware.controller.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.request.SearchCriteria;
import com.groupware.service.board.NoticeService;

@Controller
@RequestMapping("/board/notice/*")
public class NoticeBoardController {
	
	
	@Autowired
	private NoticeService nService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping("list")
	public ModelAndView noticeList(SearchCriteria cri, ModelAndView modelnView)throws SQLException{
		String url="board/notice/notice_list";
		
		Map<String, Object> dataMap = nService.getNoticeList(cri);
		
		List<ColName> colNames = new ArrayList<ColName>();
		
		String[] colNameArr = {"","번&nbsp;호","제&nbsp;목","작성일","작성자","첨&nbsp;부","조회수"};
		String[] colWidthArr= {"4","10","46","10","10","10","10"};
		for(int i =0;i<colNameArr.length;i++) {
			colNames.add(new ColName(colNameArr[i],colWidthArr[i]));
		}
		
		dataMap.put("colNames", colNames);
		
		modelnView.addAllObjects(dataMap);
		modelnView.setViewName(url);
		
		return modelnView;
	}
}
