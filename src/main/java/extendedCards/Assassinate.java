package extendedCards;

import cards.Minion;
import cards.SpellWithTarget;
import gameLogic.Game;

public class Assassinate extends SpellWithTarget {

	private Game game;
	
	public Assassinate() {
		game = Game.getInstance();
		
		setManaCost(5);
		setName("Assassinate");
		setRarity("Free");
		setHeroClass("Rogue");
		setType("Spell");
		setDescription("Destroy an enemy minion.");
		setPrice(5);
		setEcho(false);
		setDiscover(false);
	}
	
	public boolean isTargetValid(Minion Target) {
		return game.isEnemy(Target);
	}

	public void perform(Minion Target) {
		game.destroyMinion(Target);
	}

}
