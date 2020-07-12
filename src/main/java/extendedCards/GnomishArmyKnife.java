package extendedCards;

import cards.Minion;
import cards.SpellWithTarget;

public class GnomishArmyKnife extends SpellWithTarget {
	
	public GnomishArmyKnife() {
		setManaCost(5);
		setName("GnomishArmyKnife");
		setRarity("Free");
		setHeroClass("Paladin");
		setType("Spell");
		setDescription("Give a minion Charge, Windfury, Divine Shield, Lifesteal, Poisonous, Taunt, and Stealth.");
		setPrice(5);
		setEcho(false);
		setDiscover(false);
	}
	
	public boolean isTargetValid(Minion Target) {
		return true;
	}

	public void perform(Minion Target) {
		Target.setCharge(true);
		Target.setWindfury(true);
		Target.setDivineshield(true);
		Target.setLifeSteal(true);
		Target.setPoisonous(true);
		Target.setTaunt(true);
		Target.setStealth(true);
	}

}
