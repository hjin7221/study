package hyunjin.submit09;

public class ProductExplan {
	private String name;
	private int price;
	
	public ProductExplan() {}
	
	public ProductExplan(String name, int price) {

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

	@Override
	public String toString() {
		return "ProductExplan [name=" + name + ", price=" + price + "]";
	}
	
	
	
	
	
	
}
