package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class ArenaPatron extends Minion {
	private Game game;
	
	public ArenaPatron () {
		game = Game.getInstance();
		setManaCost(5);
		setName("ArenaPatron");
		setRarity("Rare");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Overkill: Summon another Arena Patron.");
		setPrice(7);
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

}
