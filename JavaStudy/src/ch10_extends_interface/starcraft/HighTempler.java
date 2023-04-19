package ch10_extends_interface.starcraft;

public class HighTempler extends StarUnit{
	
	private int shield;
	private int mp;
	
	public HighTempler() {
		this("하이템플러", 0, 60, 0, 50, 150);
	} 
	
	public HighTempler(String name, int damage, int hp, int armor, int shield, int mp) {
		super(name,damage,hp,armor);
		this.shield = shield;
		this.mp = mp;
	}
	

	
	public void thunderStorm() {
		mp -= 75;
		System.out.println("우르르 쾅쾅!");
	}
	
	
	
	@Override
	public String toString() {
		return "HighTempler [name=" + getName() + ", damage=" + getDamage() + ", hp=" + getHp() + ", armor=" + getArmor() + ", shield="
				+ shield + ", mp=" + mp + "]";
	}


	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}
	
	
	
	
	
}
