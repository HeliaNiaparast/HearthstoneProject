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
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cards.Card;
import cards.Deck;
import game.LogWriter;
import game.Player;

public class Play extends JPanel {
	
	private Player player;
	private ArrayList<Card> currentDeck;
	private ArrayList<Card> groundCards;
	private Deck deck;
	private String hero;
	private JPanel ground;
	private JScrollPane groundScroll;
	private JPanel eventsPanel;
	private JButton turn;
	private JPanel currentDeckPanel;
	private JScrollPane currentDeckScroll;
	private JLabel remainingCards;
	private JLabel remainingIcon;
	private JButton heroPower;
	private JLabel heroIcon;
	private JLabel manaIcon;
	private JLabel mana;
	private JLabel[] eventLabels;
	private JLabel infoLabel;
	private int manaCnt;
	private ArrayList<String> events;
	private JLabel nextCard1, nextCard2;
	private Card next1, next2;
	private int turnNum;
	private JButton exit, menu;
	private Game game;
	private JLabel passiveInfo;
	private JPanel gameOver;
	
	public String passive;
	
	public Play(Player player, String passive) {
		setLayout(null);
		setBackground(Constants.shopColor);
		
		this.passive = passive;
		this.player = player;
		deck = player.getCurrentDeck();
		hero = deck.getHero();
		
		setGround();
		setEvents();
		setCurrentDeck();
		setTurnButton();
		setScreenBottom();
		initGround();
		setPassive();
	} 

	private void setGround() {
		ground = new JPanel(new GridLayout(0, 6, 5, 5));
		ground.setBackground(Constants.newDeckColor);
		ground.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		groundScroll = new JScrollPane(ground, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		groundScroll.setBounds(Constants.ground);
		add(groundScroll);
	}
	
	private void setEvents() {
		events = new ArrayList<>();
		
		eventsPanel = new JPanel();
		eventsPanel.setLayout(new BoxLayout(eventsPanel, BoxLayout.Y_AXIS));
		eventsPanel.setBounds(Constants.events);
		eventsPanel.setBackground(Color.BLACK);
		
		eventLabels = new JLabel[30];
		for(int i = 0; i < 30; i ++) {
			eventLabels[i] = new JLabel("");
			eventLabels[i].setForeground(Constants.newDeckColor);
			eventLabels[i].setBounds(new Rectangle(895, 20*(i-1) , 120, 20));
			eventsPanel.add(eventLabels[i]);
		}
		
		add(eventsPanel);
	}
	
	private void setCurrentDeck() {
		currentDeckPanel = new JPanel(new GridLayout(1, 0, 5, 5));
		currentDeckPanel.setBackground(Constants.collectionsExitColor);
		currentDeckPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		currentDeckScroll = new JScrollPane(currentDeckPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		currentDeckScroll.setBounds(Constants.currentDeck);
		
		add(currentDeckScroll);	
	}

	private void setTurnButton() {
		turn = new JButton("End Turn");
		turn.setBounds(Constants.turn);
		turn.setBackground(Constants.newDeckColor);
		turn.setForeground(Color.BLACK);
		turn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(deck.getCards().size() == 0) {
					if(passive == null || !passive.equals("TwiceDraw")) {
						if(currentDeck.size() == 12)
							next1 = null;
						else {
							currentDeck.add(next1);
							next1 = null;
							}
						}
					else {
						if(currentDeck.size() == 12) {
							next1 = null;
							next2 = null;
						}
						else if(currentDeck.size() == 11) {
							currentDeck.add(next1);
							next1 = next2;
							next2 = null;
						}
						else {
							currentDeck.add(next1);
							currentDeck.add(next2);
							next1 = null;
							next2 = null;
						}
					}

				}
				
				if(deck.getCards().size() != 0) {
					
					if(turnNum < 10)	turnNum ++;
					manaCnt = turnNum;
		
					if(passive == null || !passive.equals("TwiceDraw")) {
						if(currentDeck.size() < 12) {
							currentDeck.add(next1);
							next1 = deck.getCards().get(0);
							deck.remove(next1);
						} else {
							next1 = deck.getCards().get(0);
							deck.remove(next1);
						}
					}
					
					if(passive != null && passive.equals("TwiceDraw")) {
						if(currentDeck.size() == 12) {
							if(deck.getCards().size() >= 2) {
								next1 = deck.getCards().get(0);
								next2 = deck.getCards().get(1);
								deck.remove(next1);
								deck.remove(next2);
							} else {
								next1 = next2;
								next2 = deck.getCards().get(0);
								deck.remove(next2);
							}
						}
						
						else if(currentDeck.size() == 11) {
							currentDeck.add(next1);
							next1 = next2;
							next2 = deck.getCards().get(0);
							deck.remove(next2);
						}
						
						else {
							if(deck.getCards().size() >= 2) {
								currentDeck.add(next1);
								currentDeck.add(next2);
								next1 = deck.getCards().get(0);
								next2 = deck.getCards().get(1);
								deck.remove(next1);
								deck.remove(next2);
							} else {
								currentDeck.add(next1);
								currentDeck.add(next2);
								next1 = deck.getCards().get(0);
								next2 = null;
								deck.remove(next1);
							}
							
						}
					}
				}
				
				LogWriter.write(player, "Click", "End Turn");
				
				drawGround();
			}
		});
		add(turn);
	}
	
	private void setScreenBottom() {
		exit = new JButton("Exit");
		exit.setBounds(Constants.playExit);
		exit.setFont(Constants.errorFont);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LogWriter.save(player);
				Main.frame.dispose();
			}
		});
		exit.setBackground(Constants.collectionsExitColor);
		exit.setForeground(Color.BLACK);
		add(exit);
		
		menu = new JButton("Menu");
		menu.setBounds(Constants.playMenu);
		menu.setFont(Constants.errorFont);
		menu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				game = Game.getInstance();
				
				LogWriter.write(player, "Navigate", "Menu");
				
				game.show("Menu");
			}
		});
		menu.setBackground(Constants.collectionsExitColor);
		menu.setForeground(Color.BLACK);
		add(menu);
		
		manaIcon = new JLabel();
		manaIcon.setBounds(Constants.manaIcon);
		manaIcon.setIcon(getIcon("/Images/ManaLabel", 45, 45));
		add(manaIcon);
		
		mana = new JLabel("");
		mana.setBounds(Constants.mana);
		mana.setForeground(Constants.manaColor);
		mana.setFont(Constants.coinsFont);
		add(mana);
		
		remainingIcon = new JLabel();
		remainingIcon.setBounds(Constants.remainingIcon);
		remainingIcon.setIcon(getIcon("/Images/DeckIcon", 45, 60));
		add(remainingIcon);
		
		remainingCards = new JLabel(String.valueOf(deck.getCards().size()));
		remainingCards.setBounds(Constants.remainingCard);
		remainingCards.setForeground(Constants.cardsColor);
		remainingCards.setFont(Constants.coinsFont);
		add(remainingCards);
		
		heroIcon = new JLabel();
		heroIcon.setBounds(Constants.heroIcon);
		heroIcon.setIcon(getIcon("/Hero Images/" + hero, 108, 150));
		add(heroIcon);
		
		heroPower = new JButton();
		heroPower.setBounds(Constants.heroPower);
		heroPower.setOpaque(false);
		heroPower.setContentAreaFilled(false);
		heroPower.setBorderPainted(false);
		heroPower.setIcon(getIcon("/Hero Images/" + hero + "HeroPower", 100, 138));
		add(heroPower);
		
		infoLabel = new JLabel("");
		infoLabel.setBounds(Constants.infoLabel);
		infoLabel.setForeground(Constants.newDeckColor);
		add(infoLabel);
		
		nextCard1 = new JLabel();
		nextCard1.setBounds(Constants.nextCard1);
		add(nextCard1);
		
		nextCard2 = new JLabel();
		nextCard2.setBounds(Constants.nextCard2);
		add(nextCard2);
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
	
	private void setPassive() {
		passiveInfo = new JLabel("");
		passiveInfo.setBounds(Constants.passive);
		passiveInfo.setFont(Constants.errorFont);
		passiveInfo.setForeground(Constants.cardsColor);
		add(passiveInfo);
		
		if(passive == null)	return;
		
		if(passive.equals("OffCards")) 
			passiveInfo.setText("<html>All Cards Cost 1 Mana Less Than Their Mana Label</html>");
		
		if(passive.equals("FreePower"))
			passiveInfo.setText("<html>Hero Power Costs 1 Mana Less Than Its Mana Label</html>");
		
		if(passive.equals("Zombie"))
			passiveInfo.setText("<html>Zombie: Hero Power Costs Zero Manas</html>");
		
		if(passive.equals("TwiceDraw"))
			passiveInfo.setText("Twice Draw");
		
		if(passive.equals("ManaJump"))
			passiveInfo.setText("Mana Jump");
	}
	
	private void initGround() {
		if(passive != null && passive.equals("ManaJump"))
			turnNum = 2;
		else	turnNum = 1;
		
		manaCnt = turnNum;
		mana.setText(String.valueOf(manaCnt));
		
		groundCards = new ArrayList<>();
		
		currentDeck = new ArrayList<>();
		if(deck.getCards().size() <= 3)
			currentDeck.addAll(deck.getCards());
		
		if(deck.getCards().size() != 0) {
			Random random = new Random();
			currentDeck.add(deck.getCards().get(random.nextInt(deck.getCards().size())));
			currentDeck.add(deck.getCards().get(random.nextInt(deck.getCards().size())));
			currentDeck.add(deck.getCards().get(random.nextInt(deck.getCards().size())));
			
			next1 = deck.getCards().get(0);
		}
		
		if(deck.getCards().size() >= 2 && passive != null && passive == "TwiceDraw")
			next2 = deck.getCards().get(1);
		
		drawGround();
	}
	
	private void drawGround() {
		ground.removeAll();
		currentDeckPanel.removeAll();
		
		for(Card card : currentDeck)
			addCardButton("/Card Images/" + card.getName(), currentDeckPanel);
		
		for(Card card : groundCards)
			addCardLabel("/Card Images/" + card.getName(), ground);
		
		mana.setText(String.valueOf(manaCnt));
		remainingCards.setText(String.valueOf(deck.getCards().size()));
		
		for(int i = 0; i < events.size(); i ++) {
			eventLabels[i].setText(events.get(i));
		}
		
		infoLabel.setText("");
		
		nextLabels();
		
		gameOver();
		
		revalidate();
		repaint();		
	}
	
	private void addCardButton(String path, JPanel panel) {
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(120, 165));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setActionCommand(path.substring(13));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Card card = Card.convert(button.getActionCommand());
				
				if(passive != null && passive.equals("OffCards"))
					card.setManaCost(card.getManaCost() - 1);
				
				if(manaCnt < card.getManaCost())
					infoLabel.setText("You Don't Have Enough Mana");
				else if(groundCards.size() == 7 && card.getType().equals("Minion"))
					infoLabel.setText("Ground Is Full");
				else {
					if(card.getType().equals("Minion"))
						groundCards.add(card);
					
					for(int i = 0;  i < currentDeck.size(); i ++)
						if(currentDeck.get(i).getName().equals(card.getName())) {
							currentDeck.remove(i);
							break;
						}
					
					manaCnt -= card.getManaCost();
				
					events.add(card.getName());
					
					LogWriter.write(player, "Play Card", card.getName());
					
					drawGround();
				}
				
			}
		});
		button.setIcon(getIcon(path, 120, 165));
		
		panel.add(button);
	}
	
	private void addCardLabel(String path, JPanel panel) {
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(120, 165));
		label.setOpaque(false);
		label.setIcon(getIcon(path, 120, 165));
		
		panel.add(label);
	}

	private void nextLabels() {
		if(next1 == null)	nextCard1.setIcon(null);
		else nextCard1.setIcon(getIcon("/Card Images/" + next1.getName(), 100, 135));
		
		if(next2 == null)	nextCard2.setIcon(null);
		else nextCard2.setIcon(getIcon("/Card Images/" + next2.getName(), 100, 135));
	}

	private void gameOver() {
		if(deck.getCards().size() == 0 && next1 == null && next2 == null) {
			gameOver = new JPanel(null);
			gameOver.setBounds(new Rectangle(0, 0, 1000, 600));
			gameOver.setBackground(Color.BLACK);
			
			JLabel Label = new JLabel("Game Over");
			Label.setBounds(Constants.gameOverLabel);
			Label.setForeground(Constants.newDeckColor);
			Label.setFont(Constants.gameOver);
			
			gameOver.add(Label);
			
			exit = new JButton("Exit");
			exit.setBounds(Constants.playExit);
			exit.setFont(Constants.errorFont);
			exit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					LogWriter.save(player);
					Main.frame.dispose();
				}
			});
			exit.setBackground(Constants.collectionsExitColor);
			exit.setForeground(Color.BLACK);
			add(exit);
			
			menu = new JButton("Menu");
			menu.setBounds(Constants.playMenu);
			menu.setFont(Constants.errorFont);
			menu.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					game = Game.getInstance();
					Main.frame.setContentPane(game);
					
					LogWriter.write(player, "Navigate", "Menu");
					
					game.show("Menu");
				}
			});
			menu.setBackground(Constants.collectionsExitColor);
			menu.setForeground(Color.BLACK);
			add(menu);
				
			gameOver.add(exit);
			gameOver.add(menu);
			
			Main.frame.setContentPane(gameOver);
		}
	}
}
