package hyunjin.submit09;

public class Product {
	// 필드 변수 선언
	private String name;
	private int price;

	// 생성자 만들기
	public Product() {

	}

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

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

	// to_string()

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

}