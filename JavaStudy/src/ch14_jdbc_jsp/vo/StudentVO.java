package ch14_jdbc_jsp.vo;

public class StudentVO {
	private String stuId;
	private String StuPassword;
	private String stuName;
	private int stuScore;

	public StudentVO() {
	}

	public StudentVO(String stuId, String stuPassword, String stuName, int stuScore) {
		super();
		this.stuId = stuId;
		StuPassword = stuPassword;
		this.stuName = stuName;
		this.stuScore = stuScore;
	}

	@Override
	public String toString() {
		return "StudentVO [stuId=" + stuId + ", StuPassword=" + StuPassword + ", stuName=" + stuName + ", stuScore="
				+ stuScore + "]";
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuPassword() {
		return StuPassword;
	}

	public void setStuPassword(String stuPassword) {
		StuPassword = stuPassword;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuScore() {
		return stuScore;
	}

	public void setStuScore(int stuScore) {
		this.stuScore = stuScore;
	}

}