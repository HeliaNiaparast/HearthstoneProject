package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class AzalinaSoulthief extends Minion {

	private Game game;
	
	public AzalinaSoulthief() {
		game = Game.getInstance();
		setManaCost(7);
		setName("AzalinaSoulthief");
		setRarity("Legendary");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Battlecry: Replace your hand with a copy of your opponent's.");
		setPrice(15);
		setHP(3);
		setAttack(3);
		setSubType("");
		setCurrentAttack(getAttack());
		setCurrentHP(getHP());
		setTaunt(false);
		setAlive(true);
	}
	
	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {
		game.replaceHand();
	}

	public void doEndOfTurnAction() {}
}
