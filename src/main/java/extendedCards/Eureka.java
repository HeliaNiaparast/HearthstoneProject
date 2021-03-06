package extendedCards;

import cards.SpellWithoutTarget;
import gameLogic.Game;

public class Eureka extends SpellWithoutTarget {

	private Game game;
	
	public Eureka() {
		game = Game.getInstance();
		
		setManaCost(6);
		setName("Eureka");
		setRarity("Rare");
		setHeroClass("Neutral");
		setType("Spell");
		setDescription("Summon a copy of a random minion from your hand.");
		setPrice(8);
		setEcho(false);
		setDiscover(false);
	}
	
	public void perform() {
		if(game.copyRandomMinionFromHand() != null)
			game.summon(game.copyRandomMinionFromHand());
	}

}
