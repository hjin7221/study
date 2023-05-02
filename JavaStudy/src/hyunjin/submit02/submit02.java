package hyunjin.submit02;

import java.util.Scanner;

public class submit02 {

	public static void main(String[] args) {
		System.out.println("\n========= 1번 문제 =========\n");

		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		System.out.print(">>> ");
		String name = scan.nextLine();
		System.out.println("국어 점수를 입력해주세요.");
		System.out.print(">>> ");
//		String koreanPoint = scan.nextLine();
		int kor = Integer.parseInt(scan.nextLine());
		System.out.println("영어 점수를 입력해주세요.");
		System.out.print(">>> ");
//		String englishPoint = scan.nextLine();
		int eng = Integer.parseInt(scan.nextLine());
		System.out.println("수학 점수를 입력해주세요.");
		System.out.print(">>> ");
//		String mathPoint = scan.nextLine();
		int math = Integer.parseInt(scan.nextLine());
		System.out.println("이름: " + name);
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
//		double averagePoint = ((double)(Integer.parseInt(koreanPoint)) 
//				+ (Integer.parseInt(englishPoint))
//				+ (Integer.parseInt(mathPoint))) /3 ;
		double averagePoint = (kor + eng + math) / 3.0;
		System.out.printf("평균: %.2f\n", averagePoint);
		String grade = (averagePoint >= 90) ? ("A") : ((averagePoint >= 80) ? ("B") : ("C"));
		System.out.println("등급 : " + grade);

		System.out.println("\n========= 2번 문제 =========\n");

		String idBack = "1231476";

		int firstNum = Integer.parseInt(idBack.substring(0, 1));
		String gender = (firstNum % 2 == 1) ? ("남") : ("여");
		System.out.println(gender);

//		String first = idback.substring(0,1);
//		System.out.println(first);

//		char start = idback.charAt(0) + "";
//		System.out.println(start);

//		String strStart = start + "";
//		System.out.println(strStart);

//		int num = Integer.ParseInt(strStart);
//		String gender = (num & 2 == 1) ? ("남") : ("여");
//		System.out.println(gender);

	}

}