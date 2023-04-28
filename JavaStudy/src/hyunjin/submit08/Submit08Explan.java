package hyunjin.submit08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Submit08Explan {

	public static void main(String[] args) {
		
		System.out.println("\n=====================1번 문제 ===================\n");
		//Q.01 makeLotto를 ArrayList와 HashSet을 이용해서 만들어보세요
		ArrayList<Integer> myLotto = makeLotto();
		System.out.println(myLotto);
		
		System.out.println("\n=====================2번 문제 ===================\n");
		
		HashMap<String, String> infoMap = new HashMap<>();
		
		infoMap.put("a001", "1234a");
		infoMap.put("b001", "1234b");
		infoMap.put("c001", "1234c");
		infoMap.put("d001", "1234d");
		infoMap.put("e001", "1234e");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("아이디를 입력해주세요.");
		System.out.print(">>> ");
		String id = scan.nextLine();
		
		System.out.println("비밀번호를 입력해주세요.");
		System.out.print(">>> ");
		String pw = scan.nextLine();
		
		// 입력한 id가 key값 중에 존재하면 true, 없으면 false
//		infoMap.containsKey(id)
		
		// 입력한 id가 key값 중에 존재하면 value 리턴, 업으면 null 리턴
		// 입력한 id가 key값 중에 존재하면 null이 아님, 없으면 null 리턴
//		infoMap.get(id)
		
		if(infoMap.get(id) != null ) {
			// id가 map안에 key값으로 존재
			
			// TODO 비밀번호 체크
			if(infoMap.get(id).contentEquals(pw)) {
				System.out.println("로그인 성공!");
			}else {
				System.out.println("비밀번호가 틀립니다.");
			}
		}else {
			// id가 map안에 key값으로 존재하지 않음
			System.out.println("존재하지 않는 아이디 입니다.");
		}
		
	}
	
	public static ArrayList<Integer> makeLotto() {
		HashSet<Integer> lottoSet = new HashSet<>();
		
		while(lottoSet.size() < 6) {
			// 랜덤 로또 번호 lottoSet 에 사이즈가 6이 될때까지 
			// 담는다. 
			int rand = (int)(Math.random() * 45) +1;
			
			lottoSet.add(rand);
			
//			if(lottoSet.size() == 6) {
//				break;
//			}
			
		}
		
		// Set의 값들을 ArrayList에 옮긴다.
		ArrayList<Integer> result = new ArrayList<>();
		
		for(Integer num : lottoSet) {
			result.add(num);
		}
		// 정렬
		Collections.sort(result);
		return result;
	}
}
