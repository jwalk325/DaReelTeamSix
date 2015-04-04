import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LostPasswordUI {
	private JPanel lostPasswordPanel;
	private JLabel lostPasswordLabel;
	private JLabel enterInfoLabel;
	private JLabel emailLabel;
	private JTextField emailField;
	private JButton continueButton;
	private JButton backButton;
	
	public LostPasswordUI(){
		lostPasswordPanel = new JPanel();
		lostPasswordPanel.setBackground(Color.WHITE);
		
		lostPasswordLabel = new JLabel("Lost Password?");
		lostPasswordLabel.setFont(new Font("Helvetica",Font.BOLD, 20));
		enterInfoLabel = new JLabel("Enter Information Below");
		enterInfoLabel.setFont(new Font("Helvetica",Font.PLAIN, 14));
		emailLabel = new JLabel("E-mail:");
		emailField = new JTextField(15);
		continueButton = new JButton("Continue");
		backButton = new JButton("Back to Log In");
		
		JPanel emailLayout = new JPanel();
		emailLayout.setBackground(Color.WHITE);
		emailLayout.setLayout(new BoxLayout(emailLayout, BoxLayout.X_AXIS));
		
		emailLayout.add(emailLabel);
		emailLayout.add(Box.createRigidArea(new Dimension (5,0)));
		emailLayout.add(emailField);
		emailLayout.add(Box.createRigidArea(new Dimension (52,0)));
		
		JPanel layout = new JPanel();
		layout.setBackground(Color.WHITE);
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		layout.add(lostPasswordLabel);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(enterInfoLabel);
		layout.add(Box.createRigidArea(new Dimension (0,75)));
		layout.add(emailLayout);
		layout.add(Box.createRigidArea(new Dimension (0,15)));
		layout.add(continueButton);
		layout.add(Box.createRigidArea(new Dimension (0,5)));
		layout.add(backButton);
		
		lostPasswordLabel.setAlignmentX(lostPasswordLabel.CENTER_ALIGNMENT);
		enterInfoLabel.setAlignmentX(enterInfoLabel.CENTER_ALIGNMENT);
		continueButton.setAlignmentX(continueButton.CENTER_ALIGNMENT);
		backButton.setAlignmentX(backButton.CENTER_ALIGNMENT);
		
		lostPasswordPanel.add(layout);
	}
	
	public JPanel getLostPasswordPanel(){
		return lostPasswordPanel;
	}
	
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void continueListener (ActionListener cl){
		continueButton.addActionListener(cl);
	}
}
