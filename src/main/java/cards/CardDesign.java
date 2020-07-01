package cards;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CardDesign {
	private static ArrayList <Card> cards;
	
	private static void createCards() {
		cards = new ArrayList <>();
		String description;
		
		//Special Hero Cards
		description = "Transform a minion into a 1/1 Sheep.";
		Spell Polymorph = new Spell(4, "Polymorph", "Free", "Mage", "Spell", description, 4);
		cards.add(Polymorph);
		
		description = "Discover a weapon from any class. Add it to your Adventure Deck with +2/+2.";
		Spell FriendlySmith = new Spell (1, "FriendlySmith", "Common", "Rogue", "Spell", description, 2);
		cards.add(FriendlySmith);
		
		description = "At the end of your turn, deal 1 damage to all other minions.";
		Minion Dreadscale = new Minion(3, "Dreadscale", "Legendary", "Warlock", "Minion", description, 2, 4, 11, "");
		cards.add(Dreadscale);
		
		description = "Deal 6 damage.";
		Spell Fireball = new Spell (4, "Fireball", "Free", "Mage", "Spell", description, 4);
		cards.add(Fireball);
		
		description = "Destroy an enemy minion.";
		Spell Assassinate = new Spell(5, "Assassinate", "Free", "Rogue", "Spell", description, 5);
		cards.add(Assassinate);
		
		description = "Battlecry: Deal 1 damage to ALL other characters.";
		Minion DreadInfernal = new Minion(6, "DreadInfernal", "Free", "Warlock", "Minion", description, 6, 6, 6, "");
		cards.add(DreadInfernal);
		
		description = "After your opponent plays a minion, attack it.";
		Minion SwampKingDred = new Minion(7, "SwampKingDred", "Legendary", "Hunter", "Minion", description, 9, 9, 15, "Beast");
		cards.add(SwampKingDred);
		
		description = "Battlecry: Give a friendly Beast +2/+2 and Taunt.";
		Minion Houndmaster = new Minion(4, "Houndmaster", "Free", "Hunter", "Minion", description, 3, 4, 4, "");
		cards.add(Houndmaster);
		
		description = "Give a minion Charge, Windfury, Divine Shield, Lifesteal, Poisonous, Taunt, and Stealth.";
		Spell GnomishArmyKnife = new Spell(5, "GnomishArmyKnife", "Free", "Paladin", "Spell", description, 5);
		cards.add(GnomishArmyKnife);
		
		description = "Resurrect 3 friendly Mechs. They keep any Magnetic upgrades.";
		Spell KangorsEndlessArmy = new Spell(7, "KangorsEndlessArmy", "Legendary", "Paladin", "Spell", description, 15);
		cards.add(KangorsEndlessArmy);
		
		//Regular Cards
		description = "";
		Minion Wisp = new Minion(0, "Wisp", "Common", "Neutral", "Minion", description, 1, 1, 1, "");
		cards.add(Wisp);
		
		description = "Give your hero +2 Attack this turn. Gain 2 Armor.";
		Spell Claw = new Spell(1, "Claw", "Free", "Neutral", "Spell", description, 1);
		cards.add(Claw);
		
		description = "Battlecry: Draw a card.";
		Minion NoviceEngineer = new Minion(2, "NoviceEngineer", "Free", "Neutral", "Minion", description, 1, 1, 2, "");
		cards.add(NoviceEngineer);

		description = "Echo Deal 1 damage to all minions.";
		Spell Warpath = new Spell(2, "Warpath", "Common", "Neutral", "Spell", description, 3);
		cards.add(Warpath);
		
		description = "Lifesteal Rush";
		Minion ViciousScalehide = new Minion(2, "ViciousScalehide", "Common", "Neutral", "Minion", description, 3, 1, 3, ""); 
		cards.add(ViciousScalehide);
		
		description = "At the end of your turn, deal 2 damage to the enemy hero.";
		Minion SerpentWard = new Minion(2, "SerpentWard", "Rare", "Neutral", "Minion", description, 2, 0, 4, ""); 
		cards.add(SerpentWard);
		
		description = "Destroy a random enemy minion.";
		Spell DeadlyShot = new Spell(3, "DeadlyShot", "Common", "Neutral", "Spell", description, 4);
		cards.add(DeadlyShot);
		
		description = "Gain control of an enemy minion with 3 or less Attack until end of turn.";
		Spell ShadowMadness = new Spell(4, "ShadowMadness", "Rare", "Neutral", "Spell", description, 6);
		cards.add(ShadowMadness);
		
		description = "Battlecry: Gain +1/+1 for each other friendly minion on the battlefield.";
		Minion FrostwolfWarlord = new Minion(5, "FrostwolfWarlord", "Free", "Neutral", "Minion", description, 4, 4, 5, ""); 
		cards.add(FrostwolfWarlord);
		
		description = "Taunt. Deathrattle: Deal 2 damage to ALL characters.";
		Minion Abomination = new Minion(5, "Abomination", "Rare", "Neutral", "Minion", description, 4, 4, 7, ""); 
		cards.add(Abomination);
		
		description = "Overkill: Summon another Arena Patron.";
		Minion ArenaPatron = new Minion(5, "ArenaPatron", "Rare", "Neutral", "Minion", description, 3, 3, 7, ""); 
		cards.add(ArenaPatron);
		
		description = "Summon a copy of a random minion from your hand.";
		Spell Eureka = new Spell(6, "Eureka", "Rare", "Neutral", "Spell", description, 8);
		cards.add(Eureka);
		
		description = "Battlecry: Replace your hand with a copy of your opponent's.";
		Minion AzalinaSoulthief = new Minion(7, "AzalinaSoulthief", "Legendary", "Neutral", "Minion", description, 3, 3, 15, ""); 
		cards.add(AzalinaSoulthief);
		
		description = "Battlecry: Draw a Rush, Lifesteal, and Deathrattle card from your deck.";
		Minion CountessAshmore = new Minion(7, "CountessAshmore", "Legendary", "Neutral", "Minion", description, 6, 6, 15, ""); 
		cards.add(CountessAshmore);
		
		description = "Overkill: Double this minion's Attack.";
		Minion Linecracker = new Minion(7, "Linecracker", "Epic", "Neutral", "Minion", description, 10, 5, 11, ""); 
		cards.add(Linecracker);
		
		description = "Rush. After this attacks and kills a minion, it may attack again.";
		Minion Batterhead = new Minion(8, "Batterhead", "Epic", "Neutral", "Minion", description, 12, 3, 12, ""); 
		cards.add(Batterhead);
		
		description = "Divine Shield";
		Minion BullDozer = new Minion(9, "BullDozer", "Common", "Neutral", "Minion", description, 7, 9, 10, ""); 
		cards.add(BullDozer);
		
		description = "Battlecry: Destroy all other minions and discard your hand.";
		Minion Deathwing = new Minion(10, "Deathwing", "Legendary", "Neutral", "Minion", description, 12, 12, 18, ""); 
		cards.add(Deathwing);
		
		description = "Divine Shield Reborn";
		Minion ColossusOfTheMoon = new Minion(10, "ColossusOfTheMoon", "Legendary", "Neutral", "Minion", description, 10, 10, 18, ""); 
		cards.add(ColossusOfTheMoon);
		
		description = "Draw 4 cards.";
		Spell Sprint = new Spell(7, "Sprint", "Free", "Neutral", "Spell", description, 7);
		cards.add(Sprint);
		
		description = "Summon seven 1/1 Locusts with Rush.";
		Spell SwarmOfLocusts = new Spell(6, "SwarmOfLocusts", "Rare", "Neutral", "Spell", description, 8);
		cards.add(SwarmOfLocusts);
		
		description = "Give a minion +4/+4, Divine Shield, and Taunt.";
		Spell PharaohsBlessing = new Spell(6, "PharaohsBlessing", "Rare", "Neutral", "Spell", description, 8);
		cards.add(PharaohsBlessing);
		
		description = "Draw 3 cards. Discard any spells drawn.";
		Spell BookOfSpecters = new Spell(2, "BookOfSpecters", "Epic", "Neutral", "Spell", description, 6);
		cards.add(BookOfSpecters);
		
		description = "Battlecry: Choose a friendly minion. Add a copy of it to your hand, deck, and battlefield.";
		Minion Sathrovarr = new Minion(9, "Sathrovarr", "Legendary", "Neutral", "Minion", description, 5, 5, 17, "Demon"); 
		cards.add(Sathrovarr);
		
		description = "Taunt Battlecry: Summon a copy of this minion.";
		Minion TombWarden = new Minion(8, "TombWarden", "Rare", "Neutral", "Minion", description, 6, 3, 10, "Mech"); 
		cards.add(TombWarden);
		
		description = "Whenever this minion takes damage, summon a 2/3 Mech with Taunt.";
		Minion SecurityRover = new Minion(6, "SecurityRover", "Rare", "Neutral", "Minion", description, 6, 2, 8, "Mech"); 
		cards.add(SecurityRover);
		
		description = "Whenever you draw a card, gain +1/+1.";
		Minion CurioCollector = new Minion(5, "CurioCollector", "Rare", "Neutral", "Minion", description, 4, 4, 7, ""); 
		cards.add(CurioCollector);		
		
		description = "Sidequest: Spend 10 Mana on minions. Reward: Summon a minion from your deck.";
		QuestAndReward StrengthInNumbers = new QuestAndReward(1, "StrengthInNumbers", "Common", "Neutral", "QuestAndReward", description, 2);
		cards.add(StrengthInNumbers);
		
		description = "Sidequest: Spend 8 Mana on spells. Reward: Summon a 6/6 Dragon.";
		QuestAndReward LearnDraconic = new QuestAndReward(1, "LearnDraconic", "Common", "Neutral", "QuestAndReward", description, 2);
		cards.add(LearnDraconic);
		
		description = "";
		Weapon BattleAxe = new Weapon(1, "BattleAxe", "Common", "Neutral", "Weapon", description, 2, 2, 2);
		cards.add(BattleAxe);
		
		description = "Your hero is Immune while attacking.";
		Weapon MirageBlade = new Weapon(2, "MirageBlade", "Common", "Neutral", "Weapon", description, 3, 2, 3);
		cards.add(MirageBlade);
		
		description = "";
		Weapon Ashbringer = new Weapon(5, "Ashbringer", "Common", "Neutral", "Weapon", description, 5, 3, 6);
		cards.add(Ashbringer);
	}
	
	public static ArrayList<Card> getCards(){
		createCards();
		return cards;
	}
	
	public static void main(String[] args) throws IOException {
		
		ArrayList <Card> cards = getCards();
		
		//Creating Cards
		for(Card card : cards) {
			String directory = System.getProperty("user.dir") + "src/main/resources/Cards/";
			directory += card.getName() + ".json";
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jCard = gson.toJson(card);
			try {
				FileWriter writer = new FileWriter(directory);
				writer.write(jCard);
				writer.close();
			} 
			catch (IOException e) {
				System.out.println("An error has occured.");
			}
		}
		
		for(Card card : cards) {
			String path = System.getProperty("user.dir") + "/src/main/resources/Card Images/";
			File file = new File(path + card.getName() + ".png");
	        BufferedImage originalImage = ImageIO.read(file);

	        BufferedImage grayImage = new BufferedImage(
	            originalImage.getWidth(), originalImage.getHeight(),
	            BufferedImage.TYPE_BYTE_GRAY);
	        
	        Graphics2D graphics = grayImage.createGraphics();
	        graphics.drawImage(originalImage, 0, 0, null);

	        path = System.getProperty("user.dir") + "/src/main/resources/Card Images - BlackWhite/";
	        ImageIO.write(grayImage, "png", new File(path + card.getName() + ".png")); 
		}
	}
}
