package extendedCards;

import cards.Minion;
import cards.SpellWithTarget;
import gameLogic.Game;

public class Polymorph extends SpellWithTarget {

	private Game game;
	
	public Polymorph() {
		game = Game.getInstance();
		
		setManaCost(4);
		setName("Polymorph");
		setRarity("Free");
		setHeroClass("Mage");
		setType("Spell");
		setDescription("Transform a minion into a 1/1 Sheep.");
		setPrice(4);
		setEcho(false);
		setDiscover(false);
	}
	
	@Override
	public boolean isTargetValid(Minion Target) {
		return true;
	}

	@Override
	public void perform(Minion Target) {
		game.transform(Target, new Sheep());
	}

}
