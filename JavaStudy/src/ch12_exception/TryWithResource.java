package ch12_exception;

import java.util.Scanner;

public class TryWithResource {

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		
//		try {
//			System.out.println("아무말이나 입력");
//			System.out.print(">>>");
//			String inputText = scan.nextLine();
//			System.out.println(inputText);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			scan.close();
//		}
		
		// try-with-resource 구문
		// 닫아야 할 객체를 try() 소괄호 안에 선언 후
		// try{} 브록 내에서 해당 객체를 사용
		// (그럼 자동으로 해당 객체를 close() 해준다)
		try (Scanner scan = new Scanner(System.in)){
			System.out.println("아무말이나 입력");
			System.out.print(">>> ");
			String inputText = scan.nextLine();
			System.out.println(inputText);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
