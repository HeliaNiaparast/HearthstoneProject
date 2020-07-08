package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import graphics.Constants;
import graphics.Game;

public class Main {
	
	public final static JFrame frame = new JFrame("Hearthstone");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(Constants.width, Constants.height);
				frame.setResizable(false);
				frame.add(Game.getInstance());
				frame.setVisible(true);
		});
	}
}
