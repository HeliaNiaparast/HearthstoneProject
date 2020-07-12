package extendedCards;

import cards.Minion;
import cards.SpellWithTarget;
import heroes.Hero;

public class Fireball extends SpellWithTarget {
	
	public Fireball() {
		
		setManaCost(4);
		setName("Fireball");
		setRarity("Free");
		setHeroClass("Mage");
		setType("Spell");
		setDescription("Deal 6 damage.");
		setPrice(4);
		setEcho(false);
		setDiscover(false);
	}
	
	public boolean isTargetValid(Minion Target) {
		return true;
	}

	public void perform(Minion Target) {
		Target.getAttacked(6);
	}
	
	public void perform(Hero Target) {
		Target.getAttacked(6);
	}

}
