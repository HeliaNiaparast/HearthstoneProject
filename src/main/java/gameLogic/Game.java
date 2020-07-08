package gameLogic;

import java.util.ArrayList;

import cards.Card;
import cards.Minion;
import game.Player;

public class Game {
	private static Game game;
	GamePlayer firstPlayer;
	GamePlayer secondPlayer;
	ArrayList<Card> history;
	
	public static Game getInstance() {
		if(game == null)	game = new Game();
		return game;
	}
	
	public void damageAllCharacters(int damage) {
		firstPlayer.getHero().getAttacked(damage);
		secondPlayer.getHero().getAttacked(damage);
		for(Minion minion : firstPlayer.getGround()) 
			minion.getAttacked(damage);
		for(Minion minion : secondPlayer.getGround()) 
			minion.getAttacked(damage);	
	}
}
