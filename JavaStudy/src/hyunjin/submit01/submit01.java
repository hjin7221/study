package hyunjin.submit01;

public class submit01 {

	public static void main(String[] args) {

		// 1번 문제
		String name = "정현진";
		int age = 36;
		double height = 176.7;
		String phone = "010-5587-7221";
		String email = "hjin7221@gmail.com";

		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("키: " + height);
		System.out.println("휴대폰: " + phone);
		System.out.println("이메일 :" + email);

		// 2번 문제
		String enigma = "너오구늘리뭐너먹구지리";
		enigma = enigma.replace("너", "");
		enigma = enigma.replace("구", "");
		enigma = enigma.replace("리", "");
		System.out.println(enigma);

		// 3번 문제
		int example = 278;
		String example1 = example + "";
		String x = example1.substring(0, 1);
		String y = example1.substring(1, 2);
		String z = example1.substring(2);
		int intx = Integer.parseInt(x);
		int inty = Integer.parseInt(y);
		int intz = Integer.parseInt(z);
		System.out.println(intx + inty + intz);

		///////// 풀이

		String name1 = "정현진";
		int age1 = 36;
		double height1 = 176.7;
		String phone1 = "01055877221";
		String email1 = "hjin7221@gmail.com";

		System.out.println("이름: " + name1);
		System.out.println("나이: " + age1);
		System.out.println("키: " + height1);
		System.out.println("연락처: " + phone1);
		System.out.println("이메일: " + email1);

	}
}
