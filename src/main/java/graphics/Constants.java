package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Constants {
	public final static int height = 600;
	public final static int width = 1000;
	
	//Login
	public final static Rectangle signInButton = new Rectangle(395, 400, 110, 45);
	public final static Rectangle signUpButton = new Rectangle(515, 400, 110, 45);
	public final static Rectangle exitButton = new Rectangle(875, 515, 100, 45);
	public final static Color signInColor = new Color(235, 188, 1);
	public final static Font signInFont = new Font("Eras Demi ITC", Font.PLAIN, 20);

	//Sign In and Sign Up
	public final static Rectangle usernameField = new Rectangle(400, 240, 200, 40);
	public final static Rectangle passwordField = new Rectangle(400, 285, 200, 40);
	public final static Rectangle usernameLabel = new Rectangle(270, 240, 150, 40);
	public final static Rectangle passwordLabel = new Rectangle(270, 285, 150, 40);
	public final static Color usernameFieldColor = new Color(128, 128, 64);
	public final static Color usernameColor = new Color(160, 160, 80);
	public final static Font usernameFont = new Font("Eras Demi ITC", Font.PLAIN, 20);
	public final static Font usernameFieldFont = new Font("Eras Demi ITC", Font.PLAIN, 20);
	public final static Rectangle backButton = new Rectangle(10 ,515, 100, 45);
	public final static Rectangle errorLabel = new Rectangle(400, 500, 300, 50);
	public final static Color errorColor = Color.RED;
	public final static Font errorFont = new Font("Eras Demi ITC", Font.PLAIN, 15);

	//Menu
	public final static Rectangle playButton = new Rectangle(412, 170, 170, 45);
	public final static Color playColor = new Color(3, 5, 86);
	public final static Font playFont = new Font("Eras Demi ITC", Font.PLAIN, 25);
	public final static Color menuTextColor = new Color(68, 175, 187);
	public final static Rectangle shopButton = new Rectangle(412, 220, 170, 45);
	public final static Rectangle statusButton = new Rectangle(412, 270, 170, 45);
	public final static Rectangle collectionsButton = new Rectangle(412, 320, 170, 45);
	
	//Shop
	public final static Rectangle shopCards = new Rectangle(0, 0, 995, 500);
	public final static Color shopColor = new Color(53, 27, 0);
	public final static Color shopButtonColor = new Color(155, 100, 49);
	public final static Rectangle sellButton = new Rectangle(130 ,515, 200, 45);
	public final static Rectangle coinIcon = new Rectangle(550, 515, 120, 45);
	public final static Rectangle coinNumber = new Rectangle(610, 515, 45, 45);
	public final static Color coinsColor = Color.YELLOW;
	public final static Font coinsFont = new Font("Eras Demi ITC", Font.PLAIN, 25);

	//Showing Cards in Shop
	public final static Rectangle shopCard = new Rectangle(100, 50, 300, 414);
	public final static Rectangle shopRarity = new Rectangle(430, 90, 300, 50);
	public final static Color cardInfoColor = new Color(100, 90,77);
	public final static Font cardInfoFont = new Font("Eras Demi ITC", Font.PLAIN, 25);
	public final static Rectangle shopHeroClass = new Rectangle(430, 150, 300, 50);
	public final static Rectangle shopType = new Rectangle(430, 210, 300, 50);
	public final static Rectangle shopPrice = new Rectangle(430, 270, 300, 50);
	public final static Rectangle buyButton = new Rectangle(700, 400, 150, 50);
	public final static Color buyButtonColor = new Color(157, 63, 0);
	public final static Font buyButtonFont = new Font("Eras Demi ITC", Font.PLAIN, 20);
	public final static Rectangle returnButton = new Rectangle(5, 5, 60, 60);
	public final static Rectangle buyError = new Rectangle(330, 500, 500, 50);
	
	//Collections
	public final static Rectangle deckSroll = new Rectangle(810, 80, 130, 340);
	public final static Rectangle newDeck = new Rectangle(810, 420, 130, 30);
	public final static Font newDeckFont = new Font("Eras Demi ITC", Font.PLAIN, 16);
	public final static Color newDeckColor = new Color(189, 162, 123);
	public final static Rectangle myDeck = new Rectangle(840, 50, 100, 30);
	public final static Rectangle manaLabel = new Rectangle(50, 485, 45, 45);
	public final static Rectangle manaFilter = new Rectangle(100, 493, 45, 30);
	public final static Color manaFilterColor = new Color(180, 14, 22);
	public final static Rectangle searchField = new Rectangle(160, 493, 150, 30);
	public final static Rectangle allCards = new Rectangle(325, 493, 100, 30);
	public final static Rectangle ownedCards = new Rectangle(440, 488, 50, 50);
	public final static Rectangle notOwnedCards = new Rectangle(495, 488, 50, 50);
	public final static Rectangle collectionsExit = new Rectangle(870, 488, 80, 35);
	public final static Rectangle collectionsMenu = new Rectangle(775, 488, 80, 35);
	public final static Color collectionsExitColor = new Color(124, 100, 63);
	public final static Rectangle collectionsCoin = new Rectangle(565, 485, 120, 45);
	public final static Rectangle collectionsCoinNumber = new Rectangle(630, 485, 45, 45);
	
	//Screen
	public final static Rectangle Screen = new Rectangle(50, 80, 745, 370);
	public final static Rectangle collectionsCard = new Rectangle(0, 0, 227, 311);
	public final static Rectangle collectionsRarity = new Rectangle(260, 40, 260, 30);
	public final static Rectangle collectionsType = new Rectangle(260, 80, 260, 30);
	public final static Rectangle collectionsClass = new Rectangle(260, 120, 260, 30);
	public final static Rectangle collectionsNumber = new Rectangle(260, 160, 260, 30);
	public final static Rectangle sell = new Rectangle(373, 230, 70, 30);
	public final static Rectangle addToDeck = new Rectangle(350, 270, 120, 30);
	public final static Rectangle buy = new Rectangle(373, 270, 70, 30);
	public final static Rectangle Mage = new Rectangle(50, 50, 100, 30);
	public final static Rectangle Rogue = new Rectangle(150, 50, 100, 30);
	public final static Rectangle Warlock = new Rectangle(250, 50, 100, 30);
	public final static Rectangle Paladin = new Rectangle(350, 50, 100, 30);
	public final static Rectangle Hunter = new Rectangle(450, 50, 100, 30);
	public final static Rectangle neutral = new Rectangle(550, 50, 100, 30);
	public final static Rectangle collectionsError = new Rectangle(300, 320, 400, 25);
	
	//Deck
	public final static Rectangle removeFromDeck = new Rectangle(350, 270, 150, 30);
	public final static Rectangle choose = new Rectangle(660, 450, 135, 30);
	public final static Rectangle delete = new Rectangle(525, 450, 135, 30);
	public final static Rectangle chooseDeck = new Rectangle(550, 200, 200, 30);
	public final static Rectangle deleteMessage = new Rectangle(190, 115, 350, 120);
	public final static Rectangle message = new Rectangle(50, 25, 300, 30);
	public final static Rectangle yesButton = new Rectangle(95, 75, 75, 30);
	public final static Rectangle noButton = new Rectangle(180, 75, 75, 30);
	public final static Rectangle deckName = new Rectangle(100, 60, 120, 45);
	public final static Rectangle addButton = new Rectangle(230, 65, 65, 35);
	public final static Rectangle message2 = new Rectangle(105, 25, 300, 30);
	public final static Rectangle deckError = new Rectangle(210, 320, 400, 25);
	public final static Rectangle newDeckPanel = new Rectangle(190, 60, 350, 220);
	public final static Rectangle nameField = new Rectangle(140, 60, 120, 40);
	public final static Rectangle heroField = new Rectangle(140, 110, 120, 40);
	public final static Rectangle nameLabel = new Rectangle(100, 60, 80, 40);
	public final static Rectangle heroLabel = new Rectangle(100, 110, 80, 40);
	public final static Rectangle message3 = new Rectangle(90, 20, 250, 40);
	public final static Rectangle createButton = new Rectangle(140, 170, 75, 35);
	
	//Status
	public final static Color deckButton = new Color(134, 102, 52);
	public final static Rectangle statusName = new Rectangle(430, 100, 300, 50);
	public final static Rectangle statusWinRatio = new Rectangle(430, 150, 300, 50);
	public final static Rectangle statusWins = new Rectangle(430, 200, 300, 50);
	public final static Rectangle statusGames = new Rectangle(430, 250, 300, 50);
	public final static Rectangle statusAverage = new Rectangle(430, 300, 300, 50);
	public final static Rectangle statusHero = new Rectangle(430, 350, 300, 50);
	public final static Rectangle mostUsed = new Rectangle(430, 400, 450, 50);
	
	//Play
	public final static Rectangle ground = new Rectangle(0, 0, 890, 250);	
	public final static Rectangle events = new Rectangle(890, 0, 150, 250);
	public final static Rectangle currentDeck = new Rectangle(0, 250, 1000, 185);
	public final static Rectangle turn = new Rectangle(900, 435, 100, 30);
	public final static Rectangle manaIcon = new Rectangle(705, 520, 45, 45);
	public final static Rectangle mana = new Rectangle(675, 520, 45, 45);
	public final static Color manaColor = new Color(64, 64, 255);
	public final static Rectangle remainingIcon = new Rectangle(615, 505, 45, 60);
	public final static Rectangle remainingCard = new Rectangle(575, 520, 45, 45);
	public final static Color cardsColor = new Color(168, 141, 71);
	public final static Rectangle heroIcon = new Rectangle(445, 435, 108, 150);
	public final static Rectangle heroPower = new Rectangle(340, 435, 100, 138);
	public final static Rectangle infoLabel = new Rectangle(675, 430, 200, 40);
	public final static Rectangle nextCard1 = new Rectangle(5, 435, 100, 135);
	public final static Rectangle nextCard2 = new Rectangle(110, 435, 100, 135);
	public final static Rectangle playExit = new Rectangle(900, 530, 80, 30);
	public final static Rectangle playMenu = new Rectangle(815, 530, 80, 30);
	public final static Rectangle passive = new Rectangle(790, 480, 200, 30);
	public final static Font gameOver = new Font("Eras Demi ITC", Font.BOLD, 50);
	public final static Rectangle gameOverLabel = new Rectangle(340, 170, 1000, 185);
	
	//Before Play
	public final static Rectangle nullDeckPanel = new Rectangle(230, 140, 500, 300);
	public final static Rectangle nullDeckLabel = new Rectangle(60, 40, 450, 40);
	public final static Rectangle nullDeckButton = new Rectangle(185, 200, 150, 45);
	public final static Rectangle choosePassive = new Rectangle(130, 60, 400, 45);
	
}
