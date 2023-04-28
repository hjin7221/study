package hyunjin.submit12;

public class CartoonBoard extends Board{

	private String imgFile;
	
	public CartoonBoard () {}
	
	public CartoonBoard(int no, String title, String postDate, String contents, String imgFile) {
		super(no,title,postDate,contents);
		this.imgFile = imgFile;
	}

	@Override
	public String toString() {
		return "CartoonBoard [no=" + getNo() + ", title=" + getTitle() + ", postDate=" + getPostDate() + ", contents=" + getContents()
				+ ", imgFile=" + imgFile + "]";
	}

	public String getImgFile() {
		return imgFile;
	}

	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	
	
}
