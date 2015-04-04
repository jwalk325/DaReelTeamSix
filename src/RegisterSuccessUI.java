import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RegisterSuccessUI {
	private JPanel registerSuccessPanel;
	private JLabel thankYouLabel;
	private JLabel clickContinueLabel;
	private JButton continueButton;
	
	public RegisterSuccessUI() {
		registerSuccessPanel = new JPanel();
		registerSuccessPanel.setBackground(Color.WHITE);
		
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
		
		thankYouLabel.setAlignmentX(thankYouLabel.CENTER_ALIGNMENT);
		clickContinueLabel.setAlignmentX(clickContinueLabel.CENTER_ALIGNMENT);
		continueButton.setAlignmentX(continueButton.CENTER_ALIGNMENT);

		registerSuccessPanel.add(layout);
	}
	
	public void continueListener (ActionListener cl){
		continueButton.addActionListener(cl);
	}
	
	public JPanel getRegisterSuccessPanel(){
		return registerSuccessPanel;
	}
}
