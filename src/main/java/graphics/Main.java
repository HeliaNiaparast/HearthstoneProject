package graphics;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import cards.CardDesign;

public class Main {
	
	final static JFrame frame = new JFrame("Hearthstone");
	
	public static void main(String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Constants.width, Constants.height);
		frame.setResizable(false);
		frame.add(Game.getInstance());
		frame.setVisible(true);
	}
}
