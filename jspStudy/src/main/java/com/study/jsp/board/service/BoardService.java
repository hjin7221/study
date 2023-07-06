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
}
