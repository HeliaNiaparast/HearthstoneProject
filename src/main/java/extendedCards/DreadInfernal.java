package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class DreadInfernal extends Minion {
	private Game game;
	
	public DreadInfernal() {
		game = Game.getInstance();
		setHP(6);
		setAttack(6);
		setSubType("Demon");
		setManaCost(6);
		setName("DreadInfernal");
		setRarity("Free");
		setHeroClass("Warlock");
		setType("Minion");
		setDescription("Battlecry: Deal 1 damage to ALL other characters.");
		setPrice(6);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {
		game.damageAllOtherCharacters(1, this);
	}

	public void doEndOfTurnAction() {}

}
