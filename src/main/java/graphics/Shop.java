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

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import cards.Card;
import game.LogWriter;
import game.Player;
import main.Main;

public class Shop extends JPanel implements ActionListener {
	private Game game;
	private JPanel cards;
	private JScrollPane scrollPane;
	private Player player;
	private JButton exit;
	private JButton menu;
	private JButton sell;
	private JLabel coinIcon;
	private JLabel coinNumber;
	private JPanel cardPanel;
	
	public Shop(Player player) {
		this.player = player;
		this.setLayout(null);
		this.setBackground(Constants.shopColor);
		
		shopDesign();
		cardsDesign();
		update();
	}
	
	private void cardsDesign() {
		cards = new JPanel(new GridLayout(0, 7, 5, 5));
		cards.setBackground(Constants.shopColor);
		
		Border border = BorderFactory.createEmptyBorder(17, 17, 17, 17);
		cards.setBorder(border);
		
		scrollPane = new JScrollPane(cards);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(Constants.shopCards);
        this.add(scrollPane);
	}
	
	private void shopDesign() {
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
		
		sell = new JButton("My Collections");
		sell.setBounds(Constants.sellButton);
		sell.setBackground(Constants.shopButtonColor);
		sell.setFont(Constants.signInFont);
		sell.setActionCommand("Sell");
		sell.setForeground(Constants.coinsColor);
		sell.addActionListener(this);
		this.add(sell);
		
		coinIcon = new JLabel();
		coinIcon.setBounds(Constants.coinIcon);
		BufferedImage image = null;
		String path = System.getProperty("user.dir") + "/src/main/resources" + "/Images/Coin.png";
		try {
		    image = ImageIO.read(new File(path));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image icon = image.getScaledInstance(45, 100, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(icon);
		coinIcon.setIcon(imageIcon);
		this.add(coinIcon);
		
		coinNumber = new JLabel("");
		coinNumber.setBounds(Constants.coinNumber);
		coinNumber.setForeground(Constants.coinsColor);
		coinNumber.setFont(Constants.coinsFont);
		this.add(coinNumber);
	}
	
	private void loadCards() {
		cards.removeAll();
		ArrayList <Card> shopCards = player.getShop().getCards();
	
		if(shopCards != null)
			for(Card card : shopCards) {
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(130, 178));
				button.setOpaque(false);
				button.setContentAreaFilled(false);
				button.setBorderPainted(false);
				button.addActionListener(this);
				button.setActionCommand(card.getName());
				
				BufferedImage image = null;
				String path = System.getProperty("user.dir") + "/src/main/resources" + "/Card Images/" + card.getName() + ".png";
				try {
				    image = ImageIO.read(new File(path));
				} catch (IOException e) {
				    e.printStackTrace();
				}
				
				Image icon = image.getScaledInstance(130, 178,
				        Image.SCALE_SMOOTH);
				
				ImageIcon imageIcon = new ImageIcon(icon);
				
				button.setIcon(imageIcon);
				
				cards.add(button);
			}
		
		ArrayList <Card> lockedCards = player.getShop().getLockedCards();
		if(lockedCards != null)
			for(Card card : lockedCards) {
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(130, 178));
				button.setOpaque(false);
				button.setContentAreaFilled(false);
				button.setBorderPainted(false);
				button.addActionListener(this);
				button.setActionCommand("Locked");
				
				BufferedImage image = null;
				String path = System.getProperty("user.dir") + "/src/main/resources" + "/Card Images - BlackWhite/" + card.getName() + ".png";
				try {
				    image = ImageIO.read(new File(path));
				} catch (IOException e) {
				    e.printStackTrace();
				}
				
				Image icon = image.getScaledInstance(130, 178,
				        Image.SCALE_SMOOTH);
				
				ImageIcon imageIcon = new ImageIcon(icon);
				
				button.setIcon(imageIcon);
				
				cards.add(button);
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		game = Game.getInstance();
		String command = e.getActionCommand();
		if(command.equals("Menu")) {
			LogWriter.write(player, "Navigate", "Menu");
			game.show("Menu");
		}
		else if (command.equals("Exit")) {
			LogWriter.save(player);
			Main.frame.dispose();
		}
		else if (command.equals("Sell")) {
			LogWriter.write(player, "Navigate", "Collections");
			game.show("Collection");
		}
		else {
			LogWriter.write(player, "See Card", command);
			showCard(command);
		}
	}

	private void showCard(String cardName) {
		Card card = Card.convert(cardName);
		
		cardPanel = new JPanel();
		cardPanel.setLayout(null);
		cardPanel.setBackground(Color.black);
		cardPanel.setBounds(new Rectangle(0, 0, 1000, 600));
		
		JLabel cardImage = new JLabel();
		cardImage.setBounds(Constants.shopCard);
		BufferedImage image = null;
		String path = System.getProperty("user.dir") + "/src/main/resources" + "/Card Images/" + card.getName() + ".png";
		try {
		    image = ImageIO.read(new File(path));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image icon = image.getScaledInstance(cardImage.getWidth(), cardImage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(icon);
		cardImage.setIcon(imageIcon);
		cardPanel.add(cardImage);
		
		JLabel rarity = new JLabel("Rarity: " + card.getRarity());
		rarity.setBounds(Constants.shopRarity);
		rarity.setForeground(Constants.cardInfoColor);
		rarity.setFont(Constants.cardInfoFont);
		cardPanel.add(rarity);
		
		JLabel heroClass = new JLabel("Class: " + card.getHeroClass());
		heroClass.setBounds(Constants.shopHeroClass);
		heroClass.setForeground(Constants.cardInfoColor);
		heroClass.setFont(Constants.cardInfoFont);
		cardPanel.add(heroClass);
		
		JLabel type = new JLabel("Type: " + card.getType());
		type.setBounds(Constants.shopType);
		type.setForeground(Constants.cardInfoColor);
		type.setFont(Constants.cardInfoFont);
		cardPanel.add(type);
		
		JLabel price = new JLabel("Price: " + card.getPrice());
		price.setBounds(Constants.shopPrice);
		price.setForeground(Constants.cardInfoColor);
		price.setFont(Constants.cardInfoFont);
		cardPanel.add(price);
		
		JLabel error = new JLabel("");
		error.setBounds(Constants.buyError);
		error.setForeground(Color.RED);
		error.setFont(Constants.errorFont);
		cardPanel.add(error);
		
		JLabel successLabel = new JLabel("");
		successLabel.setBounds(Constants.buyError);
		successLabel.setForeground(Color.GREEN);
		successLabel.setFont(Constants.cardInfoFont);
		cardPanel.add(successLabel);
		
		JButton buyButton = new JButton("Buy Card");
		buyButton.setBounds(Constants.buyButton);
		buyButton.setBackground(Constants.buyButtonColor);
		buyButton.setFont(Constants.buyButtonFont);
		buyButton.setForeground(Color.BLACK);
		buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!player.canBuy(card)) {
					error.setText("You Don't Have Enough Coins To Buy This Card");
				}
				
				else {
					player.getShop().buy(player, card);
					successLabel.setText(card.getName() + " Was Bought Successfully");
					update();
				}
			}
		});
		cardPanel.add(buyButton);
				
		JButton returnButton = new JButton();
		returnButton.setBounds(Constants.returnButton);
		image = null;
		path = System.getProperty("user.dir") + "/src/main/resources" + "/Images/Back.png";
		try {
		    image = ImageIO.read(new File(path));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		icon = image.getScaledInstance(returnButton.getWidth(), returnButton.getHeight(), Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(icon);
		returnButton.setIcon(imageIcon);
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
		cardPanel.add(returnButton);
		
		Main.frame.setContentPane(cardPanel);
		
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	private void update() {
		loadCards();
		coinNumber.setText(String.valueOf(player.getCoins()));
	}

}
