package ch11_api;

public class ApiStringBuffer {

	public static void main(String[] args) {
		// 문자열하면? String
		// String을 계속 수정하면
		// 힙 영역에 매번 새로운 String 객체가 만들어지고
		// 그로 인해 가비지 컬렉터가 할 일이 많아진다.
		// 비효율적

		// 랜덤 숫자 10자리를 문자열에 더하기
		String text = "";

		for (int i = 0; i < 10; i++) {
			int rand = (int) (Math.random() * 10);
			text += rand;
			if (i % 10000 == 0) {
				System.out.println(i);
			}
		}
		System.out.println(text);

		System.out.println("\n============================\n");

		// StringBuffer 객체 소환
		StringBuffer strBuff = new StringBuffer();

		System.out.println(strBuff);

		// append(문자열) 문자열을 추가.
		strBuff.append("12");
		System.out.println(strBuff);

		strBuff.append(34);
		System.out.println(strBuff);

		for (int i = 0; i < 100000000; i++) {
			int rand = (int) (Math.random() * 10);
			strBuff.append(rand);
		}
		// 문자열의 길이 리턴
		System.out.println(strBuff.length());

		// 파라미터에 String을 입력받는 메소드에
		// StringBuffer가 가진 문자열을 넘겨주는 경우
		// .toString() 꺼내어 넘겨준다.

		String str = strBuff.toString();
		System.out.println(str.length());

		// 보유중인 문자열 비우기
		strBuff = new StringBuffer();

		System.out.println("\n================================\n");
		// StringBuilder
		// StringBuffer와 사용법이 똑같다.

		StringBuilder strBuild = new StringBuilder();

		strBuild.append("안녕");
		System.out.println(strBuild);

		str = strBuild.toString();

		// 둘의 차이점
		// StringBuffer는 동기화 지원
		// StringBuilder는 동기화 미지원

		// 동기화를 지원한다???
		// 멀티 쓰레드 환경에서 해당 객체가
		// 모든 쓰레드에서 안정적으로 사용할 수 있음

		// 동기화 지원 (StringBuffer)
		// 쓰레드 a, b, c에서 strBuffer를 사용한다면
		// 쓰레드 a에서 strBuff의 값을 바꿨을 때
		// 쓰레드 b, c에서 이 사실을 안다.

		// 동기화 미지원 (StringBuilder)
		// 쓰레드 a, b, c에서 strBuild를 사용한다면
		// 쓰레드 a에서 strBuild의 값을 바꿨을 때
		// 쓰레드 b, c에서 이를 모를 수 있다.

	}

}
