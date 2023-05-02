package hyunjin.submit03;

public class Submit03 {

	public static void main(String[] args) {

		System.out.println("\n========== 1번 문제 ===============\n"); // hint : 숫자가 엄청 크다.

		long sum = 1l;
		for (int i = 1; i <= 10; i++) {
			sum *= i;
		}
		System.out.println(sum);

		sum = 1l;
		for (int i = 1; i <= 15; i++) {
			sum *= i;
		}
		System.out.println(sum);

		System.out.println("\n========== 2번 문제 ==============\n"); // hint: 어디서 에러가 나는지 확인 필요.

		String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";
		int count = 0;
		for (int i = 0; i < findWally.length(); i += 2) {
			String str = findWally.substring(i, i + 2);
			if (str.equals("윌리")) {
				count++;
			}
		}
		System.out.println("월리의 갯수: " + count);

		System.out.println("\n========== 3번 문제 ============\n");

		for (int i = 0; i < 5; i++) {
			String star = "*****";
			star = star.substring(0, 5 - i);
			System.out.println(star);
		}

	}

}