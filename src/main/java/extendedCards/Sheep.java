package extendedCards;

import cards.Minion;

public class Sheep extends Minion {
	
	public Sheep() {
		setHP(1);
		setAttack(1);
		setSubType("Beast");
		setManaCost(1);
		setName("Sheep");
		setRarity("Free");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("");
		setPrice(1);
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
