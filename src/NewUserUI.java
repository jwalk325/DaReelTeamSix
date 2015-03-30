import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NewUserUI{
	//Instance data
	private JPanel newUserPanel;
	private JLabel createProfileLabel;
	private JLabel nameLabel;
	private JLabel dobLabel;
	private JLabel emailLabel;
	private JLabel confirmEmailLabel;
	private JLabel phoneNumberLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel confirmPasswordLabel;
	private JLabel filler; //to fill space to center grids
	private JTextField nameField;
	private JTextField dobField;
	private JTextField emailField;
	private JTextField confirmEmailField;
	private JTextField phoneNumberField;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField confirmPasswordField;
	private JButton backButton;
	private JButton nextButton;
	
	//NewUserUI constructor
	public NewUserUI(){		
		newUserPanel = new JPanel();
		newUserPanel.setBackground(Color.WHITE);
		
		//Title Creation
		createProfileLabel = new JLabel("Create Profile", SwingConstants.CENTER);
		createProfileLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		//Create JLabels
		nameLabel = new JLabel("Name:", SwingConstants.RIGHT);
		dobLabel = new JLabel("Date of Birth:", SwingConstants.RIGHT);
		emailLabel = new JLabel("E-Mail:", SwingConstants.RIGHT);
		confirmEmailLabel = new JLabel("Confirm E-Mail:", SwingConstants.RIGHT);
		phoneNumberLabel = new JLabel("Phone Number:", SwingConstants.RIGHT);
		usernameLabel = new JLabel("Username:", SwingConstants.RIGHT);
		passwordLabel = new JLabel("Password:", SwingConstants.RIGHT);
		confirmPasswordLabel = new JLabel("Confirm Password:", SwingConstants.RIGHT);
		filler = new JLabel(""); //filler is a blank JLabel
		filler.setPreferredSize(new Dimension(0,0)); //set dimensions as needed to center grid objects
		
		//Create JTextFields with dimensions
		nameField = new JTextField(10);
		dobField = new JTextField(10);
		emailField = new JTextField(10);
		confirmEmailField = new JTextField(10);
		phoneNumberField = new JTextField(10);
		usernameField = new JTextField(10);
		passwordField = new JTextField(10);
		confirmPasswordField = new JTextField(10);
		
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
		c.gridx++;
		inputLayout.add(filler, c); //filler used to center grid
		
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
		inputLayout.add(usernameLabel,c);
		c.gridx++;
		inputLayout.add(usernameField,c);
		
		c.gridy = 7;
		c.gridx = 0;
		inputLayout.add(passwordLabel,c);
		c.gridx++;
		inputLayout.add(passwordField,c);
		
		c.gridy = 8;
		c.gridx = 0;
		inputLayout.add(confirmPasswordLabel,c);
		c.gridx++;
		inputLayout.add(confirmPasswordField,c);
		
		//Create a JPanel for buttons, using BoxLayout in horizontal direction this time.
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS)); 
		
		//adding buttons to JPanel and adding space between them
		buttonLayout.add(backButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (125,0)));
		buttonLayout.add(nextButton);
		
		//Creating JPanel to hold all other JPanels and components, BoxLayout again in vertical direction
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		//Adding title label on top, followed by the panel with grid of labels and text fields, and finally button panel on bottom.
		layout.add(Box.createRigidArea(new Dimension (0,50)));//add space to top so label isn't smashed at the top
		layout.add(createProfileLabel); //insert title label
		createProfileLabel.setAlignmentX(createProfileLabel.CENTER_ALIGNMENT); //center the label
		layout.add(Box.createRigidArea(new Dimension (0,25))); //add space between label and middle panel
		layout.add(inputLayout); //add the grid panel
		layout.add(Box.createRigidArea(new Dimension (0,25))); //add space between it and the button panel
		layout.add(buttonLayout); //add button panel
		layout.add(Box.createRigidArea(new Dimension (0,50))); //add space to the bottom
		
		newUserPanel.add(layout);
	}
	
	public void backListener (ActionListener dl){
		backButton.addActionListener(dl);
	}
	
	public JPanel getNewUserPanel(){
		return newUserPanel;
	}
}