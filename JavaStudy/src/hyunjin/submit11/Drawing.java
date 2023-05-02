package hyunjin.submit11;

public class Drawing {
	private int no; // 관리 no
	private String division; // 구분(자동차,ESS,MOBILE 등)
	private String pjt; // PJT명
	private String product; // 제품명
	private double rev = 1.0; // revision No.
	private String date; // 접수 일자
	private String contents; // 도면 변경 내용 (신규 접수, 도면 내 수정사항 기입)

	public Drawing() {
	}

	public Drawing(String title, String content) {
		DrawingDB drawDB = DrawingDB.getInstance();
		String[] temp = title.split("_");
		this.no = drawDB.drawNumUp();
		if (temp[0].contains("Ford") || temp[0].contains("ISUZU") || temp[0].contains("FCA") || temp[0].contains("RSA")
				|| temp[0].contains("Volvo")) {
			this.division = "자동차";
		} else if (temp[0].contains("JH") || temp[0].contains("JP") || temp[0].contains("Omron")
				|| temp[0].contains("Gen")) {
			this.division = "E S S";
		} else {
			this.division = "e t c.";
		}
		this.pjt = temp[0];
		this.product = temp[1];
		this.rev = rev;
		this.date = temp[2].substring(0, 6);
		this.contents = content;
	}

	public Drawing(int no, String title, String content) {
		DrawingDB drawDB = DrawingDB.getInstance();
		String[] temp = title.split("_");
		this.no = no;
		if (temp[0].contains("Ford") || temp[0].contains("ISUZU") || temp[0].contains("Chrysler")
				|| temp[0].contains("RSA") || temp[0].contains("Volvo")) {
			this.division = "자동차";
		} else if (temp[0].contains("JH") || temp[0].contains("JP") || temp[0].contains("Omron")
				|| temp[0].contains("Gen")) {
			this.division = "E S S";
		} else {
			this.division = "e t c.";
		}
		this.pjt = temp[0];
		this.product = temp[1];
		this.rev = rev;
		this.date = temp[2];
		this.contents = content;
	}

	public Drawing(int no, String division, String pjt, String product, double rev, String date, String contents) {
		super();
		this.no = no;
		this.division = division;
		this.pjt = pjt;
		this.product = product;
		this.rev = rev;
		this.date = date;
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "[번호: " + no + ", 구분: " + division + ", PJT명: " + pjt + ", 제품명: " + product + ", REV NO.: " + rev
				+ ", 접수일자: " + date + ", 내용: " + contents + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getPjt() {
		return pjt;
	}

	public void setPjt(String pjt) {
		this.pjt = pjt;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getRev() {
		return rev;
	}

	public void setRev(double rev) {
		this.rev = rev;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}