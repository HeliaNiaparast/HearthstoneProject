package cards;

public abstract class Spell extends Card {
	private boolean hasEcho;
	private boolean hasDiscover;
	
	public boolean hasDiscover() {
		return hasDiscover;
	}

	public void setDiscover(boolean hasDiscover) {
		this.hasDiscover = hasDiscover;
	}

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