package ch10_extends_interface.simple;

// 자바에서는 기본적으로 모든 클래스가 
// Object 클래스를 상속받고 있다.
// (보이지 않는 상태)
public class Parent {
	private String name;
	private int age;

	public Parent() {
	}

	public Parent(String name, int age) {
		// 부모 클래스의 기본 생성자
		super();
		this.name = name;
		this.age = age;
	}

	public void sayHello() {
		System.out.println("어른이입니다.");
	}

	// 부모클래스의 메소드를 자식 클래스에서
	// 재정의(Override)해서 사용
	@Override
	public String toString() {
		return "Parent [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}