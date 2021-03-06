//DoctorLoginUI class returns a JPanel containing all UI elements for the doctor login GUI
//this UI is where the doctor can login using their email and password

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DoctorLoginUI{
	//Instance data
	private JPanel doctorLoginPanel;
	private JLabel doctorLoginLabel;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JLabel filler; //filler to center grid.
	private JLabel errorLabel;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JButton forgotButton;
	private JButton submitButton;
	private JButton backButton;
	private JButton registerButton;
	
	private String email;
	private String password;
	
	//DoctorLoginUI constructor
	public DoctorLoginUI(){
		//create main panel
		doctorLoginPanel = new JPanel();
		doctorLoginPanel.setBackground(Color.WHITE);
		
		//Title creation
		doctorLoginLabel = new JLabel("Doctor Log In", SwingConstants.CENTER);
		doctorLoginLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		//Creation of other components
		emailLabel = new JLabel("E-mail:",SwingConstants.RIGHT);
		passwordLabel = new JLabel("Password:",SwingConstants.RIGHT);
		filler = new JLabel("");
		filler.setPreferredSize(new Dimension(60,0));		
		emailField = new JTextField(15);
		passwordField = new JPasswordField(15);
		forgotButton = new JButton("Forgot Password");
		submitButton = new JButton("Submit");
		backButton = new JButton("Back");
		registerButton = new JButton("Register New Doctor");
		
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
		
		c.insets = new Insets(35,5,0,0);
		c.gridy = 4;
		inputLayout.add(forgotButton, c);
		
		c.insets = new Insets(5,5,0,0);
		c.gridy = 5;
		inputLayout.add(registerButton, c);
		
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
		layout.add(doctorLoginLabel);
		doctorLoginLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,55)));
		layout.add(errorLabel);
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(inputLayout);
		layout.add(Box.createRigidArea(new Dimension (0,30)));
		layout.add(buttonLayout);
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		
		doctorLoginPanel.add(layout); //add layout to main panel
	}
	
	//public buttonListeners for use in GUI Controller class
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void forgotListener (ActionListener fl){
		forgotButton.addActionListener(fl);
	}
	
	public void registerListener (ActionListener rl){
		registerButton.addActionListener(rl);
	}
	
	public void submitListener (ActionListener sl){
		submitButton.addActionListener(sl);
	}
	
	//method to retrieve panel in GUI Controller class
	public JPanel getDoctorLoginPanel(){
		errorLabel.setText(" ");
		return doctorLoginPanel;
	}
	
	//check method to check for input errors
	public boolean check(DoctorLinkedList doctorList)
	{
		char[] pass = passwordField.getPassword();
		String password = new String(pass);
		//create temporary patient by looking up email
		Doctor d = doctorList.searchByEmail(getEmail());
		
		if(emailField.getText().isEmpty() || password.isEmpty()){
			errorLabel.setText("Please enter e-mail and password.");
			return false;
		}
		//check if patient exists
		else if(d == null){
			errorLabel.setText("Email not found.");
			return false;
		}
		//check it passwords match
		else if(d.getPassword().compareTo(getPassword()) != 0)
		{
			errorLabel.setText("Incorrect Password.");
			return false;
		}
		else{
			return true;
		}
		
	}
	
	//clear method to reset UI elements
	public void clear()
	{
		
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