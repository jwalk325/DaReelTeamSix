import javax.swing.*;

public class PatientCareSystem {

	public static void main(String[] args) {
		
		//created UI objects for testing
		WelcomeUI welcome = new WelcomeUI(); //creation of object
		welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close program when window closes
		welcome.setSize(500,500); //dimensions of JFrame
		welcome.setLocationRelativeTo(null);
		welcome.setVisible(true); //must set JFrame to be visible
		welcome.setResizable(false); //does not allow window to be resized
		
		//created UI objects for testing
		NewUserUI newUser = new NewUserUI();
		newUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newUser.setSize(500,500);
		newUser.setLocationRelativeTo(null);
		newUser.setVisible(true);
		newUser.setResizable(false);
		
		//created UI objects for testing
		PatientLoginUI existingUser = new PatientLoginUI();
		existingUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		existingUser.setSize(500,500);
		existingUser.setLocationRelativeTo(null);
		existingUser.setVisible(true);
		existingUser.setResizable(false);
		
		//created UI objects for testing
		DoctorLoginUI doctor = new DoctorLoginUI();
		doctor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		doctor.setSize(500,500);
		doctor.setLocationRelativeTo(null);
		doctor.setVisible(true);
		doctor.setResizable(false);
	}
}