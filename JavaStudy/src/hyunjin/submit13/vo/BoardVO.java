package hyunjin.submit13.vo;

/**
 * @author pc25
 *
 */
public class BoardVO {
	private int no;
	private String title;
	private String author;
	private String create_date;
	private String contents;

	public BoardVO() {
	}

	public BoardVO(int no, String title, String author, String create_date, String contents) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.create_date = create_date;
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "[" + no + ". | " + title + " | " + author + " | " + create_date + "]";
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
