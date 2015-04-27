import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SelectRecordUI {
	private JPanel selectRecordPanel;
	private JLabel patientRecordsLabel;
	private JLabel patientLabel;
	private JLabel recordLabel;
	private JLabel errorLabel;
	private JComboBox<String> patientCombo;
	private JComboBox<String> recordCombo;
	private JButton viewRecordButton;
	private JButton backButton;
	private String doctorName;
	private PatientLinkedList patientList = new PatientLinkedList();
	
	public SelectRecordUI(){
		selectRecordPanel = new JPanel();
		selectRecordPanel.setBackground(Color.WHITE);
		
		patientRecordsLabel = new JLabel("Patient Records");
		patientRecordsLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		patientLabel = new JLabel("Select Patient:", SwingConstants.RIGHT);
		recordLabel = new JLabel("Select Record:", SwingConstants.RIGHT);
		errorLabel = new JLabel(" ");
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);		
		
		String[] patients = {""};
		patientCombo = new JComboBox<String>(patients);
		String[] temp = {""};
		recordCombo = new JComboBox<String>(temp);	
		patientCombo.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
               if(e.getStateChange() == ItemEvent.SELECTED && !String.valueOf(patientCombo.getSelectedItem()).isEmpty()){
					String patientName = (String)patientCombo.getSelectedItem();
					Patient p = patientList.searchByName(patientName);
					String[] records = p.getPatientRecordList().fillRecordDates();
					DefaultComboBoxModel model = new DefaultComboBoxModel(records);
					recordCombo.setModel(model);    
               }
               else{
            	   String[] temp = {""};
            	   DefaultComboBoxModel model = new DefaultComboBoxModel(temp);
				   recordCombo.setModel(model);    
               }
            }
        });
		
		viewRecordButton = new JButton("View Record");
		backButton = new JButton("Back");
		
		JPanel selectionLayout = new JPanel();
		selectionLayout.setLayout(new GridBagLayout());
		selectionLayout.setBackground(Color.WHITE);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.insets = new Insets(35,5,0,0);
		c.gridx = 0;
		c.gridy = 0;
		selectionLayout.add(patientLabel, c);
		c.gridx++;
		selectionLayout.add(patientCombo, c);
		
		c.gridx = 0;
		c.gridy = 1;
		selectionLayout.add(recordLabel, c);
		c.gridx++;
		selectionLayout.add(recordCombo, c);
		
		JPanel buttonLayout1 = new JPanel();
		buttonLayout1.setBackground(Color.WHITE);
		buttonLayout1.setLayout(new BoxLayout(buttonLayout1, BoxLayout.Y_AXIS));
		buttonLayout1.add(viewRecordButton);
		viewRecordButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		buttonLayout1.add(Box.createRigidArea(new Dimension (0,15)));
		buttonLayout1.add(errorLabel);
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		JPanel buttonLayout2 = new JPanel();
		buttonLayout2.setBackground(Color.WHITE);
		buttonLayout2.setLayout(new BoxLayout(buttonLayout2, BoxLayout.X_AXIS));
		
		buttonLayout2.add(backButton);
		buttonLayout2.add(Box.createRigidArea(new Dimension (225,0)));
		backButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(patientRecordsLabel);
		patientRecordsLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,75)));
		layout.add(selectionLayout);
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(buttonLayout1);
		layout.add(Box.createRigidArea(new Dimension (0,64)));
		layout.add(buttonLayout2);
		
		selectRecordPanel.add(layout);
	}
	
	public JPanel getSelectRecordPanel(){
		return selectRecordPanel;
	}
	
	public String getSelectedPatient(){
		return (String)patientCombo.getSelectedItem();
	}
	
	public String getSelectedRecord(){
		return (String)recordCombo.getSelectedItem();
	}
	
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void viewRecordListener (ActionListener vrl){
		viewRecordButton.addActionListener(vrl);
	}
	
	public boolean check(){
		if(String.valueOf(patientCombo.getSelectedItem()).isEmpty() || String.valueOf(recordCombo.getSelectedItem()).isEmpty()){
			errorLabel.setText("Please select Patient and Record.");
			return false;
		}
		return true;
	}
	
	public void clear(){
		patientCombo.setSelectedIndex(0);
		recordCombo.setSelectedIndex(0);
		errorLabel.setText(" ");
	}
	
	//ADDED
	
	public void setDoctorName(String dn)
	{
		doctorName = dn;
	}
	
	public void setPatientList(PatientLinkedList pl){
		patientList = pl;
		DefaultComboBoxModel model = new DefaultComboBoxModel(pl.fillPatientNames(doctorName));
		patientCombo.setModel(model); 
	}
}
