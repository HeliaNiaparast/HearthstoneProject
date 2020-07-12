package extendedCards;

import java.util.ArrayList;

import cards.Minion;
import cards.SpellWithTarget;
import gameLogic.Game;

public class ShadowMadness extends SpellWithTarget {

	private Game game;
	
	public ShadowMadness() {
		game = Game.getInstance();
		
		setManaCost(4);
		setName("ShadowMadness");
		setRarity("Rare");
		setHeroClass("Neutral");
		setType("Spell");
		setDescription("Gain control of an enemy minion with 3 or less Attack until end of turn.");
		setPrice(6);
		setEcho(false);
		setDiscover(false);
	}
	
	@Override
	public boolean isTargetValid(Minion Target) {
		ArrayList<Minion> enemyGround = game.getPlayers()[1-game.currentPlayerIndex()].getGround();
		if(enemyGround.contains(Target) && Target.getCurrentAttack() <= 3)	return true;
		return false;
	}

	@Override
	public void perform(Minion Target) {
		game.addToControlledMinions(Target);
		
	}

}
