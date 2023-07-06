package com.study.jsp.member.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.jsp.member.service.MemberService;
import com.study.jsp.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	// 회원가입 화면 응답 메소드
	@RequestMapping("/registView")
	public String registView() {
		return "member/registView";
	}
	
	// 회원가입 처리 메소드
	@RequestMapping("registDo")
	public String registDo(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String id = request.getParameter("memId");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		System.out.println("id= "+ id);
		System.out.println("pw= "+ pw);
		System.out.println("name= "+ name);
		
		MemberVO member = new MemberVO(id, pw, name);
//		member.setMemId(id);
//		member.setMemPw(pw);
//		member.setMemName(name);
		
		memberService.registMember(member);
		
		// 회원가입 끝나면 어디로?
		// 홈, 로그인, 회원가입이 완료Page
		return "redirect:/";
	}
	
	// 로그인 화면 응답 메소드
	@RequestMapping("/loginView")
	public String loginView() {
		return "member/loginView";
	}
	
	// 로그인 처리 메소드
	@PostMapping("/loginDo")
	public String loginDo(MemberVO member, Model model, HttpSession session, boolean rememberId, HttpServletResponse response) {
		
		System.out.println(member);
		System.out.println(rememberId);
		
		try {
			MemberVO login = memberService.loginMember(member);
			System.out.println("로그인 성공");
			System.out.println(login);
			
			// 세션 객체에 로그인 정보 담기
			session.setAttribute("login", login);
			
			// 아이디 기억하기 체크했다.
			// 쿠키에 아이디 저장
			if(rememberId) {
				// 쿠키 객체 생성
				Cookie cookie = new Cookie("rememberId", login.getMemId());
				
				// response 객체에 쿠키를 담아서 전달
				response.addCookie(cookie);
			}else {
				// 아이디 기억하기 체크하지 않음.
				
				// rememberId 키값을 가지는 쿠키를 삭제시켜주기
				// = rememberId 키값을 가지는 쿠키를 생성
				// 유통기한을 0으로 설정해서 전달한다.
				Cookie cookie = new Cookie("rememberId", "메롱");
				cookie.setMaxAge(0); // 이 쿠키가 브라우저로 저장된 후 0초 후 소멸
				
				// response 객체에 쿠키를 담아서 전달
				response.addCookie(cookie);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 실패 :"+ e.getMessage());
			
			model.addAttribute("errMsg", e.getMessage());
			return "errView";
		}
		
		return "redirect:/";
	}
	
	// 로그아웃 처리 메소드
	@RequestMapping("/logoutDo")
	public String logoutDo(HttpSession session) {
		
		//해당 클라이언트에 대한 세션 객체 제거
		session.invalidate();
		
		return "redirect:/";
	}
	
	
}
