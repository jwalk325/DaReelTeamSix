import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DoctorDashboardUI {
	private JPanel doctorDashboardPanel;
	private JLabel dashboardLabel;
	private JButton notificationsButton;
	private JButton recordsButton;
	private JButton logoutButton;
	
	public DoctorDashboardUI() {
		doctorDashboardPanel = new JPanel(new BorderLayout());
		doctorDashboardPanel.setBackground(Color.WHITE);
		
		dashboardLabel = new JLabel("What do you want to do?");
		dashboardLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		notificationsButton = new JButton("Notifications");
		notificationsButton.setPreferredSize(new Dimension(150,100));
		recordsButton = new JButton("Patient Records");
		recordsButton.setPreferredSize(new Dimension(150,100));
		logoutButton = new JButton("Log Out");
		
		JPanel buttonLayout1 = new JPanel();
		buttonLayout1.setLayout(new GridBagLayout());
		buttonLayout1.setBackground(Color.WHITE);
		
		GridBagConstraints c = new GridBagConstraints(); //create variable to control constraints
		c.fill = GridBagConstraints.NONE;
		
		c.gridx = 0;
		c.gridy = 0;
		buttonLayout1.add(notificationsButton, c);
		c.gridx++;
		buttonLayout1.add(recordsButton, c);
		
		JPanel buttonLayout2 = new JPanel();
		buttonLayout2.setLayout(new BoxLayout(buttonLayout2, BoxLayout.X_AXIS));
		buttonLayout2.setBackground(Color.WHITE);
		
		buttonLayout2.add(logoutButton);
		buttonLayout2.add(Box.createRigidArea(new Dimension (225,0)));
		logoutButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
			
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(dashboardLabel);
		dashboardLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,125)));
		layout.add(buttonLayout1);
		layout.add(Box.createRigidArea(new Dimension (0,125)));
		layout.add(buttonLayout2);
		
		doctorDashboardPanel.add(layout);
	}
	
	public JPanel getDoctorDashboardPanel(){
		return doctorDashboardPanel;
	}
	
	public void notificationsListener (ActionListener nl){
		notificationsButton.addActionListener(nl);
	}
	
	public void recordsListener (ActionListener rl){
		recordsButton.addActionListener(rl);
	}
	
	public void logoutListener (ActionListener ll){
		logoutButton.addActionListener(ll);
	}
}
