package hyunjin.submit13.vo;

public class MemberVO {
	private String memId;
	private String memPW;
	
	public MemberVO() {}
	
	public MemberVO(String memId, String memPW) {
		super();
		this.memId = memId;
		this.memPW = memPW;
	}

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPW=" + memPW + "]";
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPW() {
		return memPW;
	}

	public void setMemPW(String memPW) {
		this.memPW = memPW;
	}

	
	
}