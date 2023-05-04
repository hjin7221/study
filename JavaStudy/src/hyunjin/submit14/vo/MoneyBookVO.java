package hyunjin.submit14.vo;

public class MoneyBookVO {
	private String mem_id;
	private String gubun;
	private String money_category;
	private int account;
	private String contents;
	
	public MoneyBookVO() {}
	
	public MoneyBookVO(String mem_id, String gubun, String money_category, int account, String contents) {
		super();
		this.mem_id = mem_id;
		this.gubun = gubun;
		this.money_category = money_category;
		this.account = account;
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "MoneyBookVO [mem_id=" + mem_id + ", gubun=" + gubun + ", money_category=" + money_category
				+ ", account=" + account + ", contents=" + contents + "]";
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getMoney_category() {
		return money_category;
	}

	public void setMoney_category(String money_category) {
		this.money_category = money_category;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
}
