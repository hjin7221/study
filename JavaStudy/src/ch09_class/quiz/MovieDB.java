package ch09_class.quiz;

import java.util.ArrayList;

public class MovieDB {

	private ArrayList<Movie> movieList = new ArrayList<>();

	// 싱글톤
	private MovieDB() {
		movieList.add(new Movie("신세계", "거 죽기 딱 좋은 날씨네", "이정재, 황정민, 박성웅", "ㅅㅅㄱ"));
		movieList.add(new Movie("기생충", "가장 완벽한 계획이 뭔지 알아? 무계획이야. ", "송강호, 이선균, 조여정", "ㄱㅅ"));
		movieList.add(new Movie("아저씨", "니들은 내일만 보고 살지? 내일만 사는 놈은, 오늘만 사는놈한테 죽는다. 난 오늘만 산다. 그게 얼마나 X같은지 내가 보여줄게.",
				"원빈, 김새론", "ㅇㅈ"));
		movieList.add(new Movie("삼진그룹영어토익", "나를 보지 말고 너를 봐", "고아성, 이솜, 박혜수", "ㅅㅈㄱㄹㅇㅇㅌㅇ"));
		movieList.add(new Movie("칠번방의선물", "아빠 딸로 태어나서 고맙습니다.", "류승룡, 박신혜, 갈소원", "ㅊㅂㅂㅇㅅ"));
		movieList.add(new Movie("신과함께죄와벌", "지난 일에 대해서 새로운 눈물을 낭비하지 말아라", "하정우, 차태현, 주지훈, 김향기, 김동욱, 마동석", "ㅅㄱㅎㄲㅈㅇ"));
		movieList.add(new Movie("그것만이내세상", "불가능, 그것은 사실이 아니라 하나의 의견일 뿐이다.", "이병헌, 윤여정, 박정민", "ㄱㄱㅁㅇㄴㅅㅅ"));
		movieList.add(new Movie("친구", "느그 아부지 뭐하시노?", "장동건, 유오성", "ㅊㄱ"));
		movieList.add(new Movie("엽기적인그녀", "견우야 미안해! 나도 어쩔 수 없는 여자인가봐!", "차태현, 전지현", "ㅇㄱㅈㄱㅇㄱㄴ"));
		movieList.add(new Movie("타짜", "동작그만, 밑장빼기냐?", "조승우, 김혜수, 백윤식, 유해진", "ㅌㅉ"));
	}

	private static MovieDB instance = new MovieDB();

	public static MovieDB getInstance() {
		return instance;
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

}
