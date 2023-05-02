package hyunjin.submit12;

public class DateBoard {
	private String title;
	private String date;

	public DateBoard(String title, String date) {
		this.title = title;
		this.date = date;
	}

	@Override
	public String toString() {
		return "제목: " + title + ", 게시일: " + date + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
