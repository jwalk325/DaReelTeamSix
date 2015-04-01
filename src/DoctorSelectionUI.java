import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DoctorSelectionUI {
	private JPanel doctorSelectionPanel;
	private JLabel enterInformationLabel;
	private JLabel addressLabel;
	private JLabel streetLabel;
	private JLabel cityLabel;
	private JLabel stateLabel;
	private JLabel zipLabel;
	private JLabel regionLabel;
	private JLabel hospitalLabel;
	private JLabel doctorLabel;
	private JLabel filler; //to fill space to center grids
	private JTextField streetField;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField zipField;
	private JComboBox<String> regionCombo;
	private JComboBox<String> hospitalCombo;
	private JComboBox<String> doctorCombo;
	private JButton backButton;
	private JButton finishButton;
	
	public DoctorSelectionUI(){
		doctorSelectionPanel = new JPanel();
		doctorSelectionPanel.setBackground(Color.WHITE);
		
		enterInformationLabel = new JLabel("Enter Your Information");
		enterInformationLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		addressLabel = new JLabel("Address:", SwingConstants.RIGHT);
		addressLabel.setFont(new Font("Helvetica",Font.PLAIN, 14));
		streetLabel = new JLabel("Street:", SwingConstants.RIGHT);
		cityLabel = new JLabel(" City");
		stateLabel = new JLabel("State", SwingConstants.CENTER);
		zipLabel = new JLabel("ZIP", SwingConstants.CENTER);
		regionLabel = new JLabel("Region:", SwingConstants.RIGHT);
		hospitalLabel = new JLabel("Hospital:", SwingConstants.RIGHT);
		doctorLabel = new JLabel("Doctor:", SwingConstants.RIGHT);
		filler = new JLabel(""); //filler is a blank JLabel
		filler.setPreferredSize(new Dimension(10,0)); //set dimensions as needed to center grid objects
		
		streetField = new JTextField(16);
		cityField = new JTextField(10);
		stateField = new JTextField (2);
		zipField = new JTextField (4);
		
		String[] regions = {"Region1", "Region2", "Region3"};
		String[] hospitals = {"Hospital1", "Hospital2", "Hospital3"};
		String[] doctors = {"Doctor1", "Doctor2", "Doctor3"};
		regionCombo = new JComboBox<String>(regions);
		hospitalCombo = new JComboBox<String>(hospitals);
		doctorCombo = new JComboBox<String>(doctors);
		
		backButton = new JButton("Back");
		finishButton = new JButton("Finish");
		
		JPanel inputLayout = new JPanel();
		inputLayout.setLayout(new GridBagLayout());
		inputLayout.setBackground(Color.WHITE);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.insets = new Insets(5,5,0,0);	
		c.gridx = 0;
		c.gridy = 0;
		inputLayout.add(addressLabel,c);
		
		c.gridy = 1;
		inputLayout.add(streetLabel,c);
		c.gridx++;
		c.gridwidth = 3;
		inputLayout.add(streetField,c);
		
		c.gridy = 2;
		c.gridx = 1;
		c.gridwidth = 1;
		inputLayout.add(cityField,c);
		c.gridx++;
		inputLayout.add(stateField,c);
		c.gridx++;
		inputLayout.add(zipField,c);
		c.gridx++;
		inputLayout.add(filler,c);
		
		c.gridy = 3;
		c.gridx = 1;
		inputLayout.add(cityLabel,c);
		c.gridx++;
		inputLayout.add(stateLabel,c);
		c.gridx++;
		inputLayout.add(zipLabel,c);
		
		c.insets = new Insets(15,5,0,0);	
		c.gridy = 4;
		c.gridx = 0;
		inputLayout.add(regionLabel,c);
		c.gridx++;
		c.gridwidth = 3;
		inputLayout.add(regionCombo,c);
		
		c.insets = new Insets(5,5,0,0);	
		c.gridy = 5;
		c.gridx = 0;
		c.gridwidth = 1;
		inputLayout.add(hospitalLabel,c);
		c.gridx++;
		c.gridwidth = 3;
		inputLayout.add(hospitalCombo,c);
		
		c.gridy = 6;
		c.gridx = 0;
		c.gridwidth = 1;
		inputLayout.add(doctorLabel,c);
		c.gridx++;
		c.gridwidth = 3;
		inputLayout.add(doctorCombo,c);
		
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS)); 
		
		buttonLayout.add(backButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (125,0)));
		buttonLayout.add(finishButton);
		
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		layout.add(enterInformationLabel);
		enterInformationLabel.setAlignmentX(enterInformationLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(inputLayout);
		layout.add(Box.createRigidArea(new Dimension (0,75))); //add space between it and the button panel
		layout.add(buttonLayout); //add button panel
		layout.add(Box.createRigidArea(new Dimension (0,50))); //add space to the bottom
		
		doctorSelectionPanel.add(layout);
	}
	
	public void backListener (ActionListener dl){
		backButton.addActionListener(dl);
	}
	
	public void finishListener (ActionListener fl){
		finishButton.addActionListener(fl);
	}
	
	public JPanel getDoctorSelctionPanel(){
		return doctorSelectionPanel;
	}

}