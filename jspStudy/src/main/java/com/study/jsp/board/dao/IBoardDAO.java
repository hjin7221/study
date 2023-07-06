package com.study.jsp.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.jsp.board.vo.BoardVO;

@Mapper
public interface IBoardDAO {
	
	// 게시글 목록 조회(SELECT)
	public List<BoardVO> getBoardList();
}
