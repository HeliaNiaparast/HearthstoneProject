package extendedCards;

import cards.Minion;
import cards.SpellWithTarget;

public class PharaohsBlessing extends SpellWithTarget {
	
	public PharaohsBlessing() {
		
		setManaCost(6);
		setName("PharaohsBlessing");
		setRarity("Rare");
		setHeroClass("Neutral");
		setType("Spell");
		setDescription("Give a minion +4/+4, Divine Shield, and Taunt.");
		setPrice(8);
		setEcho(false);
		setDiscover(false);
	}
	
	public boolean isTargetValid(Minion Target) {
		return true;
	}

	public void perform(Minion Target) {
		Target.addAttack(4);
		Target.addHP(4);
		Target.setTaunt(true);
		Target.setDivineshield(true);
	}

}
