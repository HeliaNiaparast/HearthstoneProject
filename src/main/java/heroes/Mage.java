package heroes;

import java.util.*;
import cards.*;

public class Mage extends Hero {
	public Mage(){
		setHeroClass("Mage");
		setHP(30);
		String heroPower = "Fireblast: Can deal 1 damage to any character with cost of 2 manas";
		setHeroPower(heroPower);
		String specialPower = "Spells cost them 2 manas less than their regular manacost";
		setSpecialPower(specialPower);
		ArrayList <Card> MageCards = new ArrayList <>();
		MageCards.add(Card.convert("Polymorph"));
		setCards(MageCards);
		ArrayList <Card> deck = new ArrayList <>();
		String [] cardNames = new String [] {"Polymorph", "Wisp", "SerpentWard", "ShadowMadness", "Abomination", "DeadlyShot", "Eureka"};
		for(int i=0; i<cardNames.length; i++)
			for(int j=0; j<2; j++)
				deck.add(Card.convert(cardNames[i]));
		setDeck(deck);
	}
}
