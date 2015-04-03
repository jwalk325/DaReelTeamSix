import javax.swing.*;

public class PatientCareSystem {

	public static void main(String[] args) {
		GUIController gui = new GUIController(); //create GUI Controller object, constructor creates JFrame
		gui.enableNavigation(); //enable navigation between UIs
	}
}