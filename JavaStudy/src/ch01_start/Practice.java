package ch01_start;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String a = scan.nextLine();
		String b = scan.nextLine();
		System.out.println(Integer.parseInt(a) + Integer.parseInt(b));
		scan.close();
	}
}