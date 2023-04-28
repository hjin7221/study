package ch09_class.homepage;

public class Board {
	private int no; // 글 번호
	private String title; // 글 제목
	private String contents; // 글 내용
	private String author; // 작성자

	public Board() {
	}

	public Board(int no, String title, String contents, String author) {
		super();
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.author = author;
	}

	@Override
	public String toString() {
		return "[" + no + ". | " + title + " | " + author + "]";
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}