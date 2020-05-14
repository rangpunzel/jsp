package com.groupware.service.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.groupware.dao.board.PageBoardDAO;
import com.groupware.dao.board.ReplyDAO;
import com.groupware.dto.BoardVO;
import com.groupware.request.PageMaker;
import com.groupware.request.SearchCriteria;

//@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	//@Autowired
	private PageBoardDAO boardDAO;
	public void setBoardDAO(PageBoardDAO boardDAO) {
		this.boardDAO=boardDAO;
	}
	
	//@Autowired
	private ReplyDAO replyDAO;
	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	
	@Override
	public List<BoardVO> getBoardList() throws SQLException {
		List<BoardVO> boardList=boardDAO.selectBoardList();		
		return boardList;
	}

	@Override
	public BoardVO getBoardForModify(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByBno(bno);
		return board;
	}
	@Override
	public BoardVO readBoard(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByBno(bno);
		int replycnt = replyDAO.countReply(bno);
		board.setReplycnt(replycnt);
		boardDAO.increaseViewCnt(bno);
		return board;
	}

	@Override
	public void write(BoardVO board) throws SQLException {
		int bno=boardDAO.selectBoardSeqNext();
		
		board.setBno(bno);
		
		boardDAO.insertBoard(board);
	}

	@Override
	public void modify(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);
	}

	@Override
	public void remove(int bno) throws SQLException {
		boardDAO.deleteBoard(bno);
	}
	@Override
	public Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<BoardVO> boardList=boardDAO.selectBoardSearchCriteria(cri);
		
		//전체 board 개수
		int totalCount=boardDAO.selectBoardSearchCriteriaTotalCount(cri);
		
		for(BoardVO board : boardList) {
			int replycnt=replyDAO.countReply(board.getBno());
			board.setReplycnt(replycnt);
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
