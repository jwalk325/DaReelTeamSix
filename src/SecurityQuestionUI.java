import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SecurityQuestionUI {
	private JPanel securityQuestionPanel;
	private JLabel answerBelowLabel;
	private JLabel enterInfoLabel;
	private JLabel answerLabel;
	private JLabel securityQuestionLabel;
	private JLabel errorLabel;
	private JTextField answerField;
	private JButton continueButton;
	private JButton backButton;
	
	public SecurityQuestionUI(){
		securityQuestionPanel = new JPanel();
		securityQuestionPanel.setBackground(Color.WHITE);
		
		answerBelowLabel = new JLabel("Security Question");
		answerBelowLabel.setFont(new Font("Helvetica",Font.BOLD, 20));
		enterInfoLabel = new JLabel("Answer Question Below");
		enterInfoLabel.setFont(new Font("Helvetica",Font.PLAIN, 14));
		securityQuestionLabel = new JLabel();
		securityQuestionLabel.setText("Example security question from user profile?");
		securityQuestionLabel.setFont(new Font("Helvetica",Font.BOLD, 14));
		answerLabel = new JLabel("Answer:");
		answerField = new JTextField(15);
		continueButton = new JButton("Continue");
		backButton = new JButton("Back");
		
		errorLabel = new JLabel();
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);	
		
		JPanel answerLayout = new JPanel();
		answerLayout.setBackground(Color.WHITE);
		answerLayout.setLayout(new BoxLayout(answerLayout, BoxLayout.X_AXIS));
		
		answerLayout.add(answerLabel);
		answerLayout.add(Box.createRigidArea(new Dimension (5,0)));
		answerLayout.add(answerField);
		
		JPanel layout = new JPanel();
		layout.setBackground(Color.WHITE);
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		layout.add(answerBelowLabel);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(enterInfoLabel);
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		layout.add(securityQuestionLabel);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(answerLayout);
		layout.add(Box.createRigidArea(new Dimension (0,15)));
		layout.add(continueButton);
		layout.add(Box.createRigidArea(new Dimension (0,5)));
		layout.add(backButton);
		layout.add(Box.createRigidArea(new Dimension (0,10))); 
		layout.add(errorLabel);
		errorLabel.setAlignmentX(errorLabel.CENTER_ALIGNMENT);
		
		answerBelowLabel.setAlignmentX(answerBelowLabel.CENTER_ALIGNMENT);
		enterInfoLabel.setAlignmentX(enterInfoLabel.CENTER_ALIGNMENT);
		securityQuestionLabel.setAlignmentX(securityQuestionLabel.CENTER_ALIGNMENT);
		continueButton.setAlignmentX(continueButton.CENTER_ALIGNMENT);
		backButton.setAlignmentX(backButton.CENTER_ALIGNMENT);
		
		securityQuestionPanel.add(layout);
	}
	
	public JPanel getSecurityQuestionPanel(){
		errorLabel.setVisible(false);
		return securityQuestionPanel;
	}
	
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void continueListener (ActionListener cl){
		continueButton.addActionListener(cl);
	}
	
}
