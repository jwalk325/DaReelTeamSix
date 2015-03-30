import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUIController{
	private JPanel mainPanel = new JPanel();
	private WelcomeUI welcomeUI  = new WelcomeUI();
	private NewPatientUI newPatientUI = new NewPatientUI();
	private PatientLoginUI patientLoginUI = new PatientLoginUI();
	private DoctorLoginUI doctorLoginUI = new DoctorLoginUI();
	
	
	public GUIController(){
		mainPanel.add(welcomeUI.getWelcomePanel());
		mainPanel.setBackground(Color.WHITE);
		
		JFrame frame = new JFrame();
		frame.setTitle("Patient Care System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.getContentPane().setBackground(Color.WHITE);
		
		welcomeUI.newPatientListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(newPatientUI.getNewPatientPanel());
		    	 frame.setTitle("New Patient Sign-Up");
		    }
		});
		
		welcomeUI.existingPatientListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(patientLoginUI.getPatientLoginPanel());
		    	 frame.setTitle("Returning Patient Log-In");
		    }
		});
		
		welcomeUI.doctorLoginListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(doctorLoginUI.getDoctorLoginPanel());
		    	 frame.setTitle("Doctor Log-In");
		    }
		});
		
		newPatientUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcomeUI.getWelcomePanel());
		    	 frame.setTitle("Patient Care System");
		    }
		});
		
		patientLoginUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcomeUI.getWelcomePanel());
		    	 frame.setTitle("Patient Care System");
		    }
		});
		
		doctorLoginUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcomeUI.getWelcomePanel());
		    	 frame.setTitle("Patient Care System");
		    }
		});
	}
}

