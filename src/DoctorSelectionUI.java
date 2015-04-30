//DoctorSelectionUI class returns a JPanel with the UI elements for the doctor selection GUI
//this UI is where the patient enters their address information and selects their doctor
//during sign-up

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DoctorSelectionUI {
	//instance variables
	private JPanel doctorSelectionPanel;
	private JLabel enterInformationLabel;
	private JLabel addressLabel;
	private JLabel cityLabel;
	private JLabel stateLabel;
	private JLabel zipLabel;
	private JLabel doctorLabel;
	private JLabel errorLabel; 
	private JTextField addressField;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField zipField;
	private JComboBox<String> doctorCombo;
	private JButton backButton;
	private JButton finishButton;
	
	private String address;
	private String city;
	private String state;
	private String zip;
	private String doctor;
	private DoctorLinkedList doctorList = new DoctorLinkedList();
	
	public DoctorSelectionUI(){
		//initializing JPanel to be returned
		doctorSelectionPanel = new JPanel();
		doctorSelectionPanel.setBackground(Color.WHITE);
		
		//initializing labels
		enterInformationLabel = new JLabel("Enter Your Information");
		enterInformationLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		addressLabel = new JLabel("Address:", SwingConstants.RIGHT);
		cityLabel = new JLabel(" City");
		stateLabel = new JLabel("State", SwingConstants.CENTER);
		zipLabel = new JLabel("ZIP", SwingConstants.CENTER);
		doctorLabel = new JLabel("Doctor:", SwingConstants.RIGHT);
		
		//Error Label
		errorLabel = new JLabel();
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);		
		
		//initializing text fields
		addressField = new JTextField(16);
		cityField = new JTextField(10);
		stateField = new JTextField (2);
		zipField = new JTextField (4);
		
		//inserting list of doctors into combo box
		String[] doctors = doctorList.fillDoctorNames();//get list of doctors
		doctorCombo = new JComboBox<String>(doctors);
		
		//initializing buttons
		backButton = new JButton("Back");
		finishButton = new JButton("Finish");
		
		//creating JPanel to hold input elements
		JPanel inputLayout = new JPanel();
		inputLayout.setLayout(new GridBagLayout());
		inputLayout.setBackground(Color.WHITE);
		
		//inserting elements into inputLayout
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
		
		c.gridy = 2;
		c.gridx = 1;
		inputLayout.add(cityLabel,c);
		c.gridx++;
		inputLayout.add(stateLabel,c);
		c.gridx++;
		inputLayout.add(zipLabel,c);		
		
		c.insets = new Insets(45,5,0,0);	
		c.gridy = 3;
		c.gridx = 0;
		c.gridwidth = 1;
		inputLayout.add(doctorLabel,c);
		c.gridx++;
		c.gridwidth = 3;
		inputLayout.add(doctorCombo,c);
		
		//creating panel to hold buttons
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS)); 
		
		//inserting elements into buttonLayout
		buttonLayout.add(backButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (120,0)));
		buttonLayout.add(finishButton);
		
		//creating JPanel to hold all UI elements
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		//adding all UI elements to layout panel
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(enterInformationLabel);
		enterInformationLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,54)));
		layout.add(inputLayout);
		layout.add(Box.createRigidArea(new Dimension (0,129))); 
		layout.add(buttonLayout); //add button panel
		layout.add(Box.createRigidArea(new Dimension (0,10))); 
		layout.add(errorLabel);
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		doctorSelectionPanel.add(layout); //adding layout to main panel
	}
	
	//add action listeners to buttons
	public void backListener (ActionListener dl){
		backButton.addActionListener(dl);
	}
	
	public void finishListener (ActionListener fl){
		finishButton.addActionListener(fl);
	}
	
	//return JPanel containing all UI elements
	public JPanel getDoctorSelctionPanel(){
		errorLabel.setText(" ");
		return doctorSelectionPanel;
	}
	
	//check method to check for input errors
	public boolean check(){
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
		else if(String.valueOf(doctorCombo.getSelectedItem()).isEmpty()){
			errorLabel.setText("Please select a doctor!");
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
		doctorCombo.setSelectedIndex(0);
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
	
	public String getDoctor(){
		doctor = String.valueOf(doctorCombo.getSelectedItem());
		return doctor;
	}
	
	//method to fill doctor names inot combo box
	public void setDoctorList(DoctorLinkedList dl){
		doctorList = dl;
		DefaultComboBoxModel model = new DefaultComboBoxModel(dl.fillDoctorNames());
		doctorCombo.setModel(model);
	}

}