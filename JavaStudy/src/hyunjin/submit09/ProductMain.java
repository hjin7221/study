package hyunjin.submit09;

import java.util.ArrayList;
import java.util.Collections;

public class ProductMain {

	public static void main(String[] args) {
		//Q.01 전자제품
		ProductExplan ref = new ProductExplan("냉장고", 2000000);
		ProductExplan tv = new ProductExplan("TV", 1000000);
		ProductExplan air = new ProductExplan("에어컨", 800000);
		ProductExplan com = new ProductExplan("컴퓨터", 1300000);
		ProductExplan fan = new ProductExplan("선풍기", 100000);
		
		//Q.03 정렬
		
		ArrayList<ProductExplan> prodList = new ArrayList<>();
		prodList.add(ref);
		prodList.add(tv);
		prodList.add(air);
		prodList.add(com);
		prodList.add(fan);
		
		Collections.sort(prodList, (prodA,prodB) -> prodB.getPrice() - prodA.getPrice());
		
		for(int i = 0; i< prodList.size(); i++) {
			System.out.println(prodList.get(i));
		}
	
	
	// indexOf()
	// ArrayList<String> ramen = ["신라면, "안성탕면", "진라면"]
	// ArrayList<Integer> number = [10, 20, 30]
	// ramen.indexOf("안성탕면") = 1
	
	// ArrayList<ProductExplan> prodList = [ProductExplan객체(냉장고), ProductExplan객체(TV)
	// prodList.indexOf("TV")
	
		for(int i = 0; i < prodList.size(); i++) {
			if(prodList.get(i).getName().equals("TV")) {
				System.out.println(i);
			}
		}
	}
}	
	

