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
		System.out.println(today.getTime());
		System.out.println("최근 한달 내 작성된 게시");
		for(int i = 0; i<dbList.size(); i++) {
			Date postDate = sdf.parse(dbList.get(i).getDate());
			long diff = today.getTime()-postDate.getTime();
			if((diff/(1000*60*60*24) < 30)) {
				System.out.println(dbList.get(i));
			}
		}
		
		System.out.println("\n===============5번 문제 ================\n");
		
		Calendar cal = Calendar.getInstance();
		int thisMonth = cal.get(Calendar.MONTH) + 1;
		
		for (int i = 0; i<dbList.size(); i++) {
			int a = Integer.parseInt(dbList.get(i).getDate().replace(".", "").substring(4,6));
			if(a == thisMonth) {
				System.out.println(dbList.get(i));
			}
		}
		
		System.out.println("\n===============6번 문제 ================\n");
		thisMonth = 02;
		for (int i = 0; i<dbList.size(); i++) {
			int a = Integer.parseInt(dbList.get(i).getDate().replace(".", "").substring(4,6));
			if(a == thisMonth) {
				System.out.println(dbList.get(i));
			}
		}
		
		System.out.println("\n===============7번 문제 ================\n");
		
		for (int i = 0; i<dbList.size(); i++) {
			int a = Integer.parseInt(dbList.get(i).getDate().replace(".", "").substring(0,8));
			if( a < 20220321 && a > 20220214) {
				System.out.println(dbList.get(i));
			}
		}
		
		
	}

}
