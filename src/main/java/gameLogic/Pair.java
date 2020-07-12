package gameLogic;

import cards.Minion;

public class Pair {
	private Minion minion;
	private String string;
	
	public Pair(Minion minion, String string) {
		this.minion = minion;
		this.string = string;
	}

	public Minion getMinion() {
		return minion;
	}

	public String getString() {
		return string;
	}
		
}
