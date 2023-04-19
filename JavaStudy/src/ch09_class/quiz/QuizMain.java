package ch09_class.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuizMain {

	public static void main(String[] args) {
		// 영화 맞추기
		// 영화 명대사가 출력
		// 못맞추면 영화 출연한 배우 출력
		// 못맞추면 영화 초성 출력
		// 못맞추면 다음 영화로 넘어감
		
		// 신세계, 거 죽기 딱 좋은 날씨네, 이정재 황정민 박성웅, ㅅㅅㄱ
		// 범죄와의 전쟁, 느그 서장 남천동 살제?, 최민식 하정우, ㅂㅈㅇㅇㅈㅈ
		
		// 영화 객체
		// 영화 제목
		// 명대사
		// 배우
		// 초성
		
		MovieDB movieDB = MovieDB.getInstance();
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Movie> movieList = movieDB.getMovieList();
		
		// ArrayList 내부 요소들 순서 랜덤하게 섞기
		Collections.shuffle(movieList);
		
		int score = 0;
		
		for(int i = 0; i < movieList.size(); i++) {
			System.out.println(movieList.get(i).getQuotes());
			System.out.print(">>> ");
			String answer = scan.nextLine();
			
			if(answer.contentEquals(movieList.get(i).getTitle())) {
				System.out.println("정답입니다~!!");
				score += 3;
				continue; // 다음 문제로 넘어감.
			}
			
			System.out.println(movieList.get(i).getActors());
			System.out.print(">>> ");
			answer = scan.nextLine();
			
			if(answer.contentEquals(movieList.get(i).getTitle())) {
				System.out.println("정답입니다~!!");
				score += 2;
				continue; // 다음 문제로 넘어감.
			}
			
			System.out.println(movieList.get(i).getWord());
			System.out.print(">>> ");
			answer = scan.nextLine();
			
			if(answer.contentEquals(movieList.get(i).getTitle())) {
				System.out.println("정답입니다~!!");
				score += 1;
				continue; // 다음 문제로 넘어감.
			}
			
			System.out.println("땡~~~!! 틀렸습니다. 다음 문제로 넘어갑니다.");
		}
		System.out.println("내 점수: " + score);
		if(score>=25) {
			System.out.println("와우~ 당신은 혹시 영화평론가??");
		}else if(score >= 15) {
			System.out.println("영화관에 돈좀 쓰셨군요~");
		}else {
			System.out.println("영화 좀 보고 삽시다~");
		}
		
		
		
		
		
		
		
		
		
	}

}
