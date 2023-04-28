package ch08_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PlayList {

	public static void main(String[] args) {
		// 자동 임포트 단축키 [Ctrl + Shift + o]
		ArrayList<String> playList = new ArrayList<String>(Arrays.asList("INVU: 태연", "사랑은 늘 도망가: 임영웅", "취중고백: 멜로망스",
				"언제나 사랑해: 케이시", "듣고 싶을까: MSG워너비", "ELEVEN: IVE", "Step Back: GOT the beat", "abcdefu: GAYLE",
				"회전목마: sokodomo", "너, 너: 휘인", "SMILEY: YENA", "호랑수월가: 탑현", "리무진: 비오", "RUN2U: STAYC", "눈이 오잖아: 이무진",
				"Counting Stars: 비오", "신호등: 이무진", "어제처럼: 폴킴", "잊었니: 임영웅", "잊을 수 있을까: 노을", "HERO: 임영웅",
				"Can't Control Myself: 태연", "Next Level: aespa", "strawberry moon: 아이유", "겨울잠: 아이유", "끝사랑: 임영웅",
				"드라마: 아이유", "Bk Love: 임영웅", "만남은 쉽고 이별은 어려워: 베이식", "Weekend: 태연", "Savage: aespa", "Butter: 방탄소년단",
				"Dynamite: 방탄소년단", "OHAYO MY NIGHT: 디핵", "사랑인가 봐: 멜로망스", "라일락: 아이유", "Celebrity: 아이유", "낙하: 악동뮤지션",
				"Blueming: 아이유", "롤린: 브레이브걸스", "고백: 멜로망스", "그런 밤: 태연"));

		for (int i = 0; i < playList.size(); i++) {
			System.out.println(playList.get(i));
		}

		System.out.println("\n=================== 정렬 =======================\n");

		// ABC > abc > 가나다 순으로 정렬
		Collections.sort(playList);

		for (int i = 0; i < playList.size(); i++) {
			System.out.println(playList.get(i));
		}

		System.out.println("\n=================== 검색 =======================\n");

		// 검색어를 입력받으면 playList에서
		// 해당 검색어를 포함하는 ArrayList를 리턴
		ArrayList<String> searchList = searchSong("사랑", playList);

		for (int i = 0; i < searchList.size(); i++) {
			System.out.println(searchList.get(i));
		}

		System.out.println("\n=================== 제목 / 가수 검색 =======================\n");

		// 제목 검색
		searchList = searchSong("제목", "사랑", playList);

		for (int i = 0; i < searchList.size(); i++) {
			System.out.println(searchList.get(i));
		}

		// 가수 검색
		searchList = searchSong("가수", "태연", playList);

		for (int i = 0; i < searchList.size(); i++) {
			System.out.println(searchList.get(i));
		}

	} // main 끝

	public static ArrayList<String> searchSong(String option, String keyword, ArrayList<String> playList) {

		ArrayList<String> result = new ArrayList<>();

		for (int i = 0; i < playList.size(); i++) {

			// playList.get(0)이 "INVU: 태연" 이면
			// option이 제목일때 INVU에 keyword가 존재하는지 체크
			// option이 가수일때 태연에 keyword가 존재하는지 체크

			String[] temp = playList.get(i).split(":");

			// temp[0] = 제목
			// temp[1] = 가수

			if (option.equals("제목")) {
				if (temp[0].contains(keyword)) {
					result.add(playList.get(i));
				}
			} else if (option.equals("가수")) {
				if (temp[1].contains(keyword)) {
					result.add(playList.get(i));
				}
			}
		}
		return result;
	}

	public static ArrayList<String> searchSong(String keyword, ArrayList<String> playList) {

		ArrayList<String> result = new ArrayList<>();

		// playList 내에 keyword를 포함하고 있는 데이터 찾기
		for (int i = 0; i < playList.size(); i++) {
			if (playList.get(i).contains(keyword)) {
				result.add(playList.get(i));
			}
		}
		return result;

	}

}