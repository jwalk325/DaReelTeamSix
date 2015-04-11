import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIController{
	//Instance data for UIs
	private JPanel mainPanel = new JPanel();
	private WelcomeUI welcomeUI  = new WelcomeUI();
	private NewPatientUI newPatientUI = new NewPatientUI();
	private DoctorSelectionUI doctorSelectionUI = new DoctorSelectionUI();
	private RegisterSuccessUI registerSuccessUI = new RegisterSuccessUI();
	private PatientLoginUI patientLoginUI = new PatientLoginUI();
	private DoctorLoginUI doctorLoginUI = new DoctorLoginUI();
	private Symptoms1UI symptoms1UI = new Symptoms1UI();
	private Symptoms2UI symptoms2UI = new Symptoms2UI();
	private UpdateInfoCheckUI updateInfoCheckUI = new UpdateInfoCheckUI();
	private LogoutUI logoutUI = new LogoutUI();
	private UpdateInfoUI updateInfoUI = new UpdateInfoUI();
	private LostPasswordUI lostPasswordUI = new LostPasswordUI();
	private SecurityQuestionUI securityQuestionUI = new SecurityQuestionUI();
	private ResetPasswordUI resetPasswordUI = new ResetPasswordUI();
	private ResetSuccessUI resetSuccessUI = new ResetSuccessUI();
	private NewDoctorUI newDoctorUI = new NewDoctorUI();
	
	private String doctor = "Doctor";
	private String patient = "Patient";
	private String user;
	
	public GUIController(){
		//add welcomeUI to main JPanel
		mainPanel.add(welcomeUI.getWelcomePanel());
		mainPanel.setBackground(Color.WHITE);
		
		//create frame with appropriate attributes
		JFrame frame = new JFrame();
		frame.setTitle("Patient Care System"); //menu bar text
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close application when frame is closed
		frame.setSize(500, 500); //window size
		frame.setResizable(false); //do not allow window to be resized
		frame.getContentPane().setBackground(Color.WHITE); //color
		frame.setLocationRelativeTo(null); //center JFrame to user's desktop
		frame.getContentPane().add(mainPanel); //add main Panel to frame
		frame.setVisible(true); //frame is visible	
	}
	
	public void enableGUI(){
		//Action performed when New Patient button is pushed on welcome UI
		welcomeUI.newPatientListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.removeAll(); //remove everything from main panel
				mainPanel.revalidate(); //revalidate the panel
				mainPanel.repaint(); //repaint the panel
				    	 
				mainPanel.add(newPatientUI.getNewPatientPanel()); //bring up the New Patient UI
				user = patient;
			}
		});
				
		//Action performed when Returning Patient button is pushed on welcome UI
		welcomeUI.existingPatientListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(patientLoginUI.getPatientLoginPanel());
		    	 user = patient;
		    }
		});		
				
		//Action performed when Doctor Login button is pushed in welcome UI
		welcomeUI.doctorLoginListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(doctorLoginUI.getDoctorLoginPanel());
		    	 user = doctor;
		    }
		});		
				
		//Action performed when back button is pushed in New Patient UI
		newPatientUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcomeUI.getWelcomePanel());
		    }
		});		
				
		//Action performed when next button is pushed in New Patient UI
		newPatientUI.nextListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				//Example of next button calling check in New Patietn UI
				if(newPatientUI.check()){
					mainPanel.removeAll();
				    mainPanel.revalidate();
				    mainPanel.repaint();
				    	 
				    mainPanel.add(doctorSelectionUI.getDoctorSelctionPanel());
				}
		    }
		});
		
		//Action performed when back button is pushed in Doctor Selection UI
		doctorSelectionUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(newPatientUI.getNewPatientPanel());
		    }
		});
		
		//Action performed when finish button is pushed in Doctor Selection UI
		doctorSelectionUI.finishListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				if(doctorSelectionUI.check()){
					newPatientUI.clear();
					doctorSelectionUI.clear();
			    	mainPanel.removeAll();
			    	mainPanel.revalidate();
			    	mainPanel.repaint();
			    	 
			    	mainPanel.add(registerSuccessUI.getRegisterSuccessPanel());
				}
		    }
		});
		
		//Action performed when continue button is pushed in Register Success UI
		registerSuccessUI.continueListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 if(user.equals(patient)){
			    	 mainPanel.add(patientLoginUI.getPatientLoginPanel());
		    	 }
		    	 else{
		    		 mainPanel.add(doctorLoginUI.getDoctorLoginPanel());
		    	 }
		    }
		});
		
		//Action performed when back button is pushed in Patient Login UI
		patientLoginUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcomeUI.getWelcomePanel());
		    }
		});
		
		//Action performed when submit button is pushed in Patient Login UI
		patientLoginUI.submitListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(symptoms1UI.getSymptoms1Panel());
		    }
		});
		
		//Action performed when forgot password button is pushed in Patient Login UI
		patientLoginUI.forgotListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(lostPasswordUI.getLostPasswordPanel());
		    }
		});
		
		//Action performed when back to log in button is pushed in Forgot Password UI
		lostPasswordUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 if(user.equals(patient)){
		    		 mainPanel.add(patientLoginUI.getPatientLoginPanel());
		    	 }
		    	 else{
		    		 mainPanel.add(doctorLoginUI.getDoctorLoginPanel());
		    	 }
		    }
		});
		
		//Action performed when continue button is pushed in Forgot Password UI
		lostPasswordUI.continueListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(securityQuestionUI.getSecurityQuestionPanel());
		    }
		});
		
		//Action performed when back button is pushed in Security Question UI
		securityQuestionUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(lostPasswordUI.getLostPasswordPanel());
		    }
		});
		
		//Action performed when continue button is pushed in Security Question UI
		securityQuestionUI.continueListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(resetPasswordUI.getResetPasswordPanel());
		    }
		});
		
		//Action performed when back button is pushed in Reset Password UI
		resetPasswordUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(securityQuestionUI.getSecurityQuestionPanel());
		    }
		});
		
		//Action performed when reset password button is pushed in Reset Password UI
		resetPasswordUI.resetPasswordListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(resetSuccessUI.getResetSuccessPanel());
		    }
		});
		
		//Action performed when Log In button is pushed in Reset Success UI
		resetSuccessUI.continueListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 if(user.equals(patient)){
		    		 mainPanel.add(patientLoginUI.getPatientLoginPanel());
		    	 }
		    	 else{
		    		 mainPanel.add(doctorLoginUI.getDoctorLoginPanel());
		    	 }
		    }
		});
		
		//Action performed when logout button is pushed in the first page of symptoms UI
		symptoms1UI.logoutListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.removeAll();
			    mainPanel.revalidate();
			    mainPanel.repaint();
			    	 
			    mainPanel.add(welcomeUI.getWelcomePanel());
		    }
		});
		
		//Action performed when the next button is pushed in the first page of symptoms UI
		symptoms1UI.nextListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.removeAll();
			    mainPanel.revalidate();
			    mainPanel.repaint();
			    	 
			    mainPanel.add(symptoms2UI.getSymptoms2Panel());
		    }
		});
		
		//Action performed when the back button is pushed in the second page of symptoms UI
		symptoms2UI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(symptoms1UI.getSymptoms1Panel());
		    }
		});
		
		//Action performed when the finish button is pushed in the second page of symptoms UI
		symptoms2UI.finishListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				 mainPanel.removeAll();
				 mainPanel.revalidate();
				 mainPanel.repaint();
				    	 
				 mainPanel.add(updateInfoCheckUI.getUpdateInfoCheckPanel());
			}
		});
		
		//Action performed when yes button is pushed in Update Info Check UI
		updateInfoCheckUI.yesListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.removeAll();
				mainPanel.revalidate();
				mainPanel.repaint();
				    	 
				mainPanel.add(updateInfoUI.getUpdateInfoPanel());
			}
		});
		
		//Action performed when no button is pushed in Update Info Check UI
		updateInfoCheckUI.noListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.removeAll();
				mainPanel.revalidate();
				mainPanel.repaint();
				    	 
				mainPanel.add(logoutUI.getLogoutPanel());
			}
		});
		
		//Action performed when submit button is pushed in Update Info UI
		updateInfoUI.submitListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.removeAll();
				mainPanel.revalidate();
				mainPanel.repaint();
				    	 
				mainPanel.add(logoutUI.getLogoutPanel());
			}
		});
		
		//Action performed when logout button is pushed in the Logout UI
		logoutUI.logoutListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.removeAll();
				mainPanel.revalidate();
				mainPanel.repaint();
					    	 
				mainPanel.add(welcomeUI.getWelcomePanel());
			}
		});
		
		//Action performed when submit button is pushed in Doctor Login UI
		doctorLoginUI.registerListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(newDoctorUI.getNewDoctorPanel());
		    }
		});
			
		//Action performed when back button is pushed in Doctor Login UI
		doctorLoginUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcomeUI.getWelcomePanel());
		    }
		});
		
		//Action performed when forgot password button is pushed in Doctor Login UI
		doctorLoginUI.forgotListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(lostPasswordUI.getLostPasswordPanel());
		    }
		});
		
		//Action performed when submit button is pushed in New Doctor UI
		newDoctorUI.submitListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(registerSuccessUI.getRegisterSuccessPanel());
		    }
		});
		
		//Action performed when back button is pushed in New Doctor UI
		newDoctorUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(doctorLoginUI.getDoctorLoginPanel());
		    }
		});
	}			
}