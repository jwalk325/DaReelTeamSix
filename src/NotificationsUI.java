import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NotificationsUI {
	private JPanel notificationsPanel;
	private JLabel notificationsLabel;
	private JLabel errorLabel;
	private JTable notificationsTable;
	private JButton backButton;
	private JButton viewButton;
	private DefaultTableModel model = new DefaultTableModel();

	
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
			    
		notificationsTable = new JTable(){
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {                
                return false;      
			}
		};
		
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
		model.setColumnCount(0);
		model.setRowCount(0);
		errorLabel.setText(" ");
	}
	
	public void clear2(){
		notificationsTable.clearSelection();
		errorLabel.setText(" ");
	}
	
	public void createColumns(){
		model.addColumn("Last Name");
		model.addColumn("First Name");
		model.addColumn("Priority");
		model.addColumn("Date Receieved");
	}
	
	public void addRow(Object[] row){
		model.addRow(row);
	}
	
	public void createTable(){
		notificationsTable.setModel(model);
		notificationsTable.setRowSelectionAllowed(true);
		notificationsTable.setColumnSelectionAllowed(false);
		notificationsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
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
