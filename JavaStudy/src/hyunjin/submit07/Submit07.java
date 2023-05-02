package hyunjin.submit07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Submit07 {

	public static void main(String[] args) {
		System.out.println("\n===================== 1-1번 문제 =================\n");
		// Q.1-1 정수를 담을 수 있는 ArrayList 객체를 생성하고, 10부터 20사이의 랜덤 숫자를 10개 담으시오.
		// (10도 나오고 20도 나올수 있어야 함.)
		ArrayList<Integer> randomList = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			int randInt = (int) (Math.random() * 11) + 10;
			randomList.add(randInt);
		}
		System.out.println(randomList);

		System.out.println("\n===================== 1-2번 문제 =================\n");
		// Q.1-2 해당 정수형 리스트에서 중복된 숫자들을 제거한 후 출력하시오.

		ArrayList<Integer> randList = new ArrayList<Integer>();
		for (int i = 0; i < randomList.size(); i++) {
			if (randList.contains(randomList.get(i))) {
				continue;
			} else {
				randList.add(randomList.get(i));
			}
		}
		System.out.println(randList);

		System.out.println("\n===================== 1-3번 문제 =================\n");
		// Q.1-3 중복을 제거한 정수형 리스트를 오름차순으로 정렬하여 출력하시오.
		Collections.sort(randList);
		System.out.println(randList);

		System.out.println("\n===================== 1-4번 문제 =================\n");
		// Q.1-4 중복을 제거한 정수형 리스트를 내림차순으로 정렬하여 출력하시오.
		Collections.sort(randList, Collections.reverseOrder());
		System.out.println(randList);

		System.out.println("\n===================== 1-@번 문제 =================\n");
		// Q.1-@ 숫자 a부터 b사이의 랜덤 정수를 리턴해주는 메소드를 만들어보세요.
		int rand = makeRandom(10, 20);
		System.out.println(rand);

		System.out.println("\n===================== 2-1번 문제 =================\n");

		ArrayList<String> wifeList = new ArrayList<String>(Arrays.asList("냉장고", "로봇청소기", "세탁기", "에어컨"));
		ArrayList<String> husbandList = new ArrayList<String>(Arrays.asList("노트북", "TV", "에어컨", "플레이스테이션", "로봇청소기"));

		// Q.2-1 서로 사고 싶은 물건 목록을 새로운 리스트에 담아 콘솔에 출력해주세요.

		ArrayList<String> coupleList = new ArrayList<String>();

		while (true) {
			for (int i = 0; i < husbandList.size(); i++) {
				if (wifeList.contains(husbandList.get(i))) {
					coupleList.add(husbandList.get(i));
				} else {
					continue;
				}
			}
			System.out.println(coupleList);
			break;
		}

		System.out.println("\n===================== 2-2번 문제 =================\n");

		ArrayList<String> coupList = new ArrayList<String>();

		for (int i = 0; i < wifeList.size(); i++) {
			coupList.add(wifeList.get(i));
		}

		for (int i = 0; i < husbandList.size(); i++) {
			if (coupList.contains(husbandList.get(i))) {
				continue;
			} else {
				coupList.add(husbandList.get(i));
			}
		}
		System.out.println(coupList);
	}

	public static int makeRandom(int num1, int num2) {

		int randInt = (int) (Math.random() * ((num2 - num1) + 1)) + (num1);

		return randInt;

	}

}