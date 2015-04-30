//NotificationsUI class returns a JPanel containing all UI elements for Notifications GUI
//this UI contains all the notifications for the doctor currently signed in

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NotificationsUI {
	//instance data
	private JPanel notificationsPanel;
	private JLabel notificationsLabel;
	private JLabel errorLabel;
	private JTable notificationsTable;
	private JButton backButton;
	private JButton viewButton;
	private DefaultTableModel model = new DefaultTableModel();

	public NotificationsUI(){
		//create main JPanel to be returned
		notificationsPanel = new JPanel();
		notificationsPanel.setBackground(Color.WHITE);
		
		//initialize instance data
		notificationsLabel = new JLabel("Notifications");
		notificationsLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		errorLabel = new JLabel(" ");
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);
		
		backButton = new JButton("Back");
		viewButton = new JButton("View");
		
		//initialize JTable and make cells uneditable
		notificationsTable = new JTable(){
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {                
                return false;      
			}
		};
		
		//scroll pain to hold JTable
		JScrollPane notificationsPane = new JScrollPane(notificationsTable);
		notificationsPane.setMaximumSize(new Dimension(400,150));
		
		//create JPanel for buttons
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);;
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS));
		
		//add buttons to buttonLayout
		buttonLayout.add(backButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (170,0)));
		buttonLayout.add(viewButton);
		backButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		//create JPanel to hold all UI elements
		JPanel layout = new JPanel();
		layout.setBackground(Color.WHITE);
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		
		//add all UI elements to layout
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
				
		notificationsPanel.add(layout);	//add layout to main panel
	}
	
	//returns JPanel containing all UI elements
	public JPanel getNotificationsPanel(){
		return notificationsPanel;
	}
	
	//add actionlisteners to buttons
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void viewListener (ActionListener vl){
		viewButton.addActionListener(vl);
	}
	
	//check method to ensure doctor has selected a patient
	public boolean check(){
		if(notificationsTable.getSelectedRow() == -1){
			errorLabel.setText("Please select a patient.");
			return false;
		}
		else{
			return true;
		}
	}
	
	//clear method to reset UI elements for 2 circumstances
	public void clear(){
		notificationsTable.clearSelection();
		model.setColumnCount(0);
		model.setRowCount(0);
		errorLabel.setText(" ");
	}
	
	public void clear2(){
		notificationsTable.clearSelection();
		errorLabel.setText(" ");
	}
	
	//method that adds a row to the JTable
	public void addRow(Object[] row){
		model.addRow(row);
	}
	
	//method that creates basic table structure with no data
	public void createTable(){
		notificationsTable.setModel(model);
		notificationsTable.setRowSelectionAllowed(true);
		notificationsTable.setColumnSelectionAllowed(false);
		notificationsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model.addColumn("Last Name");
		model.addColumn("First Name");
		model.addColumn("Priority");
		model.addColumn("Date Receieved");
		notificationsTable.getColumnModel().getColumn(0).setPreferredWidth(52);
		notificationsTable.getColumnModel().getColumn(1).setPreferredWidth(52);
		notificationsTable.getColumnModel().getColumn(2).setPreferredWidth(18);
	}
	
	//get methods
	public String getSelectedPatientName(){
		int row = notificationsTable.getSelectedRow();
		String firstName = (String) notificationsTable.getModel().getValueAt(row, 1);
		String lastName = (String) notificationsTable.getModel().getValueAt(row, 0);
		String name = firstName + lastName;
		return name;
	}
	
	public String getSelectedPatientPriority(){
		int row = notificationsTable.getSelectedRow();
		String priority = (String) notificationsTable.getModel().getValueAt(row, 2);
		return priority;
	}
	
	public String getSelectedPatientDate(){
		int row = notificationsTable.getSelectedRow();
		String date = (String) notificationsTable.getModel().getValueAt(row, 3);
		return date;
	}
}
