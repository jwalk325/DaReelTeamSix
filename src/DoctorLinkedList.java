import java.io.Serializable;

public class DoctorLinkedList implements Serializable
{
	
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
	
	public void insert(Doctor d) 
	{
		DoctorNode temp = head;
        head = new DoctorNode(d);
        head.next = temp;
    }
	
	//print doctor list
	public String[] fillDoctorNames()
	{
		DoctorNode temp = head;
		String[] doctors = new String[count()+1];
		doctors[0] = "";
		for(int i = 1; temp != null; i++)
		{
			doctors[i] = temp.doctor.getName();
			temp = temp.next;
		}
		return doctors;
	}
	
	public int count()
	{
		DoctorNode temp = head;
		int count = 0;
		while(temp != null)
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
			
		while(temp != null)
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
				
			while(temp != null)
			{
					if (name.compareTo(temp.doctor.getName())==0)//doctor found
					return temp.doctor;
				temp = temp.next;
			}
			
			return null;
		}
}