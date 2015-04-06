import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UpdateInfoUI {
	private JPanel updateInfoPanel;
	private JLabel updateInformationLabel;
	private JLabel addressLabel;
	private JLabel streetLabel;
	private JLabel cityLabel;
	private JLabel stateLabel;
	private JLabel zipLabel;
	private JLabel emailLabel;
	private JLabel confirmEmailLabel;
	private JLabel phoneNumberLabel;
	private JLabel filler; //to fill space to center grids
	private JLabel errorLabel;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField zipField;
	private JTextField emailField;
	private JTextField confirmEmailField;
	private JTextField phoneNumberField;
	private JButton submitButton;

	
	public UpdateInfoUI(){
		updateInfoPanel = new JPanel();
		updateInfoPanel.setBackground(Color.WHITE);
		
		updateInformationLabel = new JLabel("Update Information");
		updateInformationLabel.setFont(new Font("Helvetica",Font.BOLD, 28));
		
		addressLabel = new JLabel("Address:", SwingConstants.RIGHT);
		addressLabel.setFont(new Font("Helvetica",Font.PLAIN, 14));
		streetLabel = new JLabel("Street:", SwingConstants.RIGHT);
		cityLabel = new JLabel(" City");
		stateLabel = new JLabel("State", SwingConstants.CENTER);
		zipLabel = new JLabel("ZIP", SwingConstants.CENTER);
		emailLabel = new JLabel("E-mail:", SwingConstants.RIGHT);
		confirmEmailLabel = new JLabel("Confirm E-mail:", SwingConstants.RIGHT);
		phoneNumberLabel = new JLabel("Phone Number:", SwingConstants.RIGHT);
		filler = new JLabel(""); //filler is a blank JLabel
		filler.setPreferredSize(new Dimension(10,0)); //set dimensions as needed to center grid objects
		
		//Error Label
		errorLabel = new JLabel();
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);		
		
		streetField = new JTextField(16);
		cityField = new JTextField(10);
		stateField = new JTextField (2);
		zipField = new JTextField (4);
		
		emailField = new JTextField(12);
		confirmEmailField = new JTextField(12);
		phoneNumberField = new JTextField(10);
		
		submitButton = new JButton("Submit");
		
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
		inputLayout.add(emailLabel,c);
		c.gridx++;
		c.gridwidth = 2;
		inputLayout.add(emailField,c);
		
		c.insets = new Insets(5,5,0,0);	
		c.gridy = 5;
		c.gridx = 0;
		c.gridwidth = 1;
		inputLayout.add(confirmEmailLabel,c);
		c.gridx++;
		c.gridwidth = 2;
		inputLayout.add(confirmEmailField,c);
		
		c.gridy = 6;
		c.gridx = 0;
		c.gridwidth = 1;
		inputLayout.add(phoneNumberLabel,c);
		c.gridx++;
		inputLayout.add(phoneNumberField,c);
		
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS)); 
		
		buttonLayout.add(submitButton);
		
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		layout.add(updateInformationLabel);
		updateInformationLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(inputLayout);
		layout.add(Box.createRigidArea(new Dimension (0,75))); //add space between it and the button panel
		layout.add(buttonLayout); //add button panel
		layout.add(Box.createRigidArea(new Dimension (0,10))); 
		layout.add(errorLabel);
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		updateInfoPanel.add(layout);
	}
	
	public JPanel getUpdateInfoPanel(){
		errorLabel.setVisible(false);
		return updateInfoPanel;
	}
	
	public void submitListener (ActionListener sl){
		submitButton.addActionListener(sl);
	}
}