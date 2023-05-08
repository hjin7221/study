package hyunjin.submit14.vo;

public class MoneyBookVO {
	private String use_date;
	private String mem_id;
	private String gubun;
	private String money_category;
	private int account;
	private String payment_category;
	private String contents;
	
	public MoneyBookVO() {}

	public MoneyBookVO(String use_date, String mem_id, String gubun, String money_category, int account,
			String payment_category, String contents) {
		super();
		this.use_date = use_date;
		this.mem_id = mem_id;
		this.gubun = gubun;
		this.money_category = money_category;
		this.account = account;
		this.payment_category = payment_category;
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "[사용일자: " + use_date + ", 구분: " + gubun + ", 항목: "
				+ money_category + ", 금액: " + account + ", 결제구분: " + payment_category + ", 내역: "
				+ contents + "]";
	}

	public String getUse_date() {
		return use_date;
	}

	public void setUse_date(String use_date) {
		this.use_date = use_date;
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

	public String getPayment_category() {
		return payment_category;
	}

	public void setPayment_category(String payment_category) {
		this.payment_category = payment_category;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
}
