package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import cards.Card;
import cards.Deck;
import game.LogWriter;
import game.Player;

public class Collection extends JPanel implements ActionListener {

	private JScrollPane deckScroll;
	private JPanel decks;
	private Player player;
	private JTextField manaFilter;
	private JTextField searchField;
	private JLabel manaLabel;
	private JButton allCards;
	private JButton ownedCards;
	private JButton notOwnedCards;
	private JButton menu;
	private JButton exit;
	private Game game;
	private JPanel screen;
	private JScrollPane screenScroll;
	private JPanel cardPanel;
	private JLabel coinIcon;
	private JLabel coinNumber;
	private JButton buy, addToDeck, sell;
	private JLabel errorLabel, successLabel;
	private JButton remove;
	private JButton choose, delete;
	private JPanel deleteMessege;
	private JPanel addToDeckPanel, addToDeckParent;
	private JPanel newDeckPanel, newDeckParent;

	public Collection (Player player) {
		this.player = player;		
		setLayout(null);
		
		decks = new JPanel();
		decks.setLayout(new BoxLayout(decks, BoxLayout.Y_AXIS));
		decks.setBackground(Constants.shopColor);
		loadDeckButtons();
		deckScroll = new JScrollPane(decks, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		deckScroll.setBounds(Constants.deckSroll);
		deckScroll.getVerticalScrollBar().setBackground(Constants.shopColor);
		
		add(deckScroll);
		
		JButton newDeck = new JButton("New Deck");
		newDeck.setBounds(Constants.newDeck);
		newDeck.setFont(Constants.newDeckFont);
		newDeck.setForeground(Color.BLACK);
		newDeck.setBackground(Constants.newDeckColor);
		newDeck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newDeck();
				
			}
		});
		add(newDeck);
		
		JLabel myDecks = new JLabel("My Decks");
		myDecks.setBounds(Constants.myDeck);
		myDecks.setFont(Constants.errorFont);
		myDecks.setForeground(Constants.newDeckColor);
		add(myDecks);
		
		manaLabel = new JLabel();
		manaLabel.setBounds(Constants.manaLabel);
		String path = "/Images/ManaLabel";
		manaLabel.setIcon(getIcon(path, 45, 45));
		add(manaLabel);
		
		manaFilter = new JTextField();
		manaFilter.setBounds(Constants.manaFilter);
		manaFilter.setBackground(Constants.manaFilterColor);
		manaFilter.setForeground(Color.BLACK);
		manaFilter.setFont(Constants.newDeckFont);
		manaFilter.setText("");
		add(manaFilter);
		
		searchField = new JTextField();
		searchField.setBounds(Constants.searchField);
		searchField.setBackground(Constants.manaFilterColor);
		searchField.setForeground(Color.BLACK);
		searchField.setFont(Constants.newDeckFont);
		searchField.setText("");
		add(searchField);
		
		allCards = new JButton("All Cards");
		allCards.setBounds(Constants.allCards);
		allCards.setBackground(Constants.newDeckColor);
		allCards.setForeground(Color.BLACK);
		allCards.setFont(Constants.newDeckFont);
		allCards.setActionCommand("All");
		allCards.addActionListener(this);
		add(allCards);
		
		ownedCards = new JButton();
		ownedCards.setBounds(Constants.ownedCards);
		ownedCards.setOpaque(false);
		ownedCards.setContentAreaFilled(false);
		ownedCards.setBorderPainted(false);
		path = "/Images/CardIcon";
		ownedCards.setIcon(getIcon(path, 50, 50));
		ownedCards.setActionCommand("Owned");
		ownedCards.addActionListener(this);
		add(ownedCards);
		
		notOwnedCards = new JButton();
		notOwnedCards.setBounds(Constants.notOwnedCards);
		notOwnedCards.setOpaque(false);
		notOwnedCards.setContentAreaFilled(false);
		notOwnedCards.setBorderPainted(false);
		path = "/Images/CardIconBW";
		notOwnedCards.setIcon(getIcon(path, 50, 50));
		notOwnedCards.setActionCommand("NotOwned");
		notOwnedCards.addActionListener(this);
		add(notOwnedCards);
		
		menu = new JButton("Menu");
		menu.setBounds(Constants.collectionsMenu);
		menu.setBackground(Constants.collectionsExitColor);
		menu.setForeground(Color.BLACK);
		menu.setFont(Constants.newDeckFont);
		menu.setActionCommand("Menu");
		menu.addActionListener(this);
		add(menu);
		
		exit = new JButton("Exit");
		exit.setBounds(Constants.collectionsExit);
		exit.setBackground(Constants.collectionsExitColor);
		exit.setForeground(Color.BLACK);
		exit.setFont(Constants.newDeckFont);
		exit.setActionCommand("Exit");
		exit.addActionListener(this);
		add(exit);
		
		coinIcon = new JLabel();
		coinIcon.setBounds(Constants.collectionsCoin);
		BufferedImage image = null;
		path = System.getProperty("user.dir") + "/src/main/resources" + "/Images/Coin.png";
		try {
		    image = ImageIO.read(new File(path));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image icon = image.getScaledInstance(45, 100, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(icon);
		coinIcon.setIcon(imageIcon);
		add(coinIcon);
		
		coinNumber = new JLabel(String.valueOf(player.getCoins()));
		coinNumber.setBounds(Constants.collectionsCoinNumber);
		coinNumber.setForeground(Constants.coinsColor);
		coinNumber.setFont(Constants.coinsFont);
		add(coinNumber);
		
		screen = new JPanel(new GridLayout(0, 5, 5, 5));
		screen.setBackground(Constants.newDeckColor);
		screenScroll = new JScrollPane(screen, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		screenScroll.setBounds(Constants.Screen);
		Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		screen.setBorder(border);
		add(screenScroll);
		
		JButton mage = new JButton("Mage");
		mage.setBounds(Constants.Mage);
		mage.setBackground(Constants.collectionsExitColor);
		mage.setForeground(Color.BLACK);
		mage.setFont(Constants.errorFont);
		mage.setActionCommand("Mage");
		mage.addActionListener(this);
		add(mage);
		
		JButton rogue = new JButton("Rogue");
		rogue.setBounds(Constants.Rogue);
		rogue.setBackground(Constants.collectionsExitColor);
		rogue.setForeground(Color.BLACK);
		rogue.setFont(Constants.errorFont);
		rogue.setActionCommand("Rogue");
		rogue.addActionListener(this);
		add(rogue);
		
		JButton warlock = new JButton("Warlock");
		warlock.setBounds(Constants.Warlock);
		warlock.setBackground(Constants.collectionsExitColor);
		warlock.setForeground(Color.BLACK);
		warlock.setFont(Constants.errorFont);
		warlock.setActionCommand("Warlock");
		warlock.addActionListener(this);
		add(warlock);
		
		JButton Paladin = new JButton("Paladin");
		Paladin.setBounds(Constants.Paladin);
		Paladin.setBackground(Constants.collectionsExitColor);
		Paladin.setForeground(Color.BLACK);
		Paladin.setFont(Constants.errorFont);
		Paladin.setActionCommand("Paladin");
		Paladin.addActionListener(this);
		add(Paladin);
		
		JButton Hunter = new JButton("Hunter");
		Hunter.setBounds(Constants.Hunter);
		Hunter.setBackground(Constants.collectionsExitColor);
		Hunter.setForeground(Color.BLACK);
		Hunter.setFont(Constants.errorFont);
		Hunter.setActionCommand("Hunter");
		Hunter.addActionListener(this);
		add(Hunter);
		
		JButton neutral = new JButton("Neutral");
		neutral.setBounds(Constants.neutral);
		neutral.setBackground(Constants.collectionsExitColor);
		neutral.setForeground(Color.BLACK);
		neutral.setFont(Constants.errorFont);
		neutral.setActionCommand("Neutral");
		neutral.addActionListener(this);
		add(neutral);
		
		successLabel = new JLabel("");
		successLabel.setBounds(Constants.collectionsError);
		successLabel.setFont(Constants.errorFont);
		successLabel.setForeground(new Color(26, 132, 57));
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(Constants.collectionsError);
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(Constants.errorFont);
		
		choose = new JButton("Choose Deck");
		choose.setBounds(Constants.choose);
		choose.setBackground(Constants.collectionsExitColor);
		choose.setForeground(Color.BLACK);
		choose.setFont(Constants.errorFont);
		choose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String deckName = choose.getActionCommand();
				for(Deck deck : player.getDecks())
					if(deck.getName().equals(deckName)) {
						player.setCurrentDeck(deck);
						LogWriter.write(player, "Choose Deck", deck.getName());
					}
			}
		});
		
		delete = new JButton("Delete Deck");
		delete.setBounds(Constants.delete);
		delete.setBackground(Constants.collectionsExitColor);
		delete.setForeground(Color.BLACK);
		delete.setFont(Constants.errorFont);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showDeleteMessage(delete.getActionCommand());
			}
		});
	
		loadScreen("All");
		
	}

	private void showDeleteMessage(String name) {
		deleteMessege = new JPanel();
		deleteMessege.setLayout(null);
		deleteMessege.setBackground(Constants.collectionsExitColor);
		deleteMessege.setBounds(Constants.deleteMessage);
		
		JLabel message = new JLabel("Are You Sure You Want To Delete This Deck?");
		message.setBounds(Constants.message);
		message.setForeground(Color.BLACK);
		deleteMessege.add(message);
		
		JButton yes = new JButton("Delete");
		yes.setBounds(Constants.yesButton);
		yes.setBackground(Constants.newDeckColor);
		yes.setForeground(Color.BLACK);
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < player.getDecks().size(); i ++) {
					Deck deck = player.getDecks().get(i);
					if(deck.getName().equals(name)) {
						player.removeDeck(deck);
						
						LogWriter.write(player, "Remove Deck", deck.getName());
						
						loadDeckButtons();
						loadScreen("All");
						break;
					}
				}
			}
		});
		deleteMessege.add(yes);
		
		JButton no = new JButton("Cancel");
		no.setBounds(Constants.noButton);
		no.setBackground(Constants.newDeckColor);
		no.setForeground(Color.BLACK);
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadScreen("All");
			}
		});
		deleteMessege.add(no);
		
		Border border = BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createLoweredBevelBorder());
		deleteMessege.setBorder(border);
		
		loadScreen("DeleteMessage");
	}
	
	private int convert(String s) {
		if(s.equals(""))	return 0;
		
		int ans = 0;
		for(int i = s.length()-1; i >= 0; i --) {
			if(s.charAt(i) < '0' || s.charAt(i) > '9')
				return 0;
			ans *= 10;
			ans += s.charAt(i) - '0';
		}
		
		return ans;
	} 
	
	private void loadDeckButtons() {
		decks.removeAll();
		for(Deck deck : player.getDecks()) {
			String path = "/DeckButton Images/" + deck.getHero();
			JButton button = new JButton(deck.getName(), getIcon(path, 125, 45));
			button.setPreferredSize(new Dimension(125, 65));
			button.setMaximumSize(new Dimension(125, 65));
			button.setVerticalTextPosition(AbstractButton.TOP);
			button.setHorizontalTextPosition(AbstractButton.CENTER);
			button.setForeground(Color.BLACK);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					loadScreen("ShowDeck" + deck.getName());
				}
			});
			
			switch(deck.getHero()) {
			case "Mage" :
				button.setBackground(new Color(75, 24, 81));
				break;
			case "Rogue" :
				button.setBackground(new Color(113, 22, 24));
				break;
			case "Warlock" :
				button.setBackground(new Color(94, 111, 56));
				break;
			case "Paladin" :
				button.setBackground(new Color(95, 100, 119));
				break;
			case "Hunter" :
				button.setBackground(new Color(139, 150, 147));
				break;
			}
			
			decks.add(button);
			revalidate();
			repaint();
		}
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
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		BufferedImage bgImage = null;
		String path = System.getProperty("user.dir") + "/src/main/resources" + "/Images/Collection.jpg";
		try {
			bgImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(bgImage, 0, 0, null);
	}
	
	private boolean contains(String s, String[] ss) {
		for(int i = 0; i < ss.length; i ++)
			if(s.equals(ss[i]))
				return true;
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		game = Game.getInstance();
		String command = e.getActionCommand();
		String[] classes = new String[] {"Mage", "Rogue", "Warlock", "Paladin", "Hunter", "Neutral"};

		if(command.equals("Menu")) {
			LogWriter.write(player, "Navigate", "Menu");
			game.show("Menu");
		}
		else if(command.equals("Exit")) {
			LogWriter.save(player);
			Main.frame.dispose();
		}
		else if(command.equals("All")) {
			LogWriter.write(player, "See", "All Cards");
			loadScreen(command);
		}
		else if(command.equals("Owned")) {
			LogWriter.write(player, "See", "Owned Cards");
			loadScreen(command);
		}
		else if(command.equals("NotOwned")) {
			LogWriter.write(player, "See", "Not Owned Cards");
			loadScreen(command);
		}
		else if(command.equals("Buy")) {
			LogWriter.write(player, "Navigate", "Shop");
			game.show("Shop");
		}
		else if(contains(command, classes)) {
			LogWriter.write(player, "See", command + " Cards");
			loadScreen(command);
		}
		else if(!command.equals("Locked")) {
			LogWriter.write(player, "See", command + "Card");
			showCard(command);
		}
	}

	private void addCardButton(String prepath, Card card, String commandType, String deckName) {
		String path = prepath + card.getName();
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(130, 178));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.addActionListener(this);
		button.setIcon(getIcon(path, 130, 178));
		
		ArrayList<Card> cards = new ArrayList<>();
		cards.addAll(player.getLockedCards());
		cards.addAll(player.getShop().getLockedCards());
		boolean isLocked = contains(cards, card);
		
		if(isLocked)
			button.setActionCommand("Locked");
		else if(commandType.equals("Deck"))
			button.setActionCommand(commandType + "-" + card.getName() + "-" + deckName);
		else 
			button.setActionCommand(commandType + "-" + card.getName());
		
		screen.add(button);
	}

	private boolean contains(ArrayList<Card> cards, Card card) {
		for(int i = 0; i < cards.size(); i ++)
			if(cards.get(i).getName().equals(card.getName()))
				return true;
		return false;
	}

	private int getCnt(ArrayList<Card> cards, Card card) {
		int cnt = 0;
		for(Card carrd : cards) 
			if(carrd.getName().equals(card.getName()))
				cnt ++;
		
		return cnt;
	}
	
	private void showCard(String cardName) {
		String[] splited = cardName.split("-" , 3);
		String name = splited[1];
		Card card = Card.convert(name);
		
		cardPanel = new JPanel();
		cardPanel.setBackground(Constants.newDeckColor);	
		cardPanel.setLayout(null);
		cardPanel.setBounds(Constants.Screen);
		
		JLabel cardImage = new JLabel();
		cardImage.setBounds(Constants.collectionsCard);
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
		rarity.setBounds(Constants.collectionsRarity);
		rarity.setForeground(Color.BLACK);
		rarity.setFont(Constants.buyButtonFont);
		cardPanel.add(rarity);
		
		JLabel heroClass = new JLabel("Class: " + card.getHeroClass());
		heroClass.setBounds(Constants.collectionsClass);
		heroClass.setForeground(Color.BLACK);
		heroClass.setFont(Constants.buyButtonFont);
		cardPanel.add(heroClass);
		
		JLabel type = new JLabel("Type: " + card.getType());
		type.setBounds(Constants.collectionsType);
		type.setForeground(Color.BLACK);
		type.setFont(Constants.buyButtonFont);
		cardPanel.add(type);
		
		String commandType = splited[0];
		if(commandType.equals("Deck")) {
			remove = new JButton("Remove From Deck");
			remove.setBounds(Constants.removeFromDeck);
			remove.setBackground(Constants.collectionsExitColor);
			remove.setForeground(Color.BLACK);
			remove.setActionCommand("RemoveFromDeck");
			remove.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String deckName = splited[2];
					for(Deck deck : player.getDecks())
						if(deckName.equals(deck.getName())) {
							player.removeDeck(deck);
							deck.remove(card);
							player.addDeck(deck);
							successLabel.setText("Card Was Removed From Deck Successfully");
							
							LogWriter.write(player, "Remove Card From Deck", card.getName() + ", " + deck.getName());
							
							break;
						}
					
				}
			});
			cardPanel.add(remove);
		}
		
		else if(contains(player.getCards(), card)) {
			JLabel number = new JLabel("Number: " + getCnt(player.getCards(), card));
			number.setBounds(Constants.collectionsNumber);
			number.setForeground(Color.BLACK);
			number.setFont(Constants.buyButtonFont);
			cardPanel.add(number);
			
			sell = new JButton("Sell");
			sell.setBounds(Constants.sell);
			sell.setBackground(Constants.collectionsExitColor);
			sell.setForeground(Color.BLACK);
			sell.setActionCommand("Sell");
			sell.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!player.canSell(card))
						errorLabel.setText("You Can't Sell This Card");
					else {
						player.getShop().sell(player, card);
						successLabel.setText("Card Was Sold Successfully");
						coinNumber.setText(String.valueOf(player.getCoins()));
					}
					
				}
			});
			cardPanel.add(sell);
		
			addToDeck = new JButton("Add To A Deck");
			addToDeck.setBounds(Constants.addToDeck);
			addToDeck.setBackground(Constants.collectionsExitColor);
			addToDeck.setForeground(Color.BLACK);
			addToDeck.setActionCommand("AddToDeck");
			addToDeck.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					addCardToDeck(card);
				}
			});
			cardPanel.add(addToDeck);
		}
		
		if(contains(player.getShop().getCards(), card)) {
			buy = new JButton("Buy");
			buy.setBounds(Constants.buy);
			buy.setBackground(Constants.collectionsExitColor);
			buy.setForeground(Color.BLACK);
			buy.setActionCommand("Buy");
			buy.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!player.canBuy(card))
						errorLabel.setText("You Can't Buy This Card");
					else {
						player.getShop().buy(player, card);
						successLabel.setText("Card Was Bought Successfully");
						coinNumber.setText(String.valueOf(player.getCoins()));
					}
				}
			});
			cardPanel.add(buy);
		}

		errorLabel = new JLabel("");
		errorLabel.setBounds(Constants.collectionsError);
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(Constants.errorFont);
		cardPanel.add(errorLabel);
		
		successLabel = new JLabel("");
		successLabel.setBounds(Constants.collectionsError);
		successLabel.setForeground(new Color(26, 132, 57));
		successLabel.setFont(Constants.errorFont);
		cardPanel.add(successLabel);
		
		loadScreen("showCard");
		
	}
	
	private void addCardToDeck(Card card) {
		addToDeckParent = new JPanel(null);
		addToDeckParent.setBounds(Constants.Screen);
		addToDeckParent.setBackground(Constants.newDeckColor);
		
		addToDeckPanel = new JPanel(null);
		addToDeckPanel.setBounds(Constants.deleteMessage);
		addToDeckPanel.setBackground(Constants.collectionsExitColor);
		
		JLabel message = new JLabel("Enter Deck's Name:");
		message.setBounds(Constants.message2);
		message.setForeground(Color.BLACK);
		addToDeckPanel.add(message);
		
		JTextField deckName = new JTextField();
		deckName.setBounds(Constants.deckName);
		deckName.setBackground(Constants.newDeckColor);
		deckName.setForeground(Color.BLACK);
		deckName.setFont(Constants.usernameFieldFont);
		addToDeckPanel.add(deckName);
		
		JButton add = new JButton("Add");
		add.setBounds(Constants.addButton);
		add.setBackground(Constants.newDeckColor);
		add.setForeground(Color.BLACK);
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				successLabel.setText("");
				successLabel.setBounds(Constants.deckError);
				successLabel.setFont(Constants.errorFont);
				successLabel.setForeground(new Color(26, 132, 57));
				
				errorLabel.setText("");
				errorLabel.setBounds(Constants.deckError);
				errorLabel.setForeground(Color.RED);
				errorLabel.setFont(Constants.errorFont);
				addToDeckParent.add(errorLabel);
				addToDeckParent.add(successLabel);
				
				Deck target = null;
				boolean exist = false;
				String name = deckName.getText();
				for(Deck deck : player.getDecks()) {
					if(deck.getName().equals(name)) {
						exist = true;
						target = deck;
						break;
					}
				}
				
				if(exist == false) {
					errorLabel.setBounds(Constants.collectionsError);
					errorLabel.setText("This Deck Doesn't Exist");
				}
				
				else if(target.getCards().size() == 15) {
					errorLabel.setBounds(Constants.collectionsError);
					errorLabel.setText("This Deck Is Full");
				}
				
				else if(!target.getHero().equals(card.getHeroClass()) &&
						!card.getHeroClass().equals("Neutral")) {
					errorLabel.setBounds(Constants.deckError);
					errorLabel.setText("Card's Hero Is Different From Deck's Hero");
				}
				
				else if(getCnt(target.getCards(), card) == 2) {
					errorLabel.setBounds(Constants.deckError);
					errorLabel.setText("There Are Already 2 " + card.getName() + " Cards In This Deck");
				}
				
				else {
					successLabel.setBounds(Constants.collectionsError);
					player.removeDeck(target);
					target.add(card);
					player.addDeck(target);
					successLabel.setText("Card Was Added To " + target.getName());
					
					LogWriter.write(player, "Add Card To Deck", target.getName());
				}
			}
		});
		addToDeckPanel.add(add);
		
		Border border = BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createLoweredBevelBorder());
		addToDeckPanel.setBorder(border);
		
		addToDeckParent.add(addToDeckPanel);
		
		loadScreen("AddCard");
	}
	
	private void newDeck() {
		newDeckParent = new JPanel(null);
		newDeckParent.setBackground(Constants.newDeckColor);
		newDeckParent.setBounds(Constants.Screen);
		
		newDeckPanel = new JPanel(null);
		newDeckPanel.setBackground(Constants.collectionsExitColor);
		newDeckPanel.setBounds(Constants.newDeckPanel);
		
		Border border = BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createLoweredBevelBorder());
		newDeckPanel.setBorder(border);
		
		errorLabel.setText("");
		errorLabel.setBounds(Constants.collectionsError);
		errorLabel.setForeground(Color.BLACK);
		errorLabel.setFont(Constants.errorFont);
		newDeckParent.add(errorLabel);
		
		JLabel message = new JLabel("Enter Deck's Information:");
		message.setBounds(Constants.message3);
		message.setForeground(Color.BLACK);
		message.setFont(Constants.errorFont);
		newDeckPanel.add(message);
		
		JTextField name = new JTextField("");
		name.setBounds(Constants.nameField);
		name.setBackground(Constants.newDeckColor);
		name.setForeground(Color.BLACK);
		name.setFont(Constants.usernameFieldFont);
		newDeckPanel.add(name);
		
		JTextField hero = new JTextField("");
		hero.setBounds(Constants.heroField);
		hero.setBackground(Constants.newDeckColor);
		hero.setForeground(Color.BLACK);
		hero.setFont(Constants.usernameFieldFont);
		newDeckPanel.add(hero);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(Constants.nameLabel);
		nameLabel.setForeground(Color.BLACK);
		newDeckPanel.add(nameLabel);
		
		JLabel heroLabel = new JLabel("Hero:");
		heroLabel.setBounds(Constants.heroLabel);
		heroLabel.setForeground(Color.BLACK);
		newDeckPanel.add(heroLabel);
		
		JButton create = new JButton("Create");
		create.setBounds(Constants.createButton);
		create.setBackground(Constants.newDeckColor);
		create.setForeground(Color.BLACK);
		create.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] heroes = new String[] {"Mage", "Rogue", "Warlock", "Paladin", "Hunter"};
				boolean exist = false;
				for(Deck deck : player.getDecks())
					if(deck.getName().equals(hero.getText()))
						exist = true;
				
				if(name.getText().equals(""))
					errorLabel.setText("Please Enter Deck's Name");
				else if(hero.getText().equals(""))
					errorLabel.setText("Please Enter Hero's Name");
				else if(!contains(hero.getText(), heroes)) 
					errorLabel.setText("Hero Name Is Invalid");
				else if(exist) 
					errorLabel.setText("Duplicate Deck Name");
				else {
					Deck deck = new Deck(name.getText(), hero.getText());
					player.addDeck(deck);
					
					LogWriter.write(player, "Create Deck", deck.getName());
					
					loadDeckButtons();
					loadScreen("All");
				}
				
			}
		});
		newDeckPanel.add(create);
		
		newDeckParent.add(newDeckPanel);
		loadScreen("CreateDeck");
		
	}
	
	private void loadScreen(String command) {
		String[] classes = new String[] {"Mage", "Rogue", "Warlock", "Paladin", "Hunter", "Neutral"};
		
		screen.removeAll();
		remove(choose);
		remove(delete);
		
		int mana = convert(manaFilter.getText());
		String search = searchField.getText();
		
		if(command.equals("All")) {
			screen.setLayout(new GridLayout(0, 5, 5, 5));
			ArrayList<ArrayList<Card>> cards = new ArrayList<>();
			cards.add(player.getShop().getCards());
			cards.add(player.getLockedCards());
			cards.add(player.getShop().getLockedCards());
			
			for(int i = 0; i < cards.size(); i ++) {
				String prepath = "";
				
				if(i == 0)
					prepath = "/Card Images/";
				if(i == 1 || i == 2)
					prepath = "/Card Images - BlackWhite/";
				
				for(int j = 0; j < cards.get(i).size(); j ++) {
					Card card = cards.get(i).get(j);
					String name = card.getName();
					if((mana == 0 || card.getManaCost() == mana) && (name.contains(search) || search.equals(""))) {
						addCardButton(prepath, card, "Neck", "");
					}
				}
			}
		}
		
		if(command.equals("Owned")) {
			screen.setLayout(new GridLayout(0, 5, 5, 5));
			String prepath = "/Card Images/";
			ArrayList<Card> cards = player.getCards();
			for(Card card : cards) {
				String name = card.getName();
				if((mana == 0 || card.getManaCost() == mana) && (name.contains(search) || search.equals("")))
					addCardButton(prepath, card, "Neck", "");
			}
		}
		
		if(command.equals("NotOwned")) {
			screen.setLayout(new GridLayout(0, 5, 5, 5));
			String prepath = "";
			ArrayList<ArrayList<Card>> cards = new ArrayList <>();
			cards.add(player.getShop().getCards());
			cards.add(player.getLockedCards());
			cards.add(player.getShop().getLockedCards());
			
			for(int i = 0; i < 3; i ++) {
				if(i == 0)	prepath = "/Card Images/";
				if(i == 1 || i == 2)	prepath = "/Card Images - BlackWhite/";
				for(int j = 0; j < cards.get(i).size(); j ++) {
					Card card = cards.get(i).get(j);
					String name = card.getName();
					if((mana == 0 || card.getManaCost() == mana) && (name.contains(search) || search.equals("")))
						addCardButton(prepath, card, "Neck", "");
				}
			}
		}
		
		if(command.equals("showCard")) {
			screen.setLayout(new GridLayout(1,1));
			screen.add(cardPanel);
		}
			
		if(contains(command, classes)) {
			screen.setLayout(new GridLayout(0, 5, 5, 5));
			ArrayList<ArrayList<Card>> cards = new ArrayList<>();
			cards.add(player.getShop().getCards());
			cards.add(player.getLockedCards());
			cards.add(player.getShop().getLockedCards());
			
			for(int i = 0; i < cards.size(); i ++) {
				String prepath = "";
				
				if(i == 0)
					prepath = "/Card Images/";
				if(i == 1 || i == 2)
					prepath = "/Card Images - BlackWhite/";
				
				for(int j = 0; j < cards.get(i).size(); j ++) {
					Card card = cards.get(i).get(j);
					String name = card.getName();
					if((mana == 0 || card.getManaCost() == mana) && (name.contains(search) || search.equals(""))
							&& card.getHeroClass().equals(command)) {
						addCardButton(prepath, card, "Neck", "");
					}
				}
			}
		}
		
		if(command.length() >= 8 && command.substring(0, 8).equals("ShowDeck")) {
			screen.setLayout(new GridLayout(0, 5, 5, 5));
			String name = command.substring(8);
			
			choose.setActionCommand(name);
			delete.setActionCommand(name);
			add(choose);
			add(delete);
			
			Deck deck = null;
			for(Deck fdeck : player.getDecks())
				if(fdeck.getName().equals(name))
					deck = fdeck;
			
			String path = "/Card Images/";
			for(Card card : deck.getCards()) {
				addCardButton(path, card, "Deck", deck.getName());
			}
			
			LogWriter.write(player, "See Deck", deck.getName());
			
		}
		
		if(command.equals("DeleteMessage")) {
			screen.setLayout(null);
			screen.add(deleteMessege);
		}
		
		if(command.equals("AddCard")) {
			screen.setLayout(new GridLayout(1,1));
			screen.add(addToDeckParent);
		}
		
		if(command.equals("CreateDeck")) {
			screen.setLayout(new GridLayout(1,1));
			screen.add(newDeckParent);
		}
		
		revalidate();
		repaint();
		
	}
}
