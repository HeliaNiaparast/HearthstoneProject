package extendedCards;

import cards.Minion;

public class ViciousScalehide extends Minion {
	
	public ViciousScalehide() {
		setHP(3);
		setAttack(1);
		setSubType("Beast");
		setManaCost(2);
		setName("ViciousScalehide");
		setRarity("Common");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Lifesteal Rush");
		setPrice(3);
		setLifeSteal(true);
		setRush(true);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

}
