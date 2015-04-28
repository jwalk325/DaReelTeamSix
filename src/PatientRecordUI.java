import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PatientRecordUI {
	private JPanel patientRecordPanel;
	private JLabel patientRecordLabel;
	private JLabel patientNameLabel;
	private JLabel symptomsLabel;
	private JLabel painLabel;
	private JLabel tirednessLabel;
	private JLabel nasueaLabel;
	private JLabel depressionLabel;
	private JLabel drowsinessLabel;
	private JLabel anxietyLabel;
	private JLabel painValue;
	private JLabel tirednessValue;
	private JLabel nasueaValue;
	private JLabel depressionValue;
	private JLabel drowsinessValue;
	private JLabel anxietyValue;
	private JLabel severityLabel;
	private JLabel highLabel;
	private JLabel mediumLabel;
	private JLabel lowLabel;
	private JLabel patientCommentsLabel;
	private JLabel doctorCommentsLabel;
	private JLabel errorLabel;
	private JLabel filler;
	private JTextArea patientCommentsArea;
	private JTextArea doctorCommentsArea;
	private JButton backButton;
	private JButton submitButton;
	private JButton contactButton;
	private final int painThresh = 4;
	private final int tirednessThresh = 6;
	private final int nasueaThresh = 6;
	private final int depressionThresh = 4;
	private final int anxietyThresh = 4;
	private final int drowsinessThresh = 6;
	
	public PatientRecordUI(){
		patientRecordPanel = new JPanel();
		patientRecordPanel.setBackground(Color.WHITE);
		
		patientRecordLabel = new JLabel("Patient Record: ");
		patientRecordLabel.setFont(new Font("Helvetica",Font.BOLD, 24));
		patientNameLabel = new JLabel("Patient Name");
		patientNameLabel.setFont(new Font("Helvetica",Font.BOLD, 24));
		
		errorLabel = new JLabel(" ");
		errorLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		errorLabel.setForeground(Color.RED);
		
		JPanel titleLayout = new JPanel();
		titleLayout.setBackground(Color.WHITE);
		titleLayout.setLayout(new BoxLayout(titleLayout, BoxLayout.X_AXIS));
		titleLayout.add(patientRecordLabel);
		patientRecordLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		titleLayout.add(patientNameLabel);
		patientNameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		JPanel symptomsLayout = new JPanel();
		symptomsLayout.setBackground(Color.WHITE);
		symptomsLayout.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints(); //create variable to control constraints
		c.fill = GridBagConstraints.BOTH;
		
		symptomsLabel = new JLabel("        Symptoms", SwingConstants.CENTER);
		symptomsLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
		painLabel = new JLabel("Pain:", SwingConstants.RIGHT);
		tirednessLabel = new JLabel("Tiredness:", SwingConstants.RIGHT);
		nasueaLabel = new JLabel("Nausea:", SwingConstants.RIGHT);
		depressionLabel = new JLabel("Depression:", SwingConstants.RIGHT);
		drowsinessLabel = new JLabel("Drowsiness:", SwingConstants.RIGHT);
		anxietyLabel = new JLabel("Anxiety:", SwingConstants.RIGHT);
		painValue = new JLabel("0", SwingConstants.LEFT);
		tirednessValue = new JLabel("0", SwingConstants.LEFT);
		nasueaValue = new JLabel("0", SwingConstants.LEFT);
		depressionValue = new JLabel("0", SwingConstants.LEFT);
		drowsinessValue = new JLabel("0", SwingConstants.LEFT);
		anxietyValue = new JLabel("0", SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		symptomsLayout.add(symptomsLabel,c);
		
		c.insets = new Insets(5,5,0,2);	//provides space between objects
		c.gridy = 1;
		c.gridwidth = 1;
		symptomsLayout.add(painLabel,c);
		c.gridx++;
		symptomsLayout.add(painValue,c);
		
		c.gridy = 2;
		c.gridx = 0;
		symptomsLayout.add(tirednessLabel,c);
		c.gridx++;
		symptomsLayout.add(tirednessValue,c);
		
		c.gridy = 3;
		c.gridx = 0;
		symptomsLayout.add(nasueaLabel,c);
		c.gridx++;
		symptomsLayout.add(nasueaValue,c);
		
		c.gridy = 4;
		c.gridx = 0;
		symptomsLayout.add(depressionLabel,c);
		c.gridx++;
		symptomsLayout.add(depressionValue,c);
		
		c.gridy = 5;
		c.gridx = 0;
		symptomsLayout.add(anxietyLabel,c);
		c.gridx++;
		symptomsLayout.add(anxietyValue,c);

		c.gridy = 6;
		c.gridx = 0;
		symptomsLayout.add(drowsinessLabel,c);
		c.gridx++;
		symptomsLayout.add(drowsinessValue,c);

		
		JPanel severityLayout = new JPanel();
		severityLayout.setBackground(Color.WHITE);
		severityLayout.setLayout(new BoxLayout(severityLayout, BoxLayout.Y_AXIS));
		severityLabel = new JLabel("Severity");
		severityLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		highLabel = new JLabel("High");
		highLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		highLabel.setForeground(Color.RED);
		mediumLabel = new JLabel("Medium");
		mediumLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		mediumLabel.setForeground(Color.ORANGE);
		lowLabel = new JLabel("Low");
		lowLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		
		severityLayout.add(severityLabel);
		severityLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		severityLayout.add(Box.createRigidArea(new Dimension (0,10)));
		severityLayout.add(highLabel);
		highLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		severityLayout.add(Box.createRigidArea(new Dimension (0,5)));
		severityLayout.add(mediumLabel);
		mediumLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		severityLayout.add(Box.createRigidArea(new Dimension (0,5)));
		severityLayout.add(lowLabel);
		lowLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		JPanel centerLayout = new JPanel();
		centerLayout.setBackground(Color.WHITE);
		centerLayout.setLayout(new BoxLayout(centerLayout, BoxLayout.X_AXIS));
		centerLayout.add(symptomsLayout);
		centerLayout.add(Box.createRigidArea(new Dimension (85,0)));
		centerLayout.add(severityLayout);
		filler = new JLabel(" ");
		filler.setPreferredSize(new Dimension(100,0));
		centerLayout.add(filler);
		
		JPanel commentsLayout = new JPanel();
		commentsLayout.setBackground(Color.WHITE);
		commentsLayout.setLayout(new GridBagLayout());
		GridBagConstraints d = new GridBagConstraints(); //create variable to control constraints
		d.fill = GridBagConstraints.BOTH;
		
		patientCommentsLabel = new JLabel("Patient Comments", SwingConstants.CENTER);
		doctorCommentsLabel = new JLabel("Doctor Comments", SwingConstants.CENTER);
		patientCommentsArea = new JTextArea(5,17);
		patientCommentsArea.setLineWrap(true);
		patientCommentsArea.setWrapStyleWord(true);
		patientCommentsArea.setEditable(false);
		JScrollPane patientCommentsPane = new JScrollPane(patientCommentsArea);
		patientCommentsPane.setBackground(Color.LIGHT_GRAY);
		doctorCommentsArea = new JTextArea(5,17);
		doctorCommentsArea.setLineWrap(true);
		doctorCommentsArea.setWrapStyleWord(true);
		JScrollPane doctorCommentsPane = new JScrollPane(doctorCommentsArea);
		doctorCommentsPane.setBackground(Color.LIGHT_GRAY);
		
		d.insets = new Insets(5,15,0,15);	//provides space between objects
		d.gridx = 0;
		d.gridy = 0;
		commentsLayout.add(patientCommentsLabel,d);
		d.gridx++;
		commentsLayout.add(doctorCommentsLabel,d);
		
		d.gridx = 0;
		d.gridy = 1;
		commentsLayout.add(patientCommentsPane,d);
		d.gridx++;
		commentsLayout.add(doctorCommentsPane,d);
		
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS));
		backButton = new JButton("Back");
		submitButton = new JButton("Submit");
		contactButton = new JButton("Contact");
		buttonLayout.add(backButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (163,0)));
		buttonLayout.add(contactButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (5,0)));
		buttonLayout.add(submitButton);
		
		JPanel layout = new JPanel();
		layout.setBackground(Color.WHITE);
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(titleLayout);
		layout.add(Box.createRigidArea(new Dimension (0,35)));
		layout.add(centerLayout);
		layout.add(Box.createRigidArea(new Dimension (0,35)));
		layout.add(commentsLayout);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(errorLabel);
		errorLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,10)));
		layout.add(buttonLayout);

		
		patientRecordPanel.add(layout);
	}
	
	public JPanel getPatientRecordPanel(){
		return patientRecordPanel;
	}
	
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void submitListener (ActionListener sl){
		submitButton.addActionListener(sl);
	}
	
	public void contactListener (ActionListener cl){
		contactButton.addActionListener(cl);
	}
	
	public void error(){
		errorLabel.setText("Record already submitted!");
	}
	
	public boolean check(){
		if(doctorCommentsArea.getText().isEmpty()){
			errorLabel.setText("Please enter comments before submitting.");
			return false;
		}
		else{
			return true;
		}
	}
	
	public void clear(){
		errorLabel.setText(" ");
		doctorCommentsArea.setText("");
		painValue.setForeground(Color.BLACK);
		tirednessValue.setForeground(Color.BLACK);
		nasueaValue.setForeground(Color.BLACK);
		depressionValue.setForeground(Color.BLACK);
		anxietyValue.setForeground(Color.BLACK);
		drowsinessValue.setForeground(Color.BLACK);
	}
	
	public void clear2(){
		errorLabel.setText(" ");
	}
	
	public void setPatientName(String name){
		patientNameLabel.setText(name);
	}
	
	public void setPain(int pain){
		painValue.setText(Integer.toString(pain));
	}
	
	public void setTiredness(int tiredness){
		tirednessValue.setText(Integer.toString(tiredness));
	}
	
	public void setNasuea(int nasuea){
		nasueaValue.setText(Integer.toString(nasuea));
	}
	
	public void setDepression(int depression){
		depressionValue.setText(Integer.toString(depression));
	}
	
	public void setDrowsiness(int drowsiness){
		drowsinessValue.setText(Integer.toString(drowsiness));
	}
	
	public void setAnxiety(int anxiety){
		anxietyValue.setText(Integer.toString(anxiety));
	}
	
	public void setPatientComments(String comments){
		patientCommentsArea.setText(comments);
	}
	
	public void setDoctorComments(String comments){
		doctorCommentsArea.setText(comments);
	}
	
	public String getPatientName(){
		return patientNameLabel.getText();
	}
	
	public String getDoctorComments(){
		return doctorCommentsArea.getText();
	}
	
	public void colorSymptoms(){
		if(Integer.parseInt(painValue.getText()) >= painThresh + 3){
			painValue.setForeground(Color.RED);
		}
		else if(Integer.parseInt(painValue.getText()) >= painThresh + 2){
			painValue.setForeground(Color.ORANGE);
		}
		if(Integer.parseInt(tirednessValue.getText()) >= tirednessThresh + 3){
			tirednessValue.setForeground(Color.RED);
		}
		else if(Integer.parseInt(tirednessValue.getText()) >= tirednessThresh + 2){
			tirednessValue.setForeground(Color.ORANGE);
		}
		if(Integer.parseInt(nasueaValue.getText()) >= nasueaThresh + 3){
			nasueaValue.setForeground(Color.RED);
		}
		else if(Integer.parseInt(nasueaValue.getText()) >= nasueaThresh + 2){
			nasueaValue.setForeground(Color.ORANGE);
		}
		if(Integer.parseInt(depressionValue.getText()) >= depressionThresh + 3){
			depressionValue.setForeground(Color.RED);
		}
		else if(Integer.parseInt(depressionValue.getText()) >= depressionThresh + 2){
			depressionValue.setForeground(Color.ORANGE);
		}
		if(Integer.parseInt(anxietyValue.getText()) >= anxietyThresh + 3){
			anxietyValue.setForeground(Color.RED);
		}
		else if(Integer.parseInt(anxietyValue.getText()) >= anxietyThresh + 2){
			anxietyValue.setForeground(Color.ORANGE);
		}
		if(Integer.parseInt(drowsinessValue.getText()) >= drowsinessThresh + 3){
			drowsinessValue.setForeground(Color.RED);
		}
		else if(Integer.parseInt(drowsinessValue.getText()) >= drowsinessThresh + 2){
			drowsinessValue.setForeground(Color.ORANGE);
		}
	}
}
