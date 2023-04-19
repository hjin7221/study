package ch06_method;

import java.util.Scanner;

public class MethodMainPractice {

	public static void main(String[] args) {
		
		printSum(1,100);	
		printSum(30,60);
		printSum(25,50);
		
		System.out.println("\n================================\n");
		
		printSum(70,90);
		
		// 리턴값이 존재하는 함수 만들기
		returnSum(80,90);
		
		int rst = returnSum(80,90);
		System.out.println(rst);
		
		System.out.println("\n================================\n");
		
		print("파이썬 저리가라");
		
		System.out.println(returnSum(1,10));
		print(returnSum(1,10));
		
		System.out.println("\n================================\n");
		
		int number = Math.abs(-10);
		System.out.println(number);
		
		number =absolute(-10);
		System.out.println(number);
		
		System.out.println("\n================================\n");
		makeCard ("현진",65,91,92);
		
		System.out.println("\n================================\n");
		
		// Loopfor에서 했던 각 자리수 더하기 메소드화
		int sum = eachAdd(33332323);
		System.out.println(sum);
		
		System.out.println("\n================================\n");
		
		// LoopWhile에서 했던 포켓몬스터도 메소드로 만들어버리기
		playPokemon();
		
		// 재귀함수 만들기 
		recursionPrint(10);
		
		System.out.println("\n================================\n");
		
		// 팩토리얼
		long no = factorial(15);
		System.out.println(no);
		
		// 재귀함수를 이용한 팩토리얼
		no = recFactorial(5);
		System.out.println(no);
		
	} // main 끝
	
	public static long recFactorial(int num) {
		if(num == 1) {
			return 1;
		}
		return num * recFactorial (num - 1);
	}
	
	public static long factorial(int num) {
		long lrst = 1;
		for (int i= 1; i<=num; i++) {
			lrst *= i;
		}
		return lrst;
	}
	
	public static void recursionPrint(int num) {
		if(num == 0) {
			return;
		}
		System.out.println(num);
		recursionPrint(num -1);
	}
	
	
	public static void playPokemon() {
		Scanner scan = new Scanner(System.in);
		int enemyHp = 100;
		outer: while(true) {
			System.out.println("야생의 파이리를 만났습니다.");
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 공격 | 2. 도망");
			System.out.println(">>> ");
			
			int command = Integer.parseInt(scan.nextLine());
			
			if(command ==1 ) {
				// TODO 공격
				 while(true) {
					System.out.println("공격 방법 선택");
					System.out.println("1. 백만볼트 | 2. 전광석화 | 3. 취소");
					System.out.println(">>> " );
					
					int select = Integer.parseInt(scan.nextLine());
					
					if(select == 1) {
						System.out.println("피~카~~~~~~~~~~츄!!!!");
						enemyHp -= 20;
					}else if(select == 2) {
						System.out.println("삐까삐까!!");
						enemyHp -= 10;
					}else if(select == 3) {
						System.out.println("공격 취소");
						// 내부 while문 종료
						// 외부 while문은 계속 실
						break;
					}
					
					System.out.println("파이리의 현재 체력: " + enemyHp);
					
					//파이리 깨꼬닥
					if(enemyHp <=0) {
						System.out.println("파이리를 잡았다!!");
//						System.exit(0);    // 프로그램 종료
						// 내부에 외부 while문 중지
						break ;
					}
				}
			}else if(command == 2) {
				// 도망
				System.out.println("도망쳤습니다.");
				break outer;
			}
			
			
		}
	}
	
	
	
	
	public static int eachAdd(int num) {
		String temp = num + "";
		int result = 0;
		for (int i=0; i<temp.length(); i++) {
			result += Integer.parseInt(temp.substring(i,i+1));
		}
		return result;
	}
	
	
	
	public static void printSum(int from, int to) {
		int sum = 0;
		for (int i = from; i <= to ; i++) {
			sum+=i;
		}
		System.out.println(from + "부터 " + to + "까지 더한 결과는: " + sum + "입니다.");
	}
	
	public static int returnSum(int from, int to) {
		int sum = 0;
		for (int i = from; i <= to ; i++) {
			sum+=i;
		}
		return sum;
	}
	public static void print(String msg) {
		System.out.println(msg);
	}
	public static void print(int num) {
		System.out.println(num);
	}
	public static int absolute(int num) {
		if(num>0) {
			num = num;
		}else if (num < 0) {
			num = num *= -1;
		}
		return num;
	}
	public static void makeCard(String name, int kor, int eng, int math) {
		System.out.println("이름: " + name);
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
		double avg = ( kor + eng + math )/ 3.0;
		System.out.printf("평균: %.2f\n", avg);
		String grade = "C";
		if (avg>=90) {
			grade = "A";
		}else if (avg>=80) {
			grade = "B";
		}
		System.out.println("등급: " + grade);
	}
}
