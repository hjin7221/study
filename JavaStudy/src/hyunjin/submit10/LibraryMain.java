package hyunjin.submit10;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) {

		// 책 입고, 책 대여, 책 목록조회, 책 검색을 할 수 있도록 프로그램을 만들어주세요.
		Library library = Library.getInstance();
//		String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자, 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";
//		for (int i =0; i<strBooks.split(",").length; i++) {
//			String[] temp = strBooks.split(",");
//			Book book = new Book(i+1 ,temp[i]);
//			library.bookAdd(book);
//		}
		library.showBookList();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("1. 책 반납 | 2. 책 대여 | 3. 책 목록 | 4. 책 검색 | 5. 종료 ");
			System.out.println("행동을 선택해주세요.");
			System.out.print(">>> ");

			int command = Integer.parseInt(scan.nextLine());

			if (command == 1) {
				// TODO 책 입고
				System.out.print("책 번호를 입력해주세요: ");
				int a = Integer.parseInt(scan.nextLine());
				library.returnBook(a);
//				library.bookList.get(a-1).setRental(false);
//				System.out.println(library.bookList.get(a-1).getTitle()+ "이(가) 입고되었습니다.");
//				library.
			} else if (command == 2) {
				// TODO 책 대여
//				System.out.println("책 번호를 입력해주세요");
//				System.out.print(">>> ");
//				int b = Integer.parseInt(scan.nextLine());
//				
//				// library  내에 있는 bookList가 가진 book 객체 중에
//				// no와 같은 책 번호를 가진 객체를 찾아서
//				// 그 객체의 rental을 true로 바꿔준다.
//				library.rentalBook(b);

				System.out.print("책 이름을 입력해주세요: ");
				String c = scan.nextLine();

				// name을 포함하는 book 객체들을 찾아서
				// 가져오기
				ArrayList<Book> searchList = library.searchBookList(c);

				if (searchList.size() == 0) {
					System.out.println("해당 책이 존재하지 않습니다.");
				} else if (searchList.size() == 1) {
					library.rentalBook(searchList.get(0).getNo());
				} else {
					library.searchBook(c);
					System.out.println("책 번호를 입력해주세요");
					System.out.print(">>> ");
					int b = Integer.parseInt(scan.nextLine());
					library.rentalBook(b);
				}

//				library.bookList.get(b-1).setRental(true);
//				System.out.println(library.bookList.get(b-1).getTitle()+ "을(를) 대여하셨습니다.");
//				
//				// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
////				System.out.print("책 이름을 입력해주세요: ");
////				String d = scan.nextLine();
////				for(int i = 0; i<library.bookList.size(); i++) {
////					if(library.bookList.get(i).getTitle().contains(d).size()  1 ) {
////						System.out.println(library.bookList.get(i));
////						System.out.print("도서 번호를 입력해주세요: ");
////						int e = Integer.parseInt(scan.nextLine());
////						library.bookList.get(e-1).setRental(true);
////						System.out.println(library.bookList.get(e-1).getTitle() + "을(를) 대여하셨습니다.");
////					}else {
////						library.bookList.get(Integer.parseInt(d)-1).setRental(true);
////						System.out.println(library.bookList.get(Integer.parseInt(d)-1).getTitle() + "을(를) 대여하셨습니다.");
////					}
////				}
//				
			} else if (command == 3) {
				// 책 목록 조회
				library.showBookList();
			} else if (command == 4) {
				// TODO 책 검색
				System.out.print("책 이름을 입력해주세요: ");
				String c = scan.nextLine();
				library.searchBook(c);
//				for(int i = 0; i<library.bookList.size(); i++) {
//					if(library.bookList.get(i).getTitle().contains(c)) {
//						System.out.println(library.bookList.get(i));
//					}
//				}
			} else {
				// 종료
				System.out.println("종료합니다.");
				break;
			}

		}
	}

}