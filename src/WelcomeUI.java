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
		doctorLoginButton = new JButton ("Doctor Login");
		
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
		
		welcomePanel.add(layout);
				
		//Align all components in the center
		welcomeLabel.setAlignmentX(welcomeLabel.CENTER_ALIGNMENT);
		patientLabel.setAlignmentX(patientLabel.CENTER_ALIGNMENT);
		newPatientButton.setAlignmentX(newPatientButton.CENTER_ALIGNMENT);
		existingPatientButton.setAlignmentX(existingPatientButton.CENTER_ALIGNMENT);
		doctorLabel.setAlignmentX(doctorLabel.CENTER_ALIGNMENT);
		doctorLoginButton.setAlignmentX(doctorLoginButton.CENTER_ALIGNMENT);
	}
	
	public void newPatientListener (ActionListener ny){
		newPatientButton.addActionListener(ny);
	}
	
	public void existingPatientListener (ActionListener ny){
		existingPatientButton.addActionListener(ny);
	}
	
	public void doctorLoginListener (ActionListener dl){
		doctorLoginButton.addActionListener(dl);
	}
	
	public JPanel getWelcomePanel(){
		return welcomePanel;
	}
}