package game;

import java.io.File;
import java.util.ArrayList;

import cards.Card;
import cards.Deck;
import heroes.Hero;
import heroes.Mage;

public class Player {
	private String username;
	private String password;
	private long userID;
	private int coins;
	private ArrayList <Deck> decks;
	private Deck currentDeck;
	private ArrayList <Card> allCards;
	private ArrayList <Card> cards;
	private ArrayList <Card> lockedCards;
	private ArrayList <String> heroes;
	private Shop shop;
	private Hero hero;
	
	public Player(){}
	
	public Player(String username, String password){
		setUsername(username);
		setPassword(password);
		setUserID(java.lang.System.currentTimeMillis());
		setCoins(50);
		cardsInit();
		
		this.heroes = new ArrayList<>();
		String[] heroes = new String[] {"Mage", "Rogue", "Warlock", "Paladin", "Hunter"};
		for(int i = 0; i < 5; i ++)
			this.heroes.add(heroes[i]);
		
		setHero(new Mage());
	}
	
	private void cardsInit() {
		cards = new ArrayList <>();
		String [] cardNames = new String [] {"Polymorph", "Fireball", "FriendlySmith", "DreadScale"
				, "SwampKingDred", "GnomishArmyKnife"};
		for(int i = 0; i < cardNames.length; i ++)
			cards.add(Card.convert(cardNames[i]));
		
		lockedCards = new ArrayList<>();
		
		ArrayList<Card> shopCards = new ArrayList<>();
		shopCards.add(Card.convert("Assassinate"));
		shopCards.add(Card.convert("KangorsEndlessArmy"));
		
		ArrayList<Card> shopLocked = new ArrayList<>();
		
//		ArrayList<Card> gameCards = CardDesign.getCards();
		ArrayList<Card> gameCards = getAllGameCards();
		for(int i = 10; i < gameCards.size(); i += 4) {
			cards.add(gameCards.get(i));
			cards.add(gameCards.get(i+1));
			shopCards.add(gameCards.get(i+2));
			lockedCards.add(gameCards.get(i+3));
			shopLocked.add(gameCards.get(i+3));
		}
		
		for(int i = 0; i < 4; i ++) {
			lockedCards.remove(0);
			shopLocked.remove(shopLocked.size()-1);
		}
		
		shopLocked.add(Card.convert("Houndmaster"));
		shopCards.addAll(cards);
		lockedCards.add(Card.convert("DreadInfernal"));
		
		shop = new Shop(shopCards, shopLocked);
		
		allCards = new ArrayList<>();
		allCards.addAll(cards);
		allCards.addAll(lockedCards);
		
		ArrayList <Card> deck = new ArrayList<>();
		String[] deckCards = new String[] {"Polymorph", "Fireball", "Wisp", "Claw", "ViciousScalehide"};
		for(int i = 0; i < deckCards.length; i ++) {
			deck.add(Card.convert(deckCards[i]));
			deck.add(Card.convert(deckCards[i]));
		}
		
		decks = new ArrayList<>();
		decks.add(new Deck(deck, "FirstDeck", "Mage"));

	}
	
	public ArrayList<Deck> getDecks(){
		return decks;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	public long getUserID() {
		return userID;
	}
	
	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public void setAllCards(ArrayList <Card> allCards) {
		this.allCards = allCards;
	}
	
	public ArrayList <Card> getAllCards() {
		return allCards;
	}
	
	public void setCurrentDeck(Deck currentDeck) {
		this.currentDeck = currentDeck;
	}
	
	public Deck getCurrentDeck() {
		return currentDeck;
	}	
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public Shop getShop() {
		return shop;
	}
	
	public boolean canBuy(Card card) {
		if(getCoins() < card.getManaCost())		return false;
		else	return true;
	}
	
	public boolean canSell(Card card) {
		for(Deck deck : decks) 
			for(Card deckCard : deck.getCards())
				if(deckCard.getName().equals(card.getName()))
					return false;

		return true;
	}
	
	public void setCards(ArrayList <Card> cards) {
		this.cards = cards;
	}
	
	public ArrayList <Card> getCards(){
		return cards;
	}
	
	public void removeCard(Card card) {
		int index = -1;
		for(int i = 0; i < cards.size(); i ++)
			if(cards.get(i).getName().equals(card.getName())) {
				index = i;
				break;
			}
		
		if(index != -1)		cards.remove(index);
		
		index = -1;
		for(int i = 0; i < allCards.size(); i ++)
			if(allCards.get(i).getName().equals(card.getName())){
				index = i;
				break;
			}
		
		if(index != -1)		allCards.remove(index);
	}

	public void addCard(Card card) {
		allCards.add(card);
		cards.add(card);
	}

	public ArrayList<Card> getLockedCards() {
		return lockedCards;
	}

	public ArrayList <String> getHeroes() {
		return heroes;
	}

	public void setHeroes(ArrayList <String> heroes) {
		this.heroes = heroes;
	}

	public void addDeck(Deck deck) {
		decks.add(deck);
		LogWriter.write(this, "Add Deck", deck.getName());
	}
	
	public void removeDeck(Deck deck) {
		int index = -1;
		for(int i = 0; i < decks.size(); i ++)
			if(decks.get(i).getName().equals(deck.getName())) {
				index = i;
				break;
			}
		
		if(index != -1) {
			decks.remove(index);
			LogWriter.write(this, "Delete Deck", deck.getName());
		}
	}

	private ArrayList<Card> getAllGameCards() {
		ArrayList<Card> cards = new ArrayList<>();
		
		File file = new File(System.getProperty("user.dir") + "/src/main/resources/Cards");
		String[] files = file.list();
		for(String fileName : files)	cards.add(Card.convert(fileName.substring(0, fileName.length()-5)));
		
		return cards;
	}
}
