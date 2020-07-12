package extendedCards;

import cards.SpellWithoutTarget;
import gameLogic.Game;

public class FriendlySmith extends SpellWithoutTarget {
	private Game game;
	
	public FriendlySmith() {
		game = Game.getInstance();
		
		setManaCost(1);
		setName("FriendlySmith");
		setRarity("Common");
		setHeroClass("Rogue");
		setType("Spell");
		setDescription("Discover a weapon from any class. Add it to your Adventure Deck with +2/+2.");
		setPrice(2);
		setEcho(false);
		setDiscover(true);
	}
	
	public void perform() {}


}
