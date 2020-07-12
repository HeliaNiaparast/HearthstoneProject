package extendedCards;

import cards.Minion;

public class Sathrovarr extends Minion {
	public Sathrovarr() {
		setHP(5);
		setAttack(5);
		setSubType("Demon");
		setManaCost(9);
		setName("Sathrovarr");
		setRarity("Legendary");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Battlecry: Choose a friendly minion. Add a copy of it to your hand, deck, and battlefield.");
		setPrice(17);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

}
