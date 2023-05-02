package hyunjin.submit09;

import java.util.ArrayList;

import ch09_class.school.Student;

public class Submit09 {

	public static void main(String[] args) {

		System.out.println("\n================= Q.1-1 ==============\n");

		// 1. 하이마트에 놀러갔더니 전자제품들이 정말 많이 있군요. 전자제품들은 각각 제품명과 가격이 함께 전시되어있습니다.
		// 이를 코드로 구현하기 위해, 필드 변수에 제품명과 가격을 포함하는 전자제품 클래스(Product)를 만들어보세요.
		// (당연히 제품명과 가격을 입력받는 생성자를 포함하며, 필드 변수들은 캡슐화를 해야 겠죠?)

		System.out.println("\n================= Q.1-2 ==============\n");

		Product refrigerator = new Product("냉장고", 2000000);
		Product tv = new Product("TV", 1000000);
		Product aircon = new Product("에어컨", 800000);
		Product computer = new Product("컴퓨터", 1300000);
		Product fan = new Product("선풍기", 100000);

		System.out.println("\n================= Q.1-3 ==============\n");

		ArrayList<Product> productList = new ArrayList<>();

		productList.add(refrigerator);
		productList.add(tv);
		productList.add(aircon);
		productList.add(computer);
		productList.add(fan);

		for (int k = 0; k < productList.size() - 1; k++) {
			for (int i = 0; i < productList.size() - 1; i++) {
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if (productList.get(i).getPrice() < productList.get(i + 1).getPrice()) {
					Product t = productList.get(i);
					productList.set(i, productList.get(i + 1));
					productList.set(i + 1, t);
				}
			}
		}

		for (int i = 0; i < productList.size(); i++) {
			System.out.println(productList.get(i));
		}

		System.out.println("\n================= Q.1-4 ==============\n");

		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getName().contains("TV")) {
				System.out.println(productList.indexOf(productList.get(i)));
			}
		}

		System.out.println("\n================= Q.1-@ ==============\n");

	}

}