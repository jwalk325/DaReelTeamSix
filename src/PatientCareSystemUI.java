import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PatientCareSystemUI{
	private JPanel mainPanel = new JPanel();
	private WelcomeUI welcome  = new WelcomeUI();
	private NewUserUI newUser = new NewUserUI();
	private PatientLoginUI patient = new PatientLoginUI();
	private DoctorLoginUI doctor = new DoctorLoginUI();
	
	
	public PatientCareSystemUI(){
		mainPanel.add(welcome.getWelcomePanel());
		mainPanel.setBackground(Color.WHITE);
		
		JFrame frame = new JFrame();
		frame.setTitle("Patient Care System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.getContentPane().setBackground(Color.WHITE);
		
		welcome.newUserListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(newUser.getNewUserPanel());
		    	 frame.setTitle("New Patient Sign-Up");
		    }
		});
		
		welcome.existingUserListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(patient.getPatientLoginPanel());
		    	 frame.setTitle("Returning Patient Log-In");
		    }
		});
		
		welcome.doctorLoginListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(doctor.getDoctorLoginPanel());
		    	 frame.setTitle("Doctor Log-In");
		    }
		});
		
		newUser.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcome.getWelcomePanel());
		    	 frame.setTitle("Patient Care System");
		    }
		});
		
		patient.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcome.getWelcomePanel());
		    	 frame.setTitle("Patient Care System");
		    }
		});
		
		doctor.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcome.getWelcomePanel());
		    	 frame.setTitle("Patient Care System");
		    }
		});
	}
}

