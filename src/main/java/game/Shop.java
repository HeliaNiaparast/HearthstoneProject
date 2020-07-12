package game;

import java.util.ArrayList;

import cards.Card;

public class Shop {
	private ArrayList <Card> cards;
	private ArrayList <Card> lockedCards;

	public Shop(){}
	
	public Shop(ArrayList <Card> cards, ArrayList<Card> lockedCards) {
		setCards(cards);
		setLockedCards(lockedCards);
	}
	
	public void setCards(ArrayList <Card> cards) {
		this.cards = cards;
	}
	
	public ArrayList <Card> getCards(){
		return cards;
	}
	
	public boolean sell(Player player, Card card) {
		if(!player.canSell(card))	return false;
		
		cards.add(card);
		player.setCoins(player.getCoins() + card.getPrice());
		player.removeCard(card);
		
		LogWriter.write(player, "Sell", card.getName());
		
		return true;
	}
	
	public boolean buy(Player player, Card card) {
		if(!player.canBuy(card))	return false;
		
		player.addCard(card);
		player.setCoins(player.getCoins() - card.getPrice());
			
		LogWriter.write(player, "Buy", card.getName());
		
		return true;
	}

	public ArrayList<Card> getLockedCards() {
		return lockedCards;
	}

	public void setLockedCards(ArrayList<Card> lockedCards) {
		this.lockedCards = lockedCards;
	}

	public void remove(Card card) {
		int index = -1;
		for(int i = 0; i < cards.size(); i ++) 
			if(cards.get(i).getName().equals(card.getName())) {
				index = i;
				break;
			}
		
		if(index != -1)		cards.remove(index);
	}
}
