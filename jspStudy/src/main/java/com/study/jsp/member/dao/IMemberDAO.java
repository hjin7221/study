package com.study.jsp.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.study.jsp.member.vo.MemberVO;

@Mapper
public interface IMemberDAO {
	
	// 회원가입 진행(INSERT)
	public int registMember(MemberVO member);
	
	// 로그인 진행(SELECT)
	public MemberVO loginMember(MemberVO member);
	
	
}
