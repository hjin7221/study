package ch10_extends_interface.ramen;

public abstract class Ramen {
	String name;
	int price;

	public Ramen() {
	}

	public Ramen(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public abstract void printRecipe();
}