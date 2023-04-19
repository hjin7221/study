package ch10_extends_interface.simple;

// Child 는 Parent가 가진 필드변수, 메소드를 가지고 있는 상태
// private으로 되어있는건 자식 객체에서 접근할 수 없다.
public class Child extends Parent {
	 
	public Child() {
		super();
	}

	public Child(String name, int age) {
		super(name, age);
	}

	@Override
	public void sayHello() {
		System.out.println("응애에요.");;
	}

	@Override
	public String toString() {
		return "Child [getName()=" + super.getName() + ", getAge()=" + getAge() + "]";
	}
	
	
	
	
	
}
