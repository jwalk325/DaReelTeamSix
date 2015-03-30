import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomeUI extends JFrame{
	//Instance Data
	private JLabel welcomeLabel;
	private JLabel patientLabel;
	private JLabel doctorLabel;
	private JButton newUserButton;
	private JButton existingUserButton;
	private JButton doctorLoginButton;
	
	//WelcomeUI constructor
	public WelcomeUI(){
		this.setTitle("Welcome"); //sets title in task bar
		
		//Title creation
		welcomeLabel = new JLabel("Welcome");
		welcomeLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		//Create other components
		patientLabel = new JLabel("Are You A Patient?");
		doctorLabel = new JLabel("Are You A Doctor?");		
		newUserButton = new JButton("New Patient");
		existingUserButton = new JButton("Returning Patient");
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
		layout.add(newUserButton);
		layout.add(Box.createRigidArea(new Dimension (0,5)));
		layout.add(existingUserButton);
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		layout.add(doctorLabel);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(doctorLoginButton);
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		
		//Align all components in the center
		welcomeLabel.setAlignmentX(CENTER_ALIGNMENT);
		patientLabel.setAlignmentX(CENTER_ALIGNMENT);
		newUserButton.setAlignmentX(CENTER_ALIGNMENT);
		existingUserButton.setAlignmentX(CENTER_ALIGNMENT);
		doctorLabel.setAlignmentX(CENTER_ALIGNMENT);
		doctorLoginButton.setAlignmentX(CENTER_ALIGNMENT);
		
		//Add JPanel to the JFrame
		getContentPane().add(layout);
	}	
	
	private class  implements ActionListener
		{
	  			public void actionPerformed(ActionEvent event)
 			{
}