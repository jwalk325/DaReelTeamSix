import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LostPasswordUI {
	private JPanel lostPasswordPanel;
	private JLabel lostPasswordLabel;
	private JLabel enterInfoLabel;
	private JLabel emailLabel;
	private JLabel errorLabel;
	private JTextField emailField;
	private JButton continueButton;
	private JButton backButton;
	
	private String email;
	private final String INITIAL_EMAIL = "example@domain.com";
	
	public LostPasswordUI(){
		lostPasswordPanel = new JPanel();
		lostPasswordPanel.setBackground(Color.WHITE);
		
		lostPasswordLabel = new JLabel("Lost Password?");
		lostPasswordLabel.setFont(new Font("Helvetica",Font.BOLD, 20));
		enterInfoLabel = new JLabel("Enter Information Below");
		enterInfoLabel.setFont(new Font("Helvetica",Font.PLAIN, 14));
		emailLabel = new JLabel("E-mail:");
		emailField = new JTextField(INITIAL_EMAIL,15);
		emailField.setForeground(Color.LIGHT_GRAY);
		continueButton = new JButton("Continue");
		backButton = new JButton("Back to Log In");
		
		emailField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (emailField.getText().equals(INITIAL_EMAIL)) {
	                emailField.setText("");
	                emailField.setForeground(Color.BLACK);
	            }

	        }

	        public void focusLost(FocusEvent e) {
	        	if (emailField.getText().isEmpty())
	            {
	                emailField.setForeground(Color.LIGHT_GRAY);
	                emailField.setText(INITIAL_EMAIL);
	            }
	        }
	    });
		
		errorLabel = new JLabel();
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);	
		
		JPanel emailLayout = new JPanel();
		emailLayout.setBackground(Color.WHITE);
		emailLayout.setLayout(new BoxLayout(emailLayout, BoxLayout.X_AXIS));
		
		emailLayout.add(emailLabel);
		emailLayout.add(Box.createRigidArea(new Dimension (5,0)));
		emailLayout.add(emailField);
		emailLayout.add(Box.createRigidArea(new Dimension (52,0)));
		
		JPanel layout = new JPanel();
		layout.setBackground(Color.WHITE);
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		layout.add(lostPasswordLabel);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(enterInfoLabel);
		layout.add(Box.createRigidArea(new Dimension (0,75)));
		layout.add(emailLayout);
		layout.add(Box.createRigidArea(new Dimension (0,15)));
		layout.add(continueButton);
		layout.add(Box.createRigidArea(new Dimension (0,5)));
		layout.add(backButton);
		layout.add(Box.createRigidArea(new Dimension (0,10))); 
		layout.add(errorLabel);
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		lostPasswordLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		enterInfoLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		continueButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		backButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		lostPasswordPanel.add(layout);
	}
	
	public JPanel getLostPasswordPanel(){
		errorLabel.setText(" ");
		return lostPasswordPanel;
	}
	
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void continueListener (ActionListener cl){
		continueButton.addActionListener(cl);
	}
	
	public Patient check(PatientLinkedList patientList){
		String email = emailField.getText();
		//create temporary patient by looking up email
		Patient p = patientList.searchByEmail(email);
			
		if(email.equals(INITIAL_EMAIL) || email.isEmpty()){
			errorLabel.setText("E-Mail field is empty!");
			return null;
		}
		else if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") == false){
			errorLabel.setText("E-mail format is not valid!");
			return null;
		}
		else if (p == null)
		{
			errorLabel.setText("E-mail does not exist!");
			return null;
		}
		else{
			return p;
		}		
		
	}
	
	public Doctor check(DoctorLinkedList doctorList){
		String email = emailField.getText();
		//create temporary doctor by looking up email
		Doctor d = doctorList.searchByEmail(email); 
		
		if(email.equals(INITIAL_EMAIL) || email.isEmpty()){
			errorLabel.setText("E-Mail field is empty!");
			return null;
		}
		else if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") == false){
			errorLabel.setText("E-mail format is not valid!");
			return null;
		}
		else if (d == null)
		{
			errorLabel.setText("E-mail does not exist!");
			return null;
		}
		else{
			return d;
		}
	}
	
	public void clear(){
		emailField.setForeground(Color.LIGHT_GRAY);
		emailField.setText(INITIAL_EMAIL);
	}
	
	//get method
	public String getEmail(){
		email = emailField.getText();
		return email;
	}
}
