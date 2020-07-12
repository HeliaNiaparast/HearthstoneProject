package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class SerpentWard extends Minion {
	private Game game;
	
	public SerpentWard() {
		game = Game.getInstance();
		setHP(2);
		setAttack(0);
		setSubType("Totem");
		setManaCost(2);
		setName("SerpentWard");
		setRarity("Rare");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("At the end of your turn, deal 2 damage to the enemy hero.");
		setPrice(4);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {
		game.damageEnemyHero(2);
	}

}
