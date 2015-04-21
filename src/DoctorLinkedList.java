class DoctorNode 
{
	DoctorNode next;
    Patient patient;

    public DoctorNode(Patient p) 
    {
        patient = p;
        next = null;
    }
}

public class DoctorLinkedList 
{
	DoctorNode head;
	
	public void insert(Patient p) 
	{
		DoctorNode temp = head;
        head = new DoctorNode(p);
        head.next = temp;
    }
	
	public void printList()
	{
		
	}
}