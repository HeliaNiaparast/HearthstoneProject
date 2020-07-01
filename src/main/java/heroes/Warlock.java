package heroes;

import java.util.ArrayList;

import cards.Card;

public class Warlock extends Hero {
	public Warlock() {
		setHeroClass("Warlock");
		setHP(35);
		String specialPower = "Starts with 35 lives instead of 30.";
		setSpecialPower(specialPower);
		String heroPower = "Radomly does one of two things at the cost of 2 lives: " + "\r\n"
				+ "1. Randomly adds +1/+1 to one of the minions on the battlefield (if there exists any minions)" + "\r\n" 
				+ "2. Draws a card from the deck and adds it to the player's current deck.";
		setHeroPower(heroPower);
		ArrayList <Card> RogueCards = new ArrayList <>();
		RogueCards.add(Card.convert("Dreadscale"));
		RogueCards.add(Card.convert("DreadInfernal"));
		setCards(RogueCards);
		ArrayList <Card> deck = new ArrayList <>();
		String [] cardNames = new String [] {"Dreadscale", "DreadInfernal", "ViciousScalehide", "Claw", "DeadlyShot",
				"Abomination", "CountessAshmore"};
		for(int i=0; i<cardNames.length; i++)
			for(int j=0; j<2; j++)
				deck.add(Card.convert(cardNames[i]));
		setDeck(deck);
	}
}
