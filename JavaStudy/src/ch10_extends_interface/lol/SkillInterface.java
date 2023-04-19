package ch10_extends_interface.lol;

//챔피언이라면 가지고 있어야 할 Q,W,E,R 스킬 추상 메소드
public interface SkillInterface {
	
	// 추상 메소드만 가지는 인터페이스는
	// abstract를 써주지 않는다.
	public void skillQ();
	
	public void skillW();
	public void skillE();
	public void skillR();
	
	
}
