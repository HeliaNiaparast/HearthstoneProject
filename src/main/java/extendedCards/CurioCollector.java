package extendedCards;

import cards.Minion;

public class CurioCollector extends Minion {
	public CurioCollector() {
		setHP(4);
		setAttack(4);
		setSubType("");
		setManaCost(5);
		setName("CurioCollector");
		setRarity("Rare");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Whenever you draw a card, gain +1/+1.");
		setPrice(7);
	}

	public void doActionOnDraw() {
		addHP(1);
		addAttack(1);
	}
	
	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

}
