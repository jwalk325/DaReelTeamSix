import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ResetPasswordUI {
	private JPanel resetPasswordPanel;
	private JLabel resetPasswordLabel;
	private JLabel enterInfoLabel;
	private JLabel newPasswordLabel;
	private JLabel confirmPasswordLabel;
	private JLabel errorLabel;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;
	private JButton resetPasswordButton;
	private JButton backButton;
	
	private String newPassword;
	
	public ResetPasswordUI(){
		resetPasswordPanel = new JPanel();
		resetPasswordPanel.setBackground(Color.WHITE);
		
		resetPasswordLabel = new JLabel("Reset Password");
		resetPasswordLabel.setFont(new Font("Helvetica",Font.BOLD, 20));
		enterInfoLabel = new JLabel("Enter New Password Below");
		enterInfoLabel.setFont(new Font("Helvetica",Font.PLAIN, 14));
		newPasswordLabel = new JLabel("New Password:", SwingConstants.RIGHT);
		confirmPasswordLabel = new JLabel("Confirm Password:");
		newPasswordField = new JPasswordField(15);
		confirmPasswordField = new JPasswordField(15);
		newPasswordField.setEchoChar('*');
		confirmPasswordField.setEchoChar('*');
		resetPasswordButton = new JButton("Reset Password");
		backButton = new JButton("Back");
		
		errorLabel = new JLabel();
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);	
		
		JPanel passwordLayout = new JPanel();
		passwordLayout.setBackground(Color.WHITE);
		passwordLayout.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.insets = new Insets(5,5,0,0);	
		c.gridx = 0;
		c.gridy = 0;
		passwordLayout.add(newPasswordLabel,c);
		c.gridx++;
		passwordLayout.add(newPasswordField,c);
		
		c.gridx = 0;
		c.gridy = 1;
		passwordLayout.add(confirmPasswordLabel,c);
		c.gridx++;
		passwordLayout.add(confirmPasswordField,c);
		
		JPanel layout = new JPanel();
		layout.setBackground(Color.WHITE);
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		
		layout.add(Box.createRigidArea(new Dimension (0,50)));
		layout.add(resetPasswordLabel);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(enterInfoLabel);
		layout.add(Box.createRigidArea(new Dimension (0,37)));
		layout.add(passwordLayout);
		layout.add(Box.createRigidArea(new Dimension (0,15)));
		layout.add(resetPasswordButton);
		layout.add(Box.createRigidArea(new Dimension (0,5)));
		layout.add(backButton);
		layout.add(Box.createRigidArea(new Dimension (0,10))); 
		layout.add(errorLabel);
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		resetPasswordLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		enterInfoLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		resetPasswordButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		backButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		resetPasswordPanel.add(layout);
	}
	
	public JPanel getResetPasswordPanel(){
		errorLabel.setText(" ");
		return resetPasswordPanel;
	}
	
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void resetPasswordListener (ActionListener rpl){
		resetPasswordButton.addActionListener(rpl);
	}
	
	public boolean check(Patient p){
		char[] pass = newPasswordField.getPassword();
		char [] confirmPass = confirmPasswordField.getPassword();
		String password = new String(pass);		
		String confirmPassword = new String(confirmPass);
		
		if(password.isEmpty()){
			errorLabel.setText("New Password field is empty!");
			return false;
		}
		else if(confirmPassword.isEmpty()){
			errorLabel.setText("Confirm Password field is empty!");
			return false;
		}
		else if(password.equals(confirmPassword) == false){
			errorLabel.setText("New Password and Confirm Password do not match!");
			return false;
		}
		else{
			p.setPassword(password);//CHANGE PASSWORD
			return true;
		}	
	}
	
	public void clear(){
		newPasswordField.setText("");
		confirmPasswordField.setText("");
	}
	
	//get method
	public String getNewPassword(){
		char[] pass = newPasswordField.getPassword();
		newPassword = new String(pass);
		return newPassword;
	}
}
