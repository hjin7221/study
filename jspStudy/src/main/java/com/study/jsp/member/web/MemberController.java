package com.study.jsp.member.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

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
	public String loginDo(MemberVO member, Model model) {
		
		System.out.println(member);
		
		try {
			memberService.loginMember(member);
			System.out.println("로그인 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 실패 :"+ e.getMessage());
			
			model.addAttribute("errMsg", e.getMessage());
			return "errView";
		}
		
		return "redirect:/";
	}
	
}
