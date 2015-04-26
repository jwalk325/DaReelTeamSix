import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NotificationsUI {
	private JPanel notificationsPanel;
	private JLabel notificationsLabel;
	private JLabel errorLabel;
	private JTable notificationsTable;
	private JButton backButton;
	private JButton viewButton;
	
	public NotificationsUI(){
		notificationsPanel = new JPanel();
		notificationsPanel.setBackground(Color.WHITE);
		
		notificationsLabel = new JLabel("Notifications");
		notificationsLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		errorLabel = new JLabel(" ");
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);
		
		backButton = new JButton("Back");
		viewButton = new JButton("View");
		
		String[] columns = {"Last Name", "First Name", "Priority", "Date Recieved"};
		Object[][] data = {
				{"Rivers", "Phillip", "High", "3/15"},
				{"Drake", "Susan", "Medium", "3/14"},
				{"Doe", "John", "Low", "3/13"}
		};
		
		notificationsTable = new JTable(data, columns){
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {                
                return false;      
			}
		};
		
		notificationsTable.setRowSelectionInterval(0,1);
		notificationsTable.setRowSelectionAllowed(true);
		notificationsTable.setColumnSelectionAllowed(false);
		notificationsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane notificationsPane = new JScrollPane(notificationsTable);
		notificationsPane.setMaximumSize(new Dimension(400,150));
		
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);;
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS));
		
		buttonLayout.add(backButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (170,0)));
		buttonLayout.add(viewButton);
		backButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		JPanel layout = new JPanel();
		layout.setBackground(Color.WHITE);
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(notificationsLabel);
		notificationsLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,100)));
		layout.add(notificationsPane);
		layout.add(Box.createRigidArea(new Dimension (0,15)));
		layout.add(errorLabel);
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,67)));
		layout.add(buttonLayout);
				
		notificationsPanel.add(layout);	
	}
	
	public JPanel getNotificationsPanel(){
		return notificationsPanel;
	}
	
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void viewListener (ActionListener vl){
		viewButton.addActionListener(vl);
	}
	
	public boolean check(){
		if(notificationsTable.getSelectedRow() == -1){
			errorLabel.setText("Please select a patient.");
			return false;
		}
		else{
			return true;
		}
	}
	
	public void clear(){
		notificationsTable.clearSelection();
		errorLabel.setText(" ");
	}
	
	public void setName(String name){
		
	}
}
