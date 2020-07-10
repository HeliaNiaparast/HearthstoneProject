package graphics;

import java.awt.CardLayout;

import javax.swing.JPanel;

import game.Player;

public class Game extends JPanel {
	private static Game game;
	private Login login;
	private Login2 login2;
	private CardLayout layout;
	private Player player;
	private Play play;
	
	public Menu menu;	
	public Shop shop;
	public Collection collection;
	public Status status;
	
	private Game() {
		layout = new CardLayout();
		this.setLayout(layout);
		
		login = new Login();
		login2 = new Login2();
		
		this.add(login, "Login");
		this.add(login2, "Login2");
	}

	public static Game getInstance() {
		if(game == null)	
			game = new Game();
		return game;
	}
	
	public void loginCommand(String command) {
		login2.setCommand(command);
	}
	
	public void show(String panelName) {
		layout.show(this, panelName);
	}

	public void setPlay(String passive) {
		play = new Play(player, passive);
		this.add(play, "Play");
		show("Play");
	}
	
	public void setPlayer(Player player) {
		this.player = player;
		
		menu = new Menu(player);
		this.add(menu, "Menu");
		
		shop = new Shop(player);
		this.add(shop, "Shop");
		
		collection = new Collection(player);
		this.add(collection, "Collection");
		
		status = new Status(player);
		this.add(status, "Status");
	}

	public Player getPlayer() {
		return player;
	}
}
