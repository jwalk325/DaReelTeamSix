import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewPatientUI{
	//Instance UI
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
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JTextField answerField;
	private JButton backButton;
	private JButton nextButton;
	
	//Instance variables
	private String name;
	private String dob;
	private String email;
	private String phoneNumber;
	private String password;
	private String question;
	private String answer;
	
	//final variables
	final String INITIAL_DOB = "MM/DD/YYYY";
	final String INITIAL_EMAIL = "example@domain.com";
	final String INITIAL_PHONE = "XXX-XXX-XXXX";
	final String INITIAL_QUESTION = "Ex: Mother's maiden name?";
	
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
		dobField = new JTextField(INITIAL_DOB,15);
		emailField = new JTextField(INITIAL_EMAIL,15);
		confirmEmailField = new JTextField(15);
		phoneNumberField = new JTextField(INITIAL_PHONE,15);
		questionField = new JTextField(INITIAL_QUESTION,15);
		passwordField = new JPasswordField(15);
		confirmPasswordField = new JPasswordField(15);
		answerField = new JTextField(15);
		
		//JTextField modifications
		dobField.setForeground(Color.LIGHT_GRAY);
		emailField.setForeground(Color.LIGHT_GRAY);
		phoneNumberField.setForeground(Color.LIGHT_GRAY);
		questionField.setForeground(Color.LIGHT_GRAY);
		//Adding FocusListeners to JTextFields
		dobField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (dobField.getText().equals(INITIAL_DOB)) {
	                dobField.setText("");
	                dobField.setForeground(Color.BLACK);
	            }
	        }
	        public void focusLost(FocusEvent e) {
	        	if (dobField.getText().isEmpty())
	            {
	                dobField.setForeground(Color.LIGHT_GRAY);
	                dobField.setText(INITIAL_DOB);
	            }
	        }
	    });
		emailField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (emailField.getText().equals(INITIAL_EMAIL)) {
	                emailField.setText("");
	                emailField.setForeground(Color.BLACK);
	            }

	        }

	        public void focusLost(FocusEvent e) {
	        	if (emailField.getText().isEmpty())
	            {
	                emailField.setForeground(Color.LIGHT_GRAY);
	                emailField.setText(INITIAL_EMAIL);
	            }
	        }
	    });
		phoneNumberField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (phoneNumberField.getText().equals(INITIAL_PHONE)) {
					phoneNumberField.setText("");
					phoneNumberField.setForeground(Color.BLACK);
	            }

	        }

	        public void focusLost(FocusEvent e) {
	        	if (phoneNumberField.getText().isEmpty())
	            {
	        		phoneNumberField.setForeground(Color.LIGHT_GRAY);
	        		phoneNumberField.setText(INITIAL_PHONE);
	            }
	        }
	    });
		questionField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (questionField.getText().equals(INITIAL_QUESTION)) {
					questionField.setText("");
					questionField.setForeground(Color.BLACK);
	            }

	        }

	        public void focusLost(FocusEvent e) {
	        	if (questionField.getText().isEmpty())
	            {
	        		questionField.setForeground(Color.LIGHT_GRAY);
	        		questionField.setText(INITIAL_QUESTION);
	            }
	        }
	    });
		//Asterisk password fields
		passwordField.setEchoChar('*');
		confirmPasswordField.setEchoChar('*');
		
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
	
	//check method to check for input errors
	public boolean check(){
		String email = emailField.getText();
		String confirmEmail = confirmEmailField.getText();
		char[] pass = passwordField.getPassword();
		char [] confirmPass = confirmPasswordField.getPassword();
		String password = new String(pass);		
		String confirmPassword = new String(confirmPass);
		
		if(nameField.getText().isEmpty()){
			errorLabel.setText("Name field is empty!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(nameField.getText().indexOf(' ') == -1){
			errorLabel.setText("First and last name required!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(dobField.getText().equals(INITIAL_DOB) || dobField.getText().isEmpty()){
			errorLabel.setText("Date of Birth field is empty!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(dobField.getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") == false){
			errorLabel.setText("Date of Birth format is not valid!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(email.equals(INITIAL_EMAIL) || email.isEmpty()){
			errorLabel.setText("E-Mail field is empty!");
			errorLabel.setVisible(true);
			return false;
		}
		else if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") == false){
			errorLabel.setText("E-mail format is not valid!");
			errorLabel.setVisible(true);
			return false;
		}
		else if (confirmEmail.isEmpty()){
			errorLabel.setText("Confirm E-mail field is empty!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(email.equals(confirmEmail) == false){
			errorLabel.setText("E-Mail and Confirm E-mail do not match!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(phoneNumberField.getText().equals(INITIAL_PHONE) || phoneNumberField.getText().isEmpty()){
			errorLabel.setText("Phone Number field is empty!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(phoneNumberField.getText().matches("([0-9]{3})-([0-9]{3})-([0-9]{4})") == false){
			errorLabel.setText("Phone Number format is not valid!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(password.isEmpty()){
			errorLabel.setText("Password field is empty!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(confirmPassword.isEmpty()){
			errorLabel.setText("Confirm Password field is empty!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(password.equals(confirmPassword) == false){
			errorLabel.setText("Password and Confirm Password do not match!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(questionField.getText().equals(INITIAL_QUESTION) || questionField.getText().isEmpty()){
			errorLabel.setText("Security Question field is empty!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(answerField.getText().isEmpty()){
			errorLabel.setText("Answer field is empty!");
			errorLabel.setVisible(true);
			return false;
		}
		else {
			return true;
		}
		
	}
	
	//clear method to clear user input upon submission
	public void clear(){
		nameField.setText("");
		dobField.setForeground(Color.LIGHT_GRAY);
		dobField.setText(INITIAL_DOB);
		emailField.setForeground(Color.LIGHT_GRAY);
		emailField.setText(INITIAL_EMAIL);
		confirmEmailField.setText("");
		phoneNumberField.setForeground(Color.LIGHT_GRAY);
		phoneNumberField.setText(INITIAL_PHONE);
		passwordField.setText("");
		confirmPasswordField.setText("");
		questionField.setForeground(Color.LIGHT_GRAY);
		questionField.setText(INITIAL_QUESTION);
		answerField.setText("");
	}
	
	//get methods
	public String getName(){
		name = nameField.getText();
		return name;
	}
	
	public String getDOB(){
		dob = dobField.getText();
		return dob;
	}
	
	public String getEmail(){
		email = emailField.getText();
		return email;
	}
	
	public String getPhoneNumber(){
		phoneNumber = phoneNumberField.getText();
		return phoneNumber;
	}
	
	public String getPassword(){
		char [] pass = passwordField.getPassword();
		password = new String(pass);
		return password;
	}
	
	public String getQuestion(){
		question = questionField.getText();
		return question;
	}
	
	public String getAnswer(){
		answer = answerField.getText();
		return answer;
	}	
}