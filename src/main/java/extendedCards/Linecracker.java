package extendedCards;

import cards.Minion;

public class Linecracker extends Minion {

	public Linecracker() {
		setHP(10);
		setAttack(5);
		setSubType("");
		setManaCost(7);
		setName("Linecracker");
		setRarity("Epic");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Overkill: Double this minion's Attack.");
		setPrice(11);
	}
	
	public void doDeathrattle() {}

	public void doOverkill() {
		addAttack(getAttack());
	}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

}
