package hyunjin.submit05;

public class Submit05Explan {

	public static void main(String[] args) {
		System.out.println("\n====== 1번 문제 ========");
		makeTree(5);
		
		System.out.println("\n====== 2번 문제 ========");
		
		String input = "내일은 금요일";
		String reverse = reverseStr(input);
		System.out.println(reverse);
		
		System.out.println("\n====== 3번 문제 ========");
		
		// Q.03 십진수를 이진수로 변환
		//(자바에서 이진수, 16진수 등등은 문자열)
		// 17 -> "10001"
		String binaryString = Integer.toBinaryString(23);
		System.out.println(binaryString);
		
		binaryString = makeBinary(23);
		System.out.println(binaryString);
		
	}
	
	public static String makeBinary(int num) {
		// num에 17이 들어왔다.
		// 17을 2로 나눠서 나머지 1 / 몫은 8
		//  8을 2로 나눠서 나머지 0 / 몫은 4
		//  4를 2로 나눠서 나머지 0 / 몫은 2
		//  2를 2로 나눠서 나머지 0 / 몫은 1
		//  1을 2로 나눠서 나머지 1 / 몫은 0 (스탑)
		//반복횟수와 기준이 애매하면 while(true)
		String result = "";
		while(num != 0) {
			result += num % 2;
			num = num / 2;
			
			if (num == 0 ) {
				break;
			}
		}
		String rst = reverseStr(result);
		return rst;
		
		
		
		
		
		
		
	}
	
	public static void makeTree(int floor) {
		for (int i = 0; i< floor; i++) {
			String space = "";
			for (int k = 0; k < (floor - 1) - i; k++) {
				space += " ";
			}
			String star = "";
			for (int k = 0; k < (i * 2) + 1; k++) {
				star += "*";
			}
			System.out.println(space + star);
		}
	}
	public static String reverseStr(String input) {
		String result = "";
		for(int i = 0; i <input.length(); i++) {
			String str = input.substring(i, i+1) ;
			result = str + result;
		}
		return result;
	}
}
