package hyunjin.submit08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Submit08 {

	public static void main(String[] args) {

		System.out.println("\n=====================1번 문제 ===================\n");
		// Q.01 makeLotto를 ArrayList와 HashSet을 이용해서 만들어보세요

		ArrayList<Integer> myLotto = makeLotto();
		System.out.println(myLotto);

		System.out.println("\n=====================2번 문제 ===================\n");

		HashMap<String, String> infoMap = new HashMap<>();

		infoMap.put("a001", "1234a");
		infoMap.put("b001", "1234b");
		infoMap.put("c001", "1234c");
		infoMap.put("d001", "1234d");
		infoMap.put("e001", "1234e");

		System.out.println("아이디를 입력해주세요.");
		System.out.print(">>> ");

		Scanner scan = new Scanner(System.in);
		String id = scan.nextLine();
		if (infoMap.containsKey(id)) {
			System.out.println("비밀번호를 입력해주세요.");
			System.out.print(">>> ");
			String pass = scan.nextLine();
			if (infoMap.get(id).equals(pass)) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}

	public static ArrayList<Integer> makeLotto() {
		HashSet<Integer> temp = new HashSet<>();
		ArrayList<Integer> result = new ArrayList<>();
		while (temp.size() != 6) {
			temp.add((int) (Math.random() * 45) + 1);
		}
		result.addAll(temp);
		Collections.sort(result);
		return result;
	}
}