package extendedCards;

import cards.Minion;

public class Houndmaster extends Minion {
	public Houndmaster() {
		setHP(3);
		setAttack(4);
		setSubType("");
		setManaCost(4);
		setName("Houndmaster");
		setRarity("Free");
		setHeroClass("Hunter");
		setType("Minion");
		setDescription("Battlecry: Give a friendly Beast +2/+2 and Taunt.");
		setPrice(4);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

}
