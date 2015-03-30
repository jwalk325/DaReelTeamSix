import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIController{
	//Instance data for UIs
	private JPanel mainPanel = new JPanel();
	private WelcomeUI welcomeUI  = new WelcomeUI();
	private NewPatientUI newPatientUI = new NewPatientUI();
	private PatientLoginUI patientLoginUI = new PatientLoginUI();
	private DoctorLoginUI doctorLoginUI = new DoctorLoginUI();
	
	public GUIController(){
		//add welcomeUI to main JPanel
		mainPanel.add(welcomeUI.getWelcomePanel());
		mainPanel.setBackground(Color.WHITE);
		
		//create frame with appropriate attributes
		JFrame frame = new JFrame();
		frame.setTitle("Patient Care System"); //menu bar text
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close application when frame is closed
		frame.getContentPane().add(mainPanel); //add main Panel to frame
		frame.setSize(500, 500); //window size
		frame.setResizable(false); //do not allow window to be resized
		frame.getContentPane().setBackground(Color.WHITE); //color
		frame.setVisible(true); //frame is visible
		
		//Action performed when New Patient button is pushed on welcome UI
		welcomeUI.newPatientListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll(); //remove everything from main panel
		    	 mainPanel.revalidate(); //revalidate the panel
		    	 mainPanel.repaint(); //repaint the panel
		    	 
		    	 mainPanel.add(newPatientUI.getNewPatientPanel()); //bring up the New Patient UI
		    	 //frame.setTitle("New Patient Sign-Up");
		    }
		});
		
		//Action performed when Returning Patient button is pushed on welcome UI
		welcomeUI.existingPatientListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(patientLoginUI.getPatientLoginPanel());
		    	 //frame.setTitle("Returning Patient Log-In");
		    }
		});
		
		//Action performed when Doctor Login button is pushed in welcome UI
		welcomeUI.doctorLoginListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(doctorLoginUI.getDoctorLoginPanel());
		    	 //frame.setTitle("Doctor Log-In");
		    }
		});
		
		//Action performed when back button is pushed in New Patient UI
		newPatientUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcomeUI.getWelcomePanel());
		    	 //frame.setTitle("Patient Care System");
		    }
		});
		
		//Action performed when back button is pushed in Patient Login UI
		patientLoginUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcomeUI.getWelcomePanel());
		    	 //frame.setTitle("Patient Care System");
		    }
		});
		
		//Action performed when back button is pushed in Doctor Login UI
		doctorLoginUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcomeUI.getWelcomePanel());
		    	 //frame.setTitle("Patient Care System");
		    }
		});
	}
}