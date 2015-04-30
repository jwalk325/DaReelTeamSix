//RegisterSuccessUI class returns a JPanel containing all UI elements for Register Sucess GUI
//this UI is displayed when a user has successfully registered

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterSuccessUI {
	//instance data
	private JPanel registerSuccessPanel;
	private JLabel thankYouLabel;
	private JLabel clickContinueLabel;
	private JButton continueButton;
	
	public RegisterSuccessUI() {
		//initialize main panel
		registerSuccessPanel = new JPanel();
		registerSuccessPanel.setBackground(Color.WHITE);
		
		//initialize instance data
		thankYouLabel = new JLabel("Thank you for registering with us!");
		thankYouLabel.setFont(new Font("Helvetica",Font.BOLD, 18));
		clickContinueLabel = new JLabel("Click continue to go to the login page.");
		continueButton = new JButton("Continue");
		
		//Creating JPanel for components, used BoxLayout in vertical direction
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE); //change color of JPanel
				
		//add components to JPanel layout
		layout.add(Box.createRigidArea(new Dimension (0,150)));
		layout.add(thankYouLabel);
		layout.add(Box.createRigidArea(new Dimension (0,100)));
		layout.add(clickContinueLabel);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(continueButton);
		
		thankYouLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		clickContinueLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		continueButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

		registerSuccessPanel.add(layout); //add layout to main panel
	}
	
	//add action listener to continue button
	public void continueListener (ActionListener cl){
		continueButton.addActionListener(cl);
	}
	
	//returns JPanel containing all UI elements
	public JPanel getRegisterSuccessPanel(){
		return registerSuccessPanel;
	}
}
