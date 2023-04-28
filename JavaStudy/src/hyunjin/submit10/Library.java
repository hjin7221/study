package hyunjin.submit10;

import java.util.ArrayList;

import ch09_class.homepage.Board;
import ch09_class.homepage.Member;

public class Library {
	
	// 선언부
	private ArrayList<Book> bookList = new ArrayList<>();
	
	private Library() {
		String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자, 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";
		String[] temp = strBooks.split(",");
			
		for (int i =0; i<temp.length; i++) {
			temp[i] = temp[i].trim();
		}
		for (int i = 0; i<temp.length; i++) {
			bookList.add(new Book(bookList.size()+1,temp[i], false));
		}
	}
	
	private static Library instance = new Library(); 
	
	public static Library getInstance() {
		return instance;
	}
	
	//책 목록 조회
	public void showBookList () {
		for(int i=0; i< bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}
	}
	
	// 책 대여
	public void rentalBook(int no) {
		for(int i = 0; i < bookList.size(); i++ ) {
			if(bookList.get(i).getNo() == no) {
				bookList.get(i).setRental(true);
				System.out.println(bookList.get(i).getTitle() + "을(를) 대여하셨습니다.");
			}
		}
	}
	
	// 책 입고
	public void returnBook(int no) {
		for(int i = 0; i < bookList.size(); i++ ) {
			if(bookList.get(i).getNo() == no) {
				bookList.get(i).setRental(false);
				System.out.println(bookList.get(i).getTitle() + "을(를) 반납하셨습니다.");
			}
		}
	}
	
	// 책 검색
	public void searchBook(String keyword) {
		for(int i = 0; i<bookList.size(); i++) {
			if(bookList.get(i).getTitle().contains(keyword)) {
				System.out.println(bookList.get(i));
			}
		}
	}
	
	// 책 검색 + 검색된 책 목록 리턴
	public ArrayList<Book> searchBookList(String keyword) {
		ArrayList<Book> result = new ArrayList<>();
		for(int i = 0; i<bookList.size(); i++) {
			if(bookList.get(i).getTitle().contains(keyword)) {
				result.add(bookList.get(i));
			}
		}
		return result;
	}
	
	
	
}
