package hyunjin.submit12;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.text.ParseException;

public class DateBoardMain {

	public static void main(String[] args) throws ParseException {
		// dbList에 랜덤 날짜를 가지는 DateBoard 객체 100개 삽입
		ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		for(int i = 0; i < 100; i++) {
			int randDay = (int)(Math.random() * 365) + 1;		// 1~365	
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, randDay * -1);
					
			String strDate = sdf.format(cal.getTime());
			dbList.add(new DateBoard((i+1) + "번째 생성된 글", strDate));
		}
			
		for(int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}
		
		Collections.sort(dbList, (dateA, dateB) -> {
			int a = Integer.parseInt(dateA.getDate().replace(".", "").substring(0,8));
			int b = Integer.parseInt(dateB.getDate().replace(".", "").substring(0,8));
			int diff = a-b;
			return (diff> 0) ? -1 : 1;
		});
		System.out.println("날짜별로 정렬 후 출력(최신순)");
		for(int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}
		
		System.out.println("\n=============== 4번 문제 ================\n");
		
		Date today = new Date();
		System.out.println("최근 한달 내 작성된 게시");
		for(int i = 0; i<dbList.size(); i++) {
			Date postDate = sdf.parse(dbList.get(i).getDate());
			long diff = today.getTime()-postDate.getTime();
			if((diff/(1000*60*60*24) < 30)) {
				System.out.println(dbList.get(i));
			}
		}
		
		//한달 전 날짜로 셋팅
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		
		for(int i = 0; i < dbList.size(); i++) {
			Date temp = sdf.parse(dbList.get(i).getDate());
			
			// temp를 밀리초로 나타낸 것이
			// 한달 전 날짜를 밀리초로 나타낸 것보다 크면
			// 최근 한달 내 데이터를 의미한다.
			if(temp.getTime() > cal.getTime().getTime()) {
				System.out.println(dbList.get(i));
			}
			
		}
		
		
		System.out.println("\n===============5번 문제 ================\n");
		
		Calendar toMonth = Calendar.getInstance();
		int thisYear = toMonth.get(Calendar.YEAR);
		int thisMonth = toMonth.get(Calendar.MONTH);
		
		for(int i =0; i < dbList.size(); i++) {
			Date temp = sdf.parse(dbList.get(i).getDate());
			Calendar tempCal = Calendar.getInstance();
			tempCal.setTime(temp);
			
			int tempYear = tempCal.get(Calendar.YEAR);
			int tempMonth = tempCal.get(Calendar.MONTH);
			
			if (thisYear == tempYear && thisMonth == tempMonth) {
				System.out.println(dbList.get(i));
			}
		}
//		for (int i = 0; i<dbList.size(); i++) {
//			int a = Integer.parseInt(dbList.get(i).getDate().replace(".", "").substring(4,6));
//			if(a == thisMonth && a == thisYear) {
//				System.out.println(dbList.get(i));
//			}
//		}
		
		System.out.println("\n===============6번 문제 ================\n");
		thisMonth = 02;
		for (int i = 0; i<dbList.size(); i++) {
			int a = Integer.parseInt(dbList.get(i).getDate().replace(".", "").substring(4,6));
			if(a == thisMonth) {
				System.out.println(dbList.get(i));
			}
		}
		
		System.out.println("\n===============7번 문제 ================\n");
		
//		for (int i = 0; i<dbList.size(); i++) {
//			int a = Integer.parseInt(dbList.get(i).getDate().replace(".", "").substring(0,8));
//			if( a < 20220321 && a > 20220214) {
//				System.out.println(dbList.get(i));
//			}
//		}
		
		String fromStr = "2023.02.14";
		String toStr = "2023.03.21";
		
		sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		Date fromDate = sdf.parse(fromStr);
		Date toDate = sdf.parse(toStr);
		
		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		for(int i = 0; i < dbList.size(); i++) {
			Date temp = sdf.parse(dbList.get(i).getDate());
			
			// temp를 밀리초로 바꾼 값이
			// fromDate를 밀리초로 바꾼것보다 크고
			// toDate를 밀리초로 바꾼것보다 작은 것
			if(temp.getTime() >=fromDate.getTime()
					&& temp.getTime() <= toDate.getTime()) {
				System.out.println(dbList.get(i));
			}
		}
		
		
	}

}
