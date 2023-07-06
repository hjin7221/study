package com.study.jsp.board.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.jsp.board.service.BoardService;
import com.study.jsp.board.vo.BoardVO;
import com.study.jsp.member.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	// 회원 게시판 화면 응답 메소드
	@RequestMapping("/boardView")
	public String boardView(Model model) {
		
		// 게시글 목록을 데이터베이스로부터 가지고 옴
		List<BoardVO> boardList = boardService.getBoardList();
		// View 단에 넘겨줌
		
		model.addAttribute("boardList", boardList);
		
		return "board/boardView";
	}
	
	// 글작성 화면 응답 메소드
	@RequestMapping("/boardWriteView")
	public String boardWriteView(HttpSession session) {
		
		// 현재 세션에 login 키값으로 저장된 정보가 있으면 
		// 글쓰기 화면으로 보내주기
		MemberVO login = (MemberVO) session.getAttribute("login");
		System.out.println(login);
		
		// 저장된게 없으면(로그인 안한 상태면)
		// 로그인 화면으로 보내주기 
		if(login == null) {
			return "member/loginView";
		}
		
		return "board/boardWriteView";
	}
	
	// 글쓰기 처리 메소드
	@PostMapping("/boardWriteDo")
	public String boardWriteDo(BoardVO board) {
		System.out.println(board);
		
		// DB에 전송 (INSERT)
		
		return "redirect:/boardView";
	}
}
