package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import com.jsp.request.SearchCriteria;
import com.jsp.dto.BoardVO;

public interface BoardDAO {
	
	//게시글정보
	List<BoardVO> selectBoardCriteria(SearchCriteria cri) throws SQLException;
	
	//전체갯수
	int selectBoardCriteriaTotalCount(SearchCriteria cri) throws SQLException;
	
	//번호선택
	BoardVO selectBoardByBno(int bno) throws SQLException;
	
	//글작성
	void insertBoard(BoardVO board) throws SQLException;
	//글수정
	void updateBoard(BoardVO board) throws SQLException;
	//글삭제
	void deleteBoard(int bno) throws SQLException;

	// viewcnt 증가
	void increaseViewCnt(int bno) throws SQLException;

	// board_seq.nextval 가져오기 ? 왜 시퀀스를 가져오는지???? 댓글갯수 적어주려구 ㅋㅋ
	int selectBoardSeqNext() throws SQLException;

}
