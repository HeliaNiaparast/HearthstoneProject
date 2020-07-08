package graphics;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import game.LogWriter;
import game.Player;
import main.Main;

public class Menu extends JPanel implements ActionListener {
	
	private Game game;
	private JButton playButton;
	private JButton shopButton;
	private JButton statusButton;
	private JButton collectionsButton;
	private JButton exitButton;
	private JButton backButton;
	private Player player;
	private JPanel nullDeck;
	private JPanel passive;
	
	public Menu() {}
	
	public Menu(Player player) {
		this.setLayout(null);
		
		this.player = player;
		
		playButton = new JButton("Play");
		playButton.setBounds(Constants.playButton);
		playButton.setBackground(Constants.playColor);
		playButton.setFont(Constants.playFont);
		playButton.setForeground(Constants.menuTextColor);
		playButton.setActionCommand("Play");
		playButton.addActionListener(this);
		this.add(playButton);
		
		shopButton = new JButton("Shop");
		shopButton.setBounds(Constants.shopButton);
		shopButton.setBackground(Constants.playColor);
		shopButton.setFont(Constants.playFont);
		shopButton.setForeground(Constants.menuTextColor);
		shopButton.addActionListener(this);
		shopButton.setActionCommand("Shop");
		this.add(shopButton);
		
		statusButton = new JButton("Status");
		statusButton.setBounds(Constants.statusButton);
		statusButton.setBackground(Constants.playColor);
		statusButton.setFont(Constants.playFont);
		statusButton.setForeground(Constants.menuTextColor);
		statusButton.addActionListener(this);
		statusButton.setActionCommand("Status");
		this.add(statusButton);
		
		collectionsButton = new JButton("Collection");
		collectionsButton.setBounds(Constants.collectionsButton);
		collectionsButton.setBackground(Constants.playColor);
		collectionsButton.setFont(Constants.playFont);
		collectionsButton.setForeground(Constants.menuTextColor);
		collectionsButton.setActionCommand("Collection");
		collectionsButton.addActionListener(this);
		this.add(collectionsButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(Constants.exitButton);
		exitButton.setBackground(Constants.playColor);
		exitButton.setFont(Constants.signInFont);
		exitButton.setForeground(Constants.menuTextColor);
		exitButton.setActionCommand("Exit");
		exitButton.addActionListener(this);
		this.add(exitButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(Constants.backButton);
		backButton.setBackground(Constants.playColor);
		backButton.setFont(Constants.signInFont);
		backButton.setForeground(Constants.menuTextColor);
		backButton.setActionCommand("Back");
		backButton.addActionListener(this);
		this.add(backButton);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		BufferedImage bgImage = null;
		String path = System.getProperty("user.dir") + "/src/main/resources" + "/Images/Menu.jfif";
		try {
			bgImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(bgImage, 0, 0, null);
	}

	private void nullDeck() {
		nullDeck = new JPanel(null);
		nullDeck.setBackground(Constants.newDeckColor);
		nullDeck.setBounds(new Rectangle(0, 0, 1000, 600));
		
		JPanel panel = new JPanel(null);
		panel.setBounds(Constants.nullDeckPanel);
		panel.setBackground(Constants.collectionsExitColor);
		Border border = BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createLoweredBevelBorder());
		panel.setBorder(border);
		
		JLabel label = new JLabel("You Have To Choose A Deck First");
		label.setBounds(Constants.nullDeckLabel);
		label.setForeground(Color.BLACK);
		label.setFont(Constants.cardInfoFont);
		panel.add(label);
		
		JButton collection = new JButton("Collections");
		collection.setBounds(Constants.nullDeckButton);
		collection.setBackground(Constants.newDeckColor);
		collection.setForeground(Color.BLACK);
		collection.setFont(Constants.errorFont);
		collection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.show("Collection");
				Main.frame.setContentPane(game);
			}
		});
		panel.add(collection);
		
		JButton exit = new JButton("Exit");
		exit.setBounds(Constants.exitButton);
		exit.setBackground(Constants.collectionsExitColor);
		exit.setForeground(Color.BLACK);
		exit.addActionListener(this);
		exit.setActionCommand("Exit");
		nullDeck.add(exit);
		
		JButton menu = new JButton("Menu");
		menu.setBounds(Constants.backButton);
		menu.setBackground(Constants.collectionsExitColor);
		menu.setForeground(Color.BLACK);
		menu.addActionListener(this);
		menu.setActionCommand("Menu");
		nullDeck.add(menu);
		
		nullDeck.add(panel);
		
		Main.frame.setContentPane(nullDeck);
	}
	
	private void choosePassive() {
		ArrayList<String> passives = new ArrayList<>();
		passives.add("TwiceDraw");
		passives.add("OffCards");
		passives.add("FreePower");
		passives.add("ManaJump");
		passives.add("Zombie");
		
		Random random = new Random();
		
		String[] randomPassives = new String[3];
		for(int i = 0; i < 3; i ++) {
			int index = random.nextInt(passives.size());
			randomPassives[i] = passives.get(index);
			passives.remove(index);
		}
		
		passive = new JPanel(null);
		passive.setBackground(Color.BLACK);
		passive.setBounds(new Rectangle(0, 0, 1000, 600));
		
		JPanel panel = new JPanel(null);
		panel.setBounds(Constants.nullDeckPanel);
		panel.setBackground(Constants.collectionsExitColor);
		Border border = BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createLoweredBevelBorder());
		panel.setBorder(border);
		
		JButton[] buttons = new JButton[3];
		for(int i = 0; i < 3; i ++) {
			buttons[i] = new JButton(randomPassives[i]);
			buttons[i].setBounds(new Rectangle(i*135 + 42 ,200, 130, 45));
			buttons[i].setForeground(Color.BLACK);
			buttons[i].setBackground(Constants.newDeckColor);
			buttons[i].setActionCommand(randomPassives[i]);
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}
		
		JLabel label = new JLabel("Choose A Passive");
		label.setBounds(Constants.choosePassive);
		label.setForeground(Color.BLACK);
		label.setFont(Constants.cardInfoFont);
		panel.add(label);
		
		JButton exit = new JButton("Exit");
		exit.setBounds(Constants.exitButton);
		exit.setBackground(Constants.collectionsExitColor);
		exit.setForeground(Color.BLACK);
		exit.addActionListener(this);
		exit.setActionCommand("Exit");
		passive.add(exit);
		
		JButton menu = new JButton("Menu");
		menu.setBounds(Constants.backButton);
		menu.setBackground(Constants.collectionsExitColor);
		menu.setForeground(Color.BLACK);
		menu.addActionListener(this);
		menu.setActionCommand("Menu");
		passive.add(menu);
		
		passive.add(panel);
		
		Main.frame.setContentPane(passive);
		
	}
	
	private void play() {
		if(player.getCurrentDeck() == null || player.getCurrentDeck().getCards().size() == 0) 
			nullDeck();
		else 
			choosePassive();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		game = Game.getInstance();
		String command = e.getActionCommand();
		switch (command) {
		case "Back" :
			LogWriter.write(player, "Click", "Back Button");
			game.show("Login2");
			break;
		case "Exit" :
			LogWriter.save(player);
			Main.frame.dispose();
			break;
		case "Shop" :
			LogWriter.write(player, "Navigate", "Shop");
			game.show("Shop");
			break;
		case "Collection" :
			LogWriter.write(player, "Navigate", "Collections");
			game.show("Collection");
			break;
		case "Status" :
			LogWriter.write(player, "Navigate", "Status");
			game.status.update();
			game.show("Status");
			break;
		case "Play" :
			LogWriter.write(player, "Click", "Play Button");
			play();
			break;
		case "Menu" :
			LogWriter.write(player, "Navigate", "Menu");
			Main.frame.setContentPane(game);
			break;
		default :
			LogWriter.write(player, "Choose Passive", command);
			game.setPlay(command);
			Main.frame.setContentPane(game);
		}
	}
}
