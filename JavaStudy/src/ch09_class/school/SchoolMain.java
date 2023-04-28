package ch09_class.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ch09_class.commons.UtilClass;

public class SchoolMain {

	public static void main(String[] args) {
		// 국어,영어,수학,평균 점수를 가지는 학생 객체
		Student yeseul = new Student("예슬", 85, 80, 87, 84);
		System.out.println(yeseul);
		
		// 캡슐화 적용
		// 같은 폴더 내에 있는 클래스라면 private 빼곤 다 접근 가능
		
		// avg에 대한 Setter를 지워서 평균은 수정할 수 없도록 함
//		yeseul.setAvg(100);
		System.out.println(yeseul);
		
		System.out.println(yeseul.getKor());
		System.out.println(yeseul.getAvg());
		
		// 국어 점수 바꾸기
		yeseul.setKor(93);
		System.out.println(yeseul);
		
		System.out.println("\n======================================\n");
		
		Student minkyoung = new Student ("민경", 90, 80, 87, UtilClass.weRound((90+80+87)/3.0, 1));
		System.out.println(minkyoung);
		
		minkyoung.setEng(86);
		System.out.println(minkyoung);
		
		// 평균을 넣지 않아도 적용되도록 생성자 추가
		Student hyunjin = new Student ("현진", 90, 87, 88);
		System.out.println(hyunjin);
		
		System.out.println("\n======================================\n");
		
		ArrayList<Student> stuList = new ArrayList<>();
		
		stuList.add(yeseul);
		stuList.add(minkyoung);
		stuList.add(hyunjin);
		stuList.add(new Student("준호", 80, 82, 77));
		stuList.add(new Student("동욱", 70, 92, 78));
		
		for(int i = 0; i < stuList.size(); i++ ) {
			System.out.println(stuList.get(i));
		}
		
		System.out.println("\n======================================\n");
		
		// 학생들의 평균을 이용해서
		// 1등 내용
		// 2등 내용 ~
		for(int k = 0; k < stuList.size() - 1; k++) {
			for (int i = 0; i < stuList.size() - 1; i++) {
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if(stuList.get(i).getAvg() < stuList.get(i+1).getAvg()) {
					Student t = stuList.get(i);
					stuList.set(i, stuList.get(i+1));
					stuList.set(i+1, t);
				}
			}
		}
		for(int i = 0; i < stuList.size(); i++) {
			
			System.out.println((i+1) + "등. " + stuList.get(i));
		}
		
		System.out.println("\n======================================\n");
		
		//Collections.sort()
		Collections.sort(stuList, new Comparator<Student>() {

			@Override
			public int compare(Student stuA, Student stuB) {
				double diff = stuB.getAvg() - stuA.getAvg();
				//양의 소수, 음의 소수 
				if(diff < 0) {
					//음의 정수
					return -1;
				}
				return 1;
			}
		});
		
		Collections.sort(stuList, (stuA,stuB) -> (stuB.getAvg() - stuA.getAvg() > 0) ? (1) : (-1));
		
		for(int i = 0; i < stuList.size(); i++) {
			
			System.out.println((i+1) + "등. " + stuList.get(i));
		}
	}

}
