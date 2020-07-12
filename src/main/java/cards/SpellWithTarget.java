package cards;

public abstract class SpellWithTarget extends Spell {
	
	public abstract boolean isTargetValid(Minion Target) ;
	
	public abstract void perform(Minion Target) ;
}
