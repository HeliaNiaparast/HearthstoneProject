package extendedCards;

import cards.Minion;

public class Batterhead extends Minion {
	
	public Batterhead () {
		setManaCost(8);
		setName("Batterhead");
		setRarity("Epic");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Rush. After this attacks and kills a minion, it may attack again.");
		setPrice(12);
		setHP(12);
		setAttack(3);
		setSubType("");
		setCurrentAttack(getAttack());
		setCurrentHP(getHP());
		setRush(true);
		setAlive(true);
	}

	@Override
	public void attackMinion(Minion minion) {
		super.attackMinion(minion);
		if(!minion.isAlive())	setAttackCnt(getAttackCnt() - 1);
	}
	
	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

}
