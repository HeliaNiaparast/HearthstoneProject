package gameLogic;

import java.util.ArrayList;

import cards.Card;
import cards.Minion;
import game.Player;

public class Game {
	private static Game game;
	GamePlayer[] players;
	ArrayList<Card> history;
	
	private Game() {
		players = new GamePlayer[2];
		players[0] = new GamePlayer(graphics.Game.getInstance().getPlayer());
		players[0].setTurn(true);
		players[1] = new GamePlayer(new Player("username", "password"));
		players[1].setTurn(false);
	}
	
	public static Game getInstance() {
		if(game == null)	game = new Game();
		return game;
	}
	
	public void damageAllCharacters(int damage) {
		for(GamePlayer player : players) {
			player.getHero().getAttacked(damage);
			for(Minion minion : player.getGround()) 
				minion.getAttacked(damage);	
		}
	}

	public void summon(Minion minion) {
		currentPlayer().getGround().add(minion);
	}

	public void replaceHand() {
		players[currentPlayerIndex()].setHand(cloneHand(players[1-currentPlayerIndex()].getHand()));
	}
	
	public GamePlayer currentPlayer() {
		for(GamePlayer player : players)
			if(player.isTurn())
				return player;
		
		return null;
	}
	
	public int currentPlayerIndex() {
		for(int i = 0; i < 2; i ++)
			if(players[i].isTurn())
				return i;	
		
		return 0;
	}

	public ArrayList<Card> cloneHand(ArrayList<Card> hand){
		ArrayList<Card> copy = new ArrayList<>();
		for(Card card : hand) {
			Card copiedCard = Card.convert(card.getName());
			copy.add(copiedCard);
		}
		
		return copy;
	}

	public void draw() {
		ArrayList<Card> cards = currentPlayer().getDeck().getCards();
		if(!cards.isEmpty())	draw(cards.get(0));
	}
	
	public void draw(String condition) {
		switch(condition) {
		case "Rush":
			for(Card card : currentPlayer().getDeck().getCards())
				if(card instanceof Minion && ((Minion)card).isRush())
					draw(card);
			break;
			
		case "Lifesteal":
			for(Card card : currentPlayer().getDeck().getCards())
				if(card instanceof Minion && ((Minion)card).isLifeSteal())
					draw(card);
			break;
		
		case "Deathrattle":
			for(Card card : currentPlayer().getDeck().getCards())
				if(card instanceof Minion && ((Minion)card).isDeathrattle())
					draw(card);
			break;
		}
	}
	
	public void draw(Card card) {
		GamePlayer player = currentPlayer();
		player.getHand().add(card);
		player.getDeck().remove(card);
	}

	public void destroyAllOtherMinions(Minion minion) {
		players[1-currentPlayerIndex()].getGround().clear();
		for(Minion groundMinion : players[currentPlayerIndex()].getGround())
			if(!groundMinion.equals(minion))
				players[currentPlayerIndex()].getGround().remove(groundMinion);
	}

	public void discardHand() {
		players[currentPlayerIndex()].getHand().clear();
	}

	public void damageAllOtherCharacters(int damage, Minion minion) {
		for(GamePlayer player : players) {
			player.getHero().getAttacked(damage);
			for(Minion groundMinion : player.getGround())
				if(!groundMinion.equals(minion))
					groundMinion.getAttacked(damage);
		}
	}

	public void damageAllOtherMinions(int damage, Minion minion) {
		for(GamePlayer player : players) 
			for(Minion groundMinion : player.getGround())
				if(!groundMinion.equals(minion))
					groundMinion.getAttacked(damage);
	}

	public void gainForFriendlyMinions(int attack, int HP) {
		for(Minion minion : players[currentPlayerIndex()].getGround()) {
			minion.addHP(HP);
			minion.addAttack(attack);
		}	
	}

	public boolean gainForFriendlyBeast(int attack, int HP, boolean Taunt, Minion minion) {
		if(minion.getSubType().equals("Beast") && currentPlayer().getGround().contains(minion)) {
			minion.addAttack(attack);
			minion.addHP(HP);
			return true;
		}
		return false;
	}
}
