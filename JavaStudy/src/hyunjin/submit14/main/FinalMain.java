package hyunjin.submit14.main;

import java.util.Scanner;

import hyunjin.submit14.service.MembersService;

public class FinalMain {

	public static void main(String[] args) {
		MembersService memService = MembersService.getInstance();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("하단 메뉴중 선택 해주세요.");
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 아이디/비밀번호 찾기 | 4. 종료");
			System.out.print(">>> ");
			
			int command = 0;
			try {
				command = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
				continue;
			}
			
			if(command == 1) {
				//TODO 로그인
				
			}else if(command == 2) {
				//TODO 회원가입
				
			}else if(command == 3) {
				//TODO 아이디/비밀번호찾기
				
			}else if(command == 4) {
				//TODO 종료
				
			}else {
				System.out.println("다시 입력해주세요.");
			}
			
			
		}
	}

}
