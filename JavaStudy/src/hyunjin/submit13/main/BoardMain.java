package hyunjin.submit13.main;

import java.util.ArrayList;
import java.util.Scanner;

import hyunjin.submit13.service.BoardService;
import hyunjin.submit13.service.MemberService;
import hyunjin.submit13.vo.BoardVO;
import hyunjin.submit13.vo.MemberVO;

public class BoardMain {

	public static void main(String[] args) {
		
		MemberService memService = MemberService.getInstance();
		BoardService bdService = BoardService.getInstance();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료");
			System.out.print(">>> ");
			
			int command = 0;
			try {
				command = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
				continue;
			}
			
			if (command == 1) {
				//TODO 회원가입
				System.out.print("아이디를 입력해주세요: ");
				String id = scan.nextLine();
				System.out.print("비밀번호를 입력해주세요: ");
				String pw = scan.nextLine();
				
				ArrayList<MemberVO> temp = memService.getMemList();
				
				MemberVO mem = new MemberVO(id,pw);
				for (int i =0; i<temp.size(); i++) {
					if(id.equals(temp.get(i).getMemId())) {
						System.out.println("중복된 아이디입니다.");
						return;
					}
				}
				memService.registMember(mem);
				
				//TODO 회원가입시 동일 아이디 보유시 가입안되게끔
				
			}else if (command == 2) {
				//TODO 로그인
				System.out.print("아이디를 입력해주세요: ");
				String id = scan.nextLine();
				System.out.print("비밀번호를 입력해주세요: ");
				String pw = scan.nextLine();
				
				MemberVO member = new MemberVO();
				member.setMemId(id);
				member.setMemPW(pw);
				
				MemberVO login = memService.login(member);
				
				if(login.getMemId() != null) {
					System.out.println("로그인 되었습니다.");
					System.out.println();
					while(true) {
						ArrayList<BoardVO> boardList = bdService.showBoardList();
						for(int i = 0; i < boardList.size(); i++) {
							System.out.println(boardList.get(i));
						}
						System.out.println("행동을 선택해주세요.");
						System.out.println("1. 글쓰기 | 2. 글조회 | 3. 로그아웃");
						System.out.println(">>> ");
						
						int select = Integer.parseInt(scan.nextLine());
						
						if(select == 1) {
							//TODO 글쓰기
							System.out.print("글 제목을 입력해주세요: ");
							String title = scan.nextLine();
							System.out.print("글 내용을 입력해주세요: ");
							String contents = scan.nextLine();
							
							BoardVO board = new BoardVO();
							board.setTitle(title);
							board.setContents(contents);
							board.setAuthor(login.getMemId());
							
							bdService.registWriting(board);
							
							
						}else if(select == 2) {
							//TODO 글조회
							ArrayList<BoardVO> bdList = bdService.showBoardList();
							System.out.print("글 번호를 입력해주세요: ");
							int a = Integer.parseInt(scan.nextLine());
							
							for ( int i = 0; i< bdList.size(); i++) {
								if(bdList.get(i).getNo() == a) {
									BoardVO b = bdService.getBoardList(bdList.get(i));
									System.out.println("========================");
									System.out.println("제목: "+ b.getTitle());
									System.out.println("작성자: "+ b.getAuthor());
									System.out.println("작성일: "+ b.getCreate_date());
									System.out.println("글내용: " + b.getContents());
									System.out.println("========================");
								}
							}
						}else if(select == 3) {
							//TODO 로그아웃
							System.out.println("로그아웃 하셨습니다.");
							break;
						}
					}
				}else {
					System.out.println("아이디 혹은 비밀번호가 틀립니다.");
				}
				
				
				
				
				
				
			}else if (command == 3) {
				// 종료
				System.out.println("종료합니다.");
				break;
			}
			
		}
		
		
	}

}
