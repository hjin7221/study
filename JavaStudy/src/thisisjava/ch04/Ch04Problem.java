package thisisjava.ch04;

import java.util.Scanner;

public class Ch04Problem {

	public static void main(String[] args) {

		// 3번 문제
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);

		// 4번 문제
		while (true) {
			int dice1 = (int) (Math.random() * 6) + 1;
			int dice2 = (int) (Math.random() * 6) + 1;
			System.out.println("(" + dice1 + " , " + dice2 + ")");
			if (dice1 + dice2 == 5) {
				break;
			}
		}

		// 5번 문제 4x + 5y = 60 의 모든 해 구하기 (단 x,y는 10이하의 자연수)

		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				if ((4 * x) + (5 * y) == 60) {
					System.out.println("(" + x + " , " + y + ")");
					continue;
				}
			}
		}

		// 6번 문제
		String star = "";
		for (int i = 0; i < 5; i++) {
			star += "*";
			System.out.println(star);
		}

		// 7번 문제

		Scanner scan = new Scanner(System.in);

		System.out.println("---------------------------------");
		System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
		System.out.println("---------------------------------");
		System.out.print("선택> ");
		int command = Integer.parseInt(scan.nextLine());
		int money = 0;
		while (true) {
			if (command == 1) {
				System.out.println("예금액> ");
				int deposit = Integer.parseInt(scan.nextLine());
				money += deposit;
				return;
			} else if (command == 2) {
				System.out.println("출금액> ");
				int withdraw = Integer.parseInt(scan.nextLine());
				money -= withdraw;
				return;
			} else if (command == 3) {
				System.out.println("잔고> " + money);
				return;
			} else {
				System.out.println("프로그램 종료");
				break;
			}
		}

	}

}