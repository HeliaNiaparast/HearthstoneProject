package extendedCards;

import cards.Minion;

public class Locust extends Minion {
	public Locust() {
		setHP(1);
		setAttack(1);
		setSubType("Beast");
		setManaCost(1);
		setName("Locust");
		setRarity("Free");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Rush");
		setPrice(1);
		setRush(true);
	}

	@Override
	public void doDeathrattle() {}

	@Override
	public void doOverkill() {}

	@Override
	public void doBattlecry() {}

	@Override
	public void doEndOfTurnAction() {}

}
