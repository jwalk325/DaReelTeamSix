import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DoctorSelectionUI {
	private JPanel doctorSelectionPanel;
	private JLabel enterInformationLabel;
	private JLabel addressLabel;
	private JLabel cityLabel;
	private JLabel stateLabel;
	private JLabel zipLabel;
	private JLabel hospitalLabel;
	private JLabel doctorLabel;
	private JLabel errorLabel; 
	private JTextField addressField;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField zipField;
	private JComboBox<String> hospitalCombo;
	private JComboBox<String> doctorCombo;
	private JButton backButton;
	private JButton finishButton;
	
	private String address;
	private String city;
	private String state;
	private String zip;
	private String hospital;
	private String doctor;
	
	public DoctorSelectionUI(){
		doctorSelectionPanel = new JPanel();
		doctorSelectionPanel.setBackground(Color.WHITE);
		
		enterInformationLabel = new JLabel("Enter Your Information");
		enterInformationLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		addressLabel = new JLabel("Address:", SwingConstants.RIGHT);
		cityLabel = new JLabel(" City");
		stateLabel = new JLabel("State", SwingConstants.CENTER);
		zipLabel = new JLabel("ZIP", SwingConstants.CENTER);
		hospitalLabel = new JLabel("Hospital:", SwingConstants.RIGHT);
		doctorLabel = new JLabel("Doctor:", SwingConstants.RIGHT);
		
		//Error Label
		errorLabel = new JLabel();
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);		
		
		addressField = new JTextField(16);
		cityField = new JTextField(10);
		stateField = new JTextField (2);
		zipField = new JTextField (4);
		
		String[] hospitals = {"", "Hospital1", "Hospital2", "Hospital3"};
		String[] doctors = {"", "Doctor1", "Doctor2", "Doctor3"};
		hospitalCombo = new JComboBox<String>(hospitals);
		doctorCombo = new JComboBox<String>(doctors);
		
		backButton = new JButton("Back");
		finishButton = new JButton("Finish");
		
		JPanel inputLayout = new JPanel();
		inputLayout.setLayout(new GridBagLayout());
		inputLayout.setBackground(Color.WHITE);

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
		inputLayout.add(hospitalLabel,c);
		c.gridx++;
		c.gridwidth = 3;
		inputLayout.add(hospitalCombo,c);
		
		c.insets = new Insets(5,5,0,0);	
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 1;
		inputLayout.add(doctorLabel,c);
		c.gridx++;
		c.gridwidth = 3;
		inputLayout.add(doctorCombo,c);
		
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS)); 
		
		buttonLayout.add(backButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (120,0)));
		buttonLayout.add(finishButton);
		
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(enterInformationLabel);
		enterInformationLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,54)));
		layout.add(inputLayout);
		layout.add(Box.createRigidArea(new Dimension (0,97))); 
		layout.add(buttonLayout); //add button panel
		layout.add(Box.createRigidArea(new Dimension (0,10))); 
		layout.add(errorLabel);
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		doctorSelectionPanel.add(layout);
	}
	
	public void backListener (ActionListener dl){
		backButton.addActionListener(dl);
	}
	
	public void finishListener (ActionListener fl){
		finishButton.addActionListener(fl);
	}
	
	public JPanel getDoctorSelctionPanel(){
		errorLabel.setVisible(false);
		return doctorSelectionPanel;
	}
	
	public boolean check(){
		if(addressField.getText().isEmpty()){
			errorLabel.setText("Address field blank!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(cityField.getText().isEmpty()){
			errorLabel.setText("City Field is empty!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(stateField.getText().isEmpty()){
			errorLabel.setText("State Field is empty!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(stateField.getText().matches("[A-Z][A-Z]") == false){
			errorLabel.setText("State format is not valid!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(zipField.getText().isEmpty()){
			errorLabel.setText("ZIP field is empty!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(zipField.getText().matches("[0-9]{5}") == false){
			errorLabel.setText("ZIP format is not valid!");
			errorLabel.setVisible(true);
			return false;
		}
		else if(String.valueOf(hospitalCombo.getSelectedItem()).isEmpty() || String.valueOf(doctorCombo.getSelectedItem()).isEmpty()){
			errorLabel.setText("Please select a hospital and doctor!");
			errorLabel.setVisible(true);
			return false;
		}
		else{
			return true;
		}
	}
	
	public void clear(){
		addressField.setText("");
		cityField.setText("");
		stateField.setText("");
		zipField.setText("");
		hospitalCombo.setSelectedIndex(0);
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
	
	public String getHospital(){
		hospital = String.valueOf(hospitalCombo.getSelectedItem());
		return hospital;
	}
	
	public String getDoctor(){
		doctor = String.valueOf(doctorCombo.getSelectedItem());
		return doctor;
	}

}