package ch10_extends_interface.ramen;

public class RamenMain {

	public static void main(String[] args) {
		// 추상 메소드를 가지는 추상 클래스는 
		// 객체로 소환할 수 없다. 
//		Ramen anyRamen = new Ramen("신라면", 1200);
		
		JinRamen jin = new JinRamen("진라면", 800);
		jin.printRecipe();
		
		Jjappagheti jja = new Jjappagheti("짜파게티", 1200);
		jja.printRecipe();
		
		
		
		
	}

}
