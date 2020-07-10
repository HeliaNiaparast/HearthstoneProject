package cards;

public abstract class Minion extends Card {
	private int HP;
	private int attack;
	private String subType;
	private boolean taunt = false;
	private boolean rush = false;
	private boolean charge = false;
	private boolean divineshield = false;
	private boolean reborn = false;
	private boolean windfury = false;
	private boolean poisonous = false;
	private boolean lifeSteal = false;
	private boolean stealth = false;
	private boolean deathrattle = false;
	private int attackCnt;
	private int currentHP;
	private int currentAttack;
	private boolean isAlive = true;
	
	public Minion (){}
	public Minion (int manaCost, String name, String rarity, String heroClass, String type, String description, 
			int HP, int attack, int price, String subType){
		setManaCost(manaCost);
		setName(name);
		setRarity(rarity);
		setHeroClass(heroClass);
		setType(type);
		setDescription(description);
		setPrice(price);
		setHP(HP);
		setAttack(attack);
		setSubType(subType);
		setCurrentAttack(attack);
		setCurrentHP(HP);
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}
	
	public int getHP() {
		return HP;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public boolean isTaunt() {
		return taunt;
	}

	public void setTaunt(boolean taunt) {
		this.taunt = taunt;
	}

	public boolean isRush() {
		return rush;
	}

	public void setRush(boolean rush) {
		this.rush = rush;
	}

	public boolean isCharge() {
		return charge;
	}

	public void setCharge(boolean charge) {
		this.charge = charge;
	}

	public boolean isDivineshield() {
		return divineshield;
	}

	public void setDivineshield(boolean divineshield) {
		this.divineshield = divineshield;
	}

	public boolean isReborn() {
		return reborn;
	}

	public void setReborn(boolean reborn) {
		this.reborn = reborn;
	}

	public boolean isWindfury() {
		return windfury;
	}

	public void setWindfury(boolean windfury) {
		this.windfury = windfury;
	}

	public boolean isPoisonous() {
		return poisonous;
	}

	public void setPoisonous(boolean poisonous) {
		this.poisonous = poisonous;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getCurrentAttack() {
		return currentAttack;
	}

	public void setCurrentAttack(int currentAttack) {
		this.currentAttack = currentAttack;
	}

	public boolean isLifeSteal() {
		return lifeSteal;
	}

	public void setLifeSteal(boolean lifeSteal) {
		this.lifeSteal = lifeSteal;
	}

	public boolean isStealth() {
		return stealth;
	}

	public void setStealth(boolean stealth) {
		this.stealth = stealth;
	}
	
	public int getAttackCnt() {
		return attackCnt;
	}
	
	public void setAttackCnt(int attackCnt) {
		this.attackCnt = attackCnt;
	}
	
	public void addAttack(int attack) {
		currentAttack += attack;
	}
	
	public void reduceAttack(int attack) {
		currentAttack -= attack;
	}
	
	public void addHP(int HP) {
		currentHP += HP;
	}
	
	public void reduceHP(int HP) {
		currentAttack -= HP;
	}
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public boolean isDeathrattle() {
		return deathrattle;
	}
	
	public void setDeathrattle(boolean deathrattle) {
		this.deathrattle = deathrattle;
	}
	
	public abstract void doDeathrattle();

	public abstract void doOverkill();

	public abstract void doBattlecry();
	
	public abstract void doEndOfTurnAction();

	public void attackMinion(Minion minion){
		this.getAttacked(minion.getAttack());
		minion.getAttacked(attack);
		attackCnt ++;
	}
	
	public void getAttacked(int attack) {
		if(divineshield)	divineshield = false;
		else {
			currentHP -= attack;
			if(currentHP <= 0) {
				doDeathrattle();
				if(reborn)	setCurrentHP(1);
				else	isAlive = false;
			}
		}
	}
}