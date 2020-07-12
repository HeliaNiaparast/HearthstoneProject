package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class TombWarden extends Minion {
	private Game game;
	
	public TombWarden() {
		game = Game.getInstance();
		setHP(6);
		setAttack(3);
		setSubType("Mech");
		setManaCost(8);
		setName("TombWarden");
		setRarity("Rare");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Taunt Battlecry: Summon a copy of this minion.");
		setPrice(10);
		setTaunt(true);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {
		game.summon(new TombWarden());
	}

	public void doEndOfTurnAction() {}

}
