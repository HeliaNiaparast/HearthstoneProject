package extendedCards;

import cards.SpellWithoutTarget;
import gameLogic.Game;

public class Warpath extends SpellWithoutTarget {

	private Game game;
	
	public Warpath() {
		game = Game.getInstance();
		
		setManaCost(2);
		setName("Warpath");
		setRarity("Common");
		setHeroClass("Neutral");
		setType("Spell");
		setDescription("Echo Deal 1 damage to all minions.");
		setPrice(3);
		setEcho(true);
		setDiscover(false);
	}

	
	@Override
	public void perform() {
		game.damageAllMinions(1);
	}

}
