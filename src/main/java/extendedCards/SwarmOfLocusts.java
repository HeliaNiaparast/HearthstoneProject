package extendedCards;

import cards.SpellWithoutTarget;
import gameLogic.Game;

public class SwarmOfLocusts extends SpellWithoutTarget {

	private Game game;
	
	public SwarmOfLocusts() {
		game = Game.getInstance();
		
		setManaCost(6);
		setName("SwarmOfLocusts");
		setRarity("Rare");
		setHeroClass("Neutral");
		setType("Spell");
		setDescription("Summon seven 1/1 Locusts with Rush.");
		setPrice(8);
		setEcho(false);
		setDiscover(false);
	}

	
	@Override
	public void perform() {
		for(int i = 0; i < 7; i++)
			game.summon(new Locust());
	}

}
