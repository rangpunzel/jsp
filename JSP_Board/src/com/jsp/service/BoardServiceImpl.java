package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jsp.dao.AttachDAO;
import com.jsp.dao.BoardDAO;
import com.jsp.dao.ReplyDAO;
import com.jsp.dto.AttachVO;
import com.jsp.dto.BoardVO;
import com.jsp.dto.MemberVO;
import com.jsp.request.PageMaker;
import com.jsp.request.SearchCriteria;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO=boardDAO;
	}
	
	private ReplyDAO replyDAO;
	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
		
	
	private AttachDAO attachDAO;
	public void setAttachDAO(AttachDAO attachDAO) {
		this.attachDAO=attachDAO;
	}

	@Override
	public BoardVO getBoardForModify(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByBno(bno);
		return board;
	}
	@Override
	public BoardVO getBoard(int bno) throws SQLException {
		boardDAO.increaseViewCnt(bno);
		
		BoardVO board = boardDAO.selectBoardByBno(bno);
		List<AttachVO> attachList=attachDAO.selectAttachesByBno(bno);
		board.setAttachList(attachList);
		
		return board;
	}

	@Override
	public void write(BoardVO board) throws SQLException {
		int bno=boardDAO.selectBoardSeqNext();
		board.setBno(bno);
		boardDAO.insertBoard(board);
		for(AttachVO attach:board.getAttachList()) {
			attach.setBno(bno);
			attach.setAttacher(board.getWriter());
			attachDAO.insertAttach(attach);
		}
	}

	@Override
	public void modify(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);
		for(AttachVO attach:board.getAttachList()) {
			attach.setBno(board.getBno());
			attach.setAttacher(board.getWriter());
			attachDAO.insertAttach(attach);
		}
	}

	@Override
	public void remove(int bno) throws SQLException {
		boardDAO.deleteBoard(bno);
	}
	@Override
	public Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<BoardVO> boardList=boardDAO.selectBoardCriteria(cri);
		
		//전체 board 개수
		int totalCount=boardDAO.selectBoardCriteriaTotalCount(cri);
		
		for(BoardVO board : boardList) {
			int replycnt=replyDAO.countReply(board.getBno());
			board.setReplycnt(replycnt);
		}
		
		for(BoardVO board : boardList) {
			List<AttachVO> attachList=attachDAO.selectAttachesByBno(board.getBno());
			board.setAttachList(attachList);
		}
		
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("boardList", boardList);
		dataMap.put("pageMaker",pageMaker);
		
		
		return dataMap;
	}

}