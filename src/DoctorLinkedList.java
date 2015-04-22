import java.io.Serializable;

class DoctorNode implements Serializable
{
	DoctorNode next;
    Doctor doctor;

    public DoctorNode(Doctor d) 
    {
        doctor = d;
        next = null;
    }
}

public class DoctorLinkedList implements Serializable
{
	DoctorNode head;
	
	public void insert(Doctor d) 
	{
		DoctorNode temp = head;
        head = new DoctorNode(d);
        head.next = temp;
    }
	
	//print doctor list
	public void printList()
	{
		DoctorNode temp = head;
		
		while(temp != null)
		{
			temp.doctor.printInfo();
			temp = temp.next;
		}
	}
	
	//SEARCH FOR DOCTOR BY EMAIL
		public Doctor searchByEmail(String email)
		{
			DoctorNode temp = head;
			
			while(temp != null)
			{
				if (email.compareTo(temp.doctor.getEmail())==0)//doctor found
					return temp.doctor;
				temp = temp.next;
			}
			
			return null;
		}
}