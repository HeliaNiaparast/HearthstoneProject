package cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck implements Comparable<Deck> {
	private ArrayList <Card> cards;
	private String name;
	private int wins;
	private int games;
	private String hero;
	
	public Deck() {}
	
	public Deck(String name, String hero) {
		setName(name);
		setHero(hero);
		cards = new ArrayList<>();
		init();
	}

	private void init() {
		wins = 0;
		games = 0;
	}
	
	public Deck(ArrayList<Card> cards, String name, String hero) {
		setCards(cards);
		setName(name);
		setHero(hero);
		init();
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public void add(Card card) {
		cards.add(card);
	}
	
	public void remove(Card card) {
		int index = 0;
		for(int i = 0; cards != null && i < cards.size(); i ++)
			if(cards.get(i).getName().equals(card.getName())) {
				index = i;
				break;
			}
		cards.remove(index);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public double winRatio() {
		if(games == 0)	return 0;
		return (double)wins / (double)games;
	}
	
	public double averageCost() {
		if(cards.size() == 0)
			return 0;
		
		double avr = 0;
		for(int i = 0; i < cards.size(); i ++) {
			avr += cards.get(i).getManaCost();
		}
		avr /= cards.size();
		return avr;
	}
	
	public int getCardCnt(Card card) {
		int cnt = 0;
		for(Card fcard : cards)
			if(fcard.getName().equals(card.getName()))
				cnt ++;
		
		return cnt;
	}
	
	public Card mostUsed() {
		if(cards.size() == 0)	return null;
		
		int cnt = 0;
		for(Card card : cards)
			if(getCardCnt(card) > cnt)	
				cnt = getCardCnt(card);
		
		ArrayList<Card> maxCards = new ArrayList<>();
		for(Card card : cards)
			if(getCardCnt(card) == cnt)
				maxCards.add(card);
		
		Collections.sort(maxCards);
		
		return maxCards.get(maxCards.size()-1);
	}

	@Override
	public int compareTo(Deck deck) {
		if(this.winRatio() > deck.winRatio())	return 1;
		if(this.winRatio() < deck.winRatio())	return -1;
		
		if(this.wins > deck.wins)	return 1;
		if(this.wins < deck.wins)	return -1;
		
		if(this.games > deck.games)	return 1;
		if(this.games < deck.games)	return -1;
		
		if(this.averageCost() > deck.averageCost())	return 1;
		if(this.averageCost() < deck.averageCost())	return -1;
		
		return 1;
	}
}
