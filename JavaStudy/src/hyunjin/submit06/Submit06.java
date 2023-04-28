package hyunjin.submit06;

import java.util.Arrays;

public class Submit06 {

	public static void main(String[] args) {

		System.out.println("\n=================== 1번 문제 =========================");
		// for문을 이용하여 이씨성을 가진 사람이 몇명인지 출력하시오
		String[] nameList = { "이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석", "황정민", "박소담", "이선균", "이성민",
				"최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬" };
		int count = 0;
		for (int i = 0; i < nameList.length; i++) {
			if (nameList[i].contains("이")) {
				count++;
			}
		}
		System.out.println("이씨 성을 가진 배우가 총 " + count + "명 있습니다.");

		System.out.println("\n=================== 2번 문제 =========================");
		// 최댓값, 최소값 구하기

		int[] intArr = { 23, 456, 213, 32, 464, 1, 2, 4 };

		for (int k = 0; k < intArr.length - 1; k++) {
			for (int i = 0; i < intArr.length - 1; i++) {
				if (intArr[i] < intArr[i + 1]) {
					int t = intArr[i];
					intArr[i] = intArr[i + 1];
					intArr[i + 1] = t;
				}
			}
		}
		System.out.println("최대값: " + intArr[0]);

		for (int k = 0; k < intArr.length - 1; k++) {
			for (int i = 0; i < intArr.length - 1; i++) {
				if (intArr[i] > intArr[i + 1]) {
					int t = intArr[i];
					intArr[i] = intArr[i + 1];
					intArr[i + 1] = t;
				}
			}
		}

		System.out.println("최소값: " + intArr[0]);

		System.out.println("\n=================== 3번 문제 =========================");

		// 로또 번호 생성기

		int[] myLotto = makeLotto();
		for (int i = 0; i < myLotto.length; i++) {
			System.out.print(myLotto[i] + " ");
		}

	}

	public static int[] makeLotto() {
		int[] intArray = new int[6];
		for (int i = 0; i < 6; i++) {
			intArray[i] = (int) (Math.random() * 45) + 1;
		}
		for (int k = 0; k < intArray.length - 1; k++) {
			for (int i = 0; i < intArray.length - 1; i++) {
				if (intArray[i] > intArray[i + 1]) {
					int t = intArray[i];
					intArray[i] = intArray[i + 1];
					intArray[i + 1] = t;
				}
			}
		}
		return intArray;
	}

}
