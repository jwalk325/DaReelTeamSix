import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	private DoctorDashboardUI doctorDashboardUI = new DoctorDashboardUI();
	private SelectRecordUI selectRecordUI = new SelectRecordUI();
	private NotificationsUI notificationsUI = new NotificationsUI();
	private PatientRecordUI patientRecordUI = new PatientRecordUI();
	private ContactUI contactUI = new ContactUI();
	
	//CREATE NEW PATIENTLINKEDLIST
	PatientLinkedList patientList = new PatientLinkedList();
	//CREATE NEW PATIENTLINKEDLIST
	DoctorLinkedList doctorList = new DoctorLinkedList();
	//CREATE NEW PATIENT 
	Patient p;
	//CREATE NEW DOCTOR
	Doctor d;
	//CREATE NEW PATIENTRECORD
	PatientRecord pr;
	
	private String doctor = "Doctor";
	private String patient = "Patient";
	private String user;
	
	private String selectRecord = "select";
	private String notification = "notification";
	private String patientRecordReturn;
		
	public GUIController(){
		
		loadPatientFile();//loadPatientList
		loadDoctorFile();//loadDoctorList
		
		doctorSelectionUI.setDoctorList(doctorList);
		
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
	
	//SAVE SERIALIZABLE PATIENT FILE
	public void savePatientFile()
	{
		FileOutputStream file = null;
		try 
		{
			file = new FileOutputStream("patient_info.ser");
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		}
	   
		ObjectOutputStream out = null;
		try 
		{
			out = new ObjectOutputStream(file);
			out.writeObject(patientList);
			out.close();
		} 
		catch (IOException e) 
		{
			System.out.println("IOException");
			e.printStackTrace();
		}
	}
	
	//LOAD SERIALIZABLE PATIENT FILE
	public void loadPatientFile()
	{
		InputStream file = null;
		try 
		{
			file = new FileInputStream("patient_info.ser");
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		}
		InputStream buffer = new BufferedInputStream(file);
		ObjectInput input;
		try 
		{
			input = new ObjectInputStream (buffer);
			try 
			{
				patientList = (PatientLinkedList)input.readObject();
			} 
			catch (ClassNotFoundException e) 
			{
				System.out.println("ClassNotFoundException");
				e.printStackTrace();
			}
			input.close();
		} 
		catch (IOException e) 
		{
			System.out.println("IOException");
			e.printStackTrace();
		}
	}
	
	//SAVE SERIALIZABLE DOCTOR FILE
	public void saveDoctorFile()
	{
		FileOutputStream file = null;
		try 
		{
			file = new FileOutputStream("doctor_info.ser");
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		}
	   
		ObjectOutputStream out = null;
		try 
		{
			out = new ObjectOutputStream(file);
			out.writeObject(doctorList);
			out.close();
		} 
		catch (IOException e) 
		{
			System.out.println("IOException");
			e.printStackTrace();
		}
	}
	
	//LOAD SERIALIZABLE DOCTOR FILE
	public void loadDoctorFile()
	{
		InputStream file = null;
		try 
		{
			file = new FileInputStream("doctor_info.ser");
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		}
		InputStream buffer = new BufferedInputStream(file);
		ObjectInput input;
		try 
		{
			input = new ObjectInputStream (buffer);
			try 
			{
				doctorList = (DoctorLinkedList)input.readObject();
			} 
			catch (ClassNotFoundException e) 
			{
				System.out.println("ClassNotFoundException");
				e.printStackTrace();
			}
			input.close();
		} 
		catch (IOException e) 
		{
			System.out.println("IOException");
			e.printStackTrace();
		}
	}
	
	public void enableGUI(){
		//Action performed when New Patient button is pushed on welcome UI
		welcomeUI.newPatientListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.removeAll(); //remove everything from main panel
				mainPanel.revalidate(); //revalidate the panel
				mainPanel.repaint(); //repaint the panel
				    	 
				mainPanel.add(newPatientUI.getNewPatientPanel()); //bring up New Patient UI
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
				warningPrompt();
		    }
		});		
				
		//Action performed when next button is pushed in New Patient UI
		newPatientUI.nextListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				//Example of next button calling check in New Patient UI
				if(newPatientUI.check(patientList)){
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
					//CREATE PATIENT BEFORE INFORMATION IS CLEARD
					//CONSTRUCTOR = (String d, String a, String pd, String n, String e, String ph, String u, String p, String h)
					p = new Patient(newPatientUI.getDOB(), doctorSelectionUI.getAddress(), doctorSelectionUI.getCity(), doctorSelectionUI.getState(), doctorSelectionUI.getZIP(), doctorSelectionUI.getDoctor(), newPatientUI.getName() , newPatientUI.getEmail(), newPatientUI.getPhoneNumber(), newPatientUI.getPassword(), newPatientUI.getQuestion(), newPatientUI.getAnswer());
					
					//TEST PRINT INFO FOR PATIENT
					//p.printInfo();//success
					
					//ADD NEW PATIENT NODE TO PATIENT LINKEDLIST
					patientList.insert(p);
					
					savePatientFile();//success
					
					//TEST PRINT PATIENTLINKEDLIST
					//patientList.printList();//success

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
				 patientLoginUI.clear();
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcomeUI.getWelcomePanel());
		    }
		});
		
		//Action performed when submit button is pushed in Patient Login UI
		patientLoginUI.submitListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				if(patientLoginUI.check(patientList) != null)
				{
					p = patientLoginUI.check(patientList); //temp patient is updated (logged in)
					patientLoginUI.clear();
					mainPanel.removeAll();
			    	mainPanel.revalidate();
			    	mainPanel.repaint();
			    	 
			    	mainPanel.add(symptoms1UI.getSymptoms1Panel());
				}
		    }
		});
		
		//Action performed when forgot password button is pushed in Patient Login UI
		patientLoginUI.forgotListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				 patientLoginUI.clear();
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(lostPasswordUI.getLostPasswordPanel());
		    }
		});
		
		//Action performed when back to log in button is pushed in Forgot Password UI
		lostPasswordUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				 lostPasswordUI.clear();
				 securityQuestionUI.clear();
				 resetPasswordUI.clear();
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
				if(user.equals(patient)){
					if (lostPasswordUI.check(patientList) != null){
					 p = lostPasswordUI.check(patientList);//temp patient used in securityQuestionUI
					 securityQuestionUI.setQuestion(p);
					 mainPanel.removeAll();
			    	 mainPanel.revalidate();
			    	 mainPanel.repaint();    	 
			    	 mainPanel.add(securityQuestionUI.getSecurityQuestionPanel());
					}
				}
				else {
					if (lostPasswordUI.check(doctorList) != null){
						 d = lostPasswordUI.check(doctorList);//temp patient used in securityQuestionUI
						 securityQuestionUI.setQuestion(d);
						 mainPanel.removeAll();
				    	 mainPanel.revalidate();
				    	 mainPanel.repaint();
				    	 mainPanel.add(securityQuestionUI.getSecurityQuestionPanel());
					}
				}
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
				if(user.equals(patient)){
					if(securityQuestionUI.check(p)){
					mainPanel.removeAll();
			    	 mainPanel.revalidate();
			    	 mainPanel.repaint();
			    	 
			    	 mainPanel.add(resetPasswordUI.getResetPasswordPanel());
					}	    	
				}
				else {
					if(securityQuestionUI.check(d)){
					mainPanel.removeAll();
			    	 mainPanel.revalidate();
			    	 mainPanel.repaint();
			    	 
			    	 mainPanel.add(resetPasswordUI.getResetPasswordPanel());
					}	    	
				}
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
				if(user.equals(patient)){
					if(resetPasswordUI.check(p)){
						savePatientFile();//UPDATE SAVED PATIENT PASSWORD
						lostPasswordUI.clear();
						securityQuestionUI.clear();
						resetPasswordUI.clear();
						mainPanel.removeAll();
						mainPanel.revalidate();
						mainPanel.repaint();
						mainPanel.add(resetSuccessUI.getResetSuccessPanel());
					}
				}
				else{
					if(resetPasswordUI.check(d)){
						 saveDoctorFile();//UPDATE SAVED PATIENT PASSWORD
						 lostPasswordUI.clear();
						 securityQuestionUI.clear();
						 resetPasswordUI.clear();
						 mainPanel.removeAll();
				    	 mainPanel.revalidate();
				    	 mainPanel.repaint();
				    	 
				    	 mainPanel.add(resetSuccessUI.getResetSuccessPanel());
					}
				}
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
				warningPrompt();
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
				 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss"); //changed date
				 Date today = Calendar.getInstance().getTime();   
				 //ADD PATIENT RECORD TO DOCTOR NOTICATION LINKED LIST
				 pr = new PatientRecord(symptoms1UI.getPain(), symptoms1UI.getTiredness(), symptoms1UI.getNasuea(), symptoms2UI.getDepression(), symptoms2UI.getAnxiety(), symptoms2UI.getDrowsiness(), dateFormat.format(today), symptoms1UI.getComments(), symptoms2UI.getComments());
				 d = doctorList.searchByName(p.getPreferredDoctor());
				 d.insertNoticationList(p.getName(), pr);
				 saveDoctorFile();
				 symptoms1UI.clear();
				 symptoms2UI.clear();
				 mainPanel.removeAll();
				 mainPanel.revalidate();
				 mainPanel.repaint();
				    	 
				 mainPanel.add(updateInfoCheckUI.getUpdateInfoCheckPanel());
			}
		});
		
		//Action performed when yes button is pushed in Update Info Check UI
		updateInfoCheckUI.yesListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				updateInfoUI.setAddressField(p.getAddress());
				updateInfoUI.setCityField(p.getCity());
				updateInfoUI.setStateField(p.getState());
				updateInfoUI.setZIPField(p.getZip());
				updateInfoUI.setEmailField(p.getEmail());
				updateInfoUI.setPhoneNumberField(p.getPhone());
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
		
		//Action performed when cancel button is pushed in Update Info UI
		updateInfoUI.cancelListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				updateInfoUI.clear();
				mainPanel.removeAll();
				mainPanel.revalidate();
				mainPanel.repaint();
				    	 
				mainPanel.add(logoutUI.getLogoutPanel());
			}
		});		
		
		//Action performed when submit button is pushed in Update Info UI
		updateInfoUI.submitListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				if(updateInfoUI.check()){
					p.setAddress(updateInfoUI.getAddress());
					p.setEmail(updateInfoUI.getEmail());
					p.setPhone(updateInfoUI.getPhoneNumber());
					savePatientFile();
					updateInfoUI.clear();
					mainPanel.removeAll();
					mainPanel.revalidate();
					mainPanel.repaint();
					    	 
					mainPanel.add(logoutUI.getLogoutPanel());
				}			
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
				 doctorLoginUI.clear();
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(newDoctorUI.getNewDoctorPanel());
		    }
		});
		
		doctorLoginUI.submitListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				if(doctorLoginUI.check(doctorList))
				{
					d = doctorList.searchByEmail(doctorLoginUI.getEmail());
					

					selectRecordUI.setDoctorName(d.getName());//sends doctorName
					selectRecordUI.setPatientList(patientList);
					
					doctorLoginUI.clear();
					mainPanel.removeAll();
			    	mainPanel.revalidate();
			    	mainPanel.repaint();
			    	 
			    	mainPanel.add(doctorDashboardUI.getDoctorDashboardPanel());
				}
		    }
		});
			
		//Action performed when back button is pushed in Doctor Login UI
		doctorLoginUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				 doctorLoginUI.clear();
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(welcomeUI.getWelcomePanel());
		    }
		});
		
		//Action performed when forgot password button is pushed in Doctor Login UI
		doctorLoginUI.forgotListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				 doctorLoginUI.clear();
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(lostPasswordUI.getLostPasswordPanel());
		    }
		});
		
		//Action performed when submit button is pushed in New Doctor UI
		newDoctorUI.submitListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				 if(newDoctorUI.check() == true)
				 {
					//CONSTRUCTOR = Doctor(PatientLinkedList pl, String n, String e, String ph, String p, String h, String q, String a)
					 d = new Doctor(patientList, newDoctorUI.getName() , newDoctorUI.getEmail(), newDoctorUI.getPhoneNumber(), newDoctorUI.getPassword(), newDoctorUI.getQuestion(), newDoctorUI.getAnswer());
					 
					 doctorList.insert(d);
					
					 saveDoctorFile();//success
					 
					 doctorSelectionUI.setDoctorList(doctorList);
					 
					 newDoctorUI.clear();
					 mainPanel.removeAll();
					 mainPanel.revalidate();
					 mainPanel.repaint();
				 }
				
		    	 
		    	 mainPanel.add(registerSuccessUI.getRegisterSuccessPanel());
		    }
		});
		
		//Action performed when back button is pushed in New Doctor UI
		newDoctorUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				 warningPrompt();
		    }
		});
		
		//Action performed when notifications button is pushed in Doctor Dashboard UI
		doctorDashboardUI.notificationsListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				 //fill table
				notificationsUI.createColumns();
				NotificationNode temp = d.getNotifcationsList().getHead();
				while (temp != null){
					String lastName = temp.getLastName();
					String firstName = temp.getFirstName();
					
					String priority = temp.patientRecord.getPriority();
					String date = temp.patientRecord.getDate();
					Object[] row = {lastName, firstName, priority, date};
					notificationsUI.addRow(row);
					temp = temp.next;
				}				
				notificationsUI.createTable();
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(notificationsUI.getNotificationsPanel());
		    }
		});
		
		//Action performed when Patient Records button is pushed in Doctor Dashboard UI
		doctorDashboardUI.recordsListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(selectRecordUI.getSelectRecordPanel());
		    }
		});	
		
		//Action performed when Log Out button is pushed in Doctor Dashboard UI
		doctorDashboardUI.logoutListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(logoutUI.getLogoutPanel());
		   }
		});
		
		//Action performed when Back button is pushed in Patient Records UI
		selectRecordUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				 selectRecordUI.clear();
		    	 mainPanel.removeAll();
		    	 mainPanel.revalidate();
		    	 mainPanel.repaint();
		    	 
		    	 mainPanel.add(doctorDashboardUI.getDoctorDashboardPanel());
		   }
		});
		
		//Action performed when View Record button is pushed in Patient Records UI
		selectRecordUI.viewRecordListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				if(selectRecordUI.check()){			
					String name = selectRecordUI.getSelectedPatient();
					String date = selectRecordUI.getSelectedRecord();
					
					p = patientList.searchByName(name);
					PatientRecordNode temp = p.getPatientRecordList().getHead();
					
					while(temp != null){						
						if(temp.patientRecord.getDate().equals(date)){
							pr = temp.patientRecord;
							patientRecordUI.setPatientName(p.getName());
							patientRecordUI.setPain(pr.getPain());
							patientRecordUI.setTiredness(pr.getTiredness());
							patientRecordUI.setNasuea(pr.getNasuea());
							patientRecordUI.setDepression(pr.getDepression());
							patientRecordUI.setDrowsiness(pr.getDrowsiness());
							patientRecordUI.setAnxiety(pr.getAnxiety());
							patientRecordUI.setPatientComments(pr.getComments());
							patientRecordUI.setDoctorComments(pr.getDComments());
							patientRecordUI.colorSymptoms();
							
							break;
						}
						else{
							temp = temp.next;
						}
					}
					
					
					selectRecordUI.clear();
					mainPanel.removeAll();
			    	mainPanel.revalidate();
			    	mainPanel.repaint();
			    	 
			    	mainPanel.add(patientRecordUI.getPatientRecordPanel());
			    	patientRecordReturn = selectRecord;
				}			
		   }
		});	
		
		//Action performed when Back button is pushed in Notifications UI
		notificationsUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				notificationsUI.clear();
				mainPanel.removeAll();
		    	mainPanel.revalidate();
		    	mainPanel.repaint();
		    	 
		    	mainPanel.add(doctorDashboardUI.getDoctorDashboardPanel());
		   }
		});		
		
		//Action performed when View button is pushed in Notifications UI
		notificationsUI.viewListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				if(notificationsUI.check()){
					String name = notificationsUI.getSelectedPatientName();
					String priority = notificationsUI.getSelectedPatientPriority();
					String date = notificationsUI.getSelectedPatientDate();
					
					NotificationNode temp = d.getNotifcationsList().getHead();

					while(temp != null){						
						if(name.equals(temp.getName()) && priority.equals(temp.patientRecord.getPriority()) && date.equals(temp.patientRecord.getDate())){
							pr = temp.patientRecord;
							patientRecordUI.setPatientName(temp.getName());
							patientRecordUI.setPain(pr.getPain());
							patientRecordUI.setTiredness(pr.getTiredness());
							patientRecordUI.setNasuea(pr.getNasuea());
							patientRecordUI.setDepression(pr.getDepression());
							patientRecordUI.setDrowsiness(pr.getDrowsiness());
							patientRecordUI.setAnxiety(pr.getAnxiety());
							patientRecordUI.setPatientComments(pr.getComments());
							patientRecordUI.colorSymptoms();
							break;
						}
						else{
							temp = temp.next;
						}
					}
					
					notificationsUI.clear2();
					mainPanel.removeAll();
			    	mainPanel.revalidate();
			    	mainPanel.repaint();
			    	 
			    	mainPanel.add(patientRecordUI.getPatientRecordPanel());
			    	patientRecordReturn = notification;
				}
		   }
		});		
		
		//Action performed when Back button is pushed in Patient Record UI
		patientRecordUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				if(patientRecordReturn.equals(notification)){
					patientRecordUI.clear();
					mainPanel.removeAll();
			    	mainPanel.revalidate();
			    	mainPanel.repaint();
			    	 
			    	mainPanel.add(notificationsUI.getNotificationsPanel());
				}
				else{
					patientRecordUI.clear();
					mainPanel.removeAll();
			    	mainPanel.revalidate();
			    	mainPanel.repaint();
			    	 
			    	mainPanel.add(selectRecordUI.getSelectRecordPanel());
				}
		   }
		});	
		
		//Action performed when Submit button is pushed in Patient Record UI
		patientRecordUI.submitListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				if(patientRecordReturn.equals(notification)){
					if(patientRecordUI.check()){
						String name = patientRecordUI.getPatientName();
						String dComments = patientRecordUI.getDoctorComments();
						pr.setDComments(dComments);
						p = patientList.searchByName(name);
						p.getPatientRecordList().insert(pr);
						savePatientFile();				
						
						d.getNotifcationsList().delete(p.getName(), pr);
						saveDoctorFile();
						
						notificationsUI.clear();
						notificationsUI.createColumns();
						NotificationNode temp = d.getNotifcationsList().getHead();
						while (temp != null){
							String lastName = temp.getLastName();
							String firstName = temp.getFirstName();
							
							String priority = temp.patientRecord.getPriority();
							String date = temp.patientRecord.getDate();
							Object[] row = {lastName, firstName, priority, date};
							notificationsUI.addRow(row);
							temp = temp.next;
						}				
						notificationsUI.createTable();
						
						patientRecordUI.clear();
						mainPanel.removeAll();
				    	mainPanel.revalidate();
				    	mainPanel.repaint();
				    	 
				    	mainPanel.add(notificationsUI.getNotificationsPanel());
					}				
				}
				else{
					patientRecordUI.error();
				}
		   }
		});			
		
		//Action performed when Contact button is pushed in Patient Record UI
		patientRecordUI.contactListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				p = patientList.searchByName(patientRecordUI.getPatientName());
				contactUI.setPatientName(p.getName());
				contactUI.setAddress(p.getAddress());
				contactUI.setCity(p.getCity());
				contactUI.setState(p.getState());
				contactUI.setZIP(p.getZip());
				contactUI.setPhoneNumber(p.getPhone());
				contactUI.setEmail(p.getEmail());
				
				patientRecordUI.clear2();
				mainPanel.removeAll();
		    	mainPanel.revalidate();
		    	mainPanel.repaint();
		    	 
		    	mainPanel.add(contactUI.getContactPanel());
		   }
		});	
		
		//Action performed when Back button is pushed in Contact UI
		contactUI.backListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.removeAll();
		    	mainPanel.revalidate();
		    	mainPanel.repaint();
		    	 
		    	mainPanel.add(patientRecordUI.getPatientRecordPanel());
		   }
		});
		
		//Action performed when Dashboard button is pushed in Contact UI
		contactUI.dashboardListener(new ActionListener() {	       
			public void actionPerformed(ActionEvent arg0) {
				notificationsUI.clear();
				mainPanel.removeAll();
		    	mainPanel.revalidate();
		    	mainPanel.repaint();
		    	 
		    	mainPanel.add(doctorDashboardUI.getDoctorDashboardPanel());
		   }
		});			
	}
	
	public void warningPrompt(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.WHITE);
		
		JLabel questionLabel;
		if(user.equals(patient)){
			questionLabel = new JLabel("Are you sure you want to return to the Welcome screen?");
		}
		else{
			questionLabel = new JLabel("Are you sure you want to return to the Log In screen?");
		}
		JLabel warningLabel = new JLabel("All progress will be lost.");
		
		JPanel buttonLayout = new JPanel();
		buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS));
		buttonLayout.setBackground(Color.WHITE);
		JButton yesButton = new JButton("Yes");
		JButton noButton = new JButton("No");
		buttonLayout.add(yesButton);
		buttonLayout.add(Box.createRigidArea(new Dimension (125,0)));
		buttonLayout.add(noButton);
		
		panel.add(Box.createRigidArea(new Dimension (0,85)));
		panel.add(questionLabel);
		panel.add(warningLabel);
		panel.add(Box.createRigidArea(new Dimension (0,50)));
		panel.add(buttonLayout);
		questionLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		warningLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		final JFrame frame = new JFrame();
		
		frame.setSize(400, 300); //window size
		frame.setTitle("Warning!");
		frame.setResizable(false); //do not allow window to be resized
		frame.getContentPane().setBackground(Color.WHITE); //color
		frame.setLocationRelativeTo(null); //center JFrame to user's desktop
		frame.getContentPane().add(panel); //add main Panel to frame
		frame.setVisible(true); //frame is visible	
		
		yesButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(user.equals(patient)){
					symptoms1UI.clear();
					symptoms2UI.clear();
					newPatientUI.clear();
					doctorSelectionUI.clear();
					mainPanel.removeAll();
			    	mainPanel.revalidate();
			    	mainPanel.repaint();
			    	 
			    	mainPanel.add(welcomeUI.getWelcomePanel());
					frame.dispose();
				}
				else{
					newDoctorUI.clear();
			    	mainPanel.removeAll();
			    	mainPanel.revalidate();
			    	mainPanel.repaint();
			    	 
			    	mainPanel.add(doctorLoginUI.getDoctorLoginPanel());
			    	frame.dispose();
				}
				
			}
		});
		
		noButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
	}
}