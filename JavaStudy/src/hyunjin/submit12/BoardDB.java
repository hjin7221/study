package hyunjin.submit12;

import java.util.ArrayList;

import ch09_class.homepage.Board;

public class BoardDB {
	private ArrayList<Board> boardList = new ArrayList<>();
	
	private BoardDB() {
		boardList.add(new Board (1, "첫 번째 글", "2022.03.18 10:41:00", "What?" ) );
		boardList.add(new Board (2, "두 번째 글", "2022.03.18 10:41:20", "What?" ) );
		boardList.add(new Board (3, "세 번째 글", "2022.03.18 10:41:27", "What?" ) );
	}
	
	private static BoardDB instance = new BoardDB();
	
	public static BoardDB getInstance() {
		return instance;
	}
	
	//현재 리스트 출력 메소드
	public void showBoardList() {
		for (int i = 0; i<boardList.size(); i++) {
			System.out.println(boardList.get(i));
		}
	}
	// 보드 디비 넘버 올리기 
	public void addBoarding(Board board) {
		board.setNo(boardList.size() + 1);
		boardList.add(board);
	}
}
