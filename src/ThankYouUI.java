import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ThankYouUI {
	private JPanel thankYouPanel;
	private JLabel thankYouLabel;
	private JButton logoutButton;
	
		public ThankYouUI(){			
			thankYouPanel = new JPanel();
			thankYouPanel.setBackground(Color.WHITE);
			
			thankYouLabel = new JLabel("Thank you for using our service.");
			thankYouLabel.setFont(new Font("Helvetica",Font.BOLD, 22));
			
			logoutButton = new JButton("Log Out");
			
			JPanel layout = new JPanel();
			layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
			layout.setBackground(Color.WHITE);
			
			layout.add(Box.createRigidArea(new Dimension (0,150)));
			layout.add(thankYouLabel);
			layout.add(Box.createRigidArea(new Dimension (0,75)));
			layout.add(logoutButton);
			
			thankYouLabel.setAlignmentX(thankYouLabel.CENTER_ALIGNMENT);
			logoutButton.setAlignmentX(logoutButton.CENTER_ALIGNMENT);
			
			thankYouPanel.add(layout);		
		}
		
		public JPanel getThankYouPanel(){
			return thankYouPanel;
		}
		
		public void logoutListener (ActionListener ll){
			logoutButton.addActionListener(ll);
		}
}
