package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class Abomination extends Minion {
	private Game game;
	
	public Abomination() {
		game = Game.getInstance();
		setManaCost(5);
		setName("Abomination");
		setRarity("Rare");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Taunt. Deathrattle: Deal 2 damage to ALL characters.");
		setPrice(7);
		setHP(4);
		setAttack(4);
		setSubType("");
		setCurrentAttack(getAttack());
		setCurrentHP(getHP());
		setTaunt(true);
		setAlive(true);
	}

	public void doDeathrattle() {
		game.damageAllCharacters(2);
	}

	public void doOverkill() {}

}
