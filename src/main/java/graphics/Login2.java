package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import game.LogWriter;
import game.Player;
import main.Main;

public class Login2 extends JPanel implements ActionListener {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton exit;
	private JButton back;
	private JLabel errorLabel;
	private Game game;
	private String command;

	ActionListener enter = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			game = Game.getInstance();
			
			if(usernameField.getText() == null || usernameField.getText().equals(""))
				errorLabel.setText("Please Enter Your Username!");
			else if(passwordField.getPassword() == null || passwordField.getPassword().length == 0)
				errorLabel.setText("Please Enter Your Password!");
			else if(command != null && command.equals("SignIn")) {
				if(!check(usernameField.getText(), convertPassword(passwordField.getPassword()))) {
					errorLabel.setText("Username or Password is Incorrect!");
					usernameField.setText("");
					passwordField.setText("");
				}
				else if(command != null){
					errorLabel.setText("");
					setPlayer(usernameField.getText(), convertPassword(passwordField.getPassword()));
					game.show("Menu");
					
				}
			}
			else if(command != null && command.equals("SignUp")) {
				if(!check(usernameField.getText())) {
					errorLabel.setText("Username Already Exists!");
					usernameField.setText("");
				}
				else if(command != null){
					errorLabel.setText("");
					createPlayer(usernameField.getText(), convertPassword(passwordField.getPassword()));
					game.show("Menu");
				}
			}				
		}
	};
	
	public Login2 (){
		this.setLayout(null);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(Constants.errorLabel);
		errorLabel.setForeground(Constants.errorColor);
		errorLabel.setFont(Constants.errorFont);
		this.add(errorLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(Constants.usernameField);
		usernameField.setBackground(Constants.usernameFieldColor);
		usernameField.setFont(Constants.usernameFieldFont);
		usernameField.addActionListener(enter);
		this.add(usernameField);
		
		usernameLabel = new JLabel("Username: ");
		usernameLabel.setBounds(Constants.usernameLabel);
		usernameLabel.setForeground(Constants.usernameColor);
		usernameLabel.setFont(Constants.usernameFont);
		this.add(usernameLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(Constants.passwordField);
		passwordField.setBackground(Constants.usernameFieldColor);
		passwordField.setFont(Constants.usernameFieldFont);
		passwordField.addActionListener(enter);
		this.add(passwordField);
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(Constants.passwordLabel);
		passwordLabel.setForeground(Constants.usernameColor);
		passwordLabel.setFont(Constants.usernameFont);
		this.add(passwordLabel);
		
		exit = new JButton("Exit");
		exit.setBounds(Constants.exitButton);
		exit.setBackground(Constants.usernameFieldColor);
		exit.setFont(Constants.signInFont);
		exit.setActionCommand("Exit");
		exit.addActionListener(this);
		this.add(exit);
		
		back = new JButton("Back");
		back.setBounds(Constants.backButton);
		back.setBackground(Constants.usernameFieldColor);
		back.setFont(Constants.signInFont);
		back.setActionCommand("Back");
		back.addActionListener(this);
		this.add(back);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		BufferedImage bgImage = null;
		String path = System.getProperty("user.dir") + "/src/main/resources" + "/Images/Login.jpg";
		try {
			bgImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(bgImage, 0, 0, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game = Game.getInstance();
		String command = e.getActionCommand();
		switch (command) {
		case "Back" :
			game.show("Login");
			break;
		case "Exit" :
			Main.frame.dispose();
			break;
		}		
	}

	public boolean check (String username, String password) {
		File profile = new File("./src/main/resources/Profiles/", username + ".json");
		if(!profile.exists())	return false;
		String jPlayer = "";
		Player player = new Player();
		try {
			Scanner profileScanner = new Scanner(profile);
			while(profileScanner.hasNext())
				jPlayer += profileScanner.nextLine();
			profileScanner.close();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			player = gson.fromJson(jPlayer, Player.class);
		} catch (IOException e) {
			System.out.println("An error has occured!");
			e.printStackTrace();
		}
		
		String correctPassword = player.getPassword();
		if(!correctPassword.equals(password))	return false;
		
		return true;
	}

	public boolean check (String username) {
		File profile = new File("./src/main/resources/Profiles/", username + ".json");
		if(profile.exists())	return false;
		return true;
	}
	
	public String convertPassword(char [] password) {
		String ans = "";
		for(int i = 0; i < password.length; i ++)
			ans += password[i];
		
		return ans;
	}

	public void setCommand(String command) {
		this.command = command;
	}	

	public void createPlayer(String username, String password) {
		Player player = new Player(username, password);
		LogWriter.create(player);
		game.setPlayer(player);
	}
	
	public void setPlayer(String username, String password) {
		File profile = new File("./src/main/resources/Profiles/" + username + ".json");
		String jPlayer = "";
		Player player = null;
		
		try {
			Scanner profileScanner = new Scanner(profile);
			while(profileScanner.hasNext())
				jPlayer += profileScanner.nextLine();
			profileScanner.close();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			player = gson.fromJson(jPlayer, Player.class);
		} catch (IOException e) {
			System.out.println("An error has occured!");
			e.printStackTrace();
		}
		
		LogWriter.write(player, "Sign in", "");
		
		game.setPlayer(player);
	}
}

