//WelcomeUI class returns a JPanel containing all UI elements for the Welcome GUI
//this UI is where all users start and the home page for the application

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomeUI{
	//Instance Data
	private JPanel welcomePanel;
	private JLabel welcomeLabel;
	private JLabel patientLabel;
	private JLabel doctorLabel;
	private JButton newPatientButton;
	private JButton existingPatientButton;
	private JButton doctorLoginButton;
	
	//WelcomeUI constructor
	public WelcomeUI(){
		//create main welcome Panel
		welcomePanel = new JPanel();
		welcomePanel.setBackground(Color.WHITE);
		
		//Title creation
		welcomeLabel = new JLabel("Welcome");
		welcomeLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		//Create other components
		patientLabel = new JLabel("Are You A Patient?");
		doctorLabel = new JLabel("Are You A Doctor?");		
		newPatientButton = new JButton("New Patient");
		existingPatientButton = new JButton("Returning Patient");
		doctorLoginButton = new JButton ("Doctor Log In");
		
		//Creating JPanel for components, used BoxLayout in vertical direction
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE); //change color of JPanel
		
		//add components to JPanel layout
		layout.add(Box.createRigidArea(new Dimension (0,50))); //create space between components
		layout.add(welcomeLabel);
		layout.add(Box.createRigidArea(new Dimension(0,75)));
		layout.add(patientLabel);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(newPatientButton);
		layout.add(Box.createRigidArea(new Dimension (0,5)));
		layout.add(existingPatientButton);
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		layout.add(doctorLabel);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(doctorLoginButton);
		layout.add(Box.createRigidArea(new Dimension (0,50)));
						
		//Align all components in the center
		welcomeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		patientLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		newPatientButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		existingPatientButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		doctorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		doctorLoginButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		welcomePanel.add(layout);//add layout to main welcome Panel
	}
	
	//public buttonListeners for use in GUI Controller class
	public void newPatientListener (ActionListener ny){
		newPatientButton.addActionListener(ny);
	}
	
	public void existingPatientListener (ActionListener ny){
		existingPatientButton.addActionListener(ny);
	}
	
	public void doctorLoginListener (ActionListener dl){
		doctorLoginButton.addActionListener(dl);
	}
	
	//method to retrieve panel in GUI Controller class
	public JPanel getWelcomePanel(){
		return welcomePanel;
	}
}