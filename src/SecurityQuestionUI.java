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
	
	private String answer;
	
	public SecurityQuestionUI(){
		securityQuestionPanel = new JPanel();
		securityQuestionPanel.setBackground(Color.WHITE);
		
		answerBelowLabel = new JLabel("Security Question");
		answerBelowLabel.setFont(new Font("Helvetica",Font.BOLD, 20));
		enterInfoLabel = new JLabel("Answer Question Below");
		enterInfoLabel.setFont(new Font("Helvetica",Font.PLAIN, 14));
		securityQuestionLabel = new JLabel();
		securityQuestionLabel.setText("Example security question.");
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
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		answerBelowLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		enterInfoLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		securityQuestionLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		continueButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		backButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		securityQuestionPanel.add(layout);
	}
	
	public JPanel getSecurityQuestionPanel(){
		errorLabel.setText(" ");
		return securityQuestionPanel;
	}
	
	public void setQuestion(Patient p){
		securityQuestionLabel.setText(p.getQuestion());
	}
	
	public void setQuestion(Doctor d){
		securityQuestionLabel.setText(d.getQuestion());
	}
	
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void continueListener (ActionListener cl){
		continueButton.addActionListener(cl);
	}
	
	public boolean check(Patient p){
		if(answerField.getText().isEmpty()){
			errorLabel.setText("Answer Field is empty!");
			return false;
		}
		else if (answerField.getText().compareTo(p.getAnswer()) != 0)
		{
			errorLabel.setText("Incorrect Answer!");
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean check(Doctor d){
		if(answerField.getText().isEmpty()){
			errorLabel.setText("Answer Field is empty!");
			return false;
		}
		else if (answerField.getText().compareTo(d.getAnswer()) != 0)
		{
			errorLabel.setText("Incorrect Answer!");
			return false;
		}
		else{
			return true;
		}
	}
	
	public void clear(){
		answerField.setText("");
	}
	
	//get method
	public String getAnswer(){
		answer = answerField.getText();
		return answer;
	}
}
