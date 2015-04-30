//UpdateInfoCheckUI class returns a JPanel containing all UI elements for the Update Information Check GUI
//this UI is displayed after a patient has submitted a record/report
//it asks if they would like to update any of their contact information

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateInfoCheckUI {
	//instance data
	private JPanel updateInfoCheckPanel;
	private JLabel infoChangedLabel;
	private JButton yesButton;
	private JButton noButton;
	
	UpdateInfoCheckUI(){
		//initialize main panel
		updateInfoCheckPanel = new JPanel();
		updateInfoCheckPanel.setBackground(Color.WHITE);
		
		//initialize instance data
		infoChangedLabel = new JLabel("Has your contact information changed?");
		infoChangedLabel.setFont(new Font("Helvetica",Font.BOLD, 22));
		
		yesButton = new JButton("Yes");
		noButton = new JButton("No");
		
		//create JPanel for buttons
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS)); 
		
		//adding buttons to JPanel and adding space between them
		buttonLayout.add(yesButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (125,0)));
		buttonLayout.add(noButton);
		
		//create JPanel to hold all UI elements and add them
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		layout.add(Box.createRigidArea(new Dimension (0,150)));
		layout.add(infoChangedLabel);
		layout.add(Box.createRigidArea(new Dimension (0,75)));
		layout.add(buttonLayout);
		
		infoChangedLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		updateInfoCheckPanel.add(layout); //add layout to main panel
	}
	
	//returns JPanel with all UI elements
	public JPanel getUpdateInfoCheckPanel(){
		return updateInfoCheckPanel;
	}
	
	//add actionlisteners to buttons
	public void yesListener (ActionListener yl){
		yesButton.addActionListener(yl);
	}
	
	public void noListener (ActionListener nl){
		noButton.addActionListener(nl);
	}
}
