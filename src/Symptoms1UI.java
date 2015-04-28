import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Symptoms1UI {
	private JPanel symptoms1Panel;
	private JLabel feelingLabel;
	private JLabel noneLabel1;
	private JLabel noneLabel2;
	private JLabel noneLabel3;
	private JLabel severeLabel1;
	private JLabel severeLabel2;
	private JLabel severeLabel3;
	private JLabel painLabel;
	private JLabel tirednessLabel;
	private JLabel nasueaLabel;
	private JLabel commentsLabel;
	private JLabel filler;
	private JTextArea commentsArea;
	private JScrollPane commentsPane;
	private JSlider painSlider;
	private JSlider tirednessSlider;
	private JSlider nasueaSlider;
	private JButton nextButton;
	private JButton logoutButton;
	
	private int pain;
	private int tiredness;
	private int nasuea;
	private String comments;
	
	public Symptoms1UI(){
		symptoms1Panel = new JPanel();
		symptoms1Panel.setBackground(Color.WHITE);
		
		feelingLabel = new JLabel("How Are You Feeling? (1/2)");
		feelingLabel.setFont(new Font("Helvetica",Font.BOLD, 22));
		
		noneLabel1 = new JLabel("None", SwingConstants.CENTER);
		noneLabel2 = new JLabel("None", SwingConstants.CENTER);
		noneLabel3 = new JLabel("None", SwingConstants.CENTER);
		severeLabel1 = new JLabel("Severe", SwingConstants.CENTER);
		severeLabel2 = new JLabel("Severe", SwingConstants.CENTER);
		severeLabel3 = new JLabel("Severe", SwingConstants.CENTER);
		painLabel = new JLabel("Pain", SwingConstants.CENTER);
		painLabel.setFont(new Font("Helvetica",Font.BOLD, 14));
		tirednessLabel = new JLabel("Tiredness", SwingConstants.CENTER);
		tirednessLabel.setFont(new Font("Helvetica",Font.BOLD, 14));
		nasueaLabel = new JLabel("Nausea", SwingConstants.CENTER);
		nasueaLabel.setFont(new Font("Helvetica",Font.BOLD, 14));
		commentsLabel = new JLabel("Comments:");
		filler = new JLabel(""); //filler is a blank JLabel
		filler.setPreferredSize(new Dimension(5,5)); //set dimensions as needed to center grid objects
		
		commentsArea = new JTextArea(4,0);
		commentsArea.setLineWrap(true);
		commentsArea.setWrapStyleWord(true);
		commentsPane = new JScrollPane(commentsArea);
		commentsPane.setBackground(Color.LIGHT_GRAY);
		commentsPane.setMaximumSize(new Dimension(300,300));
		
		painSlider = new JSlider(JSlider.VERTICAL,0, 10, 0);
		painSlider.setMajorTickSpacing(1);
		painSlider.setFont(new Font("Helvetica",Font.PLAIN,10));
		painSlider.setPaintLabels(true);
		painSlider.setPaintTicks(true);		
		painSlider.setAlignmentX(JSlider.LEFT_ALIGNMENT);
		tirednessSlider = new JSlider(JSlider.VERTICAL,0, 10, 0);
		tirednessSlider.setMajorTickSpacing(1);
		tirednessSlider.setFont(new Font("Helvetica",Font.PLAIN,10));
		tirednessSlider.setPaintLabels(true);
		tirednessSlider.setPaintTicks(true);
		nasueaSlider = new JSlider(JSlider.VERTICAL,0, 10, 0);
		nasueaSlider.setMajorTickSpacing(1);
		nasueaSlider.setFont(new Font("Helvetica",Font.PLAIN,10));
		nasueaSlider.setPaintLabels(true);
		nasueaSlider.setPaintTicks(true);
	
		nextButton = new JButton("Next");
		logoutButton = new JButton("Log Out");
		
		JPanel inputLayout = new JPanel();		
		inputLayout.setLayout(new GridBagLayout());
		inputLayout.setBackground(Color.WHITE); //background color

		GridBagConstraints c = new GridBagConstraints(); //create variable to control constraints
		c.fill = GridBagConstraints.NONE; //determines if object takes available space in vertical and/or horizontal directions
		
		c.insets = new Insets(0,50,0,50);
		c.gridx = 0; //top-left corner of window is considered (0,0). 
		c.gridy = 0;
		inputLayout.add(severeLabel1,c);
		c.gridx++;
		inputLayout.add(severeLabel2,c);
		c.gridx++;
		inputLayout.add(severeLabel3,c);	
		
		c.gridy = 1;
		c.gridx = 0;
		inputLayout.add(painSlider,c);
		c.gridx++;
		inputLayout.add(tirednessSlider,c);
		c.gridx++;
		inputLayout.add(nasueaSlider,c);
		
		c.gridy = 2;
		c.gridx = 0;
		inputLayout.add(noneLabel1,c);
		c.gridx++;
		inputLayout.add(noneLabel2,c);
		c.gridx++;
		inputLayout.add(noneLabel3,c);
		
		c.insets = new Insets(5,50,0,50);
		c.gridy = 3;
		c.gridx = 0;
		inputLayout.add(painLabel,c);
		c.gridx++;
		inputLayout.add(tirednessLabel,c);
		c.gridx++;
		inputLayout.add(nasueaLabel,c);						
		
		JPanel commentsLayout = new JPanel();
		commentsLayout.setBackground(Color.WHITE);
		commentsLayout.setLayout(new BoxLayout(commentsLayout, BoxLayout.X_AXIS)); 
		
		commentsLayout.add(commentsLabel);
		commentsLayout.add(Box.createRigidArea(new Dimension (5,0)));
		commentsLayout.add(commentsPane);

		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS)); 
		
		buttonLayout.add(logoutButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (140,0)));
		buttonLayout.add(nextButton);
		
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		//Adding title label on top, followed by the panel with grid of labels and text fields, and finally button panel on bottom.
		layout.add(Box.createRigidArea(new Dimension (0,15)));//add space to top so label isn't smashed at the top
		layout.add(feelingLabel);
		feelingLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,15))); //add space between label and middle panel
		layout.add(inputLayout); //add the grid panel
		layout.add(Box.createRigidArea(new Dimension (0,25))); //add space between it and the button panel
		layout.add(commentsLayout);
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(buttonLayout); //add button panel
		layout.add(Box.createRigidArea(new Dimension (0,50))); //add space to the bottom
		
		symptoms1Panel.add(layout);		
	}
	
	public JPanel getSymptoms1Panel(){
		return symptoms1Panel;
	}
	
	public void nextListener (ActionListener nl){
		nextButton.addActionListener(nl);
	}
	
	public void logoutListener (ActionListener ll){
		logoutButton.addActionListener(ll);
	}
	
	public void clear(){
		painSlider.setValue(0);
		tirednessSlider.setValue(0);
		nasueaSlider.setValue(0);
		commentsArea.setText("");
	}
	
	//get methods
	public int getPain(){
		pain = painSlider.getValue();
		return pain;
	}
	
	public int getTiredness(){
		tiredness = tirednessSlider.getValue();
		return tiredness;
	}
	
	public int getNasuea(){
		nasuea = nasueaSlider.getValue();
		return nasuea;
	}
	
	public String getComments(){
		if(commentsArea.getText().trim().length() != 0){
			comments = commentsArea.getText();
			return comments;
		}
		else
			return "None.";
	}
}
