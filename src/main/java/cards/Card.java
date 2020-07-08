package cards;

import java.io.*;
import java.util.*;
import com.google.gson.*;

public class Card implements Comparable<Card> {
	private int manaCost;
	private String name;
	private String rarity;
	private String heroClass;
	private String type;
	private String description;
	private int price;
	private int useNum;

	public static Card convert (String cardName) {
		String path = System.getProperty("user.dir") + "/src/main/resources" +"/Cards/" + cardName + ".json";
		File cardFile = new File(path);
		String jCard = "";
		Card card = new Card();
		try {
			Scanner cardScanner = new Scanner(cardFile);
			while(cardScanner.hasNext())
				jCard += cardScanner.nextLine();
			cardScanner.close();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			card = gson.fromJson(jCard, Card.class);
			if(card.type.equals("Minion")) {
				Minion minion = gson.fromJson(jCard, Minion.class);
				return minion;
			}
			else if(card.type.equals("Spell")) {
				Spell spell = gson.fromJson(jCard, Spell.class);
				return spell;
			}
			else if(card.type.equals("Weapon")) {
				Weapon weapon = gson.fromJson(jCard, Weapon.class);
				return weapon;
			}
		} catch (IOException e) {
			System.out.println("An error has occured!");
			e.printStackTrace();
		}
		return card;
	}
	
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	
 	public int getManaCost() {
		return manaCost;
	}
	
 	public void setName(String name) {
 		this.name = name;
 	}
 	
	public String getName() {
		return name;
	}
	
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	
	public String getRarity() {
		return rarity;
	}
	
	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
	}
	
	public String getHeroClass() {
		return heroClass;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getUseNum() {
		return useNum;
	}

	public void setUseNum(int useNum) {
		this.useNum = useNum;
	}
	
	public Card (){}

	@Override
	public int compareTo(Card card) {
		String[] rarity = new String[] {"Free", "Common", "Rare", "Epic", "Legendary"};
		int[] index = new int[2];
		
		for(int i = 0; i < 5; i++) {
			if(this.rarity.equals(rarity[i]))	index[0] = i;
			if(card.rarity.equals(rarity[i]))	index[1] = i;
		}
		
		if(index[0] > index[1])		return 1;
		if(index[0] < index[1])		return -1;
		if(this.manaCost > card.manaCost)	return 1;
		if(this.manaCost < card.manaCost)	return -1;
		if(this.type.equals("Minion") && !card.type.equals("Minion"))	return 1;
		if(!this.type.equals("Minion") && card.type.equals("Minion"))	return -1;
		
		return 1;
	}

}
