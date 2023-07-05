package com.study.jsp.member.vo;

public class MemberVO {
	
	private String memId;		/* 회원아이디 */
	private String memPw;		/* 회원비밀번호 */
	private String memName;		/* 회원 닉네임 */
	
	public MemberVO() {}

	public MemberVO(String memId, String memPw, String memName) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
	}
	
	// lombok
	
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPw=" + memPw + ", memName=" + memName + "]";
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}
	
}
