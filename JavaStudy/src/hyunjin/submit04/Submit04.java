package hyunjin.submit04;

import java.util.Scanner;

public class Submit04 {

	public static void main(String[] args) {
		// Q.01 문자열 입력받아서 순서 뒤집어서 출력
		// Hint
		// Loopfor의 1부터 n까지 더하는 형태 참고
		// for 문 내부가 반복될때마다 입력받은 문자열을 한글자씩 잘라 문자열 변수에 더한다.
		// 로꾸꺼 로꾸꺼
		Scanner scan = new Scanner(System.in);

		System.out.println("문자를 입력하시오.");
		System.out.print(">>> ");
		String input = scan.nextLine();

		for (int i = 0; i < input.length(); i++) {
			System.out.print(input.substring((input.length() - 1) - i, input.length() - i));
		}

		// Q02.

		System.out.println("\n========== 화영빌딩 엘리베이터 ========\n");

		int a = 10;
		int b = 4;
		while (true) {
			System.out.println("승강기 A의 현재위치: " + a + "층");
			System.out.println("승강기 B의 현재 위치: " + b + "층");
			System.out.print(" 몇층에 계시나요? [종료하시려면 q 또는 exit 입력]: ");
			String floor = scan.nextLine();
			;
			if (floor.equals("q") || floor.equals("exit")) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
			int aDif = Math.abs(a - Integer.parseInt(floor));
			int bDif = Math.abs(b - Integer.parseInt(floor));
			if (aDif > bDif) {
				System.out.println(b + "층에서 엘리베이터를 호출합니다.");
				System.out.println("승강기 B가 " + floor + "층으로 이동하였습니다.");
				System.out.println();
				System.out.println("\n========== 화영빌딩 엘리베이터 ========\n");
				b = Integer.parseInt(floor);
			} else if (bDif > aDif) {
				System.out.println(a + "층에서 엘리베이터를 호출합니다.");
				System.out.println("승강기 A가 " + floor + "층으로 이동하였습니다.");
				System.out.println();
				System.out.println("\n========== 화영빌딩 엘리베이터 ========\n");
				a = Integer.parseInt(floor);
			} else if (aDif == bDif) {
				if (a > b) {
					System.out.println(a + "층에서 엘리베이터를 호출합니다.");
					System.out.println("승강기 A가 " + Integer.parseInt(floor) + "층으로 이동하였습니다.");
					System.out.println();
					System.out.println("\n========== 화영빌딩 엘리베이터 ========\n");
					a = Integer.parseInt(floor);
				} else if (b > a) {
					System.out.println(b + "층에서 엘리베이터를 호출합니다.");
					System.out.println("승강기 B가 " + Integer.parseInt(floor) + "층으로 이동하였습니다.");
					System.out.println();
					System.out.println("\n========== 화영빌딩 엘리베이터 ========\n");
					b = Integer.parseInt(floor);
				}
			}
		}
	}
}