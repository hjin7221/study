package hyunjin.submit14.main;

import java.util.ArrayList;
import java.util.Scanner;

import hyunjin.submit14.service.MembersService;
import hyunjin.submit14.vo.MembersVO;

public class FinalMain {

	public static void main(String[] args) {
		MembersService memService = MembersService.getInstance();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("하단 메뉴중 선택 해주세요.");
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 아이디/비밀번호 찾기 | 4. 종료");
			System.out.print(">>> ");
			
			int command = 0;
			try {
				command = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
				continue;
			}
			
			if(command == 1) {
				//TODO 로그인
				System.out.print("아이디: ");
				String id = scan.nextLine();
				System.out.print("비밀번호: ");
				String pw = scan.nextLine();
				
				MembersVO mem = new MembersVO();
				mem.setMem_id(id);
				mem.setMem_pw(pw);
				
				MembersVO login = memService.login(mem);
				
				if(login.getMem_id() != null) {
					System.out.println(login.getMem_name() + "님 어서오세요." );
					System.out.println("가계부 시스템에 접속하신걸 환영합니다.");
					
					
					
					
					
				}else {
					System.out.println("아이디 혹은 비밀번호가 틀립니다.");
				}
			}else if(command == 2) {
				//TODO 회원가입
				System.out.print("아이디: ");
				String id = scan.nextLine();
				ArrayList<MembersVO> temp = memService.showMembersList();
				for(int i = 0; i<temp.size(); i++) {
					if(temp.get(i).getMem_id().equals(id)) {
						System.out.println("중복된 아이디 입니다.");
						break;
					} else {
						System.out.print("비밀번호: ");
						String pw = scan.nextLine();
						System.out.print("이름: ");
						String nm = scan.nextLine();
						System.out.println("#비밀번호 재설정시 필요합니다.");
						System.out.print("힌트 질문?: ");
						String question = scan.nextLine();
						System.out.print("힌트 답: ");
						String answer = scan.nextLine();
						
						MembersVO mem = new MembersVO(id,pw,nm,question,answer, null);
						memService.registMembers(mem);
					}
				}
				
			}else if(command == 3) {
				//TODO 아이디/비밀번호찾기
				System.out.println("하단 메뉴중 선택 해주세요.");
				System.out.println("1. 아이디 찾기 | 2. 비밀번호 찾기");
				int select = 0;
				try {
					select = Integer.parseInt(scan.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("숫자만 입력해주세요.");
					continue;
				}
				if(select == 1) {
					//TODO 아이디 찾기
					System.out.println("이름을 입력해주세요.");
					System.out.print(">>> ");
					String nm = scan.nextLine();
					MembersVO temp = new MembersVO();
					
					temp.setMem_name(nm);
					MembersVO result = memService.findId(temp);
					if(result.getMem_id() != null) {
						System.out.println(result.getMem_name() + "님의 아이디는 " + result.getMem_id() + " 입니다.");
					}else {
						System.out.println(nm + "님의 아이디는 존재하지 않습니다.");
					}
				}else if(select == 2) {
					//TODO 비밀번호 찾기
					System.out.println("아이디를 입력해주세요.");
					System.out.print(">>> ");
					String id2 = scan.nextLine();
					
					MembersVO temp = new MembersVO();
					temp.setMem_id(id2);
					
					MembersVO result = memService.findPw(temp);
					if(result.getMem_id() != null) {
						System.out.println("힌트: " + result.getHint_question());
						System.out.print(">>> ");
						String answer = scan.nextLine();
						
						if(result.getHint_answer().equals(answer)) {
							MembersVO temp2 = new MembersVO();
							temp2.setMem_id(id2);
							temp2.setHint_answer(answer);
							
							MembersVO pwResult = memService.findPw2(temp2);
							System.out.println("패스워드를 재설정 해주세요.");
							System.out.print(">>> ");
							String rePw = scan.nextLine();
							
							MembersVO temp3 = new MembersVO();
							temp3.setMem_pw(rePw);
							temp3.setHint_answer(answer);
							
							memService.resetPw(temp3);
							System.out.println("비밀번호가 재설정되었습니다.");
						}else {
							System.out.println("답이 잘못되었습니다.");
							continue;
						}
						
					}else {
						System.out.println("해당 아이디는 존재하지 않습니다.");
					}
				}else {
					System.out.println("숫자 1 또는 2 를 입력해주세요.");
					continue;
				}
			}else if(command == 4) {
				// 종료
				System.out.println("가계부 작성 잊지 마세요.");
				System.out.println("종료합니다.");
				break;
			}else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			
			
		}
	}

}
