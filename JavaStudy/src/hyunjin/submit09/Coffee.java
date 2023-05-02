package hyunjin.submit09;

public class Coffee {

	// 필드변수 선언
	private static String name;
	private static int price;

	// 생성자

	public Coffee() {

	}

	public Coffee(String name, int price) {
		this.name = name;
		this.price = price;
	}

	// to String
	@Override
	public String toString() {
		return "[" + name + ", " + price + "]";
	}

	// 캡슐화
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
