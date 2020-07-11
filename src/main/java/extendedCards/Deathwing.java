package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class Deathwing extends Minion {
	
	private Game game;
	
	public Deathwing() {
		game = Game.getInstance();
		setHP(12);
		setAttack(12);
		setSubType("Dragon");
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

	public void doBattlecry() {
		game.destroyAllOtherMinions(this);
		game.discardHand();
	}

	public void doEndOfTurnAction() {}

	
}
