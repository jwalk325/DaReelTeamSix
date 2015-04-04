import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ResetPasswordUI {
	private JPanel resetPasswordPanel;
	private JLabel resetPasswordLabel;
	private JLabel enterInfoLabel;
	private JLabel newPasswordLabel;
	private JLabel confirmPasswordLabel;
	private JTextField newPasswordField;
	private JTextField confirmPasswordField;
	private JButton resetPasswordButton;
	private JButton backButton;
	
	public ResetPasswordUI(){
		resetPasswordPanel = new JPanel();
		resetPasswordPanel.setBackground(Color.WHITE);
		
		resetPasswordLabel = new JLabel("Reset Password");
		resetPasswordLabel.setFont(new Font("Helvetica",Font.BOLD, 20));
		enterInfoLabel = new JLabel("Enter New Password Below");
		enterInfoLabel.setFont(new Font("Helvetica",Font.PLAIN, 14));
		newPasswordLabel = new JLabel("New Password:", SwingConstants.RIGHT);
		confirmPasswordLabel = new JLabel("Confirm Password:");
		newPasswordField = new JTextField(15);
		confirmPasswordField = new JTextField(15);
		resetPasswordButton = new JButton("Reset Password");
		backButton = new JButton("Back");
		
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
		
		resetPasswordLabel.setAlignmentX(resetPasswordLabel.CENTER_ALIGNMENT);
		enterInfoLabel.setAlignmentX(enterInfoLabel.CENTER_ALIGNMENT);
		resetPasswordButton.setAlignmentX(resetPasswordButton.CENTER_ALIGNMENT);
		backButton.setAlignmentX(backButton.CENTER_ALIGNMENT);
		
		resetPasswordPanel.add(layout);
	}
	
	public JPanel getResetPasswordPanel(){
		return resetPasswordPanel;
	}
	
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void resetPasswordListener (ActionListener rpl){
		resetPasswordButton.addActionListener(rpl);
	}
}
