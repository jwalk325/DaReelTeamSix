import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Symptoms2UI {
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
	
	public Symptoms2UI(){
		symptoms2Panel = new JPanel();
		symptoms2Panel.setBackground(Color.WHITE);
		
		feelingLabel = new JLabel("How Are You Feeling?");
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
		
		commentsArea = new JTextArea(4,0);
		commentsArea.setLineWrap(true);
		commentsPane = new JScrollPane(commentsArea);
		commentsPane.setMaximumSize(new Dimension(300,300));
		
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

		backButton = new JButton("Back");
		finishButton = new JButton("Finish");
		
		JPanel inputLayout = new JPanel();		
		inputLayout.setLayout(new GridBagLayout());
		inputLayout.setBackground(Color.WHITE); //background color

		GridBagConstraints c = new GridBagConstraints(); //create variable to control constraints
		c.fill = GridBagConstraints.NONE; //determines if object takes available space in vertical and/or horizontal directions
		
		c.insets = new Insets(0,47,0,47);
		c.gridx = 0; //top-left corner of window is considered (0,0). 
		c.gridy = 0;
		inputLayout.add(severeLabel1,c);
		c.gridx++;
		inputLayout.add(severeLabel2,c);
		c.gridx++;
		inputLayout.add(severeLabel3,c);	
		
		c.gridy = 1;
		c.gridx = 0;
		inputLayout.add(depressionSlider,c);
		c.gridx++;
		inputLayout.add(anxietySlider,c);
		c.gridx++;
		inputLayout.add(drowsinessSlider,c);
		
		c.gridy = 2;
		c.gridx = 0;
		inputLayout.add(noneLabel1,c);
		c.gridx++;
		inputLayout.add(noneLabel2,c);
		c.gridx++;
		inputLayout.add(noneLabel3,c);
		
		c.insets = new Insets(5,47,0,47);
		c.gridy = 3;
		c.gridx = 0;
		inputLayout.add(depressionLabel,c);
		c.gridx++;
		inputLayout.add(anxietyLabel,c);
		c.gridx++;
		inputLayout.add(drowsinessLabel,c);			
		
		JPanel commentsLayout = new JPanel();
		commentsLayout.setBackground(Color.WHITE);
		commentsLayout.setLayout(new BoxLayout(commentsLayout, BoxLayout.X_AXIS)); 
		
		commentsLayout.add(commentsLabel);
		commentsLayout.add(Box.createRigidArea(new Dimension (5,0)));
		commentsLayout.add(commentsPane);

		JPanel buttonLayout = new JPanel();
		buttonLayout.setBackground(Color.WHITE);
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS)); 
		
		buttonLayout.add(backButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (140,0)));
		buttonLayout.add(finishButton);
		
		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		layout.setBackground(Color.WHITE);
		
		//Adding title label on top, followed by the panel with grid of labels and text fields, and finally button panel on bottom.
		layout.add(Box.createRigidArea(new Dimension (0,15)));//add space to top so label isn't smashed at the top
		layout.add(feelingLabel);
		feelingLabel.setAlignmentX(feelingLabel.CENTER_ALIGNMENT);
		layout.add(Box.createRigidArea(new Dimension (0,15))); //add space between label and middle panel
		layout.add(inputLayout); //add the grid panel
		layout.add(Box.createRigidArea(new Dimension (0,25))); //add space between it and the button panel
		layout.add(commentsLayout);
		layout.add(Box.createRigidArea(new Dimension (0,25)));
		layout.add(buttonLayout); //add button panel
		layout.add(Box.createRigidArea(new Dimension (0,50))); //add space to the bottom
		
		symptoms2Panel.add(layout);		
	}
	
	public JPanel getSymptoms2Panel(){
		return symptoms2Panel;
	}
	
	public void backListener (ActionListener bl){
		backButton.addActionListener(bl);
	}
}
