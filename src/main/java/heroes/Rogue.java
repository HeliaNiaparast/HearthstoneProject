package heroes;

import java.util.*;
import cards.*;

public class Rogue extends Hero {
	public Rogue(){
		setHeroClass("Rogue");
		setHP(30);
		String heroPower = "Steals one card from the enemy's deck and adds it to its own deck at the cost of 3 manas. "
				+ "If its hero power levels up, it randomly steals one card from its own and one card from the enemy's deck.";
		setHeroPower(heroPower);
		String specialPower = "Cards that are neither from Rogue class nor from Neutral class, cost 2 manas "
				+ "less than their regular cost. This hero's hero power levels up when it owns a weapon.";
		setSpecialPower(specialPower);
		ArrayList <Card> RogueCards = new ArrayList <>();
		RogueCards.add(Card.convert("FriendlySmith"));
		RogueCards.add(Card.convert("Assassinate"));
		setCards(RogueCards);
		ArrayList <Card> deck = new ArrayList <>();
		String [] cardNames = new String []{"FriendlySmith", "Assassinate", "NoviceEngineer", "Warpath", "FrostwolfWarlord",
				"AzalinaSoulthief", "ShadowMadness"};
		for(int i=0; i<cardNames.length; i++)
			for(int j=0; j<2; j++)
				deck.add(Card.convert(cardNames[i]));
		setDeck(deck);
	}
}
