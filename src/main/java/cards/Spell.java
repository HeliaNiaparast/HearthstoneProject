package cards;

public abstract class Spell extends Card {
	private boolean hasEcho;
	
	public boolean hasEcho() {
		return hasEcho;
	}
	
	public void setEcho(boolean hasEcho) {
		this.hasEcho = hasEcho;
	}
	
	public Spell (){}
	public Spell (int manaCost, String name, String rarity, String heroClass, String type, String description, int price){
		setManaCost(manaCost);
		setName(name);
		setRarity(rarity);
		setHeroClass(heroClass);
		setType(type);
		setDescription(description);
		setPrice(price);
	}
}