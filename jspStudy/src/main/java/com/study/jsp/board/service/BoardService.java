package com.study.jsp.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.jsp.board.dao.IBoardDAO;
import com.study.jsp.board.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	IBoardDAO dao;
	
	// 게시글 목록 조회
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}
	
	// 게시글 등록(INSERT)
	public void writeBoard(BoardVO board){
		dao.writeBoard(board);
	}
	
	// 게시글 1개 조회
	public BoardVO getBoard(int boardNo) throws Exception {
		BoardVO result = dao.getBoard(boardNo);
		
		if(result == null) {
			throw new Exception("존재하지 않는 글입니다.");
		}
		return result;
	}
	
	// 게시글 수정
	public void editBoard(BoardVO board) {
		dao.editBoard(board);
	}
	
	// 게시글 삭제
	public void delBoard(int boardNo) {
		dao.delBoard(boardNo);
	}
}
