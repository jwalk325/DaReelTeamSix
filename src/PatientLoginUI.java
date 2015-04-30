//PatientLoginUI returns a JPanel containing all UI elements for the Patient Login GUI
//this UI allows a patient to login with their email and password

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PatientLoginUI{
	//Instance data
	private JPanel patientLoginPanel;
	private JLabel patientLoginLabel;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JLabel filler; //filler to center grid
	private JLabel errorLabel;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JButton forgotButton;
	private JButton submitButton;
	private JButton backButton;
	
	private String email;
	private String password;
	
	//PatientLoginUI constructor
	public PatientLoginUI(){
		//create main panel
		patientLoginPanel = new JPanel();
		patientLoginPanel.setBackground(Color.WHITE);
		
		//Title creation
		patientLoginLabel = new JLabel("Patient Log In", SwingConstants.CENTER);
		patientLoginLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		//Create all other components
		emailLabel = new JLabel("E-mail:",SwingConstants.RIGHT);
		passwordLabel = new JLabel("Password:",SwingConstants.RIGHT);
		filler = new JLabel("");
		filler.setPreferredSize(new Dimension(60,0));	
		emailField = new JTextField(15);
		passwordField = new JPasswordField(15);	
		passwordField.setEchoChar('*');
		forgotButton = new JButton("Forgot Password");
		submitButton = new JButton("Submit");
		backButton = new JButton("Back");
		
		//Error Label
		errorLabel = new JLabel();
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);
		
		//JPanel to hold middle section of login
		//explanation for GridBagLayout in NewUserUI class
		JPanel inputLayout = new JPanel();
		inputLayout.setLayout(new GridBagLayout());
		inputLayout.setBackground(Color.WHITE);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.insets = new Insets(5,5,0,0);	
		c.gridx = 0;
		c.gridy = 0;
		inputLayout.add(emailLabel, c);
		c.gridx++;
		inputLayout.add(emailField, c);
		c.gridx++;
		inputLayout.add(filler, c);
		
		c.gridx = 0;
		c.gridy = 1;
		inputLayout.add(passwordLabel, c);
		c.gridx++;
		inputLayout.add(passwordField, c);
		
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(10,5,0,0);	
		c.gridx = 1;
		c.gridy = 3;
		inputLayout.add(submitButton, c);
		
		c.insets = new Insets(5,5,0,0);
		c.gridy = 4;
		inputLayout.add(forgotButton, c);
		
		//JPanel for button
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS));
		buttonLayout.add(backButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (225,0)));
		
		//Master JPanel
		//explanation for BoxLayout in NewUserUI class
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		layout.add(patientLoginLabel);
		patientLoginLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,65)));
		layout.add(errorLabel);
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(inputLayout);
		layout.add(Box.createRigidArea(new Dimension (0,100)));
		layout.add(buttonLayout);
		layout.add(Box.createRigidArea(new Dimension (0,50)));
	
		patientLoginPanel.add(layout); //add layout to main panel
	}
	
	//public buttonListeners for use in GUI Controller class
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void submitListener (ActionListener sl){
		submitButton.addActionListener(sl);
	}
	
	public void forgotListener (ActionListener fl){
		forgotButton.addActionListener(fl);
	}
	
	//method to retrieve panel in GUI Controller class
	public JPanel getPatientLoginPanel(){
		errorLabel.setText(" ");
		return patientLoginPanel;
	}
	
	//check method to check for input errors
	public Patient check(PatientLinkedList patientList){
		char[] pass = passwordField.getPassword();
		String password = new String(pass);
		//create temporary patient by looking up email
		Patient p = patientList.searchByEmail(getEmail());
		
		if(emailField.getText().isEmpty() || password.isEmpty()){
			errorLabel.setText("Please enter e-mail and password.");
			return null;
		}
		//check if patient exists
		else if(p == null){
			errorLabel.setText("Email not found.");
			return null;
		}
		//check it passwords match
		else if(p.getPassword().compareTo(getPassword()) != 0)
		{
			errorLabel.setText("Incorrect Password.");
			return null;
		}
		else{
			return p;
		}
	}
	
	//clear method to reset UI elements
	public void clear(){	
		emailField.setText("");
		passwordField.setText("");
	}
	
	//get methods
	public String getEmail(){
		email = emailField.getText();
		return email;
	}
	
	public String getPassword(){
		char[] pass = passwordField.getPassword();
		password = new String(pass);
		return password;
	}
}