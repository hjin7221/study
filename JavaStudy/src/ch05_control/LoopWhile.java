package ch05_control;

import java.util.Scanner;

public class LoopWhile {

	public static void main(String[] args) {
		// While문
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		int i = 1;
		while(i <= 10) {
			// 조건문이 false가 되면 while문 종료
			// true면 내부 실행
			System.out.println(i);
			i++; //증감식
		}
		
		// for문을 굳이 while처럼 쓰기
		int k = 1;
		for( ; k <= 10; ) {
			
			System.out.println(k);
			k++;
		}
		
		// while문으로 구구단 2단
		// 2 x 2 = 4
		// 2 x 3 = 6
		// 2 x 9 = 18
		
		int x = 1;
		while ( x <= 9) {
			System.out.println("2 x " + x + " = " + (2 * x));
			x++;
		}
		
		// 서로 같은 반복문이긴 하나, 일반적으로 
		// while문은 반복횟수가 정해지지 않은 경우 사용
		// for문은 반복횟수가 정해져 있는 경우 사용
		
		System.out.println("\n=============================================\n");
		
		// 콘솔형 프로그램
		Scanner scan = new Scanner(System.in);
		boolean isRun = true;
		
		while(isRun) {
			System.out.println("이름 입력[종료는 q 또는 Q]");
			System.out.println(">>> ");
			
			String input = scan.nextLine();
			
			if(input.equals("q") || input.contentEquals("Q")) {
				System.out.println("프로그램을 종료합니다.");
				isRun = false;
			}else {
				System.out.println(input + "님 환영합니다.");
			}
			
		}
		
		// break 문 사용
//		while(true) {
//			System.out.println("이름 입력[종료는 q 또는 Q]");
//			System.out.println(">>> ");
//			
//			String input = scan.nextLine();
//			
//			// 대소문자 구분없이 체크
//			if(input.equalsIgnoreCase("q")) {
//				System.out.println("프로그램을 종료합니다.");
//				break;
//			}
//			
//				System.out.println(input + "님 환영합니다.");
//			}
		
		System.out.println("\n=============================================\n");
		
		//do-while문
		isRun = false;
		
		// 반복해야할 내용이 최소 한번은 실행되게끔
		// 하고 싶을 때 사용. (굳이 몰라도 된다.)
		
		do {
			//반복될 내용 작성
			System.out.println("하이");
		}while(isRun);
		
		System.out.println("\n=============================================\n");
		
		// while문 또한 다중으로 사용가능
		// while문으로 구구단
		// 2 x 2 = 4
		// 2 x 3 = 6
		// 2 x 9 = 18
		// 3 x 2 = 6
		// 3 x 3 = 9
		// 9 x 9 = 81
		
		int left = 2;
		while (left <= 9) {
			int right = 1;
			while (right <= 9) {
				System.out.println(left + " x " + right + " = " + (left * right));
				right++;
			}
			left++;
		}
		
		System.out.println("\n=============================================\n");
		
		// 포켓몬스터
		
		int enemyHp = 100;
		outer: while(true) {
			System.out.println("야생의 파이리를 만났습니다.");
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 공격 | 2. 도망");
			System.out.println(">>> ");
			
			int command = Integer.parseInt(scan.nextLine());
			
			if(command ==1 ) {
				// TODO 공격
				 while(true) {
					System.out.println("공격 방법 선택");
					System.out.println("1. 백만볼트 | 2. 전광석화 | 3. 취소");
					System.out.println(">>> " );
					
					int select = Integer.parseInt(scan.nextLine());
					
					if(select == 1) {
						System.out.println("피~카~~~~~~~~~~츄!!!!");
						enemyHp -= 20;
					}else if(select == 2) {
						System.out.println("삐까삐까!!");
						enemyHp -= 10;
					}else if(select == 3) {
						System.out.println("공격 취소");
						// 내부 while문 종료
						// 외부 while문은 계속 실
						break;
					}
					
					System.out.println("파이리의 현재 체력: " + enemyHp);
					
					//파이리 깨꼬닥
					if(enemyHp <=0) {
						System.out.println("파이리를 잡았다!!");
//						System.exit(0);    // 프로그램 종료
						// 내부에 외부 while문 중지
						break ;
					}
				}
			}else if(command == 2) {
				// 도망
				System.out.println("도망쳤습니다.");
				break outer;
			}
			
			
		}
		
		
	}

}
