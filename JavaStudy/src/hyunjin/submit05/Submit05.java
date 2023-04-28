package hyunjin.submit05;

public class Submit05 {

	public static void main(String[] args) {
		System.out.println("\n====== 1번 문제 ========");

		makeTree(5);
		makeTree(7);

		System.out.println("\n====== 2번 문제 ========");

		String example = "로꾸꺼 로꾸꺼";
		String result = reverseStr(example);
		System.out.println(result);

		System.out.println("\n====== 3번 문제 ========");

		String myBinaryStr = makeBinary(1000);
		System.out.println(myBinaryStr);

	}

	public static void makeTree(int num) {
		for (int i = 0; i < num; i++) {
			String spaces = "";

			for (int k = 0; k < (num - 1) - i; k++) {
				spaces += " ";
			}
			String starss = "";
			for (int k = 0; k < (i * 2) + 1; k++) {
				starss += "*";
			}

			System.out.println(spaces + starss);
		}

	}

	public static String makeBinary(int num) {
		String input = "";
		while (num != 1) {
			input = (num % 2) + input;
			num = num / 2;
		}
		if (num == 1) {
			input = num + input;
		}
//		String res3 = "";
//		for (int i = 0; i < input.length(); i++) {
//			String str = input.substring(input.length() - 1 - i, input.length() - i);
//			res3 += str;
//		}
		return input;
	}

	public static String reverseStr(String msg) {
		String res2 = "";
		for (int i = 0; i < msg.length(); i++) {
			String str = msg.substring(msg.length() - 1 - i, msg.length() - i);
			res2 += str;
		}
		return res2;
	}

}
