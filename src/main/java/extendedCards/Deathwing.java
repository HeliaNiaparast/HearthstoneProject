package extendedCards;

import cards.Minion;

public class Deathwing extends Minion {
	public Deathwing() {
		setHP(12);
		setAttack(12);
		setSubType("");
		setManaCost(10);
		setName("Deathwing");
		setRarity("Legendary");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Battlecry: Destroy all other minions and discard your hand.");
		setPrice(18);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

	
}
