package extendedCards;

import cards.Minion;

public class SwampKingDred extends Minion {
	public SwampKingDred() {
		setHP(9);
		setAttack(9);
		setSubType("Beast");
		setManaCost(7);
		setName("SwampKingDred");
		setRarity("Legendary");
		setHeroClass("Hunter");
		setType("Minion");
		setDescription("After your opponent plays a minion, attack it.");
		setPrice(15);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

}
