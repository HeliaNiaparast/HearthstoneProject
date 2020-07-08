package gameLogic;

import java.util.ArrayList;

import cards.Card;
import cards.Deck;
import cards.Minion;
import game.Player;
import heroes.Hero;

public class GamePlayer {
	private int mana;
	private ArrayList<Card> hand;
	private Deck deck;
	private ArrayList<Minion> ground;
	private Hero hero;
	private Player player;
	private boolean isTurn;
	
	public GamePlayer(Player player) {
		this.player = player;
		mana = 1;
		deck = player.getCurrentDeck();
		ground = new ArrayList<>();
		hero = player.getHero();
		hand = new ArrayList<>();
	}
	
	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public ArrayList<Minion> getGround() {
		return ground;
	}

	public void setGround(ArrayList<Minion> ground) {
		this.ground = ground;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

}
