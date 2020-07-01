package heroes;

import java.util.ArrayList;

import cards.Card;

public class Paladin extends Hero {
	
	public Paladin() {
		setHeroClass("Paladin");
		setHP(30);
		String heroPower = "Plays two 1/1 Minions at the cost of 2 manas";
		setHeroPower(heroPower);
		String specialPower = "At the end of each turn randomly adds a +1/+1 to one of its Minions";
		setSpecialPower(specialPower);
		ArrayList <Card> PaladinCards = new ArrayList <>();
		PaladinCards.add(Card.convert("GnomishArmyKnife"));
		setCards(PaladinCards);
	}
}
