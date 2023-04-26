package ch14_jdbc_jsp.main;

import java.util.ArrayList;
import java.util.Scanner;

import ch14_jdbc_jsp.service.StudentService;
import ch14_jdbc_jsp.vo.StudentVO;

public class JdbcMain {

	public static void main(String[] args) {
		StudentService stuService = StudentService.getInstance();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 회원목록 | 4. 종료");
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
				
				StudentVO student = new StudentVO();
				student.setStuId(id);
				student.setStuPassword(pw);
				
				StudentVO login = stuService.login(student);
				
				if(login.getStuId() != null) {
					// 로그인 성공
					System.out.println(login.getStuName() + "님 환영합니다.");
				}else {
					System.out.println("아이디 혹은 비밀번호가 틀립니다.");
				}
			}else if(command == 2) {
				//TODO 회원가입
				System.out.println("아이디: ");
				String id = scan.nextLine();
				
				System.out.println("비밀번호: ");
				String pw = scan.nextLine();
				
				System.out.println("닉네임: ");
				String name = scan.nextLine();
				
//				stuService.registStudent(id, pw, name);
				
				StudentVO stu = new StudentVO(id, pw, name, 0);
				stuService.registStudent(stu);
				
			}else if(command == 3) {
				//TODO 회원목록 조회
				ArrayList<StudentVO> stuList = stuService.getStuList();
				for(int i = 0; i < stuList.size(); i++) {
					System.out.println(stuList.get(i));
				}
			}else if(command == 4) {
				//TODO 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("다시 입력해주세요.");
			}
			
			
			
			
			
		}
		
		
		
	}

}
