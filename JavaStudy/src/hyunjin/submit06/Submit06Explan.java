package hyunjin.submit06;

import java.util.Arrays;

public class Submit06Explan {

	public static void main(String[] args) {
		System.out.println("\n=================== 1번 문제 =========================");
		// "이"씨 성을 가진 사람이 몇명?
		String[] nameList = { "이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석", "황정민", "박소담", "이선균", "이성민",
				"최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬" };
		int count = 0;
		for (int i = 0; i < nameList.length; i++) {
			String str = nameList[i].substring(0, 1);
			if (nameList[i].indexOf("이") == 0) {
				count++;
			}

//			if(str.equals("이")) {
//				count++;
//			}
		}
		System.out.println("이 씨 성을 가진 사람 수 :" + count);

		System.out.println("\n=================== 2번 문제 =========================");
		// 최댓값, 최소값 구하기

		int[] intArr = { 23, 456, 213, 32, 464, 1, 2, 4 };
		int max = intArr[0];
		for (int i = 0; i < intArr.length; i++) {
			if (max < intArr[i]) {
				max = intArr[i];
			}
		}
		System.out.println("최대값: " + max);

		// 최소값
		int min = intArr[0];
		for (int i = 0; i < intArr.length; i++) {
			if (min > intArr[i]) {
				min = intArr[i];

			}
		}
		System.out.println("최소값: " + min);

		System.out.println("\n=================== 3번 문제 =========================");

		// Q.003 로또 생성기

		int[] myLotto = makeLotto();
		for (int i = 0; i < myLotto.length; i++) {
			System.out.print(myLotto[i] + " ");
		}

		System.out.println("\n=================== 월요병 탈출 =========================");

		// 로또 시뮬레이션
		int[] winLotto = { 4, 24, 27, 35, 37, 45 };
		int buyCount = 0;
		while (true) {
			buyCount++;
			int[] lotto = makeLotto();

			int cnt = 0;
			for (int i = 0; i < winLotto.length; i++) {
				if (winLotto[i] == lotto[i]) {
					cnt++;
				}
			}
			if (cnt == 6) {
				System.out.println("1등 당첨!!!!!!!");
				System.out.println("구매 횟수: " + buyCount);
				System.out.println("구매 금액: " + (buyCount * 1000));
				break;
			} else {
				System.out.println(buyCount + "회차");
			}
		}
//		int[] lotto = makeLotto();
//		
//		
//		int cnt = 0;
//		for(int i = 0; i < winLotto.length; i++) {
//			if(winLotto[i] == lotto[i]) {
//				cnt++;
//			}
//		}
//		if(cnt == 6) {
//			System.out.println("두 배열이 같다");
//			
//		}else {
//			System.out.println("꽝");
//		}

	}

	public static int[] makeLotto() {
		// 로또 번호 (1~45 사이의 랜덤숫자)
		int[] result = new int[6];

		// 중복 없이 로또 번호 6자리를 담기
		int idx = 0;
		outer: while (true) {
			int rand = (int) (Math.random() * 45) + 1;

			// rand가 result 배열 안에 없는 숫자라면
			// 담기
			for (int i = 0; i < result.length; i++) {
				if (result[i] == rand) {
					continue outer;
				}
			}

			result[idx] = rand;
			idx++;

			if (idx == 6) {
				break;
			}
		}
		Arrays.sort(result);

		return result;
	}
}
