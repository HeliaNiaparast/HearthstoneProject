package factories;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

public class ButtonFactory {

	public static JButton getButton(String name, Rectangle bounds, Color background, Color foreground, Font font, 
			String actionCommand, ActionListener actionListener) {
		JButton button = new JButton(name);
		button.setBounds(bounds);
		button.setBackground(background);
		button.setForeground(foreground);
		button.setFont(font);
		button.setActionCommand(actionCommand);
		button.addActionListener(actionListener);
		return button;
	}
	
	public static JButton getButton(Rectangle bounds, boolean isOpaque, boolean isContentAreaFilled, boolean isBorderPainted, Icon icon, 
			String actionCommand, ActionListener actionListener) {
		JButton button = new JButton();
		button.setBounds(bounds);
		button.setOpaque(isOpaque);
		button.setContentAreaFilled(isContentAreaFilled);
		button.setBorderPainted(isBorderPainted);
		button.setIcon(icon);
		button.setActionCommand(actionCommand);
		button.addActionListener(actionListener);
		return button;
	}
}
