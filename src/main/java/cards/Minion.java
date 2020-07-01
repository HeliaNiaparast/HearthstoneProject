package cards;

public class Minion extends Card {
	private int HP;
	private int attack;
	private String subType;
	
	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}
	
	public int getHP() {
		return HP;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public Minion (){}
	public Minion (int manaCost, String name, String rarity, String heroClass, String type, String description, 
			int HP, int attack, int price, String subType){
		setManaCost(manaCost);
		setName(name);
		setRarity(rarity);
		setHeroClass(heroClass);
		setType(type);
		setDescription(description);
		setPrice(price);
		setHP(HP);
		setAttack(attack);
		setSubType(subType);
	}
}
