//Symptoms1UI returns a JPanel that contains all UI elements for Symptoms 1 GUI
//this UI allows the patient to rank their symptom severity from 0-10 for the last 3 symptoms
//patients can also add any additional comments about their symptoms

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Symptoms2UI {
	//instance data
	private JPanel symptoms2Panel;
	private JLabel feelingLabel;
	private JLabel noneLabel1;
	private JLabel noneLabel2;
	private JLabel noneLabel3;
	private JLabel severeLabel1;
	private JLabel severeLabel2;
	private JLabel severeLabel3;
	private JLabel depressionLabel;
	private JLabel drowsinessLabel;
	private JLabel anxietyLabel;
	private JLabel commentsLabel;
	private JLabel filler;
	private JTextArea commentsArea;
	private JScrollPane commentsPane;
	private JSlider depressionSlider;
	private JSlider drowsinessSlider;
	private JSlider anxietySlider;
	private JButton backButton;
	private JButton finishButton;
	
	private int depression;
	private int anxiety;
	private int drowsiness;
	private String comments;
	
	public Symptoms2UI(){
		//initialize main panel
		symptoms2Panel = new JPanel();
		symptoms2Panel.setBackground(Color.WHITE);
		
		//initialize instance data
		//labels
		feelingLabel = new JLabel("How Are You Feeling? (2/2)");
		feelingLabel.setFont(new Font("Helvetica",Font.BOLD, 22));
		
		noneLabel1 = new JLabel("None", SwingConstants.CENTER);
		noneLabel2 = new JLabel("None", SwingConstants.CENTER);
		noneLabel3 = new JLabel("None", SwingConstants.CENTER);
		severeLabel1 = new JLabel("Severe", SwingConstants.CENTER);
		severeLabel2 = new JLabel("Severe", SwingConstants.CENTER);
		severeLabel3 = new JLabel("Severe", SwingConstants.CENTER);
		depressionLabel = new JLabel("Depression", SwingConstants.CENTER);
		depressionLabel.setFont(new Font("Helvetica",Font.BOLD, 14));
		drowsinessLabel = new JLabel("Drowsiness", SwingConstants.CENTER);
		drowsinessLabel.setFont(new Font("Helvetica",Font.BOLD, 14));
		anxietyLabel = new JLabel("Anxiety", SwingConstants.CENTER);
		anxietyLabel.setFont(new Font("Helvetica",Font.BOLD, 14));
		commentsLabel = new JLabel("Comments:");
		filler = new JLabel(""); //filler is a blank JLabel
		filler.setPreferredSize(new Dimension(5,5)); //set dimensions as needed to center grid objects
		
		//comment area and its scroll pane
		commentsArea = new JTextArea(4,0);
		commentsArea.setLineWrap(true);
		commentsArea.setWrapStyleWord(true);
		commentsPane = new JScrollPane(commentsArea);
		commentsPane.setBackground(Color.LIGHT_GRAY);
		commentsPane.setMaximumSize(new Dimension(300,300));
		
		//sliders
		depressionSlider = new JSlider(JSlider.VERTICAL,0, 10, 0);
		depressionSlider.setMajorTickSpacing(1);
		depressionSlider.setFont(new Font("Helvetica",Font.PLAIN,10));
		depressionSlider.setPaintLabels(true);
		depressionSlider.setPaintTicks(true);		
		depressionSlider.setAlignmentX(JSlider.LEFT_ALIGNMENT);
		drowsinessSlider = new JSlider(JSlider.VERTICAL,0, 10, 0);
		drowsinessSlider.setMajorTickSpacing(1);
		drowsinessSlider.setFont(new Font("Helvetica",Font.PLAIN,10));
		drowsinessSlider.setPaintLabels(true);
		drowsinessSlider.setPaintTicks(true);
		anxietySlider = new JSlider(JSlider.VERTICAL,0, 10, 0);
		anxietySlider.setMajorTickSpacing(1);
		anxietySlider.setFont(new Font("Helvetica",Font.PLAIN,10));
		anxietySlider.setPaintLabels(true);
		anxietySlider.setPaintTicks(true);
		
		//buttons
		backButton = new JButton("Back");
		finishButton = new JButton("Finish");
		
		//create JPanel to hold input elements
		JPanel inputLayout = new JPanel();		
		inputLayout.setLayout(new GridBagLayout());
		inputLayout.setBackground(Color.WHITE); //background color

		//add elemetns to inputLayout
		GridBagConstraints c = new GridBagConstraints(); //create variable to control constraints
		c.fill = GridBagConstraints.NONE; //determines if object takes available space in vertical and/or horizontal directions
		
		c.insets = new Insets(0,50,0,47);
		c.gridx = 0; //top-left corner of window is considered (0,0). 
		c.gridy = 0;
		inputLayout.add(severeLabel1,c);
		c.gridx++;
		inputLayout.add(severeLabel2,c);
		c.insets = new Insets(0,47,0,49);
		c.gridx++;
		inputLayout.add(severeLabel3,c);	
		
		c.insets = new Insets(0,49,0,47);
		c.gridy = 1;
		c.gridx = 0;
		inputLayout.add(depressionSlider,c);
		c.gridx++;
		inputLayout.add(anxietySlider,c);
		c.insets = new Insets(0,47,0,49);
		c.gridx++;		
		inputLayout.add(drowsinessSlider,c);
		
		c.insets = new Insets(0,49,0,47);
		c.gridy = 2;
		c.gridx = 0;
		inputLayout.add(noneLabel1,c);
		c.gridx++;
		inputLayout.add(noneLabel2,c);
		c.insets = new Insets(0,47,0,47);
		c.gridx++;
		inputLayout.add(noneLabel3,c);
		
		c.insets = new Insets(5,47,0,47);
		c.gridy = 3;
		c.gridx = 0;
		inputLayout.add(depressionLabel,c);
		c.gridx++;
		inputLayout.add(anxietyLabel,c);
		c.insets = new Insets(5,47,0,49);
		c.gridx++;
		inputLayout.add(drowsinessLabel,c);			
		
		//create JPanel to hold title and add
		JPanel titleLayout = new JPanel();
		titleLayout.setBackground(Color.WHITE);
		titleLayout.setLayout(new BoxLayout(titleLayout, BoxLayout.X_AXIS));
		titleLayout.add(feelingLabel);
		titleLayout.add(Box.createRigidArea(new Dimension (2,0)));

		//create JPanel to hold comment UI elements
		JPanel commentsLayout = new JPanel();
		commentsLayout.setBackground(Color.WHITE);
		commentsLayout.setLayout(new BoxLayout(commentsLayout, BoxLayout.X_AXIS)); 
		
		//add elements to commentsLayout
		commentsLayout.add(commentsLabel);
		commentsLayout.add(Box.createRigidArea(new Dimension (5,0)));
		commentsLayout.add(commentsPane);
		commentsLayout.add(Box.createRigidArea(new Dimension (2,0)));

		//create JPanel to hold buttons
		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS)); 
		
		//add elements to buttonLayout
		buttonLayout.add(backButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (150,0)));
		buttonLayout.add(finishButton);
		
		//create JPanel to hold all UI elements
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		//add all UI elements to layout
		layout.add(Box.createRigidArea(new Dimension (0,15)));//add space to top so label isn't smashed at the top
		layout.add(titleLayout);
		layout.add(Box.createRigidArea(new Dimension (0,15))); //add space between label and middle panel
		layout.add(inputLayout); //add the grid panel
		layout.add(Box.createRigidArea(new Dimension (0,25))); //add space between it and the button panel
		layout.add(commentsLayout);
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(buttonLayout); //add button panel
		layout.add(Box.createRigidArea(new Dimension (0,50))); //add space to the bottom
		
		symptoms2Panel.add(layout);	//add layout to main panel	
	}
	
	//returns JPanel with all UI elements
	public JPanel getSymptoms2Panel(){
		return symptoms2Panel;
	}
	
	//add action listeners to buttons
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
	
	public void finishListener (ActionListener fl){
		finishButton.addActionListener(fl);
	}
	
	//clear method to reset UI elements
	public void clear(){
		depressionSlider.setValue(0);
		anxietySlider.setValue(0);
		drowsinessSlider.setValue(0);
		commentsArea.setText("");
	}
	
	//get methods
	public int getDepression(){
		depression = depressionSlider.getValue();
		return depression;
	}
	
	public int getAnxiety(){
		anxiety = anxietySlider.getValue();
		return anxiety;
	}
	
	public int getDrowsiness(){
		drowsiness = drowsinessSlider.getValue();
		return drowsiness;
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
