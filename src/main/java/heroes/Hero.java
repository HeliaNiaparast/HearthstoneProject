package heroes;

import java.util.*;
import cards.*;

public class Hero {
	private ArrayList <Card> deck;
	private ArrayList <Card> cards;
	private int HP;
	private String heroClass;
	private String heroPower;
	private String specialPower;
	
	public Hero(){}
	
	public void setDeck(ArrayList <Card> deck) {
		this.deck = deck;
	}
	
	public ArrayList <Card> getDeck(){
		return deck;
	}
	
	public void setCards(ArrayList <Card> cards) {
		this.cards = cards;
	}

	public ArrayList <Card> getCards(){
		return cards;
	} 
	
	public void setHP (int HP) {
		this.HP = HP;
	}
	
	public int getHP() {
		return HP;
	}
	
	public void setHeroPower(String heroPower) {
		this.heroPower = heroPower;
	}
	
	public String getHeroPower() {
		return heroPower;
	}
	
	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
	}
	
	public String getHeroClass() {
		return heroClass;
	}
	
	public void setSpecialPower(String specialPower) {
		this.specialPower = specialPower;
	}
	
	public String getSpecialPower() {
		return specialPower;
	}	
}
