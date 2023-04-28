package ch08_collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionSet {

	public static void main(String[] args) {
		// 집합(Set)
		
		// HashSet 의 선언
		HashSet<String> stuSet = new HashSet<>();
		
		// 다형성
		// List 중에 ArrayList가 있음
		List<String> stuList = new ArrayList<String>();
		
		// Set 중에 HashSet이 있음
		Set<String> stuSet2 =  new HashSet<String>();
		
		// .add(값);
		// 값을 추가
		stuSet.add("박진영");
		stuSet.add("유동윤");
		stuSet.add("홍민경");
		
		System.out.println(stuSet);
		
		// 중복된 값이 추가되지는 않는다.
		stuSet.add("박진영"); //에러가 나는건 아님
		System.out.println(stuSet);
		
		System.out.println("\n===============================================\n");
		
		// .size()
		// Set 내 데이터 개수를 리턴
		System.out.println(stuSet.size());
		
		// .contains(값)
		// 해당 값이 Set 안에 존재하면 true, 없으면 false
		System.out.println(stuSet.contains("홍민경"));
		
		System.out.println("\n===============================================\n");
		
		// Set 조회
		// 1. Iterator 사용
		Iterator<String> iter = stuSet.iterator();
		while(iter.hasNext()) {
			String name = iter.next();
			System.out.println(name);
		}
		
		// 2. 향상된 for문 사용
		for(String stu : stuSet) {
			System.out.println(stu);
		}
		
		// 3. forEach 사용
		stuSet.forEach(stu -> System.out.println(stu));
		
		System.out.println("\n===============================================\n");
		
		// Set은 집합을 쓰는 경우가 아니라면 잘 쓰지 않는다. 
		// 그나마 Set을 사용한다면 Set의 중복을 허용하지
		// 않는 특징을 이용하는 경우이다.
		// 배열 꾸져서 안쓴다. String.split -> 배열로 리턴
		
		ArrayList<Integer> intList = new ArrayList<>();
		
		// 15부터 30 사이의 랜덤 숫자를 10개 담기.
		// (int)(Math.random) +
		// 1~45 => (int)(Math.random * 45 ) + 1;
		// 0~44 => (int)(Math.random * 45 );
		// 0~15 => (int)(Math.random * 16);
		// 15~30 => (int)(Math.random * 16) + 15;
		for(int i = 0; i < 10; i++) {
			int rand = (int)(Math.random() * 16) + 15;
			intList.add(rand);
		}
		System.out.println(intList);
		
		// ArrayList인 intList를 HashSet에 옮기기
		HashSet<Integer> intSet = new HashSet<>();
		// intList의 값이 intSet으로 다 추가된다.
		intSet.addAll(intList);
		// 중복된게 있다면 하나만 남는다.
		System.out.println(intSet);
		
		// HashSet의 값을 ArrayList로 옮기기
		intList.clear();
		intList.addAll(intSet);
		System.out.println(intList);
		
		// 당연하게도 for문을 이용해서 옮길 수 있다.
		
		intList.clear();
		for (int num : intSet) {
			intList.add(num);
		}
		System.out.println(intList);
	}

}
