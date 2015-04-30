//DoctorDashboardUI class returns a JPanel with all UI elements for doctor dashboard GUI
//this UI allows the doctor to choose between going to his notifications or patient records

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DoctorDashboardUI {
	//instance variables
	private JPanel doctorDashboardPanel;
	private JLabel dashboardLabel;
	private JButton notificationsButton;
	private JButton recordsButton;
	private JButton logoutButton;
	
	public DoctorDashboardUI() {
		//creating JPanel to be returned
		doctorDashboardPanel = new JPanel(new BorderLayout());
		doctorDashboardPanel.setBackground(Color.WHITE);
		
		//initializing variables
		dashboardLabel = new JLabel("What do you want to do?");
		dashboardLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		notificationsButton = new JButton("Notifications");
		notificationsButton.setPreferredSize(new Dimension(150,100));
		recordsButton = new JButton("Patient Records");
		recordsButton.setPreferredSize(new Dimension(150,100));
		logoutButton = new JButton("Log Out");
		
		//creating layout center buttons
		JPanel buttonLayout1 = new JPanel();
		buttonLayout1.setLayout(new GridBagLayout());
		buttonLayout1.setBackground(Color.WHITE);	
		
		//inserting elements into buttonLayout1
		GridBagConstraints c = new GridBagConstraints(); //create variable to control constraints
		c.fill = GridBagConstraints.NONE;
		
		c.gridx = 0;
		c.gridy = 0;
		buttonLayout1.add(notificationsButton, c);
		c.gridx++;
		buttonLayout1.add(recordsButton, c);
		
		//creating layout for lower buttons
		JPanel buttonLayout2 = new JPanel();
		buttonLayout2.setLayout(new BoxLayout(buttonLayout2, BoxLayout.X_AXIS));
		buttonLayout2.setBackground(Color.WHITE);
		
		//adding buttons to buttonLayout2
		buttonLayout2.add(logoutButton);
		buttonLayout2.add(Box.createRigidArea(new Dimension (225,0)));
		logoutButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		//creating JPanel to hold all UI elements
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		//adding all UI elements
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(dashboardLabel);
		dashboardLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,125)));
		layout.add(buttonLayout1);
		layout.add(Box.createRigidArea(new Dimension (0,125)));
		layout.add(buttonLayout2);
		
		doctorDashboardPanel.add(layout); //add layout to main panel
	}
	
	//return JPanel with all UI elements
	public JPanel getDoctorDashboardPanel(){
		return doctorDashboardPanel;
	}
	
	//add action listeners to buttons
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
