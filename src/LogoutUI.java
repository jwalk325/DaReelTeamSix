import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LogoutUI {
	private JPanel logoutPanel;
	private JLabel logoutLabel;
	private JButton logoutButton;
	
		public LogoutUI(){			
			logoutPanel = new JPanel();
			logoutPanel.setBackground(Color.WHITE);
			
			logoutLabel = new JLabel("Thank you for using our service.");
			logoutLabel.setFont(new Font("Helvetica",Font.BOLD, 22));
			
			logoutButton = new JButton("Log Out");
			
			JPanel layout = new JPanel();
			layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
			layout.setBackground(Color.WHITE);
			
			layout.add(Box.createRigidArea(new Dimension (0,150)));
			layout.add(logoutLabel);
			layout.add(Box.createRigidArea(new Dimension (0,75)));
			layout.add(logoutButton);
			
			logoutLabel.setAlignmentX(logoutLabel.CENTER_ALIGNMENT);
			logoutButton.setAlignmentX(logoutButton.CENTER_ALIGNMENT);
			
			logoutPanel.add(layout);		
		}
		
		public JPanel getLogoutPanel(){
			return logoutPanel;
		}
		
		public void logoutListener (ActionListener ll){
			logoutButton.addActionListener(ll);
		}
}
