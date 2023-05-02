package hyunjin.submit12;

public class AudioBoard extends Board1 {
	private String audioFile;

	public AudioBoard() {
	}

	public AudioBoard(int no, String title, String postDate, String contents, String audioFile) {
		super(no, title, postDate, contents);
		this.audioFile = audioFile;
	}

	@Override
	public String toString() {
		return "AudioBoard [no=" + getNo() + ", title=" + getTitle() + ", PostDate=" + getPostDate() + ", contents="
				+ getContents() + ", audioFile=" + audioFile + "]";
	}

	public String getAudioFile() {
		return audioFile;
	}

	public void setAudioFile(String audioFile) {
		this.audioFile = audioFile;
	}

}
