package extendedCards;

import cards.SpellWithoutTarget;
import gameLogic.Game;

public class Sprint extends SpellWithoutTarget {

	private Game game;
	
	public Sprint() {
		game = Game.getInstance();
		
		setManaCost(7);
		setName("Sprint");
		setRarity("Free");
		setHeroClass("Neutral");
		setType("Spell");
		setDescription("Draw 4 cards.");
		setPrice(7);
		setEcho(false);
		setDiscover(false);
	}
	
	public void perform() {
		for(int i = 0; i < 4; i++)
			game.draw();
	}

}
