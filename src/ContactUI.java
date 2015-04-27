import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ContactUI {
	private JPanel contactPanel;
	private JLabel patientInfoLabel;
	private JLabel patientNameLabel;
	private JLabel addressLabel;
	private JLabel address;
	private JLabel city;
	private JLabel state;
	private JLabel zip;
	private JLabel phoneNumberLabel;
	private JLabel phoneNumber;
	private JLabel emailLabel;
	private JLabel email;
	private JButton backButton;
	private JButton dashboardButton;
	
	public ContactUI(){
		contactPanel = new JPanel();
		contactPanel.setBackground(Color.WHITE);
		
		patientInfoLabel = new JLabel("Patient Info: ");
		patientInfoLabel.setFont(new Font("Helvetica",Font.BOLD, 24));
		patientNameLabel = new JLabel("Patient Name");
		patientNameLabel.setFont(new Font("Helvetica",Font.BOLD, 24));
		
		JPanel titleLayout = new JPanel();
		titleLayout.setBackground(Color.WHITE);
		titleLayout.setLayout(new BoxLayout(titleLayout, BoxLayout.X_AXIS));
		titleLayout.add(patientInfoLabel);
		patientInfoLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		titleLayout.add(patientNameLabel);
		patientNameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		JPanel infoLayout = new JPanel();
		infoLayout.setBackground(Color.WHITE);
		infoLayout.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints(); //create variable to control constraints
		c.fill = GridBagConstraints.BOTH;
		
		addressLabel = new JLabel("Address:", SwingConstants.RIGHT);
		phoneNumberLabel = new JLabel("Phone Number:", SwingConstants.RIGHT);
		emailLabel = new JLabel("E-Mail:", SwingConstants.RIGHT);
		address = new JLabel("1234 S Temporary St");
		city = new JLabel("Tempe");
		state = new JLabel("AZ");
		zip = new JLabel("12345");
		phoneNumber = new JLabel("123-123-1234");
		email = new JLabel("example@domain.com");
		
		c.insets = new Insets(5,5,0,0);	//provides space between objects
		c.gridx = 0;
		c.gridy = 0;
		infoLayout.add(addressLabel,c);
		c.gridx++;
		c.gridwidth = 3;
		infoLayout.add(address,c);
		
		c.gridwidth = 1;
		c.gridy = 1;
		infoLayout.add(city,c);
		c.gridx++;
		infoLayout.add(state,c);
		c.gridx++;
		infoLayout.add(zip,c);
		
		c.gridx = 0;
		c.gridy = 2;
		infoLayout.add(phoneNumberLabel,c);
		c.gridx++;
		c.gridwidth = 3;
		infoLayout.add(phoneNumber,c);
		
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		infoLayout.add(emailLabel,c);
		c.gridx++;
		c.gridwidth = 3;
		infoLayout.add(email,c);
		
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);;
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS));
		
		backButton = new JButton("Back");
		dashboardButton = new JButton("Dashboard");
		buttonLayout.add(backButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (135,0)));
		buttonLayout.add(dashboardButton);
		backButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		JPanel layout = new JPanel();
		layout.setBackground(Color.WHITE);
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(titleLayout);
		layout.add(Box.createRigidArea(new Dimension (0,120)));
		layout.add(infoLayout);
		layout.add(Box.createRigidArea(new Dimension (0,145)));
		layout.add(buttonLayout);
		
		contactPanel.add(layout);
	}
	
	public JPanel getContactPanel(){
		return contactPanel;
	}
	
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void dashboardListener (ActionListener dl){
		dashboardButton.addActionListener(dl);
	}
	
	public void setPatientName(String name){
		patientNameLabel.setText(name);
	}
	
	public void setAddress(String address){
		this.address.setText(address);
	}
	
	public void setCity(String city){
		this.city.setText(city + ",");
	}
	
	public void setState(String state){
		this.state.setText(state);
	}
	
	public void setZIP(String zip){
		this.zip.setText(zip);
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber.setText(phoneNumber);
	}
	
	public void setEmail(String email){
		this.email.setText(email);
	}
}
