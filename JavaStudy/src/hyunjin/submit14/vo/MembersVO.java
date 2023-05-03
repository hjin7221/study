package hyunjin.submit14.vo;

public class MembersVO {
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private String hint_question;
	private String hint_answer;
	private String create_date;
	
	public MembersVO() {}
	
	public MembersVO(String mem_id, String mem_pw, String mem_name, String hint_question, String hint_answer,
			String create_date) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.hint_question = hint_question;
		this.hint_answer = hint_answer;
		this.create_date = create_date;
	}

	@Override
	public String toString() {
		return "MembersVO [mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", mem_name=" + mem_name + ", hint_question="
				+ hint_question + ", hint_answer=" + hint_answer + ", create_date=" + create_date + "]";
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getHint_question() {
		return hint_question;
	}

	public void setHint_question(String hint_question) {
		this.hint_question = hint_question;
	}

	public String getHint_answer() {
		return hint_answer;
	}

	public void setHint_answer(String hint_answer) {
		this.hint_answer = hint_answer;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	
	
	
	
}
