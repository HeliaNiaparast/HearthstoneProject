package gameLogic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

import cards.Card;
import cards.Minion;
import cards.Spell;
import game.Player;

public class Game {
	private static Game game;
	GamePlayer[] players;
	ArrayList<Card> history;
	ArrayList<Pair> deadMinions;
	ArrayList<Minion> controlledMinions;
	
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
	
	public ArrayList<Minion> getControlledMinions() {
		return controlledMinions;
	}

	public void setControlledMinions(ArrayList<Minion> controlledMinions) {
		this.controlledMinions = controlledMinions;
	}

	public GamePlayer[] getPlayers() {
		return players;
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

	public void damageEnemyHero(int damage) {
		players[1-currentPlayerIndex()].getHero().getAttacked(damage);
	}

	public boolean isEnemy(Minion minion) {
		if(players[1-currentPlayerIndex()].getGround().contains(minion))	return true;
		return false;
	}

	public void destroyMinion(Minion minion) {
		minion.getAttacked(minion.getCurrentHP());
	}

	public Minion getRandomEnemyMinion() {
		Random random = new Random(System.nanoTime());
		int index = random.nextInt(players[1-currentPlayerIndex()].getGround().size());
		return	players[1-currentPlayerIndex()].getGround().get(index);
	}

	public Minion getRandomMinionFromHand() {
		Random random = new Random(System.nanoTime());
		ArrayList<Minion> handMinions = new ArrayList<>();
		for(Card card : currentPlayer().getHand())
			if(card instanceof Minion)
				handMinions.add((Minion)card);
		
		int index = random.nextInt(handMinions.size());
		return handMinions.get(index);
		
	}

	public void resurrectFriendlyMechs(int cnt) {
		ArrayList<Minion> deadMechs = new ArrayList<>();
		for(Pair pair : deadMinions)
			if(pair.getMinion().getSubType().equals("Mech") && pair.getString().equals("Friendly"))
				deadMechs.add(pair.getMinion());
		
		for(int i = 0; i < Math.min(cnt, deadMechs.size()); i++) {
			Minion minion = deadMechs.get(0);
			minion.setCurrentAttack(minion.getAttack());
			minion.setCurrentHP(minion.getHP());
			currentPlayer().getGround().add(minion);
			deadMechs.remove(0);
		}
	}

	public void transform(Minion original, Minion replacement) {
		ArrayList<Minion> ground;
		if(players[currentPlayerIndex()].getGround().contains(original))
			ground = players[currentPlayerIndex()].getGround();
		else	ground = players[1-currentPlayerIndex()].getGround();
		
		ground.set(ground.indexOf(original), replacement);
		
	}

	public void addToControlledMinions(Minion minion) {
		controlledMinions.add(minion);
	}

	public void damageAllMinions(int damage) {
		for(GamePlayer player : players)
			for(Minion minion : player.getGround())
				minion.getAttacked(damage);
	}

	public void drawCardsDiscardSpells(int cnt) {
		for(int i = 0; i < cnt; i++) {
			ArrayList<Card> deck = currentPlayer().getDeck().getCards();
			if(!deck.isEmpty()) {
				if(deck.get(0) instanceof Spell)
					deck.remove(0);
				else	draw(deck.get(0));
			}
		}
	}

/**/	public Minion copyRandomMinionFromHand() {
		ArrayList<Minion> minions = new ArrayList<>();
		for(Card card : currentPlayer().getHand())
			if(card instanceof Minion)
				minions.add((Minion)card);
		
		if(minions.size() == 0)		return null;
		else {
			Random random = new Random();
			int index = random.nextInt(minions.size());
			Minion minion = minions.get(index);
			try {
				Class<?> minionClass = Class.forName(minion.getClass().getName());
					Minion duplicate = (Minion) minionClass.getConstructors()[0].newInstance();
					return duplicate;
			}
			catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | SecurityException | ClassNotFoundException e) {
			}
		}
		
		return null;
	}
}
