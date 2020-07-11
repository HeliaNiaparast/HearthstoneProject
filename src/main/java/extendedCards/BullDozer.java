package extendedCards;

import cards.Minion;

public class BullDozer extends Minion {
	public BullDozer() {
		setHP(7);
		setAttack(9);
		setSubType("Mech");
		setManaCost(9);
		setName("BullDozer");
		setRarity("Common");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Divine Shield");
		setPrice(10);
		setDivineshield(true);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

}
