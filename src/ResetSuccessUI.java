import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ResetSuccessUI {
	private JPanel resetSuccessPanel;
	private JLabel resetSuccessLabel;
	private JLabel clickLoginLabel;
	private JButton loginButton;
	
	public ResetSuccessUI(){
		resetSuccessPanel = new JPanel();
		resetSuccessPanel.setBackground(Color.WHITE);
		
		resetSuccessLabel = new JLabel("Password Reset Successful!");
		resetSuccessLabel.setFont(new Font("Helvetica",Font.BOLD, 18));
		clickLoginLabel = new JLabel("Click Log In to return to Log In.");
		loginButton = new JButton("Log In");
		
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
		layout.add(loginButton);
		
		resetSuccessLabel.setAlignmentX(resetSuccessLabel.CENTER_ALIGNMENT);
		clickLoginLabel.setAlignmentX(clickLoginLabel.CENTER_ALIGNMENT);
		loginButton.setAlignmentX(loginButton.CENTER_ALIGNMENT);

		resetSuccessPanel.add(layout);
	}
	
	public void loginListener (ActionListener ll){
		loginButton.addActionListener(ll);
	}
	
	public JPanel getResetSuccessPanel(){
		return resetSuccessPanel;
	}
}
