package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class CountessAshmore extends Minion {
	private Game game;
	
	public CountessAshmore() {
		game = Game.getInstance();
		setHP(6);
		setAttack(6);
		setSubType("");
		setManaCost(7);
		setName("CountessAshmore");
		setRarity("Legendary");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Battlecry: Draw a Rush, Lifesteal, and Deathrattle card from your deck.");
		setPrice(15);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {
		game.draw("Rush");
		game.draw("Lifesteal");
		game.draw("Deathrattle");
	}

	public void doEndOfTurnAction() {}

}
