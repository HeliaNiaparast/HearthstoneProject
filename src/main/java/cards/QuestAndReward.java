package cards;

public class QuestAndReward extends Card{
	public QuestAndReward() {}
	public QuestAndReward(int manaCost, String name, String rarity, String heroClass, String type, 
			String description, int price) {
		setManaCost(manaCost);
		setName(name);
		setRarity(rarity);
		setHeroClass(heroClass);
		setType(type);
		setDescription(description);
		setPrice(price);
	}
}
