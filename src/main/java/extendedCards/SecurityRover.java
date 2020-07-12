package extendedCards;

import cards.Minion;
import gameLogic.Game;

public class SecurityRover extends Minion {
	private Game game;
	
	public SecurityRover() {
		game = Game.getInstance();
		setHP(6);
		setAttack(2);
		setSubType("Mech");
		setManaCost(6);
		setName("SecurityRover");
		setRarity("Rare");
		setHeroClass("Neutral");
		setType("Minion");
		setDescription("Whenever this minion takes damage, summon a 2/3 Mech with Taunt.");
		setPrice(8);
	}

	public void doDeathrattle() {}

	public void doOverkill() {}

	public void doBattlecry() {}

	public void doEndOfTurnAction() {}

	@Override
	public void getAttacked(int attack) {
		int initialHP = getHP();
		super.getAttacked(attack);
		if(getHP() < initialHP) {
			SecurityRover securityRover = new SecurityRover();
			securityRover.setHP(3);
			securityRover.setTaunt(true);
			game.summon(securityRover);
		}
	}
	
}
