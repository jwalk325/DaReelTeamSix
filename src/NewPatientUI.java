import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NewPatientUI{
	//Instance data
	private JPanel newPatientPanel;
	private JLabel createProfileLabel;
	private JLabel nameLabel;
	private JLabel dobLabel;
	private JLabel emailLabel;
	private JLabel confirmEmailLabel;
	private JLabel phoneNumberLabel;
	private JLabel questionLabel;
	private JLabel passwordLabel;
	private JLabel confirmPasswordLabel;
	private JLabel answerLabel;
	private JLabel errorLabel;
	private JTextField nameField;
	private JTextField dobField;
	private JTextField emailField;
	private JTextField confirmEmailField;
	private JTextField phoneNumberField;
	private JTextField questionField;
	private JTextField passwordField;
	private JTextField confirmPasswordField;
	private JTextField answerField;
	private JButton backButton;
	private JButton nextButton;
	
	//NewPatientUI constructor
	public NewPatientUI(){	
		//create main panel
		newPatientPanel = new JPanel();
		newPatientPanel.setBackground(Color.WHITE);
		
		//Title Creation
		createProfileLabel = new JLabel("Create Profile", SwingConstants.CENTER);
		createProfileLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		//Create JLabels
		nameLabel = new JLabel("Name:", SwingConstants.RIGHT);
		dobLabel = new JLabel("Date of Birth:", SwingConstants.RIGHT);
		emailLabel = new JLabel("E-Mail:", SwingConstants.RIGHT);
		confirmEmailLabel = new JLabel("Confirm E-Mail:", SwingConstants.RIGHT);
		phoneNumberLabel = new JLabel("Phone Number:", SwingConstants.RIGHT);
		questionLabel = new JLabel("Security Question:", SwingConstants.RIGHT);
		passwordLabel = new JLabel("Password:", SwingConstants.RIGHT);
		confirmPasswordLabel = new JLabel("Confirm Password:", SwingConstants.RIGHT);
		answerLabel = new JLabel("Answer:", SwingConstants.RIGHT);
		
		//Error Label
		errorLabel = new JLabel();
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);
		
		//Create JTextFields with dimensions
		nameField = new JTextField(15);
		dobField = new JTextField(15);
		emailField = new JTextField(15);
		confirmEmailField = new JTextField(15);
		phoneNumberField = new JTextField(15);
		questionField = new JTextField(15);
		passwordField = new JTextField(15);
		confirmPasswordField = new JTextField(15);
		answerField = new JTextField(15);
		
		//Create JButtons
		backButton = new JButton("Back");
		nextButton = new JButton("Next");
		
		//Create JPanel for middle section of JFrame, using GridBagLayout
		JPanel inputLayout = new JPanel();
		inputLayout.setLayout(new GridBagLayout());
		inputLayout.setBackground(Color.WHITE); //background color

		GridBagConstraints c = new GridBagConstraints(); //create variable to control constraints
		c.fill = GridBagConstraints.BOTH; //determines if object takes available space in vertical and/or horizontal directions
		
		c.insets = new Insets(5,5,0,0);	//provides space between objects
		c.gridx = 0; //top-left corner of window is considered (0,0). 
		c.gridy = 0;
		inputLayout.add(nameLabel, c); //must add components with constraint variable c
		c.gridx++; //moving to next column
		inputLayout.add(nameField, c);
				
		c.gridy = 1; //move to next row
		c.gridx = 0; //reset column
		inputLayout.add(dobLabel,c);
		c.gridx++;
		inputLayout.add(dobField,c);
		
		c.gridy = 2;
		c.gridx = 0;
		inputLayout.add(emailLabel,c);
		c.gridx++;
		inputLayout.add(emailField,c);
		
		c.gridy = 3;
		c.gridx = 0;
		inputLayout.add(confirmEmailLabel,c);
		c.gridx++;
		inputLayout.add(confirmEmailField,c);
		
		c.gridy = 4;
		c.gridx = 0;
		inputLayout.add(confirmEmailLabel,c);
		c.gridx++;
		inputLayout.add(confirmEmailField,c);
		
		c.gridy = 5;
		c.gridx = 0;
		inputLayout.add(phoneNumberLabel,c);
		c.gridx++;
		inputLayout.add(phoneNumberField,c);
		
		c.gridy = 6;
		c.gridx = 0;
		inputLayout.add(passwordLabel,c);
		c.gridx++;
		inputLayout.add(passwordField,c);
		
		c.gridy = 7;
		c.gridx = 0;
		inputLayout.add(confirmPasswordLabel,c);
		c.gridx++;
		inputLayout.add(confirmPasswordField,c);
		
		c.gridy = 8;
		c.gridx = 0;
		inputLayout.add(questionLabel,c);
		c.gridx++;
		inputLayout.add(questionField,c);
		
		c.gridy = 9;
		c.gridx = 0;
		inputLayout.add(answerLabel,c);
		c.gridx++;
		inputLayout.add(answerField,c);
		
		//Create a JPanel for buttons, using BoxLayout in horizontal direction this time.
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS)); 
		
		//adding buttons to JPanel and adding space between them
		buttonLayout.add(backButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (127,0)));
		buttonLayout.add(nextButton);
		
		//Creating JPanel to hold all other JPanels and components, BoxLayout again in vertical direction
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		//Adding title label on top, followed by the panel with grid of labels and text fields, and finally button panel on bottom.
		layout.add(Box.createRigidArea(new Dimension (0,25))); //add space to top so label isn't smashed at the top
		layout.add(createProfileLabel); //insert title label
		createProfileLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT); //center the label
		layout.add(Box.createRigidArea(new Dimension (0,20))); //add space between label and middle panel
		layout.add(inputLayout); //add the grid panel
		layout.add(Box.createRigidArea(new Dimension (0,25))); //add space between it and the button panel
		layout.add(buttonLayout); //add button panel
		layout.add(Box.createRigidArea(new Dimension (0,10))); //add space to the bottom
		layout.add(errorLabel);
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		newPatientPanel.add(layout); //add layout to main panel
	}
	
	//public buttonListeners for use in GUI Controller class
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void nextListener (ActionListener nl){
		nextButton.addActionListener(nl);
	}
	
	//method to retrieve panel in GUI Controller class
	public JPanel getNewPatientPanel(){
		errorLabel.setVisible(false);
		return newPatientPanel;
	}
	
	//Example of check method checking for email match
	public boolean check(){
		String email = emailField.getText();
		String confirmEmail = confirmEmailField.getText();
		
		if (email.equals(confirmEmail) && email.isEmpty() == false){
			return true;
		}
		else if(email.equalsIgnoreCase(confirmEmail) == false){
			errorLabel.setText("Email fields don't match!");
			errorLabel.setVisible(true);
			return false;
		}
		else {
			errorLabel.setText("Email fields empty");
			errorLabel.setVisible(true);
			return false;
		}
	}
}