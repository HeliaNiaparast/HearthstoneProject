package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.Main;

public class Login extends JPanel implements ActionListener {
	private Game game;
	
	public Login () {
		this.setLayout(null);
		JButton signIn = new JButton("Sign in");
		signIn.setBounds(Constants.signInButton);
		signIn.setBackground(Constants.signInColor);
		signIn.setFont(Constants.signInFont);
		signIn.setActionCommand("SignIn");
		signIn.addActionListener(this);
		this.add(signIn);
		JButton signUp = new JButton("Sign up");
		signUp.setBounds(Constants.signUpButton);
		signUp.setBackground(Constants.signInColor);
		signUp.setFont(Constants.signInFont);
		signUp.setActionCommand("SignUp");
		signUp.addActionListener(this);
		this.add(signUp);
		JButton exit = new JButton("Exit");
		exit.setBounds(Constants.exitButton);
		exit.setBackground(Constants.signInColor);
		exit.setFont(Constants.signInFont);
		exit.setActionCommand("Exit");
		exit.addActionListener(this);
		this.add(exit);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		BufferedImage bgImage = null;
		String path = System.getProperty("user.dir") + "/src/main/resources" + "/Images/Enter.jpg";
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
		if(command.equals("SignIn") || command.equals("SignUp")) {
			game.loginCommand(command);
			game.show("Login2");
		}
		else if(command.equals("Exit")) {
			Main.frame.dispose();
		}
	}
}
