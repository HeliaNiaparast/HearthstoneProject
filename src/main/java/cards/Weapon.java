package cards;

public class Weapon extends Card {
	private int attack;
	private int durability;
	
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	public Weapon (){}
	
	public Weapon (int manaCost, String name, String rarity, String heroClass, String type, String description, int attack, int durability, int price){
		setManaCost(manaCost);
		setName(name);
		setRarity(rarity);
		setHeroClass(heroClass);
		setType(type);
		setDescription(description);
		setAttack(attack);
		setDurability(durability);
		setPrice(price);
	}
}