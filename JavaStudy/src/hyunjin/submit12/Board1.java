package hyunjin.submit12;

public class Board1 {
	private int no;
	private String title;
	private String postDate;
	private String contents;
	
	public Board1() {}
	
	public Board1(int no, String title, String postDate, String contents) {
		super();
		this.no = no;
		this.title = title;
		this.postDate = postDate;
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "[" + no + ". | " + title + ". | " + postDate + "]";
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

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
}

