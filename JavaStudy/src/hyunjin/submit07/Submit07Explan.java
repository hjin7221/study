package hyunjin.submit07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Submit07Explan {

	public static void main(String[] args) {

		System.out.println("\n===================== 1-1번 문제 =================\n");
		// Q.1-1 정수를 담을 수 있는 ArrayList 객체를 생성하고, 10부터 20사이의 랜덤 숫자를 10개 담으시오.
		// (10도 나오고 20도 나올수 있어야 함.)
		ArrayList<Integer> intList = new ArrayList<>();

		// 1~45 => (int)(Math.random() * 45 ) + 1;
		// 15~30 => (int)(Math.random() * 16) + 15;
		// 0~10 => (int)(Math.random() * 11);
		// 10~20 => (int)(Math.random() * 11) + 10 ;

		for (int i = 0; i < 10; i++) {
			int rand = (int) (Math.random() * 11) + 10;
			intList.add(rand);
		}
		System.out.println(intList);

		System.out.println("\n===================== 1-2번 문제 =================\n");
		// Q.1-2 해당 정수형 리스트에서 중복된 숫자들을 제거한 후 출력하시오.

		ArrayList<Integer> newList = new ArrayList<>();
		// 중복제거 1번째 방법
		for (int i = 0; i < intList.size(); i++) {
			// newList안에 현재의 intList.get(i) 가 존재하지 않는 경우에만 추가해주기
			if (newList.contains(intList.get(i))) { // newList앞에 !붙이면 not으로 바뀜
				continue;
			} else {
				newList.add(intList.get(i));
			}
		}
		System.out.println(newList);
		// 중복제거 2번째 방법
		for (int i = 0; i < intList.size(); i++) {
			for (int k = intList.size() - 1; k > i; k--) {
				if (intList.get(i) == intList.get(k)) {
					intList.remove(k);
				}
			}
		}
		System.out.println(intList);
		System.out.println("\n===================== 1-3번 문제 =================\n");
		// Q.1-3 중복을 제거한 정수형 리스트를 오름차순으로 정렬하여 출력하시오.
		Collections.sort(intList);
		System.out.println(intList);

		System.out.println("\n===================== 1-4번 문제 =================\n");
		// Q.1-4 중복을 제거한 정수형 리스트를 내림차순으로 정렬하여 출력하시오.

		Collections.sort(intList, Collections.reverseOrder());
		System.out.println(intList);

		System.out.println("\n===================== 1-@번 문제 =================\n");
		// Q.1-@ 숫자 a부터 b사이의 랜덤 정수를 리턴해주는 메소드를 만들어보세요.
		int rand = makeRandom(10, 20);
		System.out.println(rand);

		System.out.println("\n===================== 2-1번 문제 =================\n");

		ArrayList<String> wifeList = new ArrayList<>();
		wifeList.add("냉장고");
		wifeList.add("로봇청소기");
		wifeList.add("세탁기");
		wifeList.add("에어컨");

		ArrayList<String> husbandList = new ArrayList<>();
		husbandList.add("노트북");
		husbandList.add("TV");
		husbandList.add("에어컨");
		husbandList.add("플레이스테이션");
		husbandList.add("로봇청소기");

		ArrayList<String> coupleList = new ArrayList<>();
		for (int i = 0; i < wifeList.size(); i++) {
			if (husbandList.contains(wifeList.get(i))) {
				coupleList.add(wifeList.get(i));
			}
		}
		System.out.println(coupleList);

		// 교집합을 위한 .retainAll()
		coupleList.clear();
		coupleList.addAll(wifeList); // 아내의 구매목록 전부를 담기
		coupleList.retainAll(husbandList);
		System.out.println(coupleList);

		System.out.println("\n===================== 2-2번 문제 =================\n");

		// 전체구매목록(합집합)

		ArrayList<String> allBuy = new ArrayList<>();

		allBuy.addAll(wifeList);

		for (int i = 0; i < husbandList.size(); i++) {
			if (!allBuy.contains(husbandList.get(i))) {
				allBuy.add(husbandList.get(i));
			}
		}
		System.out.println(allBuy);
	}

	public static int makeRandom(int a, int b) {
		return (int) (Math.random() * (b - a + 1)) + a;
	}

}
