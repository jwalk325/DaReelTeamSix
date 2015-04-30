//SecurityQuestionUI class returns a JPanel containing all UI elements for the Security Question GUI
//this UI displays a users security question and accepts an answer (during password reset)

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SecurityQuestionUI {
	//instance data
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
		//initialize main panel
		securityQuestionPanel = new JPanel();
		securityQuestionPanel.setBackground(Color.WHITE);
		
		//initialize instance data
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
		
		//error label
		errorLabel = new JLabel();
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);	
		
		//create JPanel to hold input elements
		JPanel answerLayout = new JPanel();
		answerLayout.setBackground(Color.WHITE);
		answerLayout.setLayout(new BoxLayout(answerLayout, BoxLayout.X_AXIS));
		
		//add elements to answerLayout
		answerLayout.add(answerLabel);
		answerLayout.add(Box.createRigidArea(new Dimension (5,0)));
		answerLayout.add(answerField);
		
		//create JPanel to hold all UI elements
		JPanel layout = new JPanel();
		layout.setBackground(Color.WHITE);
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		
		//add all UI elements to layout
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
		
		securityQuestionPanel.add(layout); //add layout to main panel
	}
	
	//returns JPanel containing all UI elements
	public JPanel getSecurityQuestionPanel(){
		errorLabel.setText(" ");
		return securityQuestionPanel;
	}
	
	//method to set question label to patient's security question
	public void setQuestion(Patient p){
		securityQuestionLabel.setText(p.getQuestion());
	}
	
	//method to set question label to doctor's security question
	public void setQuestion(Doctor d){
		securityQuestionLabel.setText(d.getQuestion());
	}
	
	//add actionlistener to buttons
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void continueListener (ActionListener cl){
		continueButton.addActionListener(cl);
	}
	
	//check method to check for input errors and security answer for patient
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
	
	//check method to check for input errors and security answer for doctor
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
	
	//clear method to clear UI elements
	public void clear(){
		answerField.setText("");
	}
	
	//get method
	public String getAnswer(){
		answer = answerField.getText();
		return answer;
	}
}
