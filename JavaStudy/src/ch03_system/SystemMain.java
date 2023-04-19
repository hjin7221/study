package ch03_system;

import java.util.Scanner;

public class SystemMain {

	public static void main(String[] args) {
		// 표준 출력
		// 콘솔창에 텍스트 출력하기
		// println()
		// 콘솔창에 괄호안 내용을 출력 후 줄바꿈(개행문자) 처리
		System.out.println("start");
		System.out.println();  // 줄바꿈만 일어남
		System.out.println("end");
		
		// print()
		// 괄호안 내용을 출력하기만 함.
		System.out.print("줄바꿈 안됨");
		System.out.print("보기 불편..");
		
		System.out.println("\n===============================================\n");
		
		// 제어문자
		// 문자열 내에 역슬래시(\)를 이용하여
		// 특정 기능을 사용할 수 있다.
		
		// \n 줄바꿈
		
		System.out.print("println처럼 동작\n");
		System.out.println("중간에 \n 을 넣어보자");
		
		// \t 탭
		System.out.println("월\t화\t수\t목\t금");
		System.out.println("1\t2\t3\t4\t5");
		System.out.println("8\t9\t10\t11\t12");
		
		// 문자열 내에서 기능을 가지는 문자(\, ", ')
		// 해당 문자들을 출력하고 싶다면 앞에 \를 붙여준다
		System.out.println("개행문자는 \\n");
		System.out.println("소크라테스 왈 \"배부른 너 자신을 알라\"");
		
		// 특수문자로 출력 가능하다.
		System.out.println("＊");
		
		System.out.println("\n===============================================\n");		
		
		// printf()
		// 콘솔창에 포맷 문자열(format string) 형태로 내용을 출력
		System.out.printf("%d명이 수업을 듣고 있습니다.\n", 24);
		System.out.printf("%d명이 %s을 듣고 있습니다.\n", 24, "수업");
		
		// 예시
		System.out.printf("%03d장 표준입출력\n", 3); // d 앞 0은 해당숫자없을시 기입되는 숫자 , 3은 자릿수
		System.out.printf("원주율은 %.02f\n", 3.141592);
		System.out.printf("통장 잔고는 %,d원입니다.", 1000000);
		
		System.out.println("\n===================== 표준 입력 ==========================\n");
		
		// Scanner 클래스로부터 객체 생성
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		System.out.print(">>> ");
		
		// 키보드 입력 받기
		String name = scan.nextLine();
		
		System.out.println(name + ": 좀 덥네요.");
		
		// scan.next() 또는 scan.nextInt() 등은 사용하지 않기.
		// next() 나 nextInt()는 \n을 날리지 않아서 다음번 nextLine사용시 error발생
		System.out.println("에어컨 희망 온도를 입력해주세요.");
		System.out.print(">>> ");
		// .nextLine() 은 숫자를 입력해도 문자열로 가지고 온다.
		int temper = Integer.parseInt(scan.nextLine());
		System.out.println("희망 온도: " + temper);
		System.out.println("냉방/난방 선택해주세요.");
		System.out.print(">>> ");
		String mode = scan.nextLine();
		System.out.println("모드: " + mode);
		
		
		
	}

}
