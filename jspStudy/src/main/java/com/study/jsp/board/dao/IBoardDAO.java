package com.study.jsp.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.jsp.board.vo.BoardVO;

@Mapper
public interface IBoardDAO {
	
	// 게시글 목록 조회(SELECT)
	public List<BoardVO> getBoardList();
	
	// 게시글 등록(INSERT)
	public int writeBoard(BoardVO board);
	
	// 게시글 1개 조회(SELECT)
	public BoardVO getBoard(int boardNo);
	
	// 게시글 수정 (UPDATE)
	public int editBoard(BoardVO board);
	
	// 게시글 삭제 (UDPATE)
	public int delBoard(int boardNo);
}
