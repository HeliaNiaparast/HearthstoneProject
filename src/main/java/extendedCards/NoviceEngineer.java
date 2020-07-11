package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class NoviceEngineer extends Minion {
	private Game game;
	
	public NoviceEngineer() {
		game = Game.getInstance();
		setHP(1);
		setAttack(1);
		setSubType("");
		setManaCost(2);
		setName("NoviceEngineer");
		setRarity("Free");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Battlecry: Draw a card.");
		setPrice(2);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {
		game.draw();
	}

	public void doEndOfTurnAction() {}

}
