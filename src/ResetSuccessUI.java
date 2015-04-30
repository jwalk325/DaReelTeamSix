//ResetSuccessUI class returns a JPanel containing all UI elements for the Reset Success GUI
//this UI is displayed when a user has successfully reset their password

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResetSuccessUI {
	//instance data
	private JPanel resetSuccessPanel;
	private JLabel resetSuccessLabel;
	private JLabel clickLoginLabel;
	private JButton continueButton;
	
	public ResetSuccessUI(){
		//initialize main panel
		resetSuccessPanel = new JPanel();
		resetSuccessPanel.setBackground(Color.WHITE);
		
		//initialize instance data
		resetSuccessLabel = new JLabel("Password Reset Successful!");
		resetSuccessLabel.setFont(new Font("Helvetica",Font.BOLD, 18));
		clickLoginLabel = new JLabel("Click Continue to return to Log In.");
		continueButton = new JButton("Continue");
		
		//Creating JPanel for components, used BoxLayout in vertical direction
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE); //change color of JPanel
				
		//add components to JPanel layout
		layout.add(Box.createRigidArea(new Dimension (0,150)));
		layout.add(resetSuccessLabel);
		layout.add(Box.createRigidArea(new Dimension (0,100)));
		layout.add(clickLoginLabel);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(continueButton);
		
		resetSuccessLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		clickLoginLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		continueButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

		resetSuccessPanel.add(layout); //add layout to main panel
	}
	
	//add action listener to continue button
	public void continueListener (ActionListener ll){
		continueButton.addActionListener(ll);
	}
	
	//returns JPanel with all UI elements
	public JPanel getResetSuccessPanel(){
		return resetSuccessPanel;
	}
}