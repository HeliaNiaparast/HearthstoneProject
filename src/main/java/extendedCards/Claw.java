package extendedCards;

import cards.SpellWithoutTarget;

public class Claw extends SpellWithoutTarget {

	public Claw() {
		setManaCost(1);
		setName("Claw");
		setRarity("Free");
		setHeroClass("Neutral");
		setType("Spell");
		setDescription("Give your hero +2 Attack this turn. Gain 2 Armor.");
		setPrice(1);
		setEcho(false);
		setDiscover(false);
	}
	
	@Override
	public void perform() {}

}
