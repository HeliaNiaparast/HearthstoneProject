package heroes;

import java.util.ArrayList;

import cards.Card;

public class Hunter extends Hero {
	public Hunter(){
		setHeroClass("Hunter");
		setHP(30);
		String heroPower = "Passive. After your opponent plays a Minion deal 1 damage to it";
		setHeroPower(heroPower);
		String specialPower = "All of its Minions have Rush";
		setSpecialPower(specialPower);
		ArrayList <Card> HunterCards = new ArrayList <>();
		HunterCards.add(Card.convert("SwampKingDred"));
		setCards(HunterCards);
	}
}