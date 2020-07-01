package heroes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HeroDesign {
	public static void main(String[] args) {
		ArrayList <Hero> heroes = new ArrayList <>();
		heroes.add(new Mage());
		heroes.add(new Rogue());
		heroes.add(new Warlock());
		heroes.add(new Paladin());
		heroes.add(new Hunter());
		
		for(Hero hero : heroes) {
			String directory = System.getProperty("user.dir") + "/src/main/resources/Heroes/";
			directory += hero.getHeroClass() + ".json";
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jHero = gson.toJson(hero);
			try {
				FileWriter writer = new FileWriter(directory);
				writer.write(jHero);
				writer.close();
			} 
			catch (IOException e) {
				System.out.println("An error has occured.");
			}
		} 
	}
}
