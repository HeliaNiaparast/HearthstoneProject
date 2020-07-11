package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class Dreadscale extends Minion {
	private Game game;
	
	public Dreadscale() {
		game = Game.getInstance();
		setHP(2);
		setAttack(4);
		setSubType("Beast");
		setManaCost(3);
		setName("Dreadscale");
		setRarity("Legendary");
		setHeroClass("Warlock");
		setType("Minion");
		setDescription("At the end of your turn, deal 1 damage to all other minions.");
		setPrice(11);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {
		game.damageAllOtherMinions(1, this);
	}
	
}
