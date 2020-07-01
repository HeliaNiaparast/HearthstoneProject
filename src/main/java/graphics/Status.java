package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import cards.Deck;
import game.LogWriter;
import game.Player;

public class Status extends JPanel implements ActionListener {

	private Game game;
	private Player player;
	private JPanel decks;
	private JButton exit, menu;
	private JPanel deckPanel;
	
	public Status(Player player) {
		this.player = player;
		
		setLayout(null);
		setBackground(Constants.shopColor);
		
		exit = new JButton("Exit");
		exit.setBounds(Constants.exitButton);
		exit.setBackground(Constants.shopButtonColor);
		exit.setFont(Constants.signInFont);
		exit.setActionCommand("Exit");
		exit.setForeground(Constants.coinsColor);
		exit.addActionListener(this);
		this.add(exit);
		
		menu = new JButton("Menu");
		menu.setBounds(Constants.backButton);
		menu.setBackground(Constants.shopButtonColor);
		menu.setFont(Constants.signInFont);
		menu.setActionCommand("Menu");
		menu.setForeground(Constants.coinsColor);
		menu.addActionListener(this);
		this.add(menu);
		
		decks = new JPanel(new GridLayout(2, 5, 15, 15));
		decks.setBounds(Constants.shopCards);
		decks.setBackground(Constants.shopColor);
		
		Border border = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		decks.setBorder(border);
		
		add(decks);
		
		deckPanel = new JPanel();
		
		update();
		
	}
	
	private ImageIcon getIcon(String path, int width, int height) {
		BufferedImage image = null;
		String dir = System.getProperty("user.dir") + "/src/main/resources" + path + ".png";
		try {
		    image = ImageIO.read(new File(dir));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image icon = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon = new ImageIcon(icon);
		
		return imageIcon;
	}

	private ArrayList<Deck> topTen(){
		ArrayList<Deck> decks = player.getDecks();
		ArrayList<Deck> ans = new ArrayList<>();
		
		Collections.sort(decks);
		
		int cnt = 0;
		for(int i = decks.size()-1; i >= 0 && cnt < 10; i --) {
			ans.add(decks.get(i));
			cnt ++;
		}
	
		return ans;
	}
	
	private void loadDecks() {
		decks.removeAll();
		for(Deck deck : topTen()) {
			
			String path = "/Images/DeckIcon";
			JButton button = new JButton(deck.getName(), getIcon(path, 130, 178));
			button.setPreferredSize(new Dimension(130, 178));
			button.setMaximumSize(new Dimension(130, 178));
			button.setVerticalTextPosition(AbstractButton.TOP);
			button.setHorizontalTextPosition(AbstractButton.CENTER);
			button.setForeground(Color.WHITE);	
			button.addActionListener(this);
			button.setActionCommand(deck.getName());
			button.setOpaque(false);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			
			decks.add(button);
		}
	}
	
	private Deck findDeck(String deckName) {
		for(Deck deck : player.getDecks())
			if(deck.getName().equals(deckName))
				return deck;
		
		return null;
	}
	
	private void showDeck(String deckName) {
		deckPanel.removeAll();
		Deck deck = findDeck(deckName);
		deckPanel.setLayout(null);
		deckPanel.setBackground(Color.black);
		deckPanel.setBounds(new Rectangle(0, 0, 1000, 600));
		
		String path;
		if(deck.mostUsed() != null) {
			path = "/Card Images/" + deck.mostUsed().getName();
			
			JLabel mostUsed = new JLabel("");
			mostUsed.setText("Most Used Card: " + deck.mostUsed().getName());
			mostUsed.setBounds(Constants.mostUsed);
			mostUsed.setForeground(Constants.cardInfoColor);
			mostUsed.setFont(Constants.cardInfoFont);
			deckPanel.add(mostUsed);
		}
		else
			path = "/Images/DeckIcon";
		
		JLabel cardImage = new JLabel();
		cardImage.setBounds(Constants.shopCard);
		cardImage.setIcon(getIcon(path, cardImage.getWidth(), cardImage.getHeight()));
		deckPanel.add(cardImage);

		JLabel name = new JLabel("");
		name.setText("Name: " + deck.getName());
		name.setBounds(Constants.statusName);
		name.setForeground(Constants.cardInfoColor);
		name.setFont(Constants.cardInfoFont);
		deckPanel.add(name);
		
		JLabel winRaio = new JLabel("Wins Ratio: " + deck.winRatio());
		winRaio.setBounds(Constants.statusWinRatio);
		winRaio.setForeground(Constants.cardInfoColor);
		winRaio.setFont(Constants.cardInfoFont);
		deckPanel.add(winRaio);
		
		JLabel wins = new JLabel("Wins: " + deck.getWins());
		wins.setBounds(Constants.statusWins);
		wins.setForeground(Constants.cardInfoColor);
		wins.setFont(Constants.cardInfoFont);
		deckPanel.add(wins);
		
		JLabel Games = new JLabel("Games: " + deck.getGames());
		Games.setBounds(Constants.statusGames);
		Games.setForeground(Constants.cardInfoColor);
		Games.setFont(Constants.cardInfoFont);
		deckPanel.add(Games);
		
		JLabel average = new JLabel("Average ManaCost: " + deck.averageCost());
		average.setBounds(Constants.statusAverage);
		average.setForeground(Constants.cardInfoColor);
		average.setFont(Constants.cardInfoFont);
		deckPanel.add(average);
		
		JLabel hero = new JLabel("Hero: " + deck.getHero());
		hero.setBounds(Constants.statusHero);
		hero.setForeground(Constants.cardInfoColor);
		hero.setFont(Constants.cardInfoFont);
		deckPanel.add(hero);
		
		path = "/Images/Back";
		JButton returnButton = new JButton();
		returnButton.setBounds(Constants.returnButton);
		returnButton.setIcon(getIcon(path, returnButton.getWidth(), returnButton.getHeight()));
		returnButton.setOpaque(false);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorderPainted(false);
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LogWriter.write(player, "Click", "Back Button");
				Main.frame.setContentPane(Game.getInstance());
			}
		});
		deckPanel.add(returnButton);
		
		Main.frame.setContentPane(deckPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		game = Game.getInstance();
		String command = e.getActionCommand();
		
		if(command.equals("Exit")) {
			LogWriter.save(player);
			Main.frame.dispose();
		}
		else if(command.equals("Menu")) {
			LogWriter.write(player, "Navigate", "Menu");
			game.show("Menu");
		}
		else {
			LogWriter.write(player, "See Deck", command);
			showDeck(command);
		}
		
	}
	
	public void update() {
		loadDecks();
		revalidate();
		repaint();
	}
}
