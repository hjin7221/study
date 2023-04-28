package hyunjin.submit11;

import java.util.Scanner;


public class DrawingMain {

	public static void main(String[] args) {
		
		DrawingDB drawDB = DrawingDB.getInstance();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {

			System.out.println("⠀⠀⠀⠀⠀⢀⣀");
			System.out.println("⢰⣦⡄⣠⣾⣿⣿⣷⣿⣿⡆");
			System.out.println("⢸⣿⡇⣿⣿⡏⣿⣿⣿⣿⡇⢰⣟⣛⣻⠂⢸⣇⣀⣸⡇⠀⣿⠀⢸⣷⣄⢸⡇⢰⣟⣛⣻⡃⢸⣷⠀⢸⡇⠀⣿⣦⡀⣿⠀⣾⡛⣛⣿⡂");
			System.out.println("⠸⣿⡇⣿⣿⡇⣿⣿⡿⠿⡇⢰⣯⣭⣽⠇⢸⡏⠉⢹⡇⠀⣿⠀⢸⡇⠙⢿⡇⢠⣯⣭⣽⡇⠸⣿⣤⣼⡇⠀⣿⠈⠻⣿⠀⢿⣤⣭⣿⠇");
			System.out.println("⠀⠈⠁⠉⠙⠃⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣤⡄⣤⣤⢀⣤⣄⢠⠀⡄⣤⣤⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠬⠇⠟⠻⠘⠧⠞⠸⠤⠇⣿⠉⠀");

			System.out.println( " 신성그룹 회사 도면 관리 대장 시스템에 접속하셨습니다.");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("1. 도면 접수 | 2. 도면 출력 | 3. 도면 조회 | 4. 도면 검색| 5. 종료 ");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("행동을 선택하세요.");
			System.out.print(">>> ");
			int command = Integer.parseInt(scan.nextLine());
			
			if(command == 1) {
				// 도면 접수
				System.out.println("======================================================================");
				System.out.println("※주   의   사   항: 도면 파일 등록시 도면파일명 꼭 확인 부탁 드립니다.");
				System.out.println("도면파일명  명기법: pjt명_product명_접수일자.[pdf or dwg]");
				System.out.println("                    ex) LV5_Can,Assembly,Shield(Top 1)_160514.pdf");
				System.out.println("=====================================================================2");
				System.out.println("도면 파일을 넣어주세요.");
				System.out.print(">>> ");
				String drawing = scan.nextLine();
				System.out.println("접수 내용을 알려주세요.");
				System.out.print(">>> ");
				String content = scan.nextLine();
				Drawing draw = new Drawing(drawing, content);
				drawDB.registDrawing(draw);
				drawDB.revUp(drawing);
				
				System.out.println("도면 등록이 완료 되었습니다.");
			}else if(command == 2) {
				//도면 출력 
				//도면 출력시 검색 후 출력 되게끔 - library 클래스 참고
				System.out.print("출력할 도면 번호 입력 또는 도면명 검색해주세요: ");
				String input = scan.nextLine();
				if (drawDB.inputCheck(input)) {
					drawDB.printDrawing(Integer.parseInt(input));
				}else {
					drawDB.searchDrawing(input);
					System.out.print("출력할 도면 번호 입력 해주세요: ");
					int a = Integer.parseInt(scan.nextLine());
					drawDB.printDrawing(a);
				}
			}else if(command == 3) {
				// 도면 조회
				System.out.println("----------------------------------------------------------------------------------------");
				drawDB.showDrawList();
				System.out.println("----------------------------------------------------------------------------------------");
				// 위에 열의 제목들과 줄맞추기 -- give up
			}else if(command == 4) {
				// 도면 검색
				System.out.println("도면 검색");
				System.out.println("프로젝트명 또는 제품명 일부로 검색 가능합니다^^");
				System.out.print("검색할 내용을 입력하세요: ");
				// DB에 완료- toLowerCase()로 정리 대소문자 구분없이 검색가능하게끔 하기 (equalsIngoreCase()????????????)
				String keyword = scan.nextLine();
				drawDB.searchDrawing(keyword.toLowerCase());
			}else {
				// 종료
				System.out.println("도면 관리 잊지 마세요.");
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
