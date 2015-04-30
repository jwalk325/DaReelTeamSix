//LogoutUI class returns a JPanel containing all UI elements for the Logout GUI
//this UI contains the logout message when a user logs out of the system

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LogoutUI {
	//instance variables
	private JPanel logoutPanel;
	private JLabel logoutLabel;
	private JButton logoutButton;
	
		public LogoutUI(){	
			//initialzing Panel that returns all UI elements
			logoutPanel = new JPanel();
			logoutPanel.setBackground(Color.WHITE);
			
			//initializing variables
			logoutLabel = new JLabel("Thank you for using our service.");
			logoutLabel.setFont(new Font("Helvetica",Font.BOLD, 22));			
			logoutButton = new JButton("Log Out");
			
			//creating panel to hold elements
			JPanel layout = new JPanel();
			layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
			layout.setBackground(Color.WHITE);
			
			//adding elements to layout panel
			layout.add(Box.createRigidArea(new Dimension (0,150)));
			layout.add(logoutLabel);
			layout.add(Box.createRigidArea(new Dimension (0,75)));
			layout.add(logoutButton);
			
			logoutLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			logoutButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
			
			logoutPanel.add(layout); //adding layout to main panel		
		}
		
		//returns JPanel contaiing all UI elements
		public JPanel getLogoutPanel(){
			return logoutPanel;
		}
		
		//add action listener to logout button
		public void logoutListener (ActionListener ll){
			logoutButton.addActionListener(ll);
		}
}
