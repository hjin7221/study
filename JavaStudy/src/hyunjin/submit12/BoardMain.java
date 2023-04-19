package hyunjin.submit12;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		BoardDB boardDB = BoardDB.getInstance();
		
		System.out.println("행동을 선택해주세요.");
		System.out.println("1. 글 목록 | 2. 글 쓰기 | 3. 종료");
		System.out.println(">>> ");
		int command = Integer.parseInt(scan.nextLine());
		while(true) {
			if(command == 1) {
				//TODO 글목록
				boardDB.showBoardList();
			}else if(command == 2) {
				//TODO 글 쓰기
				Date today = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
				String strToday = sdf.format(today);
				
				
				System.out.print("글 제목을 입력해주세요:");
				String title = scan.nextLine();
				System.out.print("글 내용을 입력해주세요:");
				String contents = scan.nextLine();
				Board board = new Board (0, title,strToday, contents);
				board
			}else {
				// 종료
				System.out.println("종료합니다.");
				break;
			}
		}
		
		
		
		
		
		
		
		
	}

}
