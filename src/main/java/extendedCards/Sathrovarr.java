package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class Sathrovarr extends Minion {
	private Game game;
	
	public Sathrovarr() {
		game = Game.getInstance();
		setHP(5);
		setAttack(5);
		setSubType("Demon");
		setManaCost(9);
		setName("Sathrovarr");
		setRarity("Legendary");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Battlecry: Choose a friendly minion. Add a copy of it to your hand, deck, and battlefield.");
		setPrice(17);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

}
