package com.study.jsp.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.jsp.member.dao.IMemberDAO;
import com.study.jsp.member.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	IMemberDAO dao;
	
	// 회원가입
	public void registMember(MemberVO member) {
		dao.registMember(member);
	}
	
	// 로그인
	public MemberVO loginMember(MemberVO member) throws Exception {
		
		MemberVO result = dao.loginMember(member);
		
		// 아이디 혹은 비밀번호가 틀리면 아무 데이터도 조회되지 않으며 
		// result에는  null값이 담긴다. (시스템당 에러는 없음)
		// 직접 에러를 발생시켜 준다.
		if(result == null) {
			throw new Exception("아이디 혹은 비밀번호가 틀립니다.");
		}
		
		return result;
	}
}
