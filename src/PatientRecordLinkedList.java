import java.io.Serializable;

class PatientRecordNode implements Serializable
{
	PatientRecordNode next;
    PatientRecord patientRecord;

    public PatientRecordNode(PatientRecord p) 
    {
        patientRecord = p;
        next = null;
    }
}

public class PatientRecordLinkedList implements Serializable
{
	PatientRecordNode head;
	
	//constructor
	PatientRecordLinkedList()
	{
		head = null;
	}
	
	public void insert(PatientRecord p) 
	{
		PatientRecordNode temp = head;
        head = new PatientRecordNode(p);
        head.next = temp;
    }

}