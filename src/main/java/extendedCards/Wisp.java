package extendedCards;

import cards.Minion;

public class Wisp extends Minion {
	
	public Wisp() {
		setHP(1);
		setAttack(1);
		setSubType("");
		setManaCost(0);
		setName("Wisp");
		setRarity("Common");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("");
		setPrice(1);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

}
