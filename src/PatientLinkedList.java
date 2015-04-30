//The PatientLinkedList class contains a list of patients in the system

import java.io.Serializable;

public class PatientLinkedList implements Serializable
{
	//node information
	class PatientNode implements Serializable
	{
		private PatientNode next;
	    private Patient patient;

	    public PatientNode(Patient p) 
	    {
	        patient = p;
	        next = null;
	    }
	}
	
	private PatientNode head;
	
	//insert method inserts a new patient at the head of the list
	public void insert(Patient p) 
	{
		PatientNode temp = head;
        head = new PatientNode(p);
        head.next = temp;
    }
	
	//testable print method
	public void printList()
	{
		PatientNode temp = head;
		
		while(temp != null)
		{
			temp.patient.printInfo();
			temp = temp.next;
		}
	}
	
	//fillPatientNames method is used to fill the patient drop down bar in the doctors record view
	public String[] fillPatientNames(String doctorName)
	{
		PatientNode temp = head;
		String[] patients = new String[count(doctorName)+1];//create array with the needed return size
		patients[0] = "";//make the first selection empty forcing the doctor to select a patient
		for(int i = 1; temp != null; temp = temp.next)//traverse Patients in list
		{
			if (temp.patient.getPreferredDoctor().compareTo(doctorName) == 0)
			{
				patients[i] = temp.patient.getName();//store patient in returned array
				i++;
			}
		}
		return patients;//return array
	}
	
	//counts the number of patients in the patient list with the corresponding doctor
	public int count(String doctorName)
	{
		PatientNode temp = head;
		int count = 0;
		while(temp != null)//traverse list
		{
			if (temp.patient.getPreferredDoctor().compareTo(doctorName) == 0)//desired patient
				count++;
			temp = temp.next;
		}
		return count;
	}
	
	//SEARCH FOR PATIENT BY EMAIL
	public Patient searchByEmail(String email)
	{
		PatientNode temp = head;
		
		while(temp != null)//traverse list
		{
			if (email.compareTo(temp.patient.getEmail())==0)//patient found
				return temp.patient;
			temp = temp.next;
		}
		
		return null;
	}
	
	//SEARCH FOR PATIENT BY NAME
		public Patient searchByName(String name)
		{
			PatientNode temp = head;
			
			while(temp != null)//traverse list
			{
				if (name.compareTo(temp.patient.getName())==0)//patient found
					return temp.patient;
				temp = temp.next;
			}
			
			return null;
		}
	
}