package hyunjin.submit11;

import java.util.ArrayList;

import ch09_class.homepage.Member;

public class DrawingDB {

	private ArrayList<Drawing> drawingList = new ArrayList<>();

	private DrawingDB() {
		drawingList.add(new Drawing(1, "ISUZU_Main Busbar NEG_220617", "신규접수"));
		drawingList.add(new Drawing(2, "Ford 48V_POWER INTERFACE_220711", "신규접수"));
		drawingList.add(new Drawing(3, "Omron 100V_PF Bracket 2_220811", "신규접수"));
		drawingList.add(new Drawing(4, "Volvo P319_Busbar FF_220911", "신규접수"));
		drawingList.add(new Drawing(5, "Volvo P319_Busbar MM_220911", "신규접수"));
		drawingList.add(new Drawing(6, "Chrysler 48V_Top Case_221011", "신규접수"));
	}

	private static DrawingDB instance = new DrawingDB();

	public static DrawingDB getInstance() {
		return instance;
	}

	public void showDrawList() {
		for (int i = 0; i < drawingList.size(); i++) {
			System.out.println(drawingList.get(i));
		}
	}

	// no
	public int drawNumUp() {
		return drawingList.size() + 1;
	}

	// 도면 추가
	public void registDrawing(Drawing draw) {
		for (int i = 0; i < drawingList.size(); i++) {
			if (draw.getPjt().equals(drawingList.get(i).getPjt())
					&& draw.getProduct().equals(drawingList.get(i).getProduct())
					&& draw.getDate().equals(drawingList.get(i).getDate())) {
				System.out.println("중복된 도면 입니다.");
				return;
			}
		}
		drawingList.add(draw);
	}

	// 도면 검색
	public void searchDrawing(String keyword) {
		boolean c = false;
		for (int i = 0; i < drawingList.size(); i++) {
			if (drawingList.get(i).getPjt().toLowerCase().contains(keyword)
					|| drawingList.get(i).getProduct().toLowerCase().contains(keyword)) {
				System.out.println(drawingList.get(i));
			}
			c = true;
		}
		if (c = false) {
			System.out.println("해당 도면이 없습니다.");
		}
	}

	// 입력된 값이 정수인지 문자인지 판별
	public boolean inputCheck(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	// 입력된 도면 번호로 도면 출력
	public void printDrawing(int no) {
		boolean check = false;
		for (int i = 0; i < drawingList.size(); i++) {
			if (drawingList.get(i).getNo() == no) {
				System.out.println("선택하신 " + drawingList.get(i).getPjt() + "프로젝트 " + drawingList.get(i).getProduct()
						+ " 제품 도면을 출력합니다.");
			}
			check = true;
		}
		if (check = false) {
			System.out.println("해당 도면 번호가 존재 하지 않습니다.");
			System.out.println("번호 재확인 바랍니다.");
		}
	}

	// rev no 업
	public void revUp(String title) {
		String[] temp = title.split("_");
		for (int i = 0; i < drawingList.size(); i++) {
			if (drawingList.get(i).getPjt().equals(temp[0]) && drawingList.get(i).getProduct().equals(temp[1])) {
				drawingList.get(drawingList.size() - 1).setRev(drawingList.get(drawingList.size() - 1).getRev() + 0.05);
			}
		}
	}
}