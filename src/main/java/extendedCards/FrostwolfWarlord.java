package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class FrostwolfWarlord extends Minion {
	private Game game;
	
	public FrostwolfWarlord() {
		game = Game.getInstance();
		setHP(4);
		setAttack(4);
		setSubType("");
		setManaCost(5);
		setName("FrostwolfWarlord");
		setRarity("Free");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Battlecry: Gain +1/+1 for each other friendly minion on the battlefield.");
		setPrice(5);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {
		game.gainForFriendlyMinions(1, 1);
	}

	public void doEndOfTurnAction() {}

}
