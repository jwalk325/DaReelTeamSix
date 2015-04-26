import java.io.Serializable;

class NotificationNode implements Serializable
{
	NotificationNode next;
	String name;
    PatientRecord patientRecord;

    public NotificationNode(String n, PatientRecord pr) 
    {
    	name = name;
        patientRecord = pr;
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
	
	public void insert(String name, PatientRecord pr) 
	{
		NotificationNode temp = head;
        head = new NotificationNode(name, pr);
        head.next = temp;
    }

}