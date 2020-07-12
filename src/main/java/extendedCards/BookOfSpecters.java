package extendedCards;

import cards.SpellWithoutTarget;
import gameLogic.Game;

public class BookOfSpecters extends SpellWithoutTarget {

	Game game;
	
	public BookOfSpecters() {
		game = Game.getInstance();
		
		setManaCost(2);
		setName("BookOfSpecters");
		setRarity("Epic");
		setHeroClass("Neutral");
		setType("Spell");
		setDescription("Draw 3 cards. Discard any spells drawn.");
		setPrice(6);
		setEcho(false);
		setDiscover(false);
	}
	
	@Override
	public void perform() {
		game.drawCardsDiscardSpells(3);
	}

}
