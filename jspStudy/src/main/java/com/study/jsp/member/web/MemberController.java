package com.study.jsp.member.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	// 회원가입 화면 응답 메소드
	@RequestMapping("/registView")
	public String registView() {
		return "member/registView";
	}
	
	// 회원가입 처리 메소드
	@RequestMapping("registDo")
	public String registDo(HttpServletRequest request) {
		
		String id = request.getParameter("memId");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		System.out.println("id= "+ id);
		System.out.println("pw= "+ pw);
		System.out.println("name= "+ name);
		
		// 회원가입 끝나면 어디로?
		// 홈, 로그인, 회원가입이 완료Page
		return "redirect:/";
	}
	
}
