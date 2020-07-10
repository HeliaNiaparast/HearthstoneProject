package extendedCards;

import cards.Minion;

public class ColossusOfTheMoon extends Minion {
	public ColossusOfTheMoon() {
		setHP(10);
		setAttack(10);
		setSubType("");
		setManaCost(10);
		setName("ColossusOfTheMoon");
		setRarity("Legendary");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Divine Shield Reborn");
		setPrice(18);
		setDivineshield(true);
		setReborn(true);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

}
