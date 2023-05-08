package hyunjin.submit14.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import hyunjin.submit14.service.MembersService;
import hyunjin.submit14.service.MoneyBookService;
import hyunjin.submit14.vo.MembersVO;
import hyunjin.submit14.vo.MoneyBookVO;

public class FinalMain {

	public static void main(String[] args) {
		MembersService memService = MembersService.getInstance();
		MoneyBookService bookService = MoneyBookService.getInstance();
		
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
				// 로그인
				System.out.print("아이디: ");
				String id = scan.nextLine();
				System.out.print("비밀번호: ");
				String pw = scan.nextLine();
				
				MembersVO mem = new MembersVO();
				mem.setMem_id(id);
				mem.setMem_pw(pw);
				
				MembersVO login = memService.login(mem);
				
				if(login.getMem_id() != null) {
					while(true) {
						System.out.println(login.getMem_name() + "님 어서오세요." );
						System.out.println("가계부 시스템에 접속하신걸 환영합니다.");
						System.out.println();
						System.out.println(login.getMem_name() + "의 이달 현황");
						MoneyBookVO show = new MoneyBookVO();
						show.setMem_id(login.getMem_id());
						ArrayList<MoneyBookVO> showList = bookService.showMoneyBookList(show);
						
						System.out.println("============================");
						for(int i = 0; i < showList.size(); i++) {
							System.out.print(showList.get(i).getGubun());
							System.out.printf(" %,d원입니다.", showList.get(i).getAccount());
							System.out.println();
						}
						System.out.println("============================");
						System.out.println();
						
						System.out.println("하단의 항목을 선택해주세요.");
						System.out.println("1. 가계부 기입 | 2. 가계부 조회 | 3. 종료");
						System.out.print(">>> ");
						int sel = 0;
						try {
							sel = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("숫자만 입력해주세요.");
							continue;
						}
						if(sel == 1) {
							// 가계부 기입
							System.out.println("사용 or 입금된 날짜를 작성해주세요.");
							System.out.println("ex) 230407");
							System.out.print(">>> ");
							String use_date;
							try {
								use_date = scan.nextLine();
							} catch (Exception e) {
								System.out.println("숫자6자리만 입력해주세요.");
								break;
							}
							use_date = use_date.substring(0,2) + "/" + use_date.substring(2,4) + "/" + use_date.substring(4);
							
							System.out.println("지출 or 수입 항목을 선택 해주세요.");
							System.out.println("1. 지출 | 2. 수입");
							System.out.print(">>> ");
							int temp = Integer.parseInt(scan.nextLine());
							String gubun = null;
							if(temp == 1) {
								gubun = "지출";
							}else if(temp == 2) {
								gubun = "수입";
							}else {
								System.out.println("1번 or 2번만 선택해주세요.");
								continue;
							}
							
							System.out.println("가계부 항목 분류를 해주세요.");
							System.out.println("수입 category : 소득,대출,특수");
							System.out.println("지출 category : 식비,세금,주거,피복,보건위생,교육,교양&오락,교통,통신,특별비");
							System.out.println("＃ 위의 항목과 동일하게 이름을 맞춰야 분류별 조회시 편합니다.");
							System.out.print(">>> ");
							String moneyCatergory = scan.nextLine();
							
							System.out.println("금액을 기입해주세요");
							System.out.print(">>> ");
							int account = Integer.parseInt(scan.nextLine());
							
							System.out.println("결제구분 기입해주세요. ");
							System.out.println("ex) 신용카드, 계좌이체, 현금 등");
							System.out.print(">>> ");
							String paymentCategory = scan.nextLine();
							
							System.out.println("내역 작성해주세요.");
							System.out.print(">>> ");
							String contents = scan.nextLine();
							
							MoneyBookVO temp2 = new MoneyBookVO (use_date, login.getMem_id(), gubun, moneyCatergory, account, paymentCategory, contents);
							bookService.registAccountBook(temp2);
						}else if(sel == 2) {
							// 가계부 조회
							System.out.println("조회방법에 대해서 선택해주세요.");
							System.out.println("1. 월별 조회 | 2. 항목별 조회 | 3. 결제방법별 조회");
							System.out.print(">>> ");
							int sel2 = 0;
							try {
								sel2 = Integer.parseInt(scan.nextLine());
							} catch (NumberFormatException e) {
								System.out.println("숫자만 입력해주세요.");
								continue;
							}
							if(sel2 == 1) {
								// 월별 조회
								System.out.println("조회를 원하시는 년도를 입력해주세요 ");
								System.out.println("ex) 2023년도: 23");
								System.out.print(">>> ");
								String year = scan.nextLine();
								System.out.println("조회를 원하시는 월을 입력해주세요");
								System.out.println("ex) 1월: 01");
								String month = scan.nextLine();
								
								String date = year + "/" + month + "/11";
								MoneyBookVO temp3 = new MoneyBookVO();
								temp3.setUse_date(date);
								temp3.setMem_id(login.getMem_id());
								
								ArrayList<MoneyBookVO> temp4 = bookService.monthAccountList(temp3);
								
								System.out.println("=====================================================================================================================");
								for(int i = 0; i < temp4.size(); i++) {
									System.out.println(temp4.get(i));
								}
								System.out.println("=====================================================================================================================");
							}else if(sel2 == 2) {
								//TODO 항목별 조회
								System.out.println("이달의 항목별 조회를 원하시면 1번, 아니라면 2번을 입력해주세요.");
								System.out.print(">>> ");
								int sel3 = 0;
								try {
									sel3 = Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException e) {
									System.out.println("숫자만 입력해주세요.");
									continue;
								}
								if(sel3 == 1 ) {
									// 이달의 항목별 조회
									Date today2 = new Date();
									SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
									String strToday2 = sdf.format(today2);
									
									MoneyBookVO temp9 = new MoneyBookVO();
									temp9.setMem_id(login.getMem_id());
									temp9.setUse_date(strToday2);
									ArrayList<MoneyBookVO> temp10 = bookService.monthAccountList(temp9);
									
									System.out.println("조회를 원하시는 항목을 기입해주세요.");
									System.out.println("ex) 수입: 소득,대출,특수");
									System.out.println("    지출: 식비,세금,주거,피복,보건위생,교육,교양&오락,교통,통신,특별비");
									System.out.print(">>> ");
									String category2 = scan.nextLine();
									
									System.out.println("=====================================================================================================================");
									int total2 = 0;
									for(int i = 0; i < temp10.size(); i++) {
										if(temp10.get(i).getMoney_category().equals(category2)) {
											System.out.println(temp10.get(i));
											total2 += temp10.get(i).getAccount();
										}
									}
									System.out.printf("해당 항목의 총금액은 %,d원입니다.", total2 );
									System.out.println();
									System.out.println("=====================================================================================================================");
								}else if(sel3 == 2) {
									// 전체 의 항목별 조회
									System.out.println("조회를 원하시는 항목을 기입해주세요.");
									System.out.println("ex) 수입: 소득,대출,특수");
									System.out.println("    지출: 식비,세금,주거,피복,보건위생,교육,교양&오락,교통,통신,특별비");
									System.out.print(">>> ");
									String category = scan.nextLine();
									
									MoneyBookVO temp5 = new MoneyBookVO();
									temp5.setMem_id(login.getMem_id());
									temp5.setMoney_category(category);
									
									ArrayList<MoneyBookVO> temp6 = bookService.moneyAccountList(temp5);
									
									System.out.println("=====================================================================================================================");
									int total = 0;
									for(int i = 0; i < temp6.size(); i++) {
										System.out.println(temp6.get(i));
										total += temp6.get(i).getAccount();
									}
									System.out.printf("해당 항목의 총금액은 %,d원입니다.", total );
									System.out.println();
									System.out.println("=====================================================================================================================");
								}else {
									System.out.println("1번 or 2번을 입력해주세요.");
									continue;
								}
								
							}else if(sel2 == 3) {
								//TODO 결제방법별 조회
								System.out.println("이달의 결제구분별 조회를 원하시면 1번, 아니라면 2번을 입력해주세요.");
								System.out.print(">>> ");
								int sel4 = 0;
								try {
									sel4 = Integer.parseInt(scan.nextLine());
								} catch (NumberFormatException e) {
									System.out.println("숫자만 입력해주세요.");
									continue;
								}
								if(sel4 == 1) {
									//TODO 이달의 결제방법별 조회
									Date today3 = new Date();
									SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
									String strToday3 = sdf.format(today3);
									
									MoneyBookVO temp11 = new MoneyBookVO();
									temp11.setMem_id(login.getMem_id());
									temp11.setUse_date(strToday3);
									ArrayList<MoneyBookVO> temp12 = bookService.monthAccountList(temp11);
									
									System.out.println("조회를 원하시는 결항목을 기입해주세요.");
									System.out.println("ex) 신용카드, 계좌이체, 현금 등");
									System.out.print(">>> ");
									String category3 = scan.nextLine();
									
									System.out.println("=====================================================================================================================");
									int total4 = 0;
									for(int i = 0; i < temp12.size(); i++) {
										if(temp12.get(i).getPayment_category().equals(category3)) {
											System.out.println(temp12.get(i));
											total4 += temp12.get(i).getAccount();
										}
									}
									System.out.printf("해당 항목의 총금액은 %,d원입니다.", total4 );
									System.out.println();
									System.out.println("=====================================================================================================================");
								}else if(sel4 == 2) {
									//TODO 전체의 결제방법별 조회
									System.out.println("조회를 원하시는 결항목을 기입해주세요.");
									System.out.println("ex) 신용카드, 계좌이체, 현금 등");
									System.out.print(">>> ");
									String category4 = scan.nextLine();
									
									MoneyBookVO temp7 = new MoneyBookVO();
									temp7.setMem_id(login.getMem_id());
									temp7.setPayment_category(category4);
									
									ArrayList<MoneyBookVO> temp8 = bookService.paymentAccountList(temp7);
									
									System.out.println("=====================================================================================================================");
									int total3 = 0;
									for(int i = 0; i < temp8.size(); i++) {
										System.out.println(temp8.get(i));
										total3 += temp8.get(i).getAccount();
									}
									System.out.printf("해당 항목의 총금액은 %,d원입니다.", total3 );
									System.out.println();
									System.out.println("=====================================================================================================================");
								}else {
									System.out.println("1번 or 2번을 입력해주세요.");
									continue;
								}
							}else {
								System.out.println("1,2,3번만 입력해주세요.");
								continue;
							}
						}else if(sel == 3) {
							// 종료
							System.out.println("가계부 프로그램 종료합니다~~!");
							break;
						}else {
							System.out.println("1,2,3번만 입력해주세요.");
							continue;
						}
					}
				}else {
					System.out.println("아이디 혹은 비밀번호가 틀립니다.");
				}
			}else if(command == 2) {
				// 회원가입
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
				// 아이디/비밀번호찾기
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
					// 아이디 찾기
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
					// 비밀번호 찾기
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
