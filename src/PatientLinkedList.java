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
	
	//NOT FINISHED//EXAMPLE
	public Patient search(String name)
	{
		PatientNode temp = head;
		
		while(temp != null)
		{
			//if name = temp.patient.name
				//return temp.patient;
			temp = temp.next;
		}
		
		return null;
	}
	
}