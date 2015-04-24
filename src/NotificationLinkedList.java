import java.io.Serializable;

class NotificationNode implements Serializable
{
	NotificationNode next;
    PatientRecord patientRecord;

    public NotificationNode(PatientRecord p) 
    {
        patientRecord = p;
        next = null;
    }
}

public class NotificationLinkedList implements Serializable
{
	NotificationNode head;
	
	//constructor
	NotificationLinkedList()
	{
		head = null;
	}
	
	public void insert(PatientRecord p) 
	{
		NotificationNode temp = head;
        head = new NotificationNode(p);
        head.next = temp;
    }

}