package ch09_class.commons;

// 유용한 메소드들을 가지고 있는 클래스 
public class UtilClass {
	
	// ch06_mehthod/MethodMain에서 했던 weRound
	/**
	 * 입력한 소수를 반올림하여 소수 n번째 자리로 리턴해주는 함수입니다.
	 * 
	 * @param num 반올림하고자 하는 소수
	 * @param n   소수 n번째 자리까지 리턴
	 * @return 반올림된 소수를 리턴
	 */
	public static double weRound(double num, int n) {
		// 10의 n제곱 구하기
		int ten = 1;
		for (int i = 0; i < n; i++) { // n회 반복 for문
			ten *= 10;
		}

		num *= ten;
		long temp = Math.round(num);
		double result = (double) temp / ten;
		return result;
	}
	
	
	
}
