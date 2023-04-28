package ch02_variable;

public class VariableName {
	// 변수명, 클래스명 등 명명 규칙
	
	// 프로젝트 이름은 앞에 대문자를 쓴다.
	// 다음 단어의 앞글자도 대문자를 쓴다.(예: JavaStudy, MyProject 등)
	
	// 패키지(폴더) 이름은 전부 소문자로 쓴다.
	// 필요하다면 단어 사이에 언더바(_) 추가
	
	// 클래스 이름은 프로젝트 이름 짓는 법과 동일
	
	// 변수명 짓기 (=함수명 짓기)
	// 카멜(Camel) 방식
	// 첫글자는 소문자, 다음 단어들은 대문자로 시작
	// 가장 많이 쓰게 될 명명 규칙
	int todayIsHappy = 0;
	
	// 스네이크 방식
	int today_is_happy = 0;
	int TODAY_IS_HAPPY = 0;
	
	// 헝가리안 방식
	// 변수명 앞에 변수의 타입 적어두는 방식
	int intTodayIsHappy = 0;
	String strTodayIsHappy = "행복";
	
	// 변수명에는 앞에 v_ 를 붙이고
	// 함수명에는 앞에 f_ 를 붙이고
	// 파라미터명에는 앞에 p_ 를 붙이는 방식
	int v_todayIsHappy = 0;
	
	
	
	
	
}
