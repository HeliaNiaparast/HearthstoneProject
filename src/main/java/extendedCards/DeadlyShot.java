package extendedCards;

import cards.SpellWithoutTarget;
import gameLogic.Game;

public class DeadlyShot extends SpellWithoutTarget {

	Game game;
	
	public DeadlyShot() {
		game = Game.getInstance();
		
		setManaCost(3);
		setName("DeadlyShot");
		setRarity("Common");
		setHeroClass("Neutral");
		setType("Spell");
		setDescription("Destroy a random enemy minion.");
		setPrice(4);
		setEcho(false);
		setDiscover(false);
	}
	
	public void perform() {
		game.destroyMinion(game.getRandomEnemyMinion());
	}

}
