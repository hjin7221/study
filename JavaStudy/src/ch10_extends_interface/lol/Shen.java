package ch10_extends_interface.lol;

public class Shen extends Champion implements SkillInterface {

	public Shen() {
		super();
	}

	public Shen(String name, int damage, int hp) {
		super(name, damage, hp);
	}

	@Override
	public void skillQ() {
		System.out.println("3번 세게 때린다.");
	}

	@Override
	public void skillW() {
		System.out.println("방어막을 생성한다.");
	}

	@Override
	public void skillE() {
		System.out.println("적에게 돌진한다.");
	}

	@Override
	public void skillR() {
		System.out.println("아군에게 돌진한다.");
	}

}
