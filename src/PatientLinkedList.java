import java.io.Serializable;

class PatientNode implements Serializable
{
	PatientNode next;
    Patient patient;

    public PatientNode(Patient p) 
    {
        patient = p;
        next = null;
    }
}

public class PatientLinkedList implements Serializable
{
	PatientNode head;
	
	public void insert(Patient p) 
	{
		PatientNode temp = head;
        head = new PatientNode(p);
        head.next = temp;
    }
	
	public void printList()
	{
		PatientNode temp = head;
		
		while(temp != null)
		{
			temp.patient.printInfo();
			temp = temp.next;
		}
	}
	
	//print patient list
		public String[] fillPatientNames(String doctorName)
		{
			PatientNode temp = head;
			String[] patients = new String[count()+1];
			patients[0] = "";
			for(int i = 1; temp != null; i++)
			{
				if (temp.patient.getPreferredDoctor().compareTo(doctorName) == 0)
				{
					patients[i] = temp.patient.getName();
				}
				temp = temp.next;
			}
			return patients;
		}
		
		public int count()
		{
			PatientNode temp = head;
			int count = 0;
			while(temp != null)
			{
				count++;
				temp = temp.next;
			}
			return count;
		}
	
	//SEARCH FOR PATIENT BY EMAIL
	public Patient searchByEmail(String email)
	{
		PatientNode temp = head;
		
		while(temp != null)
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
			
			while(temp != null)
			{
				if (name.compareTo(temp.patient.getName())==0)//patient found
					return temp.patient;
				temp = temp.next;
			}
			
			return null;
		}
	
}