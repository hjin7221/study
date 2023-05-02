package hyunjin.submit10;

public class Book {

	private int no; // 도서 번호
	private String title; // 도서 제목
	private boolean rental = false; // 대여 여부

	public Book() {
	}

//	public Book(int no, String title) {
//		this.no = no;
//		this.title = title;
//		this.rental = false;
//	}

	public Book(int no, String title, boolean rental) {
		super();
		this.no = no;
		this.title = title;
		this.rental = rental;
	}

	@Override
	public String toString() {
		if (rental == true) {
			return "[책번호: " + no + ", 책 제목:" + title + ", 대여상태: 대여중 ]";
		} else {
			return "[책번호: " + no + ", 책 제목:" + title + ", 대여상태: 입고중 ]";
		}
//		String state = (rental) ? ("대여중") : ("입고중");
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRental() {
		return rental;
	}

	public void setRental(boolean rental) {
		this.rental = rental;
	}

}
