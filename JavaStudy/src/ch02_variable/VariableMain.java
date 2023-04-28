package ch02_variable;

public class VariableMain {

	public static void main(String[] args) {
		// 변수의 선언 
		// [변수 타입] [변수명] 의 형태
		int myMoney;
		
		// 값을 담지 않은 경우 사용할 수 없다.
		// 해당 커서 주석처리
		// 단축키 [Ctrl + /]
//		System.out.println(myMoney);
		
		// 변수에 값 할당
		// 변수 초기화 (intialization = init)라고 한다.
		// 등호(=)를 이용하여 변수에 값을 담을 수 있다.
		// 등호 오른쪽의 값을 왼쪽에 담는다.
		myMoney = 10000;
		System.out.println(myMoney);
		
		// 변수의 값을 변경 할 수 있다.
		// (그러니까 변수라고 부름, 값이 변할 수 있는 녀석)
		myMoney = 1000000;
		System.out.println(myMoney);
		
		// 변수의 선언과 함께 값을 할당
		int numOne = 1;
		double pi = 3.14;
		
		System.out.println(numOne);
		System.out.println(pi);
		
		// 상수(Constant)의 선언
		// 값이 항상 같은 녀석
		// 값이 바뀌면 안되는 녀석에 대해 상수로 선언
		final double MATH_PI = 3.14;
		
		// 상수는 값을 바꿀 수 없다.
//		MATH_PI = 4.23;
		
		System.out.println("\n============================\n");
		
		// 변수를 사용하는 이유
		
		// 콘솔창에 20을 10번 출력
		int a = 20;
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		
		// 수정이 용이하다.
		// 값에 이름을 부여할 수 있다.
		
		int myAge = 36;
		
		System.out.println(myAge);
		
		System.out.println("\n========= String Method ===================\n");
		
		// 문자열 String
		// 문자열은 클래스이므로, 다양한 메소드를 내정하고 있다.
		String fruits = "Apple, Banana, Cherry";
		
		// .length()
		// 해당 문자열의 길이를 리턴
		int len = fruits.length();
		System.out.println(len);
		
		// .charAt(인덱스)
		// 인덱스는 배열, 문자열에서 몇 번째에 해당하는 숫자
		// 인덱스는 0부터 시작(첫 번째 = 인덱스 0)
		// 해당 문자열에서 해당 인덱스에 해당하는
		// 문자(char)를 리턴한다.
		char alphaL = fruits.charAt(3);
		System.out.println(alphaL);
		
		// .indexOf(문자열)
		// 해당 문자열에서 괄호 안에 있는 문자열의 인덱스를 리턴
		System.out.println(fruits.indexOf("Banana"));
		// 대소문자를 구분한다.
		// 괄호 안 문자열이 존재하지 않으면 -1 리턴
		System.out.println(fruits.indexOf("banana"));
		// 처음 발견된 녀석의 인덱스만 리턴
		System.out.println(fruits.indexOf("p"));
		
		//.substring(시작 인덱스, 끝 인덱스)
		// 해당 문자열을 시작 인덱스부터 끝 인덱스 전까지 자른다.
		System.out.println(fruits.substring(7, 13));
		// 자른 값을 리턴, 실제로 해당 문자열을 잘라버리진 않는다.
		System.out.println(fruits);
		// .substring(시작 인덱스)
		// 해당 문자열을 시작 인덱스부터 끝까지 자른다.
		System.out.println(fruits.substring(15));
		
		
		// .replace(바뀔 문자열, 바꾸고 싶은 문자열)
		System.out.println(fruits.replace("Cherry", "Chamwui"));
		// 원본은 변하지 않는다.
		System.out.println(fruits);
		
		// 원본을 바꾸고 싶다면?
		fruits = fruits.replace("Cherry", "Chamwui");
		
		System.out.println(fruits);
		
		// .trim()
		// 해당 문자열의 양 끝에 존재하는 모든 공백문자를 제거해준다.
		String world = "  The New World!!  ";
		System.out.println(world.replace(" ", ""));
		System.out.println(world.trim());
		
		// .toUpperCase()
		// .toLowerCase()
		// 해당 문자열에 존재하는 알파벳들을
		// 전부 대문자/소문자로 바꿔준다.
		System.out.println(fruits.toUpperCase());
		System.out.println(fruits.toLowerCase());
		
		// .concat(문자열)
		// 해당 문자열 뒤에 괄호 안에 있는 문자열을 붙인다.
		
		System.out.println(fruits.concat(", Durian"));
		
		// 문자열은 더하기 기호를 통해 추가 가능
		System.out.println(fruits + ", Durian");
		
		fruits = fruits + ", Durian";
		System.out.println(fruits);
		
		fruits = "과일 목록: " + fruits;
		System.out.println(fruits);
		
		System.out.println("\n============================================\n");
		
		// String 은 기본타입이 아닌 참조타입이므로 
		// null 값을 가질 수 있다.
		// 참조타입의 변수를 객체(instance)라고 부른다.
		String empty = "";
		System.out.println(empty);
		
		String strNull = null;
		System.out.println(strNull);
		
		System.out.println(empty.concat("채웠음"));
//		System.out.println(strNull.concat("채우기"));
		
		System.out.println("\n====================== char ========================\n");
		
		// 문자(char)
		// 작은 따옴표 ('') 안에 한 문자를 담을 수 있으며
		// 숫자 또한 담을 수 있다.
		// 이때의 숫자는 유니코드에 등록된 각 문자들에 대한 넘버링
		
		// A는 유니코드에서 65번째에 위치
		char wordA = 'A';
		char numA = 65;
		System.out.println(wordA);
		System.out.println(numA);
		
		// 한글 '가'는 유니코드에서 44032번째 위치
		char hangul = 44032;
		System.out.println(hangul);
		
		hangul++; // 1을 더한다.
		System.out.println(hangul);
		
		// byte -128부터 127까지만 담을 수 있다.
		byte byteNum = 127;
		byteNum++;
		System.out.println(byteNum);
		
		System.out.println("\n================== 형변환 ==================\n");
		
		// 형 변환(Casting)
		// 형 변환이 가능한 경우에는 형 변환을
		// 이용해서 상황에 맞게 적절히 사용할 수 있다.
		
		int intVal = 15;
		double doubVal = 1.23;
		
		System.out.println(intVal * doubVal);
		
		// int 곱하기 double은 double 타입으로 자동으로 형변환이 된다.
		double mulResult = intVal * doubVal;
		
		// int 곱하기 float을 해도 float 타입으로 자동 형변환 된다.
		float floatRst = intVal * 1.23f;
		
		// int 20000이 long 타입으로 자동 형변환 되어 담긴다. 
		long longVal = 20000;
		
		// 숫자 더하기 문자열(String)을 하면
		// 숫자가 문자열로 자동 형변환이 되어
		// 문자열 더하기(이어붙이기)가 된다.
		String name = "찬웅";
		String age = name + "31";
		System.out.println(age);
		
		// 강제 형변환 
		// (타입) 값
		// 형변환이 가능한 경우에 대해, 해당 값이 괄호 안 타입으로 
		// 변환 된다.
		int intCast = (int)3.3333;
		System.out.println(intCast);
		
		// 주의해야할 점
		int mulVal = (int)(10 * 3.333);
		System.out.println(mulVal);
		
		// 많이 하는 실수
		double result = 10 / 3; // 3.3333
		System.out.println(result); // 3.0
		
		// result가 3.3333으로 출력되도록 바꿔보세요
		result = (double)10 / 3; 
		System.out.println(result); 
		
		// 숫자 문자열과 숫자간의 형변환
		String strNum = "1324";
		System.out.println(strNum + 2);
		
		// 문자열을 정수 타입으로 형변환
		// Integer.parseInt(숫자 문자열) !!!!!!
		int intNum = Integer.parseInt(strNum);
		System.out.println(intNum + 2);
		
		// 정수 타입을 문자열로 형변환
		// Integer.toString(숫자) ㄴㄴ
		String strCast = intNum + "";
		System.out.println(strCast + 2);

		
		
		
		
		
		
	}

}
