package extendedCards;

import cards.SpellWithoutTarget;
import gameLogic.Game;

public class KangorsEndlessArmy extends SpellWithoutTarget {
	private Game game;
	
	public KangorsEndlessArmy() {
		game = Game.getInstance();
		
		setManaCost(7);
		setName("KangorsEndlessArmy");
		setRarity("Legendary");
		setHeroClass("Paladin");
		setType("Spell");
		setDescription("Resurrect 3 friendly Mechs. They keep any Magnetic upgrades.");
		setPrice(15);
		setEcho(false);
		setDiscover(false);
	}
	
	public void perform() {
		game.resurrectFriendlyMechs(3);
	}

}
