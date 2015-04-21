import java.io.*;

//import javax.swing.*;

public class PatientCareSystem {			
	public static void main(String[] args) 
	{						
		GUIController gui = new GUIController(); //create GUI Controller object, constructor creates JFrame
		gui.loadFile();//success
		gui.enableGUI(); //enable navigation between UIs  
	}
}