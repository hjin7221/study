package com.study.jsp.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	public String boardWriteView(HttpSession session, HttpServletRequest request, Model model) {
		
		// 현재 세션에 login 키값으로 저장된 정보가 있으면 
		// 글쓰기 화면으로 보내주기
		MemberVO login = (MemberVO) session.getAttribute("login");
		System.out.println(login);
		
		// 저장된게 없으면(로그인 안한 상태면)
		// 로그인 화면으로 보내주기 
		if(login == null) {
			String fromUrl = request.getHeader("Referer");
			model.addAttribute("fromUrl", fromUrl);
			
			return "member/loginView";
		}
		
		return "board/boardWriteView";
	}
	
	// 글쓰기 처리 메소드
	@PostMapping("/boardWriteDo")
	public String boardWriteDo(BoardVO board, HttpSession session) {
		System.out.println(board);
		
		// DB에 전송 (INSERT)
		// boardWriteView로부터 boardTitle, boardContent만 가져옴
		
		// memId도 챙겨와야함.
		// 1. boardWriteView.jsp에다가 input 태그 (hidden) 이용
		// 2. Controller 메소드에서 세션 객체를 통해 꺼내 쓰기
		MemberVO login = (MemberVO) session.getAttribute("login");
		board.setMemId(login.getMemId());
		
		boardService.writeBoard(board);
		
		return "redirect:/boardView";
	}
	
	// 글 상세 페이지 응답 메소드
	@RequestMapping("boardDetailView")
	public String boardDetailView(int boardNo, Model model) {
		
		System.out.println("boardNo= " + boardNo);
		
		//DB로부터 boardNo에 해당하는 게시글 데이터 가져와서
		// boardDetailView.jsp 파일에 전달(model)
		try {
			BoardVO board = boardService.getBoard(boardNo);
			
			model.addAttribute("board", board);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			model.addAttribute("errMsg", e.getMessage());
			
			return "errView";
		}
		
		return "board/boardDetailView";
	}
	
	// 글 수정 처리
	@PostMapping("boardEditDo")
	public String boardEditDo(BoardVO board) {
		
		System.out.println(board);
		// DB에 해당 게시글 수정(UPDATE)
		boardService.editBoard(board);
		
		return "redirect:/boardDetailView?boardNo=" + board.getBoardNo();
		
	}
	
	// 글 수정 화면 응답
	@PostMapping("boardEditView")
	public String boardEditView(int boardNo, Model model) {
		
		// DB로부터 해당 게시글 데이터 가져와서 model에 담아주기
		try {
			BoardVO board = boardService.getBoard(boardNo);
			
			model.addAttribute("board", board);
		} catch (Exception e) {
			e.printStackTrace();
			
			return "errView";
		}
		return "board/boardEditView";
	}
	
	// 게시글 삭제 
	@PostMapping("/boardDelDo")
	public String boardDelDo(int boardNo) {
		
		System.out.println(boardNo);
		
		// DB에 해당 게시글 삭제(UPDATE로 del_yn = 'Y')
		boardService.delBoard(boardNo);
		
		return "redirect:/boardView";
	}
	
}
