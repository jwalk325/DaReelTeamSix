//The DoctorLinkedList class contains a list of doctors in the system

import java.io.Serializable;

public class DoctorLinkedList implements Serializable
{
	//node information
	class DoctorNode implements Serializable
	{
		private DoctorNode next;
	    private Doctor doctor;

	    public DoctorNode(Doctor d) 
	    {
	        doctor = d;
	        next = null;
	    }
	}
	
	private DoctorNode head;
	
	//insert method inserts a new doctor at the head of the list
	public void insert(Doctor d) 
	{
		DoctorNode temp = head;
        head = new DoctorNode(d);
        head.next = temp;
    }
	
	//fillDoctorNames method is used to fill the doctor drop down bar while creating a new patient
	public String[] fillDoctorNames()
	{
		DoctorNode temp = head;
		String[] doctors = new String[count()+1];//create array with the needed return size
		doctors[0] = "";//make the first selection empty forcing the patient to select a doctor
		for(int i = 1; temp != null; i++)//traverse Doctors in list
		{
			doctors[i] = temp.doctor.getName();//store doctor in returned array
			temp = temp.next;
		}
		return doctors;
	}
	
	//counts the number of doctors in the list
	public int count()
	{
		DoctorNode temp = head;
		int count = 0;
		while(temp != null)//traverse list
		{
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	//SEARCH FOR DOCTOR BY EMAIL
	public Doctor searchByEmail(String email)
	{
		DoctorNode temp = head;
			
		while(temp != null)//traverse list
		{
				if (email.compareTo(temp.doctor.getEmail())==0)//doctor found
				return temp.doctor;
			temp = temp.next;
		}
		
		return null;
	}
	
	//SEARCH FOR DOCTOR BY NAME
	public Doctor searchByName(String name)
	{
		DoctorNode temp = head;
			
		while(temp != null)//traverse list
		{
			if (name.compareTo(temp.doctor.getName())==0)//doctor found
				return temp.doctor;
			temp = temp.next;
		}
			
		return null;
	}
}