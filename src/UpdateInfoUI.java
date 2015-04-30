//UpdateInfoUI class returns a JPanel containing all UI elemets for the Update Information GUI
//this UI allows a patient to update their contact information

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateInfoUI {
	//instance data
	private JPanel updateInfoPanel;
	private JLabel updateInformationLabel;
	private JLabel addressLabel;
	private JLabel cityLabel;
	private JLabel stateLabel;
	private JLabel zipLabel;
	private JLabel emailLabel;
	private JLabel confirmEmailLabel;
	private JLabel phoneNumberLabel;
	private JLabel filler; //to fill space to center grids
	private JLabel errorLabel;
	private JTextField addressField;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField zipField;
	private JTextField emailField;
	private JTextField confirmEmailField;
	private JTextField phoneNumberField;
	private JButton submitButton;
	private JButton cancelButton;

	private String address;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String phoneNumber;
	
	public UpdateInfoUI(){
		//initialize main panel
		updateInfoPanel = new JPanel();
		updateInfoPanel.setBackground(Color.WHITE);
		
		//initialize instance data
		//labels
		updateInformationLabel = new JLabel("Update Information");
		updateInformationLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		addressLabel = new JLabel("Address:", SwingConstants.RIGHT);
		cityLabel = new JLabel(" City");
		stateLabel = new JLabel("State", SwingConstants.CENTER);
		zipLabel = new JLabel("ZIP", SwingConstants.CENTER);
		emailLabel = new JLabel("E-mail:", SwingConstants.RIGHT);
		confirmEmailLabel = new JLabel("Confirm E-mail:", SwingConstants.RIGHT);
		phoneNumberLabel = new JLabel("Phone Number:", SwingConstants.RIGHT);
		filler = new JLabel(""); //filler is a blank JLabel
		filler.setPreferredSize(new Dimension(10,0)); //set dimensions as needed to center grid objects
		
		//Error Label
		errorLabel = new JLabel();
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);		
		
		//text fields
		addressField = new JTextField(16);
		cityField = new JTextField(10);
		stateField = new JTextField (2);
		zipField = new JTextField (4);
		emailField = new JTextField(12);
		confirmEmailField = new JTextField(12);
		phoneNumberField = new JTextField(10);
		
		//buttons
		submitButton = new JButton("Submit");
		cancelButton = new JButton("Cancel");
		
		//create JPanel to hold input elements
		JPanel inputLayout = new JPanel();
		inputLayout.setLayout(new GridBagLayout());
		inputLayout.setBackground(Color.WHITE);
		
		//add elements to inputLayout
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.insets = new Insets(5,5,0,0);	
		c.gridx = 0;
		c.gridy = 0;
		inputLayout.add(addressLabel,c);
		c.gridx++;
		c.gridwidth = 3;
		inputLayout.add(addressField,c);
		
		c.gridy = 1;
		c.gridx = 1;
		c.gridwidth = 1;
		inputLayout.add(cityField,c);
		c.gridx++;
		inputLayout.add(stateField,c);
		c.gridx++;
		inputLayout.add(zipField,c);
		c.gridx++;
		inputLayout.add(filler,c);
		
		c.gridy = 2;
		c.gridx = 1;
		inputLayout.add(cityLabel,c);
		c.gridx++;
		inputLayout.add(stateLabel,c);
		c.gridx++;
		inputLayout.add(zipLabel,c);
		
		c.insets = new Insets(15,5,0,0);	
		c.gridy = 3;
		c.gridx = 0;
		inputLayout.add(emailLabel,c);
		c.gridx++;
		c.gridwidth = 2;
		inputLayout.add(emailField,c);
		
		c.insets = new Insets(5,5,0,0);	
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 1;
		inputLayout.add(confirmEmailLabel,c);
		c.gridx++;
		c.gridwidth = 2;
		inputLayout.add(confirmEmailField,c);
		
		c.gridy = 5;
		c.gridx = 0;
		c.gridwidth = 1;
		inputLayout.add(phoneNumberLabel,c);
		c.gridx++;
		inputLayout.add(phoneNumberField,c);
		
		//create JPanel to hold buttons and add them
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS)); 
		buttonLayout.add(cancelButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (125,0)));
		buttonLayout.add(submitButton);
		
		//create JPanel to hold all UI elements
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		//add all UI elements to layout
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		layout.add(updateInformationLabel);
		updateInformationLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(inputLayout);
		layout.add(Box.createRigidArea(new Dimension (0,75))); //add space between it and the button panel
		layout.add(buttonLayout); //add button panel
		layout.add(Box.createRigidArea(new Dimension (0,10))); 
		layout.add(errorLabel);
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		updateInfoPanel.add(layout); //add layout to main panel
	}
	
	//returns JPanel with all UI elements
	public JPanel getUpdateInfoPanel(){
		errorLabel.setText(" ");
		return updateInfoPanel;
	}
	
	//add action listeners to buttons
	public void submitListener (ActionListener sl){
		submitButton.addActionListener(sl);
	}
	
	public void cancelListener (ActionListener cl){
		cancelButton.addActionListener(cl);
	}
	
	//check method to check for input errors
	public boolean check(){
		String email = emailField.getText();
		String confirmEmail = confirmEmailField.getText();
		
		if(addressField.getText().isEmpty()){
			errorLabel.setText("Address field blank!");
			return false;
		}
		else if(cityField.getText().isEmpty()){
			errorLabel.setText("City Field is empty!");
			return false;
		}
		else if(stateField.getText().isEmpty()){
			errorLabel.setText("State Field is empty!");
			return false;
		}
		else if(stateField.getText().matches("[A-Za-z]{2}") == false){
			errorLabel.setText("State format is not valid!");
			return false;
		}
		else if(zipField.getText().isEmpty()){
			errorLabel.setText("ZIP field is empty!");
			return false;
		}
		else if(zipField.getText().matches("[0-9]{5}") == false){
			errorLabel.setText("ZIP format is not valid!");
			return false;
		}
		else if(email.isEmpty()){
			errorLabel.setText("E-Mail field is empty!");
			return false;
		}
		else if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") == false){
			errorLabel.setText("E-mail format is not valid!");
			return false;
		}
		else if (confirmEmail.isEmpty()){
			errorLabel.setText("Confirm E-mail field is empty!");
			return false;
		}
		else if(email.equals(confirmEmail) == false){
			errorLabel.setText("E-Mail and Confirm E-mail do not match!");
			return false;
		}
		else if(phoneNumberField.getText().isEmpty()){
			errorLabel.setText("Phone Number field is empty!");
			return false;
		}
		else if(phoneNumberField.getText().matches("([0-9]{3})-([0-9]{3})-([0-9]{4})") == false){
			errorLabel.setText("Phone Number format is not valid!");
			return false;
		}
		else{
			return true;
		}
	}
	
	//clear method to reset UI elements
	public void clear(){
		addressField.setText("");
		cityField.setText("");
		stateField.setText("");
		zipField.setText("");
		emailField.setText("");
		confirmEmailField.setText("");
		phoneNumberField.setText("");
	}
	
	//get methods
	public String getAddress(){
		address = addressField.getText();
		return address;
	}
	
	public String getCity(){
		city = cityField.getText();
		return city;
	}
	
	public String getState(){
		state = stateField.getText();
		return state;
	}
	
	public String getZIP(){
		zip = zipField.getText();
		return zip;
	}
	
	public String getEmail(){
		email = emailField.getText();
		return email;
	}
	
	public String getPhoneNumber(){
		phoneNumber = phoneNumberField.getText();
		return phoneNumber;
	}
	
	//set methods
	public void setAddressField(String address){
		addressField.setText(address);
	}
	
	public void setCityField(String city){
		cityField.setText(city);
	}
	
	public void setStateField(String state){
		stateField.setText(state);
	}
	
	public void setZIPField(String zip){
		zipField.setText(zip);
	}
	
	public void setEmailField(String email){
		emailField.setText(email);
	}
	
	public void setPhoneNumberField(String phoneNumber){
		phoneNumberField.setText(phoneNumber);
	}
}
